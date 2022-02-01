package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.emoji.i.d;
import com.tencent.mm.plugin.emoji.i.e;
import com.tencent.mm.plugin.emoji.i.f;
import com.tencent.mm.plugin.emoji.i.h;
import com.tencent.mm.plugin.emoji.model.l;
import com.tencent.mm.plugin.emoji.model.p;
import com.tencent.mm.protocal.protobuf.buh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmojiMineUI
  extends BaseEmojiStoreUI
  implements View.OnClickListener
{
  private final String TAG;
  private ViewGroup tCV;
  private View uIT;
  private TextView uIU;
  private View uJA;
  private View uJB;
  private ViewGroup uJC;
  private ViewGroup uJD;
  private ViewGroup uJE;
  private ViewGroup uJF;
  private TextView uJG;
  private com.tencent.mm.emoji.sync.a uJH;
  
  public EmojiMineUI()
  {
    AppMethodBeat.i(255614);
    this.TAG = "MicroMsg.emoji.EmojiMineUI";
    this.uJH = new com.tencent.mm.emoji.sync.a()
    {
      public final void aCT()
      {
        AppMethodBeat.i(257304);
        EmojiMineUI.a(EmojiMineUI.this);
        AppMethodBeat.o(257304);
      }
    };
    AppMethodBeat.o(255614);
  }
  
  private boolean JG(int paramInt)
  {
    AppMethodBeat.i(108939);
    Object localObject = new Intent();
    ((Intent)localObject).setClass(this, EmojiCustomUI.class);
    ((Intent)localObject).putExtra("key_emoji_panel_type", paramInt);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/emoji/ui/EmojiMineUI", "startEmojiCustom", "(I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/emoji/ui/EmojiMineUI", "startEmojiCustom", "(I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(108939);
    return true;
  }
  
  private void aCS()
  {
    AppMethodBeat.i(255633);
    if ((p.cUP().uGy.uGJ) || (p.cUP().cVl() > 0))
    {
      this.uIT.setVisibility(0);
      p.cUP();
      if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
      {
        this.uIU.setText(i.h.emoji_sync_syncing_in_wifi);
        this.uJA.setVisibility(8);
        this.uJB.setVisibility(0);
        AppMethodBeat.o(255633);
        return;
      }
      if (p.cUP().uGy.uGG)
      {
        this.uJA.setVisibility(8);
        this.uJB.setVisibility(0);
        this.uIU.setText(i.h.emoji_group_sync_no_wifi);
        AppMethodBeat.o(255633);
        return;
      }
      this.uJA.setVisibility(0);
      this.uJB.setVisibility(8);
      this.uIU.setText(i.h.emoji_panel_group_sync_content);
      AppMethodBeat.o(255633);
      return;
    }
    this.uIT.setVisibility(8);
    AppMethodBeat.o(255633);
  }
  
  protected final void a(boolean paramBoolean1, l paraml, boolean paramBoolean2, boolean paramBoolean3) {}
  
  protected final int bC(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108941);
    int i = super.bC(paramArrayOfByte);
    AppMethodBeat.o(108941);
    return i;
  }
  
  protected final void c(buh parambuh)
  {
    AppMethodBeat.i(108946);
    super.c(parambuh);
    AppMethodBeat.o(108946);
  }
  
  protected final int cVA()
  {
    return 8;
  }
  
  protected final boolean cVF()
  {
    boolean bool = true;
    AppMethodBeat.i(108945);
    if (this.uEH != null)
    {
      this.uEH.notifyDataSetChanged();
      this.uHC = true;
      this.Xd.setVisibility(8);
    }
    for (;;)
    {
      cVL();
      AppMethodBeat.o(108945);
      return bool;
      bool = false;
    }
  }
  
  protected final boolean cVJ()
  {
    return true;
  }
  
  protected final boolean cVK()
  {
    return false;
  }
  
  public final void cVL()
  {
    AppMethodBeat.i(108948);
    if (this.tCV != null)
    {
      if ((this.uEH != null) && (!this.uEH.isEmpty()))
      {
        this.uJG.setVisibility(0);
        AppMethodBeat.o(108948);
        return;
      }
      this.uJG.setVisibility(8);
    }
    AppMethodBeat.o(108948);
  }
  
  protected final int cVr()
  {
    return 24;
  }
  
  protected final int cVs()
  {
    return 7;
  }
  
  protected final com.tencent.mm.plugin.emoji.a.a.a cVt()
  {
    AppMethodBeat.i(108940);
    com.tencent.mm.plugin.emoji.a.c localc = new com.tencent.mm.plugin.emoji.a.c(getContext());
    AppMethodBeat.o(108940);
    return localc;
  }
  
  protected final void cVu()
  {
    AppMethodBeat.i(108944);
    this.tCV = ((ViewGroup)View.inflate(getContext(), i.f.emoji_mine_header, null));
    this.uJG = ((TextView)this.tCV.findViewById(i.e.title_add_from_store));
    this.uJG.setText(i.h.settings_emoji_use_tip);
    this.uJG.setVisibility(8);
    this.mListView.addHeaderView(this.tCV, null, false);
    this.uJC = ((ViewGroup)View.inflate(getContext(), i.f.emoji_mine_footer, null));
    this.uJD = ((ViewGroup)this.tCV.findViewById(i.e.mine_more_custom));
    this.uJE = ((ViewGroup)this.tCV.findViewById(i.e.emoji_mine_capture));
    this.uJF = ((ViewGroup)this.uJC.findViewById(i.e.mine_more_paid));
    ((TextView)this.uJD.findViewById(16908310)).setText(i.h.emoji_custom);
    ((TextView)this.uJF.findViewById(16908310)).setText(i.h.emoji_paid);
    ((TextView)this.uJE.findViewById(i.e.emoji_mine_capture_title)).setText(i.h.emoji_capture_title);
    this.uJF.findViewById(i.e.content).setBackgroundResource(i.d.comm_list_item_selector_no_divider);
    this.uJD.setOnClickListener(this);
    this.uJF.setOnClickListener(this);
    this.uJE.setOnClickListener(this);
    this.mListView.addFooterView(this.uJC, null, false);
    AppMethodBeat.o(108944);
  }
  
  protected final boolean cVw()
  {
    return false;
  }
  
  protected final boolean cVx()
  {
    return false;
  }
  
  public int getLayoutId()
  {
    return i.f.emoji_store_mine;
  }
  
  public void initView()
  {
    AppMethodBeat.i(108937);
    setMMTitle(i.h.settings_emoji_mine);
    super.initView();
    this.uIT = findViewById(i.e.sync_view);
    this.uIU = ((TextView)this.uIT.findViewById(i.e.sync_status));
    this.uIU.setText(i.h.emoji_sync_syncing_in_wifi);
    this.uJA = this.uIT.findViewById(i.e.emoji_mine_sync_btn);
    this.uJB = this.uIT.findViewById(i.e.emoji_mine_sync_progress);
    p.cUP().cVk();
    aCS();
    this.uJA.setOnClickListener(this);
    p.cUP().c(this.uJH);
    this.mListView.setOnScrollListener(null);
    AppMethodBeat.o(108937);
  }
  
  public final void k(Message paramMessage)
  {
    AppMethodBeat.i(108947);
    if ((paramMessage.what == 8001) && (this.uIT != null)) {
      this.uIT.setVisibility(8);
    }
    super.k(paramMessage);
    AppMethodBeat.o(108947);
  }
  
  public final void k(String paramString1, int paramInt1, int paramInt2, String paramString2) {}
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(108938);
    b localb = new b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/EmojiMineUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if (paramView == this.uJD)
    {
      JG(0);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiMineUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(108938);
      return;
    }
    if (paramView == this.uJF)
    {
      paramView = new Intent();
      paramView.setClass(this, EmojiPaidUI.class);
      paramView = new com.tencent.mm.hellhoundlib.b.a().bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramView.aFh(), "com/tencent/mm/plugin/emoji/ui/EmojiMineUI", "startEmojiPaid", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramView.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/emoji/ui/EmojiMineUI", "startEmojiPaid", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiMineUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(108938);
      return;
    }
    if (paramView == this.uJE)
    {
      JG(1);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiMineUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(108938);
      return;
    }
    if (paramView == this.uJA)
    {
      paramView = p.cUP().uGy;
      paramView.uGG = true;
      paramView.cVn();
      aCS();
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiMineUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(108938);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(108936);
    long l = System.currentTimeMillis();
    super.onCreate(paramBundle);
    int i = getIntent().getIntExtra("10931", 0);
    com.tencent.mm.plugin.report.service.h.IzE.kvStat(10931, String.valueOf(i));
    Log.i("MicroMsg.emoji.EmojiMineUI", "jacks statistics enter Emoji Setting UI:%d", new Object[] { Integer.valueOf(i) });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(108935);
        EmojiMineUI.this.finish();
        AppMethodBeat.o(108935);
        return true;
      }
    });
    addTextOptionMenu(0, getString(i.h.emoji_sequence), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(256335);
        Object localObject = p.getEmojiStorageMgr().VFI.hBh();
        paramAnonymousMenuItem = new ArrayList();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          EmojiGroupInfo localEmojiGroupInfo = (EmojiGroupInfo)((Iterator)localObject).next();
          if (localEmojiGroupInfo.field_type != EmojiGroupInfo.YCr) {
            paramAnonymousMenuItem.add(localEmojiGroupInfo);
          }
        }
        if (paramAnonymousMenuItem.size() <= 1)
        {
          com.tencent.mm.ui.base.h.p(EmojiMineUI.this.getContext(), i.h.emoji_cant_sort_tip, i.h.app_tip);
          AppMethodBeat.o(256335);
          return true;
        }
        if (!NetStatusUtil.isConnected(MMApplicationContext.getContext()))
        {
          EmojiMineUI.b(EmojiMineUI.this);
          AppMethodBeat.o(256335);
          return true;
        }
        localObject = new Intent();
        ((Intent)localObject).setClass(EmojiMineUI.this, EmojiSortUI.class);
        paramAnonymousMenuItem = EmojiMineUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/emoji/ui/EmojiMineUI$3", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousMenuItem, "com/tencent/mm/plugin/emoji/ui/EmojiMineUI$3", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(256335);
        return true;
      }
    });
    if (!((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VgJ, Boolean.FALSE)).booleanValue()) {
      com.tencent.mm.plugin.emoji.c.a.mC(true);
    }
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(406L, 3L, 1L, false);
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(406L, 5L, System.currentTimeMillis() - l, false);
    com.tencent.mm.plugin.report.service.h.IzE.a(12740, new Object[] { Integer.valueOf(4), "", "", "", Integer.valueOf(24), Integer.valueOf(24) });
    AppMethodBeat.o(108936);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(255629);
    super.onDestroy();
    p.cUP().d(this.uJH);
    AppMethodBeat.o(255629);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(108942);
    super.onItemClick(paramAdapterView, paramView, paramInt - 1, paramLong);
    AppMethodBeat.o(108942);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(108943);
    if ((paramString != null) && (paramString.equals("event_update_group")))
    {
      cVS();
      fZ(131074, 50);
    }
    AppMethodBeat.o(108943);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiMineUI
 * JD-Core Version:    0.7.0.1
 */