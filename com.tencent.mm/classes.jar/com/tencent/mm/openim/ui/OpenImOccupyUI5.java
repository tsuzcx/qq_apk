package com.tencent.mm.openim.ui;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/openim/ui/OpenImOccupyUI5;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "getLayoutId", "", "Companion", "plugin-comm_release"})
public final class OpenImOccupyUI5
  extends MMActivity
{
  public static final a jHU;
  private HashMap _$_findViewCache;
  
  static
  {
    AppMethodBeat.i(223450);
    jHU = new a((byte)0);
    AppMethodBeat.o(223450);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(223452);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(223452);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(223451);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(223451);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 0;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/openim/ui/OpenImOccupyUI5$Companion;", "", "()V", "TAG", "", "plugin-comm_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.openim.ui.OpenImOccupyUI5
 * JD-Core Version:    0.7.0.1
 */