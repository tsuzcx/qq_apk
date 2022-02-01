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
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.model.f;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.protocal.protobuf.GetEmotionListResponse;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmojiMineUI
  extends BaseEmojiStoreUI
  implements View.OnClickListener
{
  private final String TAG = "MicroMsg.emoji.EmojiMineUI";
  private ViewGroup nGk;
  private View oBE;
  private TextView oBF;
  private ViewGroup oCp;
  private ViewGroup oCq;
  private ViewGroup oCr;
  private ViewGroup oCs;
  private TextView oCt;
  
  private boolean AC(int paramInt)
  {
    AppMethodBeat.i(108939);
    Object localObject = new Intent();
    ((Intent)localObject).setClass(this, EmojiCustomUI.class);
    ((Intent)localObject).putExtra("key_emoji_panel_type", paramInt);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/emoji/ui/EmojiMineUI", "startEmojiCustom", "(I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiMineUI", "startEmojiCustom", "(I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(108939);
    return true;
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(108943);
    if ((paramString != null) && (paramString.equals("event_update_group")))
    {
      bWc();
      fe(131074, 50);
    }
    AppMethodBeat.o(108943);
  }
  
  protected final void a(boolean paramBoolean1, f paramf, boolean paramBoolean2, boolean paramBoolean3) {}
  
  protected final int aY(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108941);
    int i = super.aY(paramArrayOfByte);
    AppMethodBeat.o(108941);
    return i;
  }
  
  protected final int bVD()
  {
    return 24;
  }
  
  protected final int bVE()
  {
    return 7;
  }
  
  protected final com.tencent.mm.plugin.emoji.a.a.a bVF()
  {
    AppMethodBeat.i(108940);
    com.tencent.mm.plugin.emoji.a.c localc = new com.tencent.mm.plugin.emoji.a.c(getContext());
    AppMethodBeat.o(108940);
    return localc;
  }
  
  protected final void bVG()
  {
    AppMethodBeat.i(108944);
    this.nGk = ((ViewGroup)View.inflate(getContext(), 2131493775, null));
    this.oCt = ((TextView)this.nGk.findViewById(2131305907));
    this.oCt.setText(2131763216);
    this.oCt.setVisibility(8);
    this.mListView.addHeaderView(this.nGk, null, false);
    this.oCp = ((ViewGroup)View.inflate(getContext(), 2131493772, null));
    this.oCq = ((ViewGroup)this.nGk.findViewById(2131302276));
    this.oCr = ((ViewGroup)this.nGk.findViewById(2131299388));
    this.oCs = ((ViewGroup)this.oCp.findViewById(2131302277));
    ((TextView)this.oCq.findViewById(16908310)).setText(2131758244);
    ((TextView)this.oCs.findViewById(16908310)).setText(2131758274);
    ((TextView)this.oCr.findViewById(2131299390)).setText(2131758236);
    this.oCs.findViewById(2131298739).setBackgroundResource(2131231820);
    this.oCq.setOnClickListener(this);
    this.oCs.setOnClickListener(this);
    this.oCr.setOnClickListener(this);
    this.mListView.addFooterView(this.oCp, null, false);
    AppMethodBeat.o(108944);
  }
  
  protected final boolean bVI()
  {
    return false;
  }
  
  protected final boolean bVJ()
  {
    return false;
  }
  
  protected final int bVM()
  {
    return 8;
  }
  
  protected final boolean bVR()
  {
    boolean bool = true;
    AppMethodBeat.i(108945);
    if (this.oxx != null)
    {
      this.oxx.notifyDataSetChanged();
      this.oAx = true;
      this.DR.setVisibility(8);
    }
    for (;;)
    {
      bVV();
      AppMethodBeat.o(108945);
      return bool;
      bool = false;
    }
  }
  
  protected final boolean bVT()
  {
    return true;
  }
  
  protected final boolean bVU()
  {
    return false;
  }
  
  public final void bVV()
  {
    AppMethodBeat.i(108948);
    if (this.nGk != null)
    {
      if ((this.oxx != null) && (!this.oxx.isEmpty()))
      {
        this.oCt.setVisibility(0);
        AppMethodBeat.o(108948);
        return;
      }
      this.oCt.setVisibility(8);
    }
    AppMethodBeat.o(108948);
  }
  
  protected final void d(GetEmotionListResponse paramGetEmotionListResponse)
  {
    AppMethodBeat.i(108946);
    super.d(paramGetEmotionListResponse);
    AppMethodBeat.o(108946);
  }
  
  public int getLayoutId()
  {
    return 2131493801;
  }
  
  public final void h(String paramString1, int paramInt1, int paramInt2, String paramString2) {}
  
  public void initView()
  {
    AppMethodBeat.i(108937);
    setMMTitle(2131763214);
    super.initView();
    this.oBE = findViewById(2131305594);
    this.oBF = ((TextView)this.oBE.findViewById(2131305593));
    this.oBF.setText(2131758401);
    if (k.bVa().ozk.ozu)
    {
      k.bVa();
      if (BKGLoaderManager.bVA())
      {
        this.oBE.setVisibility(0);
        fe(8001, 3000);
      }
    }
    for (;;)
    {
      this.mListView.setOnScrollListener(null);
      AppMethodBeat.o(108937);
      return;
      this.oBE.setVisibility(8);
    }
  }
  
  public final void m(Message paramMessage)
  {
    AppMethodBeat.i(108947);
    if ((paramMessage.what == 8001) && (this.oBE != null)) {
      this.oBE.setVisibility(8);
    }
    super.m(paramMessage);
    AppMethodBeat.o(108947);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(108938);
    if (paramView == this.oCq)
    {
      AC(0);
      AppMethodBeat.o(108938);
      return;
    }
    if (paramView == this.oCs)
    {
      paramView = new Intent();
      paramView.setClass(this, EmojiPaidUI.class);
      paramView = new com.tencent.mm.hellhoundlib.b.a().bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramView.adn(), "com/tencent/mm/plugin/emoji/ui/EmojiMineUI", "startEmojiPaid", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramView.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiMineUI", "startEmojiPaid", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(108938);
      return;
    }
    if (paramView == this.oCr)
    {
      AC(1);
      AppMethodBeat.o(108938);
      return;
    }
    AppMethodBeat.o(108938);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(108936);
    long l = System.currentTimeMillis();
    super.onCreate(paramBundle);
    int i = getIntent().getIntExtra("10931", 0);
    com.tencent.mm.plugin.report.service.h.vKh.kvStat(10931, String.valueOf(i));
    ad.i("MicroMsg.emoji.EmojiMineUI", "jacks statistics enter Emoji Setting UI:%d", new Object[] { Integer.valueOf(i) });
    setBackBtn(new EmojiMineUI.1(this));
    addTextOptionMenu(0, getString(2131758299), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(108935);
        Object localObject = k.getEmojiStorageMgr().FyZ.eNt();
        paramAnonymousMenuItem = new ArrayList();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          EmojiGroupInfo localEmojiGroupInfo = (EmojiGroupInfo)((Iterator)localObject).next();
          if (localEmojiGroupInfo.field_type != EmojiGroupInfo.TYPE_CUSTOM) {
            paramAnonymousMenuItem.add(localEmojiGroupInfo);
          }
        }
        if (paramAnonymousMenuItem.size() <= 1)
        {
          com.tencent.mm.ui.base.h.j(EmojiMineUI.this.getContext(), 2131758214, 2131755906);
          AppMethodBeat.o(108935);
          return true;
        }
        if (!ay.isConnected(aj.getContext()))
        {
          EmojiMineUI.a(EmojiMineUI.this);
          AppMethodBeat.o(108935);
          return true;
        }
        localObject = new Intent();
        ((Intent)localObject).setClass(EmojiMineUI.this, EmojiSortUI.class);
        paramAnonymousMenuItem = EmojiMineUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/emoji/ui/EmojiMineUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/plugin/emoji/ui/EmojiMineUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(108935);
        return true;
      }
    });
    if (!((Boolean)g.afB().afk().get(ae.a.Fgk, Boolean.FALSE)).booleanValue()) {
      com.tencent.mm.plugin.emoji.c.a.jB(true);
    }
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(406L, 3L, 1L, false);
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(406L, 5L, System.currentTimeMillis() - l, false);
    com.tencent.mm.plugin.report.service.h.vKh.f(12740, new Object[] { Integer.valueOf(4), "", "", "", Integer.valueOf(24), Integer.valueOf(24) });
    AppMethodBeat.o(108936);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(108942);
    super.onItemClick(paramAdapterView, paramView, paramInt - 1, paramLong);
    AppMethodBeat.o(108942);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiMineUI
 * JD-Core Version:    0.7.0.1
 */