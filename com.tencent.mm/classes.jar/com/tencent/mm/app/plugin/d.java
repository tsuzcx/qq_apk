package com.tencent.mm.app.plugin;

import android.content.Context;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.b;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;

public final class d
  implements b
{
  private static d byf = null;
  URISpanHandlerSet byg;
  ArrayList<URISpanHandlerSet.BaseUriSpanHandler> byh = new ArrayList();
  ArrayList<URISpanHandlerSet.BaseUriSpanHandler> byi = new ArrayList();
  ArrayList<URISpanHandlerSet.BaseUriSpanHandler> byj = new ArrayList();
  Context mContext = null;
  
  private d()
  {
    long l = bk.UY();
    y.d("MicroMsg.URISpanHandler", "init URISpanHandler");
    this.mContext = ae.getContext();
    this.byg = new URISpanHandlerSet(this.mContext);
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
            Object localObject2;
            try
            {
              Object localObject1 = (URISpanHandlerSet.a)localClass.getAnnotation(URISpanHandlerSet.a.class);
              localObject2 = localClass.getDeclaredConstructor(new Class[] { URISpanHandlerSet.class });
              if (localObject2 == null) {
                break;
              }
              localObject2 = (URISpanHandlerSet.BaseUriSpanHandler)URISpanHandlerSet.BaseUriSpanHandler.class.cast(((Constructor)localObject2).newInstance(new Object[] { this.byg }));
              localObject1 = ((URISpanHandlerSet.a)localObject1).tB();
              if (localObject1 == URISpanHandlerSet.PRIORITY.LOW)
              {
                this.byj.add(localObject2);
                y.d("MicroMsg.URISpanHandler", "successfully add: %s", new Object[] { localClass.getName() });
                break label392;
              }
              if (localObject1 == URISpanHandlerSet.PRIORITY.NORMAL)
              {
                this.byi.add(localObject2);
                continue;
              }
              if (localException != URISpanHandlerSet.PRIORITY.HIGH) {
                continue;
              }
            }
            catch (Exception localException)
            {
              y.printErrStackTrace("MicroMsg.URISpanHandler", localException, "", new Object[0]);
              y.d("MicroMsg.URISpanHandler", "add %s error: %s, errorType:%s", new Object[] { localClass.getName(), localException.getMessage(), localException.getClass().getName() });
            }
            this.byh.add(localObject2);
          }
          y.d("MicroMsg.URISpanHandler", "failed to add %s, constructor is null!!", new Object[] { localClass.getName() });
        }
      }
      else
      {
        y.d("MicroMsg.URISpanHandler", "init URISpanHandler used :%d ms", new Object[] { Long.valueOf(bk.UY() - l) });
        return;
      }
      label392:
      i += 1;
    }
  }
  
  private static boolean d(int[] paramArrayOfInt, int paramInt)
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
  
  public static d tz()
  {
    if (byf == null) {
      byf = new d();
    }
    return byf;
  }
  
  public final boolean a(Context paramContext, m paramm, g paramg)
  {
    if (paramm == null)
    {
      y.d("MicroMsg.URISpanHandler", "handleSpanClick, hrefInfo is null");
      return false;
    }
    int i = paramm.type;
    if (paramg == null) {}
    for (boolean bool = true;; bool = false)
    {
      y.d("MicroMsg.URISpanHandler", "handleSpanClick, hrefInfo.getType:%d, callback==null:%b, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size:%d, mLowPriorityHandlerList.size:%d", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(this.byh.size()), Integer.valueOf(this.byi.size()), Integer.valueOf(this.byj.size()) });
      if (paramContext != null) {
        break;
      }
      y.e("MicroMsg.URISpanHandler", "handleSpanClick, context is null!");
      this.byg.mContext = null;
      return false;
    }
    this.mContext = paramContext;
    this.byg.mContext = this.mContext;
    paramContext = this.byh.iterator();
    URISpanHandlerSet.BaseUriSpanHandler localBaseUriSpanHandler;
    while (paramContext.hasNext())
    {
      localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if ((d(localBaseUriSpanHandler.tA(), paramm.type)) && (localBaseUriSpanHandler.a(paramm, paramg)))
      {
        y.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", new Object[] { localBaseUriSpanHandler.getClass().getName() });
        this.mContext = null;
        this.byg.mContext = null;
        return true;
      }
    }
    paramContext = this.byi.iterator();
    while (paramContext.hasNext())
    {
      localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if ((d(localBaseUriSpanHandler.tA(), paramm.type)) && (localBaseUriSpanHandler.a(paramm, paramg)))
      {
        y.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", new Object[] { localBaseUriSpanHandler.getClass().getName() });
        this.mContext = null;
        this.byg.mContext = null;
        return true;
      }
    }
    paramContext = this.byj.iterator();
    while (paramContext.hasNext())
    {
      localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if ((d(localBaseUriSpanHandler.tA(), paramm.type)) && (localBaseUriSpanHandler.a(paramm, paramg)))
      {
        y.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", new Object[] { localBaseUriSpanHandler.getClass().getName() });
        this.mContext = null;
        this.byg.mContext = null;
        return true;
      }
    }
    this.mContext = null;
    this.byg.mContext = null;
    y.d("MicroMsg.URISpanHandler", "handleSpanClick, nothing handle");
    return false;
  }
  
  public final m r(Context paramContext, String paramString)
  {
    y.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, url:%s, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size:%d, mLowPriorityHandlerList.size：%d", new Object[] { paramString, Integer.valueOf(this.byh.size()), Integer.valueOf(this.byi.size()), Integer.valueOf(this.byj.size()) });
    if (paramContext == null)
    {
      y.e("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl error, context is null!");
      this.byg.mContext = null;
      return null;
    }
    this.mContext = paramContext;
    this.byg.mContext = this.mContext;
    if (bk.bl(paramString))
    {
      y.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, url is null");
      this.mContext = null;
      this.byg.mContext = null;
      return null;
    }
    paramContext = this.byh.iterator();
    m localm;
    while (paramContext.hasNext())
    {
      localm = ((URISpanHandlerSet.BaseUriSpanHandler)paramContext.next()).cA(paramString);
      if (localm != null)
      {
        y.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", new Object[] { Integer.valueOf(localm.type) });
        this.mContext = null;
        this.byg.mContext = null;
        return localm;
      }
    }
    paramContext = this.byi.iterator();
    while (paramContext.hasNext())
    {
      localm = ((URISpanHandlerSet.BaseUriSpanHandler)paramContext.next()).cA(paramString);
      if (localm != null)
      {
        y.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", new Object[] { Integer.valueOf(localm.type) });
        this.mContext = null;
        this.byg.mContext = null;
        return localm;
      }
    }
    paramContext = this.byj.iterator();
    while (paramContext.hasNext())
    {
      localm = ((URISpanHandlerSet.BaseUriSpanHandler)paramContext.next()).cA(paramString);
      if (localm != null)
      {
        y.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", new Object[] { Integer.valueOf(localm.type) });
        this.mContext = null;
        this.byg.mContext = null;
        return localm;
      }
    }
    this.mContext = null;
    this.byg.mContext = null;
    y.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, nothing match");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.plugin.d
 * JD-Core Version:    0.7.0.1
 */