package com.tencent.mm.app.plugin;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.c;
import com.tencent.mm.pluginsdk.ui.span.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;

public final class e
  implements c
{
  private static e cWt = null;
  private URISpanHandlerSet cWu;
  private ArrayList<URISpanHandlerSet.BaseUriSpanHandler> cWv;
  private ArrayList<URISpanHandlerSet.BaseUriSpanHandler> cWw;
  private ArrayList<URISpanHandlerSet.BaseUriSpanHandler> cWx;
  private Context mContext;
  
  private e()
  {
    AppMethodBeat.i(19669);
    this.mContext = null;
    this.cWv = new ArrayList();
    this.cWw = new ArrayList();
    this.cWx = new ArrayList();
    long l = bt.flT();
    ad.d("MicroMsg.URISpanHandler", "init URISpanHandler");
    this.mContext = aj.getContext();
    this.cWu = new URISpanHandlerSet(this.mContext);
    Class[] arrayOfClass = URISpanHandlerSet.class.getDeclaredClasses();
    int j = arrayOfClass.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Class localClass = arrayOfClass[i];
        if ((localClass != null) && (localClass.getSuperclass() != null) && (localClass.isAnnotationPresent(URISpanHandlerSet.a.class)) && (localClass.getSuperclass().getName().equals(URISpanHandlerSet.BaseUriSpanHandler.class.getName())))
        {
          for (;;)
          {
            try
            {
              localObject1 = (URISpanHandlerSet.a)localClass.getAnnotation(URISpanHandlerSet.a.class);
              localObject2 = localClass.getDeclaredConstructor(new Class[] { URISpanHandlerSet.class });
              if (localObject2 == null) {
                break label409;
              }
              localObject2 = (URISpanHandlerSet.BaseUriSpanHandler)URISpanHandlerSet.BaseUriSpanHandler.class.cast(((Constructor)localObject2).newInstance(new Object[] { this.cWu }));
              localObject1 = ((URISpanHandlerSet.a)localObject1).Nj();
              if (localObject1 != URISpanHandlerSet.PRIORITY.LOW) {
                continue;
              }
              this.cWx.add(localObject2);
            }
            catch (Exception localException)
            {
              Object localObject1;
              Object localObject2;
              ad.printErrStackTrace("MicroMsg.URISpanHandler", localException, "", new Object[0]);
              ad.d("MicroMsg.URISpanHandler", "add %s error: %s, errorType:%s", new Object[] { localClass.getName(), localException.getMessage(), localException.getClass().getName() });
              break label460;
              if (localException != URISpanHandlerSet.PRIORITY.HIGH) {
                continue;
              }
              this.cWv.add(localObject2);
              continue;
            }
            catch (Error localError)
            {
              ad.printErrStackTrace("MicroMsg.URISpanHandler", localError, "", new Object[0]);
              ad.d("MicroMsg.URISpanHandler", "add %s error: %s, errorType:%s", new Object[] { localClass.getName(), localError.getMessage(), localError.getClass().getName() });
            }
            ad.d("MicroMsg.URISpanHandler", "successfully add: %s", new Object[] { localClass.getName() });
            break label460;
            if (localObject1 != URISpanHandlerSet.PRIORITY.NORMAL) {
              continue;
            }
            this.cWw.add(localObject2);
          }
          label409:
          ad.d("MicroMsg.URISpanHandler", "failed to add %s, constructor is null!!", new Object[] { localClass.getName() });
        }
      }
      else
      {
        ad.d("MicroMsg.URISpanHandler", "init URISpanHandler used :%d ms", new Object[] { Long.valueOf(bt.flT() - l) });
        AppMethodBeat.o(19669);
        return;
      }
      label460:
      i += 1;
    }
  }
  
  public static e Nh()
  {
    AppMethodBeat.i(19668);
    if (cWt == null) {
      cWt = new e();
    }
    e locale = cWt;
    AppMethodBeat.o(19668);
    return locale;
  }
  
  private static boolean contains(int[] paramArrayOfInt, int paramInt)
  {
    boolean bool2 = false;
    int j = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramArrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public final boolean a(Context paramContext, com.tencent.mm.pluginsdk.ui.applet.u paramu, h paramh)
  {
    AppMethodBeat.i(19671);
    if (paramu == null)
    {
      ad.d("MicroMsg.URISpanHandler", "handleSpanClick, hrefInfo is null");
      AppMethodBeat.o(19671);
      return false;
    }
    int i = paramu.type;
    if (paramh == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.URISpanHandler", "handleSpanClick, hrefInfo.getType:%d, callback==null:%b, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size:%d, mLowPriorityHandlerList.size:%d", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(this.cWv.size()), Integer.valueOf(this.cWw.size()), Integer.valueOf(this.cWx.size()) });
      if (paramContext != null) {
        break;
      }
      ad.e("MicroMsg.URISpanHandler", "handleSpanClick, context is null!");
      this.cWu.mContext = null;
      AppMethodBeat.o(19671);
      return false;
    }
    this.mContext = paramContext;
    this.cWu.mContext = this.mContext;
    paramContext = this.cWv.iterator();
    URISpanHandlerSet.BaseUriSpanHandler localBaseUriSpanHandler;
    while (paramContext.hasNext())
    {
      localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if ((contains(localBaseUriSpanHandler.Ni(), paramu.type)) && (localBaseUriSpanHandler.a(paramu, paramh)))
      {
        ad.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", new Object[] { localBaseUriSpanHandler.getClass().getName() });
        this.mContext = null;
        this.cWu.mContext = null;
        AppMethodBeat.o(19671);
        return true;
      }
    }
    paramContext = this.cWw.iterator();
    while (paramContext.hasNext())
    {
      localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if ((contains(localBaseUriSpanHandler.Ni(), paramu.type)) && (localBaseUriSpanHandler.a(paramu, paramh)))
      {
        ad.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", new Object[] { localBaseUriSpanHandler.getClass().getName() });
        this.mContext = null;
        this.cWu.mContext = null;
        AppMethodBeat.o(19671);
        return true;
      }
    }
    paramContext = this.cWx.iterator();
    while (paramContext.hasNext())
    {
      localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if ((contains(localBaseUriSpanHandler.Ni(), paramu.type)) && (localBaseUriSpanHandler.a(paramu, paramh)))
      {
        ad.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", new Object[] { localBaseUriSpanHandler.getClass().getName() });
        this.mContext = null;
        this.cWu.mContext = null;
        AppMethodBeat.o(19671);
        return true;
      }
    }
    this.mContext = null;
    this.cWu.mContext = null;
    ad.d("MicroMsg.URISpanHandler", "handleSpanClick, nothing handle");
    AppMethodBeat.o(19671);
    return false;
  }
  
  public final boolean b(Context paramContext, String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
  {
    AppMethodBeat.i(19672);
    if (paramu == null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.d("MicroMsg.URISpanHandler", "handleUriJump, url:%s, isAllowScanQrCode:%b, callback==null:%b, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size: %d, mLowPriorityHandlerList.size: %d", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), Integer.valueOf(this.cWv.size()), Integer.valueOf(this.cWw.size()), Integer.valueOf(this.cWx.size()) });
      if (paramContext != null) {
        break;
      }
      ad.e("MicroMsg.URISpanHandler", "handleUriJump, context is null!");
      this.cWu.mContext = null;
      AppMethodBeat.o(19672);
      return false;
    }
    this.mContext = paramContext;
    this.cWu.mContext = this.mContext;
    if (bt.isNullOrNil(paramString))
    {
      ad.d("MicroMsg.URISpanHandler", "handleUriJump, url is null");
      this.mContext = null;
      this.cWu.mContext = null;
      AppMethodBeat.o(19672);
      return false;
    }
    paramContext = this.cWv.iterator();
    URISpanHandlerSet.BaseUriSpanHandler localBaseUriSpanHandler;
    while (paramContext.hasNext())
    {
      localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if (localBaseUriSpanHandler.a(paramString, paramBoolean, paramu, paramBundle))
      {
        ad.d("MicroMsg.URISpanHandler", "handleUriJump, %s handle", new Object[] { localBaseUriSpanHandler.getClass().getName() });
        this.mContext = null;
        this.cWu.mContext = null;
        AppMethodBeat.o(19672);
        return true;
      }
    }
    paramContext = this.cWw.iterator();
    while (paramContext.hasNext())
    {
      localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if (localBaseUriSpanHandler.a(paramString, paramBoolean, paramu, paramBundle))
      {
        ad.d("MicroMsg.URISpanHandler", "handleUriJump, %s handle", new Object[] { localBaseUriSpanHandler.getClass().getName() });
        this.mContext = null;
        this.cWu.mContext = null;
        AppMethodBeat.o(19672);
        return true;
      }
    }
    paramContext = this.cWx.iterator();
    while (paramContext.hasNext())
    {
      localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if (localBaseUriSpanHandler.a(paramString, paramBoolean, paramu, paramBundle))
      {
        ad.d("MicroMsg.URISpanHandler", "handleUriJump, %s handle", new Object[] { localBaseUriSpanHandler.getClass().getName() });
        this.mContext = null;
        this.cWu.mContext = null;
        AppMethodBeat.o(19672);
        return true;
      }
    }
    this.mContext = null;
    this.cWu.mContext = null;
    ad.d("MicroMsg.URISpanHandler", "handleUriJump, nothing handle");
    AppMethodBeat.o(19672);
    return false;
  }
  
  public final com.tencent.mm.pluginsdk.ui.applet.u w(Context paramContext, String paramString)
  {
    AppMethodBeat.i(19670);
    ad.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, url:%s, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size:%d, mLowPriorityHandlerList.size：%d", new Object[] { paramString, Integer.valueOf(this.cWv.size()), Integer.valueOf(this.cWw.size()), Integer.valueOf(this.cWx.size()) });
    if (paramContext == null)
    {
      ad.e("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl error, context is null!");
      this.cWu.mContext = null;
      AppMethodBeat.o(19670);
      return null;
    }
    this.mContext = paramContext;
    this.cWu.mContext = this.mContext;
    if (bt.isNullOrNil(paramString))
    {
      ad.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, url is null");
      this.mContext = null;
      this.cWu.mContext = null;
      AppMethodBeat.o(19670);
      return null;
    }
    paramContext = this.cWv.iterator();
    com.tencent.mm.pluginsdk.ui.applet.u localu;
    while (paramContext.hasNext())
    {
      localu = ((URISpanHandlerSet.BaseUriSpanHandler)paramContext.next()).fF(paramString);
      if (localu != null)
      {
        ad.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", new Object[] { Integer.valueOf(localu.type) });
        this.mContext = null;
        this.cWu.mContext = null;
        AppMethodBeat.o(19670);
        return localu;
      }
    }
    paramContext = this.cWw.iterator();
    while (paramContext.hasNext())
    {
      localu = ((URISpanHandlerSet.BaseUriSpanHandler)paramContext.next()).fF(paramString);
      if (localu != null)
      {
        ad.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", new Object[] { Integer.valueOf(localu.type) });
        this.mContext = null;
        this.cWu.mContext = null;
        AppMethodBeat.o(19670);
        return localu;
      }
    }
    paramContext = this.cWx.iterator();
    while (paramContext.hasNext())
    {
      localu = ((URISpanHandlerSet.BaseUriSpanHandler)paramContext.next()).fF(paramString);
      if (localu != null)
      {
        ad.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", new Object[] { Integer.valueOf(localu.type) });
        this.mContext = null;
        this.cWu.mContext = null;
        AppMethodBeat.o(19670);
        return localu;
      }
    }
    this.mContext = null;
    this.cWu.mContext = null;
    ad.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, nothing match");
    AppMethodBeat.o(19670);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.plugin.e
 * JD-Core Version:    0.7.0.1
 */