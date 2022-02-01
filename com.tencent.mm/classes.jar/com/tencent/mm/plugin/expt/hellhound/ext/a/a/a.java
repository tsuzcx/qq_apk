package com.tencent.mm.plugin.expt.hellhound.ext.a.a;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
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
  private WeakReference<RecyclerView> zDZ;
  private Field zEa;
  private Field zEb;
  private Field zEc;
  private Method zEd;
  private Method zEe;
  private Method zEf;
  private Method zEg;
  private Method zEh;
  
  public a()
  {
    AppMethodBeat.i(169309);
    Log.w("HABBYGE-MALI.FinderFeedParamsCatcher", "FinderFeedParamsCatcher");
    try
    {
      this.zEa = Class.forName("com.tencent.mm.view.recyclerview.WxRecyclerAdapter").getDeclaredField("data");
      this.zEa.setAccessible(true);
      this.zEb = Class.forName("com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter").getDeclaredField("feed");
      this.zEb.setAccessible(true);
      this.zEc = Class.forName("com.tencent.mm.plugin.finder.model.BaseFinderFeed").getDeclaredField("feedObject");
      this.zEc.setAccessible(true);
      Class localClass = Class.forName("com.tencent.mm.plugin.finder.storage.FeedData");
      this.zEd = localClass.getDeclaredMethod("getId", new Class[0]);
      this.zEd.setAccessible(true);
      this.zEe = localClass.getDeclaredMethod("getUserName", new Class[0]);
      this.zEe.setAccessible(true);
      this.zEf = localClass.getDeclaredMethod("getNickName", new Class[0]);
      this.zEf.setAccessible(true);
      this.zEg = localClass.getDeclaredMethod("getLikeCount", new Class[0]);
      this.zEg.setAccessible(true);
      this.zEh = localClass.getDeclaredMethod("getCommentCount", new Class[0]);
      this.zEh.setAccessible(true);
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
    AppMethodBeat.i(300136);
    try
    {
      Object localObject = this.zEb.get(parama);
      if (localObject == null)
      {
        AppMethodBeat.o(300136);
        return null;
      }
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.hF(((Long)this.zEd.invoke(localObject, new Object[0])).longValue());
      AppMethodBeat.o(300136);
      return localObject;
    }
    catch (Exception localException)
    {
      try
      {
        parama = this.zEa.get(parama);
        if (parama == null)
        {
          AppMethodBeat.o(300136);
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
          AppMethodBeat.o(300136);
          return null;
        }
        parama = parama.get(paramInt);
        if (parama == null)
        {
          AppMethodBeat.o(300136);
          return null;
        }
        parama = this.zEc.get(parama);
        parama = com.tencent.mm.plugin.expt.hellhound.core.b.hF(((Long)this.zEd.invoke(parama, new Object[0])).longValue());
        AppMethodBeat.o(300136);
        return parama;
      }
      catch (Exception parama)
      {
        AppMethodBeat.o(300136);
      }
    }
    return null;
  }
  
  public final String LH(int paramInt)
  {
    return null;
  }
  
  public final void a(View paramView, PInt paramPInt1, PInt paramPInt2, int paramInt)
  {
    AppMethodBeat.i(169312);
    paramPInt1.value = 0;
    paramPInt2.value = 0;
    if (this.zDZ == null)
    {
      AppMethodBeat.o(169312);
      return;
    }
    paramView = (RecyclerView)this.zDZ.get();
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
      Object localObject = this.zEa.get(paramView);
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
      localObject = this.zEc.get(localObject);
      paramPInt1.value = ((Integer)this.zEg.invoke(localObject, new Object[0])).intValue();
      paramPInt2.value = ((Integer)this.zEh.invoke(localObject, new Object[0])).intValue();
      AppMethodBeat.o(169312);
      return;
    }
    catch (Exception localException)
    {
      try
      {
        paramView = this.zEb.get(paramView);
        if (paramView == null)
        {
          AppMethodBeat.o(169312);
          return;
        }
        paramPInt1.value = ((Integer)this.zEg.invoke(paramView, new Object[0])).intValue();
        paramPInt2.value = ((Integer)this.zEh.invoke(paramView, new Object[0])).intValue();
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
  
  public final String aj(View paramView, int paramInt)
  {
    AppMethodBeat.i(169310);
    if (this.zDZ == null)
    {
      Log.e("HABBYGE-MALI.FinderFeedParamsCatcher", "getFeedId, mRecyclerView == NULL !?");
      AppMethodBeat.o(169310);
      return null;
    }
    paramView = (RecyclerView)this.zDZ.get();
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
  
  public final String ak(View paramView, int paramInt)
  {
    AppMethodBeat.i(169313);
    if (this.zDZ == null)
    {
      AppMethodBeat.o(169313);
      return null;
    }
    paramView = (RecyclerView)this.zDZ.get();
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
      Object localObject = this.zEa.get(paramView);
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
      localObject = this.zEc.get(localObject);
      localObject = (String)this.zEe.invoke(localObject, new Object[0]);
      AppMethodBeat.o(169313);
      return localObject;
    }
    catch (Exception localException)
    {
      try
      {
        paramView = this.zEb.get(paramView);
        if (paramView == null)
        {
          AppMethodBeat.o(169313);
          return null;
        }
        paramView = (String)this.zEe.invoke(paramView, new Object[0]);
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
  
  public final String al(View paramView, int paramInt)
  {
    AppMethodBeat.i(185578);
    if (this.zDZ == null)
    {
      AppMethodBeat.o(185578);
      return null;
    }
    paramView = (RecyclerView)this.zDZ.get();
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
      Object localObject = this.zEa.get(paramView);
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
      localObject = this.zEc.get(localObject);
      localObject = (String)this.zEf.invoke(localObject, new Object[0]);
      AppMethodBeat.o(185578);
      return localObject;
    }
    catch (Exception localException)
    {
      try
      {
        paramView = this.zEb.get(paramView);
        if (paramView == null)
        {
          AppMethodBeat.o(185578);
          return null;
        }
        paramView = (String)this.zEf.invoke(paramView, new Object[0]);
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
  
  public final boolean fh(View paramView)
  {
    return false;
  }
  
  public final void setRecyclerView(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(300138);
    this.zDZ = new WeakReference(paramRecyclerView);
    AppMethodBeat.o(300138);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.a.a.a
 * JD-Core Version:    0.7.0.1
 */