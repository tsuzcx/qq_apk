package com.tencent.mm.app.plugin;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.d;
import com.tencent.mm.pluginsdk.ui.span.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;

public final class e
  implements d
{
  private static e dnR = null;
  private URISpanHandlerSet dnS;
  private ArrayList<URISpanHandlerSet.BaseUriSpanHandler> dnT;
  private ArrayList<URISpanHandlerSet.BaseUriSpanHandler> dnU;
  private ArrayList<URISpanHandlerSet.BaseUriSpanHandler> dnV;
  private Context mContext;
  
  private e()
  {
    AppMethodBeat.i(19669);
    this.mContext = null;
    this.dnT = new ArrayList();
    this.dnU = new ArrayList();
    this.dnV = new ArrayList();
    long l = Util.nowMilliSecond();
    Log.d("MicroMsg.URISpanHandler", "init URISpanHandler");
    this.mContext = MMApplicationContext.getContext();
    this.dnS = new URISpanHandlerSet(this.mContext);
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
              localObject2 = (URISpanHandlerSet.BaseUriSpanHandler)URISpanHandlerSet.BaseUriSpanHandler.class.cast(((Constructor)localObject2).newInstance(new Object[] { this.dnS }));
              localObject1 = ((URISpanHandlerSet.a)localObject1).Xq();
              if (localObject1 != URISpanHandlerSet.PRIORITY.LOW) {
                continue;
              }
              this.dnV.add(localObject2);
            }
            catch (Exception localException)
            {
              Object localObject1;
              Object localObject2;
              Log.printErrStackTrace("MicroMsg.URISpanHandler", localException, "", new Object[0]);
              Log.d("MicroMsg.URISpanHandler", "add %s error: %s, errorType:%s", new Object[] { localClass.getName(), localException.getMessage(), localException.getClass().getName() });
              break label460;
              if (localException != URISpanHandlerSet.PRIORITY.HIGH) {
                continue;
              }
              this.dnT.add(localObject2);
              continue;
            }
            catch (Error localError)
            {
              Log.printErrStackTrace("MicroMsg.URISpanHandler", localError, "", new Object[0]);
              Log.d("MicroMsg.URISpanHandler", "add %s error: %s, errorType:%s", new Object[] { localClass.getName(), localError.getMessage(), localError.getClass().getName() });
            }
            Log.d("MicroMsg.URISpanHandler", "successfully add: %s", new Object[] { localClass.getName() });
            break label460;
            if (localObject1 != URISpanHandlerSet.PRIORITY.NORMAL) {
              continue;
            }
            this.dnU.add(localObject2);
          }
          label409:
          Log.d("MicroMsg.URISpanHandler", "failed to add %s, constructor is null!!", new Object[] { localClass.getName() });
        }
      }
      else
      {
        Log.d("MicroMsg.URISpanHandler", "init URISpanHandler used :%d ms", new Object[] { Long.valueOf(Util.nowMilliSecond() - l) });
        AppMethodBeat.o(19669);
        return;
      }
      label460:
      i += 1;
    }
  }
  
  public static e Xo()
  {
    AppMethodBeat.i(19668);
    if (dnR == null) {
      dnR = new e();
    }
    e locale = dnR;
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
  
  public final boolean a(Context paramContext, View paramView, com.tencent.mm.pluginsdk.ui.applet.u paramu, i parami)
  {
    AppMethodBeat.i(231414);
    if (paramu == null)
    {
      Log.d("MicroMsg.URISpanHandler", "handleSpanClick, hrefInfo is null");
      AppMethodBeat.o(231414);
      return false;
    }
    int i = paramu.type;
    if (parami == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.URISpanHandler", "handleSpanClick, hrefInfo.getType:%d, callback==null:%b, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size:%d, mLowPriorityHandlerList.size:%d", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(this.dnT.size()), Integer.valueOf(this.dnU.size()), Integer.valueOf(this.dnV.size()) });
      if (paramContext != null) {
        break;
      }
      Log.e("MicroMsg.URISpanHandler", "handleSpanClick, context is null!");
      this.dnS.mContext = null;
      AppMethodBeat.o(231414);
      return false;
    }
    this.mContext = paramContext;
    this.dnS.mContext = this.mContext;
    paramContext = this.dnT.iterator();
    URISpanHandlerSet.BaseUriSpanHandler localBaseUriSpanHandler;
    while (paramContext.hasNext())
    {
      localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if ((contains(localBaseUriSpanHandler.Xp(), paramu.type)) && (localBaseUriSpanHandler.a(paramView, paramu, parami)))
      {
        Log.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", new Object[] { localBaseUriSpanHandler.getClass().getName() });
        this.mContext = null;
        this.dnS.mContext = null;
        AppMethodBeat.o(231414);
        return true;
      }
    }
    paramContext = this.dnU.iterator();
    while (paramContext.hasNext())
    {
      localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if ((contains(localBaseUriSpanHandler.Xp(), paramu.type)) && (localBaseUriSpanHandler.a(paramView, paramu, parami)))
      {
        Log.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", new Object[] { localBaseUriSpanHandler.getClass().getName() });
        this.mContext = null;
        this.dnS.mContext = null;
        AppMethodBeat.o(231414);
        return true;
      }
    }
    paramContext = this.dnV.iterator();
    while (paramContext.hasNext())
    {
      localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if ((contains(localBaseUriSpanHandler.Xp(), paramu.type)) && (localBaseUriSpanHandler.a(paramView, paramu, parami)))
      {
        Log.d("MicroMsg.URISpanHandler", "handleSpanClick, %s handle", new Object[] { localBaseUriSpanHandler.getClass().getName() });
        this.mContext = null;
        this.dnS.mContext = null;
        AppMethodBeat.o(231414);
        return true;
      }
    }
    this.mContext = null;
    this.dnS.mContext = null;
    Log.d("MicroMsg.URISpanHandler", "handleSpanClick, nothing handle");
    AppMethodBeat.o(231414);
    return false;
  }
  
  public final boolean b(Context paramContext, String paramString, boolean paramBoolean, com.tencent.mm.pluginsdk.u paramu, Bundle paramBundle)
  {
    AppMethodBeat.i(19672);
    if (paramu == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("MicroMsg.URISpanHandler", "handleUriJump, url:%s, isAllowScanQrCode:%b, callback==null:%b, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size: %d, mLowPriorityHandlerList.size: %d", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(bool), Integer.valueOf(this.dnT.size()), Integer.valueOf(this.dnU.size()), Integer.valueOf(this.dnV.size()) });
      if (paramContext != null) {
        break;
      }
      Log.e("MicroMsg.URISpanHandler", "handleUriJump, context is null!");
      this.dnS.mContext = null;
      AppMethodBeat.o(19672);
      return false;
    }
    this.mContext = paramContext;
    this.dnS.mContext = this.mContext;
    if (Util.isNullOrNil(paramString))
    {
      Log.d("MicroMsg.URISpanHandler", "handleUriJump, url is null");
      this.mContext = null;
      this.dnS.mContext = null;
      AppMethodBeat.o(19672);
      return false;
    }
    paramContext = this.dnT.iterator();
    URISpanHandlerSet.BaseUriSpanHandler localBaseUriSpanHandler;
    while (paramContext.hasNext())
    {
      localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if (localBaseUriSpanHandler.a(paramString, paramBoolean, paramu, paramBundle))
      {
        Log.d("MicroMsg.URISpanHandler", "handleUriJump, %s handle", new Object[] { localBaseUriSpanHandler.getClass().getName() });
        this.mContext = null;
        this.dnS.mContext = null;
        AppMethodBeat.o(19672);
        return true;
      }
    }
    paramContext = this.dnU.iterator();
    while (paramContext.hasNext())
    {
      localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if (localBaseUriSpanHandler.a(paramString, paramBoolean, paramu, paramBundle))
      {
        Log.d("MicroMsg.URISpanHandler", "handleUriJump, %s handle", new Object[] { localBaseUriSpanHandler.getClass().getName() });
        this.mContext = null;
        this.dnS.mContext = null;
        AppMethodBeat.o(19672);
        return true;
      }
    }
    paramContext = this.dnV.iterator();
    while (paramContext.hasNext())
    {
      localBaseUriSpanHandler = (URISpanHandlerSet.BaseUriSpanHandler)paramContext.next();
      if (localBaseUriSpanHandler.a(paramString, paramBoolean, paramu, paramBundle))
      {
        Log.d("MicroMsg.URISpanHandler", "handleUriJump, %s handle", new Object[] { localBaseUriSpanHandler.getClass().getName() });
        this.mContext = null;
        this.dnS.mContext = null;
        AppMethodBeat.o(19672);
        return true;
      }
    }
    this.mContext = null;
    this.dnS.mContext = null;
    Log.d("MicroMsg.URISpanHandler", "handleUriJump, nothing handle");
    AppMethodBeat.o(19672);
    return false;
  }
  
  public final com.tencent.mm.pluginsdk.ui.applet.u w(Context paramContext, String paramString)
  {
    AppMethodBeat.i(19670);
    Log.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, url:%s, mHighPriorityHandlerList.size:%d, mNormalPriorityHandlerList.size:%d, mLowPriorityHandlerList.size：%d", new Object[] { paramString, Integer.valueOf(this.dnT.size()), Integer.valueOf(this.dnU.size()), Integer.valueOf(this.dnV.size()) });
    if (paramContext == null)
    {
      Log.e("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl error, context is null!");
      this.dnS.mContext = null;
      AppMethodBeat.o(19670);
      return null;
    }
    this.mContext = paramContext;
    this.dnS.mContext = this.mContext;
    if (Util.isNullOrNil(paramString))
    {
      Log.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, url is null");
      this.mContext = null;
      this.dnS.mContext = null;
      AppMethodBeat.o(19670);
      return null;
    }
    paramContext = this.dnT.iterator();
    com.tencent.mm.pluginsdk.ui.applet.u localu;
    while (paramContext.hasNext())
    {
      localu = ((URISpanHandlerSet.BaseUriSpanHandler)paramContext.next()).gx(paramString);
      if (localu != null)
      {
        Log.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", new Object[] { Integer.valueOf(localu.type) });
        this.mContext = null;
        this.dnS.mContext = null;
        AppMethodBeat.o(19670);
        return localu;
      }
    }
    paramContext = this.dnU.iterator();
    while (paramContext.hasNext())
    {
      localu = ((URISpanHandlerSet.BaseUriSpanHandler)paramContext.next()).gx(paramString);
      if (localu != null)
      {
        Log.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", new Object[] { Integer.valueOf(localu.type) });
        this.mContext = null;
        this.dnS.mContext = null;
        AppMethodBeat.o(19670);
        return localu;
      }
    }
    paramContext = this.dnV.iterator();
    while (paramContext.hasNext())
    {
      localu = ((URISpanHandlerSet.BaseUriSpanHandler)paramContext.next()).gx(paramString);
      if (localu != null)
      {
        Log.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, result.type:%d", new Object[] { Integer.valueOf(localu.type) });
        this.mContext = null;
        this.dnS.mContext = null;
        AppMethodBeat.o(19670);
        return localu;
      }
    }
    this.mContext = null;
    this.dnS.mContext = null;
    Log.d("MicroMsg.URISpanHandler", "matchHrefInfoFromUrl, nothing match");
    AppMethodBeat.o(19670);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.plugin.e
 * JD-Core Version:    0.7.0.1
 */