package com.tencent.mm.plugin.expt.hellhound.a.a.a;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public final class a
  implements b
{
  private Field KEP;
  private WeakReference<RecyclerView> pFP;
  private Field pFQ;
  private Field pFR;
  private Method pFS;
  private Method pFT;
  private Method pFU;
  private Method pFV;
  private Method pFW;
  
  public a()
  {
    AppMethodBeat.i(169309);
    ad.w("HABBYGE-MALI.FinderFeedParamsCatcher", "FinderFeedParamsCatcher");
    try
    {
      this.pFQ = Class.forName("com.tencent.mm.view.recyclerview.WxRecyclerAdapter").getDeclaredField("data");
      this.pFQ.setAccessible(true);
      this.KEP = Class.forName("com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter").getDeclaredField("feed");
      this.KEP.setAccessible(true);
      this.pFR = Class.forName("com.tencent.mm.plugin.finder.model.BaseFinderFeed").getDeclaredField("feedObject");
      this.pFR.setAccessible(true);
      Class localClass = Class.forName("com.tencent.mm.plugin.finder.storage.FinderItem");
      this.pFS = localClass.getDeclaredMethod("getId", new Class[0]);
      this.pFS.setAccessible(true);
      this.pFT = localClass.getDeclaredMethod("getUserName", new Class[0]);
      this.pFT.setAccessible(true);
      this.pFU = localClass.getDeclaredMethod("getNickName", new Class[0]);
      this.pFU.setAccessible(true);
      this.pFV = localClass.getDeclaredMethod("getLikeCount", new Class[0]);
      this.pFV.setAccessible(true);
      this.pFW = localClass.getDeclaredMethod("getCommentCount", new Class[0]);
      this.pFW.setAccessible(true);
      AppMethodBeat.o(169309);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("HABBYGE-MALI.FinderFeedParamsCatcher", localException, "reflect crash: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(169309);
    }
  }
  
  private String a(RecyclerView.a parama, int paramInt)
  {
    AppMethodBeat.i(169311);
    try
    {
      Object localObject = this.KEP.get(parama);
      if (localObject == null)
      {
        AppMethodBeat.o(169311);
        return null;
      }
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.ly(((Long)this.pFS.invoke(localObject, new Object[0])).longValue());
      AppMethodBeat.o(169311);
      return localObject;
    }
    catch (Exception localException)
    {
      try
      {
        parama = this.pFQ.get(parama);
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
        parama = this.pFR.get(parama);
        parama = com.tencent.mm.plugin.expt.hellhound.core.b.ly(((Long)this.pFS.invoke(parama, new Object[0])).longValue());
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
  
  public final void a(View paramView, PInt paramPInt1, PInt paramPInt2, int paramInt)
  {
    AppMethodBeat.i(169312);
    paramPInt1.value = 0;
    paramPInt2.value = 0;
    if (this.pFP == null)
    {
      AppMethodBeat.o(169312);
      return;
    }
    paramView = (RecyclerView)this.pFP.get();
    if (paramView == null)
    {
      AppMethodBeat.o(169312);
      return;
    }
    paramView = paramView.getAdapter();
    if (paramView == null)
    {
      ad.e("HABBYGE-MALI.FinderFeedParamsCatcher", "getFeedInfo, RecyclerView.Adapter==NULL !!");
      AppMethodBeat.o(169312);
      return;
    }
    try
    {
      Object localObject = this.pFQ.get(paramView);
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
      localObject = this.pFR.get(localObject);
      paramPInt1.value = ((Integer)this.pFV.invoke(localObject, new Object[0])).intValue();
      paramPInt2.value = ((Integer)this.pFW.invoke(localObject, new Object[0])).intValue();
      AppMethodBeat.o(169312);
      return;
    }
    catch (Exception localException)
    {
      try
      {
        paramView = this.KEP.get(paramView);
        if (paramView == null)
        {
          AppMethodBeat.o(169312);
          return;
        }
        paramPInt1.value = ((Integer)this.pFV.invoke(paramView, new Object[0])).intValue();
        paramPInt2.value = ((Integer)this.pFW.invoke(paramView, new Object[0])).intValue();
        AppMethodBeat.o(169312);
        return;
      }
      catch (Exception paramView)
      {
        ad.printErrStackTrace("HABBYGE-MALI.FinderFeedParamsCatcher", paramView, "getFeedInfo crash-1: %s", new Object[] { paramView.getMessage() });
        AppMethodBeat.o(169312);
      }
    }
  }
  
  public final String ab(View paramView, int paramInt)
  {
    AppMethodBeat.i(169310);
    if (this.pFP == null)
    {
      ad.e("HABBYGE-MALI.FinderFeedParamsCatcher", "getFeedId, mRecyclerView == NULL !?");
      AppMethodBeat.o(169310);
      return null;
    }
    paramView = (RecyclerView)this.pFP.get();
    if (paramView == null)
    {
      AppMethodBeat.o(169310);
      return null;
    }
    paramView = paramView.getAdapter();
    if (paramView == null)
    {
      ad.e("HABBYGE-MALI.FinderFeedParamsCatcher", "getFeedId, RecyclerView.Adapter == NULL !?");
      AppMethodBeat.o(169310);
      return null;
    }
    paramView = a(paramView, paramInt);
    AppMethodBeat.o(169310);
    return paramView;
  }
  
  public final String ac(View paramView, int paramInt)
  {
    AppMethodBeat.i(169313);
    if (this.pFP == null)
    {
      AppMethodBeat.o(169313);
      return null;
    }
    paramView = (RecyclerView)this.pFP.get();
    if (paramView == null)
    {
      AppMethodBeat.o(169313);
      return null;
    }
    paramView = paramView.getAdapter();
    if (paramView == null)
    {
      ad.e("HABBYGE-MALI.FinderFeedParamsCatcher", "getFeedUserName, RecyclerView.Adapter == NULL !?");
      AppMethodBeat.o(169313);
      return null;
    }
    try
    {
      Object localObject = this.pFQ.get(paramView);
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
      localObject = this.pFR.get(localObject);
      localObject = (String)this.pFT.invoke(localObject, new Object[0]);
      AppMethodBeat.o(169313);
      return localObject;
    }
    catch (Exception localException)
    {
      try
      {
        paramView = this.KEP.get(paramView);
        if (paramView == null)
        {
          AppMethodBeat.o(169313);
          return null;
        }
        paramView = (String)this.pFT.invoke(paramView, new Object[0]);
        AppMethodBeat.o(169313);
        return paramView;
      }
      catch (Exception paramView)
      {
        ad.printErrStackTrace("HABBYGE-MALI.FinderFeedParamsCatcher", paramView, "getFeedUserName crash-1: %s", new Object[] { paramView.getMessage() });
        AppMethodBeat.o(169313);
      }
    }
    return null;
  }
  
  public final String ad(View paramView, int paramInt)
  {
    AppMethodBeat.i(185578);
    if (this.pFP == null)
    {
      AppMethodBeat.o(185578);
      return null;
    }
    paramView = (RecyclerView)this.pFP.get();
    if (paramView == null)
    {
      AppMethodBeat.o(185578);
      return null;
    }
    paramView = paramView.getAdapter();
    if (paramView == null)
    {
      ad.e("HABBYGE-MALI.FinderFeedParamsCatcher", "getFeedUserName, RecyclerView.Adapter == NULL !?");
      AppMethodBeat.o(185578);
      return null;
    }
    try
    {
      Object localObject = this.pFQ.get(paramView);
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
      localObject = this.pFR.get(localObject);
      localObject = (String)this.pFU.invoke(localObject, new Object[0]);
      AppMethodBeat.o(185578);
      return localObject;
    }
    catch (Exception localException)
    {
      try
      {
        paramView = this.KEP.get(paramView);
        if (paramView == null)
        {
          AppMethodBeat.o(185578);
          return null;
        }
        paramView = (String)this.pFU.invoke(paramView, new Object[0]);
        AppMethodBeat.o(185578);
        return paramView;
      }
      catch (Exception paramView)
      {
        ad.printErrStackTrace("HABBYGE-MALI.FinderFeedParamsCatcher", paramView, "getFeedNickName crash-1: %s", new Object[] { paramView.getMessage() });
        AppMethodBeat.o(185578);
      }
    }
    return null;
  }
  
  public final String agS(int paramInt)
  {
    return null;
  }
  
  public final boolean dO(View paramView)
  {
    return false;
  }
  
  public final void setRecyclerView(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(186068);
    this.pFP = new WeakReference(paramRecyclerView);
    AppMethodBeat.o(186068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */