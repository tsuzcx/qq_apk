package com.tencent.mm.app.plugin;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.t;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.c;
import com.tencent.mm.pluginsdk.ui.span.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;

public final class e
  implements c
{
  private static e cLg = null;
  private URISpanHandlerSet cLh;
  private ArrayList<URISpanHandlerSet.BaseUriSpanHandler> cLi;
  private ArrayList<URISpanHandlerSet.BaseUriSpanHandler> cLj;
  private ArrayList<URISpanHandlerSet.BaseUriSpanHandler> cLk;
  private Context mContext;
  
  private e()
  {
    AppMethodBeat.i(19669);
    this.mContext = null;
    this.cLi = new ArrayList();
    this.cLj = new ArrayList();
    this.cLk = new ArrayList();
    long l = bs.eWj();
    ac.d("MicroMsg.URISpanHandler", "init URISpanHandler");
    this.mContext = ai.getContext();
    this.cLh = new URISpanHandlerSet(this.mContext);
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
              localObject2 = (URISpanHandlerSet.BaseUriSpanHandler)URISpanHandlerSet.BaseUriSpanHandler.class.cast(((Constructor)localObject2).newInstance(new Object[] { this.cLh }));
              localObject1 = ((URISpanHandlerSet.a)localObject1).LB();
              if (localObject1 != URISpanHandlerSet.PRIORITY.LOW) {
                continue;
              }
              this.cLk.add(localObject2);
            }
            catch (Exception localException)
            {
              Object localObject1;
              Object localObject2;
              ac.printErrStackTrace("MicroMsg.URISpanHandler", localException, "", new Object[0]);
              ac.d("MicroMsg.URISpanHandler", "add %s error: %s, errorType:%s", new Object[] { localClass.getName(), localException.getMessage(), localException.getClass().getName() });
              break label460;
              if (localException != URISpanHandlerSet.PRIORITY.HIGH) {
                continue;
              }
              this.cLi.add(localObject2);
              continue;
            }
            catch (Error localError)
            {
              ac.printErrStackTrace("MicroMsg.URISpanHandler", localError, "", new Object[0]);
              ac.d("MicroMsg.URISpanHandler", "add %s error: %s, errorType:%s", new Object[] { localClass.getName(), localError.getMessage(), localError.getClass().getName() });
            }
            ac.d("MicroMsg.URISpanHandler", "successfully add: %s", new Object[] { localClass.getName() });
            break label460;
            if (localObject1 != URISpanHandlerSet.PRIORITY.NORMAL) {
              continue;
            }
            this.cLj.add(localObject2);
          }
          label409:
          ac.d("MicroMsg.URISpanHandler", "failed to add %s, constructor is null!!", new Object[] { localClass.getName() });
        }
      }
      else
      {
        ac.d("MicroMsg.URISpanHandler", "init URISpanHandler used :%d ms", new Object[] { Long.valueOf(bs.eWj() - l) });
        AppMethodBeat.o(19669);
        return;
      }
      label460:
      i += 1;
    }
  }
  
  public static e Lz()
  {
    AppMethodBeat.i(19668);
    if (cLg == null) {
      cLg = new e();
    }
    e locale = cLg;
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
  
  public final boolean a(Context paramContext, u paramu, h paramh)
  {
    AppMethodBeat.i(19671);
    if (paramu == null)
    {
      ac.d("MicroMsg.URISpanHandler", "handleSpanClick, hrefInfo is null");
      AppMethodBeat.o(19671);
      return false;
    }
    int i = paramu.type;
    if (paramh == null) {}
    for (boolean bool = true;; bool = false)
    {
      ac.d("MicroMsg.URISpanHandler", "handleSpanClick, hrefInfo.getType:%d, callback==null:%b, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size:%d, mLowPriorityHandlerList.size:%d", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(this.cLi.size()), Integer.valueOf(this.cLj.size()), Integer.valueOf(this.cLk.size()) });
      if (paramContext != null) {
        break;
      }
      ac.e("MicroMsg.URISpanHandler", "handleSpanClick, context is null!");
      this.cLh.mContext = null;
      AppMethodBeat.o(19671);
      return false;
    }
    this.mContext = paramContext;
    this.cLh.mContext = this.mContext;
    paramContext = this.cLi.iterator();
    URISpanHandlerSet.BaseUriSpanHandler localBaseUriSpanHandler;
    while (paramContext.hasNext())
    {
      localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if ((contains(localBaseUriSpanHandler.LA(), paramu.type)) && (localBaseUriSpanHandler.a(paramu, paramh)))
      {
        ac.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", new Object[] { localBaseUriSpanHandler.getClass().getName() });
        this.mContext = null;
        this.cLh.mContext = null;
        AppMethodBeat.o(19671);
        return true;
      }
    }
    paramContext = this.cLj.iterator();
    while (paramContext.hasNext())
    {
      localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if ((contains(localBaseUriSpanHandler.LA(), paramu.type)) && (localBaseUriSpanHandler.a(paramu, paramh)))
      {
        ac.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", new Object[] { localBaseUriSpanHandler.getClass().getName() });
        this.mContext = null;
        this.cLh.mContext = null;
        AppMethodBeat.o(19671);
        return true;
      }
    }
    paramContext = this.cLk.iterator();
    while (paramContext.hasNext())
    {
      localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if ((contains(localBaseUriSpanHandler.LA(), paramu.type)) && (localBaseUriSpanHandler.a(paramu, paramh)))
      {
        ac.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", new Object[] { localBaseUriSpanHandler.getClass().getName() });
        this.mContext = null;
        this.cLh.mContext = null;
        AppMethodBeat.o(19671);
        return true;
      }
    }
    this.mContext = null;
    this.cLh.mContext = null;
    ac.d("MicroMsg.URISpanHandler", "handleSpanClick, nothing handle");
    AppMethodBeat.o(19671);
    return false;
  }
  
  public final boolean b(Context paramContext, String paramString, boolean paramBoolean, t paramt, Bundle paramBundle)
  {
    AppMethodBeat.i(19672);
    if (paramt == null) {}
    for (boolean bool = true;; bool = false)
    {
      ac.d("MicroMsg.URISpanHandler", "handleUriJump, url:%s, isAllowScanQrCode:%b, callback==null:%b, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size: %d, mLowPriorityHandlerList.size: %d", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), Integer.valueOf(this.cLi.size()), Integer.valueOf(this.cLj.size()), Integer.valueOf(this.cLk.size()) });
      if (paramContext != null) {
        break;
      }
      ac.e("MicroMsg.URISpanHandler", "handleUriJump, context is null!");
      this.cLh.mContext = null;
      AppMethodBeat.o(19672);
      return false;
    }
    this.mContext = paramContext;
    this.cLh.mContext = this.mContext;
    if (bs.isNullOrNil(paramString))
    {
      ac.d("MicroMsg.URISpanHandler", "handleUriJump, url is null");
      this.mContext = null;
      this.cLh.mContext = null;
      AppMethodBeat.o(19672);
      return false;
    }
    paramContext = this.cLi.iterator();
    URISpanHandlerSet.BaseUriSpanHandler localBaseUriSpanHandler;
    while (paramContext.hasNext())
    {
      localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if (localBaseUriSpanHandler.a(paramString, paramBoolean, paramt, paramBundle))
      {
        ac.d("MicroMsg.URISpanHandler", "handleUriJump, %s handle", new Object[] { localBaseUriSpanHandler.getClass().getName() });
        this.mContext = null;
        this.cLh.mContext = null;
        AppMethodBeat.o(19672);
        return true;
      }
    }
    paramContext = this.cLj.iterator();
    while (paramContext.hasNext())
    {
      localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if (localBaseUriSpanHandler.a(paramString, paramBoolean, paramt, paramBundle))
      {
        ac.d("MicroMsg.URISpanHandler", "handleUriJump, %s handle", new Object[] { localBaseUriSpanHandler.getClass().getName() });
        this.mContext = null;
        this.cLh.mContext = null;
        AppMethodBeat.o(19672);
        return true;
      }
    }
    paramContext = this.cLk.iterator();
    while (paramContext.hasNext())
    {
      localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if (localBaseUriSpanHandler.a(paramString, paramBoolean, paramt, paramBundle))
      {
        ac.d("MicroMsg.URISpanHandler", "handleUriJump, %s handle", new Object[] { localBaseUriSpanHandler.getClass().getName() });
        this.mContext = null;
        this.cLh.mContext = null;
        AppMethodBeat.o(19672);
        return true;
      }
    }
    this.mContext = null;
    this.cLh.mContext = null;
    ac.d("MicroMsg.URISpanHandler", "handleUriJump, nothing handle");
    AppMethodBeat.o(19672);
    return false;
  }
  
  public final u x(Context paramContext, String paramString)
  {
    AppMethodBeat.i(19670);
    ac.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, url:%s, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size:%d, mLowPriorityHandlerList.size：%d", new Object[] { paramString, Integer.valueOf(this.cLi.size()), Integer.valueOf(this.cLj.size()), Integer.valueOf(this.cLk.size()) });
    if (paramContext == null)
    {
      ac.e("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl error, context is null!");
      this.cLh.mContext = null;
      AppMethodBeat.o(19670);
      return null;
    }
    this.mContext = paramContext;
    this.cLh.mContext = this.mContext;
    if (bs.isNullOrNil(paramString))
    {
      ac.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, url is null");
      this.mContext = null;
      this.cLh.mContext = null;
      AppMethodBeat.o(19670);
      return null;
    }
    paramContext = this.cLi.iterator();
    u localu;
    while (paramContext.hasNext())
    {
      localu = ((URISpanHandlerSet.BaseUriSpanHandler)paramContext.next()).eK(paramString);
      if (localu != null)
      {
        ac.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", new Object[] { Integer.valueOf(localu.type) });
        this.mContext = null;
        this.cLh.mContext = null;
        AppMethodBeat.o(19670);
        return localu;
      }
    }
    paramContext = this.cLj.iterator();
    while (paramContext.hasNext())
    {
      localu = ((URISpanHandlerSet.BaseUriSpanHandler)paramContext.next()).eK(paramString);
      if (localu != null)
      {
        ac.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", new Object[] { Integer.valueOf(localu.type) });
        this.mContext = null;
        this.cLh.mContext = null;
        AppMethodBeat.o(19670);
        return localu;
      }
    }
    paramContext = this.cLk.iterator();
    while (paramContext.hasNext())
    {
      localu = ((URISpanHandlerSet.BaseUriSpanHandler)paramContext.next()).eK(paramString);
      if (localu != null)
      {
        ac.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", new Object[] { Integer.valueOf(localu.type) });
        this.mContext = null;
        this.cLh.mContext = null;
        AppMethodBeat.o(19670);
        return localu;
      }
    }
    this.mContext = null;
    this.cLh.mContext = null;
    ac.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, nothing match");
    AppMethodBeat.o(19670);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.plugin.e
 * JD-Core Version:    0.7.0.1
 */