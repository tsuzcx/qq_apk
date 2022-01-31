package com.tencent.mm.app.plugin;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.b;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.pluginsdk.v;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;

public final class e
  implements b
{
  private static e cah = null;
  private URISpanHandlerSet cai;
  private ArrayList<URISpanHandlerSet.BaseUriSpanHandler> caj;
  private ArrayList<URISpanHandlerSet.BaseUriSpanHandler> cak;
  private ArrayList<URISpanHandlerSet.BaseUriSpanHandler> cal;
  private Context mContext;
  
  private e()
  {
    AppMethodBeat.i(15624);
    this.mContext = null;
    this.caj = new ArrayList();
    this.cak = new ArrayList();
    this.cal = new ArrayList();
    long l = bo.aoy();
    ab.d("MicroMsg.URISpanHandler", "init URISpanHandler");
    this.mContext = ah.getContext();
    this.cai = new URISpanHandlerSet(this.mContext);
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
              localObject2 = (URISpanHandlerSet.BaseUriSpanHandler)URISpanHandlerSet.BaseUriSpanHandler.class.cast(((Constructor)localObject2).newInstance(new Object[] { this.cai }));
              localObject1 = ((URISpanHandlerSet.a)localObject1).Cg();
              if (localObject1 != URISpanHandlerSet.PRIORITY.LOW) {
                continue;
              }
              this.cal.add(localObject2);
            }
            catch (Exception localException)
            {
              Object localObject1;
              Object localObject2;
              ab.printErrStackTrace("MicroMsg.URISpanHandler", localException, "", new Object[0]);
              ab.d("MicroMsg.URISpanHandler", "add %s error: %s, errorType:%s", new Object[] { localClass.getName(), localException.getMessage(), localException.getClass().getName() });
              break label460;
              if (localException != URISpanHandlerSet.PRIORITY.HIGH) {
                continue;
              }
              this.caj.add(localObject2);
              continue;
            }
            catch (Error localError)
            {
              ab.printErrStackTrace("MicroMsg.URISpanHandler", localError, "", new Object[0]);
              ab.d("MicroMsg.URISpanHandler", "add %s error: %s, errorType:%s", new Object[] { localClass.getName(), localError.getMessage(), localError.getClass().getName() });
            }
            ab.d("MicroMsg.URISpanHandler", "successfully add: %s", new Object[] { localClass.getName() });
            break label460;
            if (localObject1 != URISpanHandlerSet.PRIORITY.NORMAL) {
              continue;
            }
            this.cak.add(localObject2);
          }
          label409:
          ab.d("MicroMsg.URISpanHandler", "failed to add %s, constructor is null!!", new Object[] { localClass.getName() });
        }
      }
      else
      {
        ab.d("MicroMsg.URISpanHandler", "init URISpanHandler used :%d ms", new Object[] { Long.valueOf(bo.aoy() - l) });
        AppMethodBeat.o(15624);
        return;
      }
      label460:
      i += 1;
    }
  }
  
  public static e Ce()
  {
    AppMethodBeat.i(15623);
    if (cah == null) {
      cah = new e();
    }
    e locale = cah;
    AppMethodBeat.o(15623);
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
  
  public final boolean a(Context paramContext, m paramm, g paramg)
  {
    AppMethodBeat.i(15626);
    if (paramm == null)
    {
      ab.d("MicroMsg.URISpanHandler", "handleSpanClick, hrefInfo is null");
      AppMethodBeat.o(15626);
      return false;
    }
    int i = paramm.type;
    if (paramg == null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.d("MicroMsg.URISpanHandler", "handleSpanClick, hrefInfo.getType:%d, callback==null:%b, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size:%d, mLowPriorityHandlerList.size:%d", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(this.caj.size()), Integer.valueOf(this.cak.size()), Integer.valueOf(this.cal.size()) });
      if (paramContext != null) {
        break;
      }
      ab.e("MicroMsg.URISpanHandler", "handleSpanClick, context is null!");
      this.cai.mContext = null;
      AppMethodBeat.o(15626);
      return false;
    }
    this.mContext = paramContext;
    this.cai.mContext = this.mContext;
    paramContext = this.caj.iterator();
    URISpanHandlerSet.BaseUriSpanHandler localBaseUriSpanHandler;
    while (paramContext.hasNext())
    {
      localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if ((contains(localBaseUriSpanHandler.Cf(), paramm.type)) && (localBaseUriSpanHandler.a(paramm, paramg)))
      {
        ab.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", new Object[] { localBaseUriSpanHandler.getClass().getName() });
        this.mContext = null;
        this.cai.mContext = null;
        AppMethodBeat.o(15626);
        return true;
      }
    }
    paramContext = this.cak.iterator();
    while (paramContext.hasNext())
    {
      localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if ((contains(localBaseUriSpanHandler.Cf(), paramm.type)) && (localBaseUriSpanHandler.a(paramm, paramg)))
      {
        ab.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", new Object[] { localBaseUriSpanHandler.getClass().getName() });
        this.mContext = null;
        this.cai.mContext = null;
        AppMethodBeat.o(15626);
        return true;
      }
    }
    paramContext = this.cal.iterator();
    while (paramContext.hasNext())
    {
      localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if ((contains(localBaseUriSpanHandler.Cf(), paramm.type)) && (localBaseUriSpanHandler.a(paramm, paramg)))
      {
        ab.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", new Object[] { localBaseUriSpanHandler.getClass().getName() });
        this.mContext = null;
        this.cai.mContext = null;
        AppMethodBeat.o(15626);
        return true;
      }
    }
    this.mContext = null;
    this.cai.mContext = null;
    ab.d("MicroMsg.URISpanHandler", "handleSpanClick, nothing handle");
    AppMethodBeat.o(15626);
    return false;
  }
  
  public final boolean b(Context paramContext, String paramString, boolean paramBoolean, v paramv, Bundle paramBundle)
  {
    AppMethodBeat.i(15627);
    if (paramv == null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.d("MicroMsg.URISpanHandler", "handleUriJump, url:%s, isAllowScanQrCode:%b, callback==null:%b, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size: %d, mLowPriorityHandlerList.size: %d", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), Integer.valueOf(this.caj.size()), Integer.valueOf(this.cak.size()), Integer.valueOf(this.cal.size()) });
      if (paramContext != null) {
        break;
      }
      ab.e("MicroMsg.URISpanHandler", "handleUriJump, context is null!");
      this.cai.mContext = null;
      AppMethodBeat.o(15627);
      return false;
    }
    this.mContext = paramContext;
    this.cai.mContext = this.mContext;
    if (bo.isNullOrNil(paramString))
    {
      ab.d("MicroMsg.URISpanHandler", "handleUriJump, url is null");
      this.mContext = null;
      this.cai.mContext = null;
      AppMethodBeat.o(15627);
      return false;
    }
    paramContext = this.caj.iterator();
    URISpanHandlerSet.BaseUriSpanHandler localBaseUriSpanHandler;
    while (paramContext.hasNext())
    {
      localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if (localBaseUriSpanHandler.a(paramString, paramBoolean, paramv, paramBundle))
      {
        ab.d("MicroMsg.URISpanHandler", "handleUriJump, %s handle", new Object[] { localBaseUriSpanHandler.getClass().getName() });
        this.mContext = null;
        this.cai.mContext = null;
        AppMethodBeat.o(15627);
        return true;
      }
    }
    paramContext = this.cak.iterator();
    while (paramContext.hasNext())
    {
      localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if (localBaseUriSpanHandler.a(paramString, paramBoolean, paramv, paramBundle))
      {
        ab.d("MicroMsg.URISpanHandler", "handleUriJump, %s handle", new Object[] { localBaseUriSpanHandler.getClass().getName() });
        this.mContext = null;
        this.cai.mContext = null;
        AppMethodBeat.o(15627);
        return true;
      }
    }
    paramContext = this.cal.iterator();
    while (paramContext.hasNext())
    {
      localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if (localBaseUriSpanHandler.a(paramString, paramBoolean, paramv, paramBundle))
      {
        ab.d("MicroMsg.URISpanHandler", "handleUriJump, %s handle", new Object[] { localBaseUriSpanHandler.getClass().getName() });
        this.mContext = null;
        this.cai.mContext = null;
        AppMethodBeat.o(15627);
        return true;
      }
    }
    this.mContext = null;
    this.cai.mContext = null;
    ab.d("MicroMsg.URISpanHandler", "handleUriJump, nothing handle");
    AppMethodBeat.o(15627);
    return false;
  }
  
  public final m y(Context paramContext, String paramString)
  {
    AppMethodBeat.i(15625);
    ab.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, url:%s, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size:%d, mLowPriorityHandlerList.size：%d", new Object[] { paramString, Integer.valueOf(this.caj.size()), Integer.valueOf(this.cak.size()), Integer.valueOf(this.cal.size()) });
    if (paramContext == null)
    {
      ab.e("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl error, context is null!");
      this.cai.mContext = null;
      AppMethodBeat.o(15625);
      return null;
    }
    this.mContext = paramContext;
    this.cai.mContext = this.mContext;
    if (bo.isNullOrNil(paramString))
    {
      ab.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, url is null");
      this.mContext = null;
      this.cai.mContext = null;
      AppMethodBeat.o(15625);
      return null;
    }
    paramContext = this.caj.iterator();
    m localm;
    while (paramContext.hasNext())
    {
      localm = ((URISpanHandlerSet.BaseUriSpanHandler)paramContext.next()).dN(paramString);
      if (localm != null)
      {
        ab.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", new Object[] { Integer.valueOf(localm.type) });
        this.mContext = null;
        this.cai.mContext = null;
        AppMethodBeat.o(15625);
        return localm;
      }
    }
    paramContext = this.cak.iterator();
    while (paramContext.hasNext())
    {
      localm = ((URISpanHandlerSet.BaseUriSpanHandler)paramContext.next()).dN(paramString);
      if (localm != null)
      {
        ab.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", new Object[] { Integer.valueOf(localm.type) });
        this.mContext = null;
        this.cai.mContext = null;
        AppMethodBeat.o(15625);
        return localm;
      }
    }
    paramContext = this.cal.iterator();
    while (paramContext.hasNext())
    {
      localm = ((URISpanHandlerSet.BaseUriSpanHandler)paramContext.next()).dN(paramString);
      if (localm != null)
      {
        ab.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", new Object[] { Integer.valueOf(localm.type) });
        this.mContext = null;
        this.cai.mContext = null;
        AppMethodBeat.o(15625);
        return localm;
      }
    }
    this.mContext = null;
    this.cai.mContext = null;
    ab.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, nothing match");
    AppMethodBeat.o(15625);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.plugin.e
 * JD-Core Version:    0.7.0.1
 */