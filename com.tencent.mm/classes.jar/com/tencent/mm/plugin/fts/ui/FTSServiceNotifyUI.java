package com.tencent.mm.plugin.fts.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.k;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSSearchView;

@k
public class FTSServiceNotifyUI
  extends FTSBaseUI
  implements View.OnClickListener
{
  private String Htv;
  private View Hyz;
  private TextView Hzi;
  private boolean Hzj = true;
  private m Hzk;
  private String lMG;
  private int syO;
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(265550);
    if (this.Hzk == null) {
      this.Hzk = new m(parame, this.Htv, this.syO);
    }
    parame = this.Hzk;
    AppMethodBeat.o(265550);
    return parame;
  }
  
  protected final void aEJ(String paramString)
  {
    AppMethodBeat.i(265553);
    super.aEJ(paramString);
    if ((this.Hzj) && (this.syO == 1)) {
      com.tencent.mm.plugin.report.service.h.OAn.b(23903, new Object[] { Integer.valueOf(4), Long.valueOf(Util.nowSecond()), null, Integer.valueOf(0) });
    }
    this.Hzj = false;
    AppMethodBeat.o(265553);
  }
  
  protected final void fyk()
  {
    AppMethodBeat.i(265549);
    this.Htv = getIntent().getStringExtra("detail_username");
    this.syO = getIntent().getIntExtra("Search_Scene", 0);
    this.lMG = getIntent().getStringExtra("Search_Str");
    Log.i("MicroMsg.FTS.FTSServiceNotifyUI", "initSearchData conversation=%s", new Object[] { this.Htv });
    AppMethodBeat.o(265549);
  }
  
  protected final void fyn()
  {
    AppMethodBeat.i(265555);
    super.fyn();
    if (this.syO == 1) {
      this.Hyz.setVisibility(0);
    }
    AppMethodBeat.o(265555);
  }
  
  protected final void fyo()
  {
    AppMethodBeat.i(265561);
    super.fyo();
    this.Hyz.setVisibility(8);
    AppMethodBeat.o(265561);
  }
  
  protected final void fyp()
  {
    AppMethodBeat.i(265559);
    super.fyp();
    this.Hyz.setVisibility(8);
    AppMethodBeat.o(265559);
  }
  
  protected final void fyq()
  {
    AppMethodBeat.i(265563);
    super.fyq();
    this.Hyz.setVisibility(8);
    AppMethodBeat.o(265563);
  }
  
  public int getLayoutId()
  {
    return p.e.fts_conv_detail_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(265544);
    super.initView();
    hideActionbarLine();
    this.Hyz = findViewById(p.d.search_record_layout);
    this.Hzi = ((TextView)findViewById(p.d.search_type_hint));
    this.Hzi.setTextSize(15.0F);
    Object localObject;
    if (this.syO == 1)
    {
      this.Hyz.setVisibility(0);
      this.Hzi.setVisibility(0);
      this.Hzi.setText(p.g.search_service_notify_education_intro);
      localObject = (RecyclerView)findViewById(p.d.gird_title_view);
      getContext();
      ((RecyclerView)localObject).setLayoutManager(new GridLayoutManager(2));
      ((RecyclerView)localObject).a(new FTSServiceNotifyUI.1(this));
      ((RecyclerView)localObject).setAdapter(new FTSServiceNotifyUI.a(this));
    }
    while ((this.syO == 4) && (!Util.isNullOrNil(this.lMG)))
    {
      localObject = com.tencent.mm.plugin.fts.a.d.aEi(this.lMG);
      if ((!Util.isNullOrNil(this.query)) && (this.query.equals(localObject)))
      {
        Log.i("MicroMsg.FTS.FTSServiceNotifyUI", "Same query %s %s", new Object[] { this.query, localObject });
        AppMethodBeat.o(265544);
        return;
        this.Hyz.setVisibility(8);
        this.Hzi.setVisibility(8);
      }
      else
      {
        aEI(this.lMG);
        aEJ((String)localObject);
      }
    }
    AppMethodBeat.o(265544);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(265582);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/fts/ui/FTSServiceNotifyUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (!(paramView instanceof TextView))
    {
      a.a(this, "com/tencent/mm/plugin/fts/ui/FTSServiceNotifyUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(265582);
      return;
    }
    int i = ((Integer)paramView.getTag()).intValue();
    if (i == 0)
    {
      Log.i("MicroMsg.FTS.FTSServiceNotifyUI", "onSearchMemberDetail");
      paramView = new Intent();
      paramView.putExtra("from_scene", 1);
      paramView.putExtra("RoomInfo_Id", "notifymessage");
      paramView.putExtra("title", getResources().getString(p.g.search_by_service_username));
      com.tencent.mm.br.c.g(this, "com.tencent.mm.chatroom.ui.SelectServiceNotifySenderUI", paramView);
      com.tencent.mm.plugin.report.service.h.OAn.b(23903, new Object[] { Integer.valueOf(2), Long.valueOf(Util.nowSecond()), null, Integer.valueOf(0) });
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/fts/ui/FTSServiceNotifyUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(265582);
      return;
      if (i == 1)
      {
        Log.i("MicroMsg.FTS.FTSServiceNotifyUI", "onSearchDateDetail");
        paramView = new Intent();
        paramView.putExtra("detail_username", "notifymessage");
        com.tencent.mm.br.c.g(this, "com.tencent.mm.chatroom.ui.SelectDateUI", paramView);
        com.tencent.mm.plugin.report.service.h.OAn.b(23903, new Object[] { Integer.valueOf(3), Long.valueOf(Util.nowSecond()), null, Integer.valueOf(0) });
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(265540);
    super.onCreate(paramBundle);
    initView();
    paramBundle = ((n)com.tencent.mm.kernel.h.az(n.class)).getFTSImageLoader();
    if (paramBundle != null) {
      paramBundle.fxg();
    }
    AppMethodBeat.o(265540);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(265573);
    super.onDestroy();
    this.Hzk.finish();
    com.tencent.mm.plugin.fts.a.d.c localc = ((n)com.tencent.mm.kernel.h.az(n.class)).getFTSImageLoader();
    if (localc != null) {
      localc.fxe();
    }
    AppMethodBeat.o(265573);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(265547);
    super.onResume();
    if (this.syO != 4) {
      this.Hyz.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(265648);
          if ((!FTSServiceNotifyUI.this.isFinishing()) && (!FTSServiceNotifyUI.this.isDestroyed()))
          {
            FTSServiceNotifyUI.this.Hye.getFtsEditText().aWT();
            FTSServiceNotifyUI.this.Hye.getFtsEditText().aWS();
          }
          AppMethodBeat.o(265648);
        }
      }, 128L);
    }
    AppMethodBeat.o(265547);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSServiceNotifyUI
 * JD-Core Version:    0.7.0.1
 */