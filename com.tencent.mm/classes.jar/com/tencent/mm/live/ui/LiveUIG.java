package com.tencent.mm.live.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import d.g.b.k;
import d.l;
import d.v;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/ui/LiveUIG;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "adapter", "Lcom/tencent/mm/live/ui/LiveUIG$ChoiceAdapter;", "listview", "Landroid/widget/ListView;", "selectsList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/live/ui/LiveUIG$ITestMenu;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "ChoiceAdapter", "ChoiceItem", "Companion", "ITestMenu", "plugin-logic_release"})
public final class LiveUIG
  extends MMActivity
{
  public static final LiveUIG.c KyQ;
  private LiveUIG.a KyP;
  private ListView izP;
  private final LinkedList<LiveUIG.d> qPR;
  
  static
  {
    AppMethodBeat.i(203307);
    KyQ = new LiveUIG.c((byte)0);
    AppMethodBeat.o(203307);
  }
  
  public LiveUIG()
  {
    AppMethodBeat.i(203306);
    this.qPR = new LinkedList();
    AppMethodBeat.o(203306);
  }
  
  public final int getLayoutId()
  {
    return 2131496328;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(203305);
    super.onCreate(paramBundle);
    paramBundle = findViewById(2131307638);
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type android.widget.ListView");
      AppMethodBeat.o(203305);
      throw paramBundle;
    }
    this.izP = ((ListView)paramBundle);
    this.KyP = new LiveUIG.a(this);
    paramBundle = this.izP;
    if (paramBundle == null) {
      k.fvU();
    }
    LiveUIG.a locala = this.KyP;
    if (locala == null) {
      k.aPZ("adapter");
    }
    paramBundle.setAdapter((ListAdapter)locala);
    this.qPR.add(new LiveUIG.b(this, "Live Mode 开关", ae.a.LBC, new String[] { "open", "close", "default" }, new int[] { 1, 2, 0 }));
    this.qPR.add(new LiveUIG.b(this, "Live DebugView 开关", ae.a.LBD, new String[] { "open", "close", "default" }, new int[] { 1, 2, 0 }));
    this.qPR.add(new LiveUIG.b(this, "主播自定义房间id", ae.a.LBE, new String[] { "open", "close", "default" }, new int[] { 1, 2, 0 }));
    this.qPR.add(new LiveUIG.b(this, "观众自定义房间id", ae.a.LBF, new String[] { "open", "close", "default" }, new int[] { 1, 2, 0 }));
    this.qPR.add(new LiveUIG.b(this, "Live Entrance 开关", ae.a.LBG, new String[] { "open", "close", "default" }, new int[] { 1, 2, 0 }));
    this.qPR.add(new LiveUIG.b(this, "观众首次微信群直播功能使用条款", ae.a.LBJ, new String[] { "open", "close" }, new int[] { 1, 0 }));
    AppMethodBeat.o(203305);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUIG
 * JD-Core Version:    0.7.0.1
 */