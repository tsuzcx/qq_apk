package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.a.c;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.GetEmotionListResponse;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public class EmojiMineUI
  extends BaseEmojiStoreUI
  implements View.OnClickListener
{
  private final String TAG = "MicroMsg.emoji.EmojiMineUI";
  private ViewGroup llZ;
  private View llo;
  private TextView llp;
  private ViewGroup lma;
  private ViewGroup lmb;
  private ViewGroup lmc;
  private ViewGroup lmd;
  private TextView lme;
  
  private boolean us(int paramInt)
  {
    AppMethodBeat.i(53378);
    Intent localIntent = new Intent();
    localIntent.setClass(this, EmojiCustomUI.class);
    localIntent.putExtra("key_emoji_panel_type", paramInt);
    startActivity(localIntent);
    AppMethodBeat.o(53378);
    return true;
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(53382);
    if ((paramString != null) && (paramString.equals("event_update_group")))
    {
      bms();
      eb(131074, 50);
    }
    AppMethodBeat.o(53382);
  }
  
  protected final void a(boolean paramBoolean1, com.tencent.mm.plugin.emoji.model.e parame, boolean paramBoolean2, boolean paramBoolean3) {}
  
  protected final int aI(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(53380);
    int i = super.aI(paramArrayOfByte);
    AppMethodBeat.o(53380);
    return i;
  }
  
  protected final int blS()
  {
    return 24;
  }
  
  protected final int blT()
  {
    return 7;
  }
  
  protected final com.tencent.mm.plugin.emoji.a.a.a blU()
  {
    AppMethodBeat.i(53379);
    c localc = new c(getContext());
    AppMethodBeat.o(53379);
    return localc;
  }
  
  protected final void blV()
  {
    AppMethodBeat.i(53383);
    this.lmd = ((ViewGroup)View.inflate(getContext(), 2130969374, null));
    this.lme = ((TextView)this.lmd.findViewById(2131823607));
    this.lme.setText(2131303247);
    this.lme.setVisibility(8);
    this.mListView.addHeaderView(this.lmd, null, false);
    this.llZ = ((ViewGroup)View.inflate(getContext(), 2130969371, null));
    this.lma = ((ViewGroup)this.lmd.findViewById(2131823603));
    this.lmb = ((ViewGroup)this.lmd.findViewById(2131823604));
    this.lmc = ((ViewGroup)this.llZ.findViewById(2131823602));
    ((TextView)this.lma.findViewById(16908310)).setText(2131299128);
    ((TextView)this.lmc.findViewById(16908310)).setText(2131299157);
    ((TextView)this.lmb.findViewById(2131823606)).setText(2131299120);
    this.lmc.findViewById(2131820946).setBackgroundResource(2130838447);
    this.lma.setOnClickListener(this);
    this.lmc.setOnClickListener(this);
    this.lmb.setOnClickListener(this);
    this.mListView.addFooterView(this.llZ, null, false);
    AppMethodBeat.o(53383);
  }
  
  protected final boolean blX()
  {
    return false;
  }
  
  protected final boolean blY()
  {
    return false;
  }
  
  protected final int bmb()
  {
    return 8;
  }
  
  protected final boolean bmg()
  {
    boolean bool = true;
    AppMethodBeat.i(53384);
    if (this.lhv != null)
    {
      this.lhv.notifyDataSetChanged();
      this.lkp = true;
      this.xy.setVisibility(8);
    }
    for (;;)
    {
      bmk();
      AppMethodBeat.o(53384);
      return bool;
      bool = false;
    }
  }
  
  protected final boolean bmi()
  {
    return true;
  }
  
  protected final boolean bmj()
  {
    return false;
  }
  
  public final void bmk()
  {
    AppMethodBeat.i(53387);
    if (this.lmd != null)
    {
      if ((this.lhv != null) && (!this.lhv.isEmpty()))
      {
        this.lme.setVisibility(0);
        AppMethodBeat.o(53387);
        return;
      }
      this.lme.setVisibility(8);
    }
    AppMethodBeat.o(53387);
  }
  
  protected final void c(GetEmotionListResponse paramGetEmotionListResponse)
  {
    AppMethodBeat.i(53385);
    super.c(paramGetEmotionListResponse);
    AppMethodBeat.o(53385);
  }
  
  public int getLayoutId()
  {
    return 2130969389;
  }
  
  public final void h(String paramString1, int paramInt1, int paramInt2, String paramString2) {}
  
  public void initView()
  {
    AppMethodBeat.i(53376);
    setMMTitle(2131303245);
    super.initView();
    this.llo = findViewById(2131823566);
    this.llp = ((TextView)this.llo.findViewById(2131823567));
    this.llp.setText(2131299275);
    if (i.blq().lje.ljm)
    {
      i.blq();
      if (BKGLoaderManager.blP())
      {
        this.llo.setVisibility(0);
        eb(8001, 3000);
      }
    }
    for (;;)
    {
      this.mListView.setOnScrollListener(null);
      AppMethodBeat.o(53376);
      return;
      this.llo.setVisibility(8);
    }
  }
  
  public final void n(Message paramMessage)
  {
    AppMethodBeat.i(53386);
    if ((paramMessage.what == 8001) && (this.llo != null)) {
      this.llo.setVisibility(8);
    }
    super.n(paramMessage);
    AppMethodBeat.o(53386);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(53377);
    if (paramView == this.lma)
    {
      us(0);
      AppMethodBeat.o(53377);
      return;
    }
    if (paramView == this.lmc)
    {
      paramView = new Intent();
      paramView.setClass(this, EmojiPaidUI.class);
      startActivity(paramView);
      AppMethodBeat.o(53377);
      return;
    }
    if (paramView == this.lmb)
    {
      us(1);
      AppMethodBeat.o(53377);
      return;
    }
    AppMethodBeat.o(53377);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(53375);
    long l = System.currentTimeMillis();
    super.onCreate(paramBundle);
    int i = getIntent().getIntExtra("10931", 0);
    h.qsU.kvStat(10931, String.valueOf(i));
    ab.i("MicroMsg.emoji.EmojiMineUI", "jacks statistics enter Emoji Setting UI:%d", new Object[] { Integer.valueOf(i) });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(53373);
        EmojiMineUI.this.finish();
        AppMethodBeat.o(53373);
        return true;
      }
    });
    addTextOptionMenu(0, getString(2131299173), new EmojiMineUI.2(this));
    if (!((Boolean)g.RL().Ru().get(ac.a.yxQ, Boolean.FALSE)).booleanValue()) {
      com.tencent.mm.plugin.emoji.c.a.gD(true);
    }
    h.qsU.idkeyStat(406L, 3L, 1L, false);
    h.qsU.idkeyStat(406L, 5L, System.currentTimeMillis() - l, false);
    h.qsU.e(12740, new Object[] { Integer.valueOf(4), "", "", "", Integer.valueOf(24), Integer.valueOf(24) });
    AppMethodBeat.o(53375);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(53381);
    super.onItemClick(paramAdapterView, paramView, paramInt - 1, paramLong);
    AppMethodBeat.o(53381);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiMineUI
 * JD-Core Version:    0.7.0.1
 */