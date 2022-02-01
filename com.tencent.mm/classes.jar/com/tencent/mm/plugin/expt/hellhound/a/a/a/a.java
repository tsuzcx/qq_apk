package com.tencent.mm.plugin.expt.hellhound.a.a.a;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public final class a
  implements b
{
  private WeakReference<RecyclerView> rbC;
  private Field rbD;
  private Field rbE;
  private Field rbF;
  private Method rbG;
  private Method rbH;
  private Method rbI;
  private Method rbJ;
  private Method rbK;
  
  public a()
  {
    AppMethodBeat.i(169309);
    ae.w("HABBYGE-MALI.FinderFeedParamsCatcher", "FinderFeedParamsCatcher");
    try
    {
      this.rbD = Class.forName("com.tencent.mm.view.recyclerview.WxRecyclerAdapter").getDeclaredField("data");
      this.rbD.setAccessible(true);
      this.rbE = Class.forName("com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter").getDeclaredField("feed");
      this.rbE.setAccessible(true);
      this.rbF = Class.forName("com.tencent.mm.plugin.finder.model.BaseFinderFeed").getDeclaredField("feedObject");
      this.rbF.setAccessible(true);
      Class localClass = Class.forName("com.tencent.mm.plugin.finder.storage.FinderItem");
      this.rbG = localClass.getDeclaredMethod("getId", new Class[0]);
      this.rbG.setAccessible(true);
      this.rbH = localClass.getDeclaredMethod("getUserName", new Class[0]);
      this.rbH.setAccessible(true);
      this.rbI = localClass.getDeclaredMethod("getNickName", new Class[0]);
      this.rbI.setAccessible(true);
      this.rbJ = localClass.getDeclaredMethod("getLikeCount", new Class[0]);
      this.rbJ.setAccessible(true);
      this.rbK = localClass.getDeclaredMethod("getCommentCount", new Class[0]);
      this.rbK.setAccessible(true);
      AppMethodBeat.o(169309);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("HABBYGE-MALI.FinderFeedParamsCatcher", localException, "reflect crash: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(169309);
    }
  }
  
  private String a(RecyclerView.a parama, int paramInt)
  {
    AppMethodBeat.i(169311);
    try
    {
      Object localObject = this.rbE.get(parama);
      if (localObject == null)
      {
        AppMethodBeat.o(169311);
        return null;
      }
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.rp(((Long)this.rbG.invoke(localObject, new Object[0])).longValue());
      AppMethodBeat.o(169311);
      return localObject;
    }
    catch (Exception localException)
    {
      try
      {
        parama = this.rbD.get(parama);
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
        parama = this.rbF.get(parama);
        parama = com.tencent.mm.plugin.expt.hellhound.core.b.rp(((Long)this.rbG.invoke(parama, new Object[0])).longValue());
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
  
  public final String Dn(int paramInt)
  {
    return null;
  }
  
  public final void a(View paramView, PInt paramPInt1, PInt paramPInt2, int paramInt)
  {
    AppMethodBeat.i(169312);
    paramPInt1.value = 0;
    paramPInt2.value = 0;
    if (this.rbC == null)
    {
      AppMethodBeat.o(169312);
      return;
    }
    paramView = (RecyclerView)this.rbC.get();
    if (paramView == null)
    {
      AppMethodBeat.o(169312);
      return;
    }
    paramView = paramView.getAdapter();
    if (paramView == null)
    {
      ae.e("HABBYGE-MALI.FinderFeedParamsCatcher", "getFeedInfo, RecyclerView.Adapter==NULL !!");
      AppMethodBeat.o(169312);
      return;
    }
    try
    {
      Object localObject = this.rbD.get(paramView);
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
      localObject = this.rbF.get(localObject);
      paramPInt1.value = ((Integer)this.rbJ.invoke(localObject, new Object[0])).intValue();
      paramPInt2.value = ((Integer)this.rbK.invoke(localObject, new Object[0])).intValue();
      AppMethodBeat.o(169312);
      return;
    }
    catch (Exception localException)
    {
      try
      {
        paramView = this.rbE.get(paramView);
        if (paramView == null)
        {
          AppMethodBeat.o(169312);
          return;
        }
        paramPInt1.value = ((Integer)this.rbJ.invoke(paramView, new Object[0])).intValue();
        paramPInt2.value = ((Integer)this.rbK.invoke(paramView, new Object[0])).intValue();
        AppMethodBeat.o(169312);
        return;
      }
      catch (Exception paramView)
      {
        ae.printErrStackTrace("HABBYGE-MALI.FinderFeedParamsCatcher", paramView, "getFeedInfo crash-1: %s", new Object[] { paramView.getMessage() });
        AppMethodBeat.o(169312);
      }
    }
  }
  
  public final String ad(View paramView, int paramInt)
  {
    AppMethodBeat.i(169310);
    if (this.rbC == null)
    {
      ae.e("HABBYGE-MALI.FinderFeedParamsCatcher", "getFeedId, mRecyclerView == NULL !?");
      AppMethodBeat.o(169310);
      return null;
    }
    paramView = (RecyclerView)this.rbC.get();
    if (paramView == null)
    {
      AppMethodBeat.o(169310);
      return null;
    }
    paramView = paramView.getAdapter();
    if (paramView == null)
    {
      ae.e("HABBYGE-MALI.FinderFeedParamsCatcher", "getFeedId, RecyclerView.Adapter == NULL !?");
      AppMethodBeat.o(169310);
      return null;
    }
    paramView = a(paramView, paramInt);
    AppMethodBeat.o(169310);
    return paramView;
  }
  
  public final String ae(View paramView, int paramInt)
  {
    AppMethodBeat.i(169313);
    if (this.rbC == null)
    {
      AppMethodBeat.o(169313);
      return null;
    }
    paramView = (RecyclerView)this.rbC.get();
    if (paramView == null)
    {
      AppMethodBeat.o(169313);
      return null;
    }
    paramView = paramView.getAdapter();
    if (paramView == null)
    {
      ae.e("HABBYGE-MALI.FinderFeedParamsCatcher", "getFeedUserName, RecyclerView.Adapter == NULL !?");
      AppMethodBeat.o(169313);
      return null;
    }
    try
    {
      Object localObject = this.rbD.get(paramView);
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
      localObject = this.rbF.get(localObject);
      localObject = (String)this.rbH.invoke(localObject, new Object[0]);
      AppMethodBeat.o(169313);
      return localObject;
    }
    catch (Exception localException)
    {
      try
      {
        paramView = this.rbE.get(paramView);
        if (paramView == null)
        {
          AppMethodBeat.o(169313);
          return null;
        }
        paramView = (String)this.rbH.invoke(paramView, new Object[0]);
        AppMethodBeat.o(169313);
        return paramView;
      }
      catch (Exception paramView)
      {
        ae.printErrStackTrace("HABBYGE-MALI.FinderFeedParamsCatcher", paramView, "getFeedUserName crash-1: %s", new Object[] { paramView.getMessage() });
        AppMethodBeat.o(169313);
      }
    }
    return null;
  }
  
  public final String af(View paramView, int paramInt)
  {
    AppMethodBeat.i(185578);
    if (this.rbC == null)
    {
      AppMethodBeat.o(185578);
      return null;
    }
    paramView = (RecyclerView)this.rbC.get();
    if (paramView == null)
    {
      AppMethodBeat.o(185578);
      return null;
    }
    paramView = paramView.getAdapter();
    if (paramView == null)
    {
      ae.e("HABBYGE-MALI.FinderFeedParamsCatcher", "getFeedUserName, RecyclerView.Adapter == NULL !?");
      AppMethodBeat.o(185578);
      return null;
    }
    try
    {
      Object localObject = this.rbD.get(paramView);
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
      localObject = this.rbF.get(localObject);
      localObject = (String)this.rbI.invoke(localObject, new Object[0]);
      AppMethodBeat.o(185578);
      return localObject;
    }
    catch (Exception localException)
    {
      try
      {
        paramView = this.rbE.get(paramView);
        if (paramView == null)
        {
          AppMethodBeat.o(185578);
          return null;
        }
        paramView = (String)this.rbI.invoke(paramView, new Object[0]);
        AppMethodBeat.o(185578);
        return paramView;
      }
      catch (Exception paramView)
      {
        ae.printErrStackTrace("HABBYGE-MALI.FinderFeedParamsCatcher", paramView, "getFeedNickName crash-1: %s", new Object[] { paramView.getMessage() });
        AppMethodBeat.o(185578);
      }
    }
    return null;
  }
  
  public final boolean dX(View paramView)
  {
    return false;
  }
  
  public final void setRecyclerView(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(186068);
    this.rbC = new WeakReference(paramRecyclerView);
    AppMethodBeat.o(186068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */