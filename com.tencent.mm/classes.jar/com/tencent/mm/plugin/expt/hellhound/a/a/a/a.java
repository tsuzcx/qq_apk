package com.tencent.mm.plugin.expt.hellhound.a.a.a;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public final class a
  implements b
{
  private WeakReference<RecyclerView> sCb;
  private Field sCc;
  private Field sCd;
  private Field sCe;
  private Method sCf;
  private Method sCg;
  private Method sCh;
  private Method sCi;
  private Method sCj;
  
  public a()
  {
    AppMethodBeat.i(169309);
    Log.w("HABBYGE-MALI.FinderFeedParamsCatcher", "FinderFeedParamsCatcher");
    try
    {
      this.sCc = Class.forName("com.tencent.mm.view.recyclerview.WxRecyclerAdapter").getDeclaredField("data");
      this.sCc.setAccessible(true);
      this.sCd = Class.forName("com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter").getDeclaredField("feed");
      this.sCd.setAccessible(true);
      this.sCe = Class.forName("com.tencent.mm.plugin.finder.model.BaseFinderFeed").getDeclaredField("feedObject");
      this.sCe.setAccessible(true);
      Class localClass = Class.forName("com.tencent.mm.plugin.finder.storage.FeedData");
      this.sCf = localClass.getDeclaredMethod("getId", new Class[0]);
      this.sCf.setAccessible(true);
      this.sCg = localClass.getDeclaredMethod("getUserName", new Class[0]);
      this.sCg.setAccessible(true);
      this.sCh = localClass.getDeclaredMethod("getNickName", new Class[0]);
      this.sCh.setAccessible(true);
      this.sCi = localClass.getDeclaredMethod("getLikeCount", new Class[0]);
      this.sCi.setAccessible(true);
      this.sCj = localClass.getDeclaredMethod("getCommentCount", new Class[0]);
      this.sCj.setAccessible(true);
      AppMethodBeat.o(169309);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.FinderFeedParamsCatcher", localException, "reflect crash: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(169309);
    }
  }
  
  private String a(RecyclerView.a parama, int paramInt)
  {
    AppMethodBeat.i(169311);
    try
    {
      Object localObject = this.sCd.get(parama);
      if (localObject == null)
      {
        AppMethodBeat.o(169311);
        return null;
      }
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.zs(((Long)this.sCf.invoke(localObject, new Object[0])).longValue());
      AppMethodBeat.o(169311);
      return localObject;
    }
    catch (Exception localException)
    {
      try
      {
        parama = this.sCc.get(parama);
        if (parama == null)
        {
          AppMethodBeat.o(169311);
          return null;
        }
        parama = (ArrayList)parama;
        if ((!parama.isEmpty()) && (paramInt >= 0))
        {
          int i = parama.size();
          if (paramInt < i) {}
        }
        else
        {
          AppMethodBeat.o(169311);
          return null;
        }
        parama = parama.get(paramInt);
        if (parama == null)
        {
          AppMethodBeat.o(169311);
          return null;
        }
        parama = this.sCe.get(parama);
        parama = com.tencent.mm.plugin.expt.hellhound.core.b.zs(((Long)this.sCf.invoke(parama, new Object[0])).longValue());
        AppMethodBeat.o(169311);
        return parama;
      }
      catch (Exception parama)
      {
        AppMethodBeat.o(169311);
      }
    }
    return null;
  }
  
  public final String GY(int paramInt)
  {
    return null;
  }
  
  public final void a(View paramView, PInt paramPInt1, PInt paramPInt2, int paramInt)
  {
    AppMethodBeat.i(169312);
    paramPInt1.value = 0;
    paramPInt2.value = 0;
    if (this.sCb == null)
    {
      AppMethodBeat.o(169312);
      return;
    }
    paramView = (RecyclerView)this.sCb.get();
    if (paramView == null)
    {
      AppMethodBeat.o(169312);
      return;
    }
    paramView = paramView.getAdapter();
    if (paramView == null)
    {
      Log.e("HABBYGE-MALI.FinderFeedParamsCatcher", "getFeedInfo, RecyclerView.Adapter==NULL !!");
      AppMethodBeat.o(169312);
      return;
    }
    try
    {
      Object localObject = this.sCc.get(paramView);
      if (localObject == null)
      {
        AppMethodBeat.o(169312);
        return;
      }
      localObject = ((ArrayList)localObject).get(paramInt);
      if (localObject == null)
      {
        AppMethodBeat.o(169312);
        return;
      }
      localObject = this.sCe.get(localObject);
      paramPInt1.value = ((Integer)this.sCi.invoke(localObject, new Object[0])).intValue();
      paramPInt2.value = ((Integer)this.sCj.invoke(localObject, new Object[0])).intValue();
      AppMethodBeat.o(169312);
      return;
    }
    catch (Exception localException)
    {
      try
      {
        paramView = this.sCd.get(paramView);
        if (paramView == null)
        {
          AppMethodBeat.o(169312);
          return;
        }
        paramPInt1.value = ((Integer)this.sCi.invoke(paramView, new Object[0])).intValue();
        paramPInt2.value = ((Integer)this.sCj.invoke(paramView, new Object[0])).intValue();
        AppMethodBeat.o(169312);
        return;
      }
      catch (Exception paramView)
      {
        Log.printErrStackTrace("HABBYGE-MALI.FinderFeedParamsCatcher", paramView, "getFeedInfo crash-1: %s", new Object[] { paramView.getMessage() });
        AppMethodBeat.o(169312);
      }
    }
  }
  
  public final String ac(View paramView, int paramInt)
  {
    AppMethodBeat.i(169310);
    if (this.sCb == null)
    {
      Log.e("HABBYGE-MALI.FinderFeedParamsCatcher", "getFeedId, mRecyclerView == NULL !?");
      AppMethodBeat.o(169310);
      return null;
    }
    paramView = (RecyclerView)this.sCb.get();
    if (paramView == null)
    {
      AppMethodBeat.o(169310);
      return null;
    }
    paramView = paramView.getAdapter();
    if (paramView == null)
    {
      Log.e("HABBYGE-MALI.FinderFeedParamsCatcher", "getFeedId, RecyclerView.Adapter == NULL !?");
      AppMethodBeat.o(169310);
      return null;
    }
    paramView = a(paramView, paramInt);
    AppMethodBeat.o(169310);
    return paramView;
  }
  
  public final String ad(View paramView, int paramInt)
  {
    AppMethodBeat.i(169313);
    if (this.sCb == null)
    {
      AppMethodBeat.o(169313);
      return null;
    }
    paramView = (RecyclerView)this.sCb.get();
    if (paramView == null)
    {
      AppMethodBeat.o(169313);
      return null;
    }
    paramView = paramView.getAdapter();
    if (paramView == null)
    {
      Log.e("HABBYGE-MALI.FinderFeedParamsCatcher", "getFeedUserName, RecyclerView.Adapter == NULL !?");
      AppMethodBeat.o(169313);
      return null;
    }
    try
    {
      Object localObject = this.sCc.get(paramView);
      if (localObject == null)
      {
        AppMethodBeat.o(169313);
        return null;
      }
      localObject = ((ArrayList)localObject).get(paramInt);
      if (localObject == null)
      {
        AppMethodBeat.o(169313);
        return null;
      }
      localObject = this.sCe.get(localObject);
      localObject = (String)this.sCg.invoke(localObject, new Object[0]);
      AppMethodBeat.o(169313);
      return localObject;
    }
    catch (Exception localException)
    {
      try
      {
        paramView = this.sCd.get(paramView);
        if (paramView == null)
        {
          AppMethodBeat.o(169313);
          return null;
        }
        paramView = (String)this.sCg.invoke(paramView, new Object[0]);
        AppMethodBeat.o(169313);
        return paramView;
      }
      catch (Exception paramView)
      {
        Log.printErrStackTrace("HABBYGE-MALI.FinderFeedParamsCatcher", paramView, "getFeedUserName crash-1: %s", new Object[] { paramView.getMessage() });
        AppMethodBeat.o(169313);
      }
    }
    return null;
  }
  
  public final String ae(View paramView, int paramInt)
  {
    AppMethodBeat.i(185578);
    if (this.sCb == null)
    {
      AppMethodBeat.o(185578);
      return null;
    }
    paramView = (RecyclerView)this.sCb.get();
    if (paramView == null)
    {
      AppMethodBeat.o(185578);
      return null;
    }
    paramView = paramView.getAdapter();
    if (paramView == null)
    {
      Log.e("HABBYGE-MALI.FinderFeedParamsCatcher", "getFeedUserName, RecyclerView.Adapter == NULL !?");
      AppMethodBeat.o(185578);
      return null;
    }
    try
    {
      Object localObject = this.sCc.get(paramView);
      if (localObject == null)
      {
        AppMethodBeat.o(185578);
        return null;
      }
      localObject = ((ArrayList)localObject).get(paramInt);
      if (localObject == null)
      {
        AppMethodBeat.o(185578);
        return null;
      }
      localObject = this.sCe.get(localObject);
      localObject = (String)this.sCh.invoke(localObject, new Object[0]);
      AppMethodBeat.o(185578);
      return localObject;
    }
    catch (Exception localException)
    {
      try
      {
        paramView = this.sCd.get(paramView);
        if (paramView == null)
        {
          AppMethodBeat.o(185578);
          return null;
        }
        paramView = (String)this.sCh.invoke(paramView, new Object[0]);
        AppMethodBeat.o(185578);
        return paramView;
      }
      catch (Exception paramView)
      {
        Log.printErrStackTrace("HABBYGE-MALI.FinderFeedParamsCatcher", paramView, "getFeedNickName crash-1: %s", new Object[] { paramView.getMessage() });
        AppMethodBeat.o(185578);
      }
    }
    return null;
  }
  
  public final boolean dP(View paramView)
  {
    return false;
  }
  
  public final void setRecyclerView(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(186068);
    this.sCb = new WeakReference(paramRecyclerView);
    AppMethodBeat.o(186068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */