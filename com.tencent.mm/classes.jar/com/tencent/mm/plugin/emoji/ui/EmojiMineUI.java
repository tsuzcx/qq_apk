package com.tencent.mm.plugin.emoji.ui;

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
import com.tencent.mm.plugin.emoji.event.EmojiPostTaskListener;
import com.tencent.mm.plugin.emoji.h.e;
import com.tencent.mm.plugin.emoji.h.f;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.plugin.emoji.model.m;
import com.tencent.mm.plugin.emoji.model.s;
import com.tencent.mm.protocal.protobuf.gog;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.ui.base.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmojiMineUI
  extends BaseEmojiStoreUI
  implements View.OnClickListener
{
  private final String TAG;
  private ViewGroup wGY;
  private View xRJ;
  private TextView xRK;
  private View xSq;
  private View xSr;
  private ViewGroup xSs;
  private ViewGroup xSt;
  private ViewGroup xSu;
  private ViewGroup xSv;
  private TextView xSw;
  private com.tencent.mm.emoji.sync.a xSx;
  
  public EmojiMineUI()
  {
    AppMethodBeat.i(270400);
    this.TAG = "MicroMsg.emoji.EmojiMineUI";
    this.xSx = new com.tencent.mm.emoji.sync.a()
    {
      public final void aVR()
      {
        AppMethodBeat.i(270414);
        EmojiMineUI.a(EmojiMineUI.this);
        AppMethodBeat.o(270414);
      }
    };
    AppMethodBeat.o(270400);
  }
  
  private boolean Kr(int paramInt)
  {
    AppMethodBeat.i(108939);
    Object localObject = new Intent();
    ((Intent)localObject).setClass(this, EmojiCustomUI.class);
    ((Intent)localObject).putExtra("key_emoji_panel_type", paramInt);
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/emoji/ui/EmojiMineUI", "startEmojiCustom", "(I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/emoji/ui/EmojiMineUI", "startEmojiCustom", "(I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(108939);
    return true;
  }
  
  private void aVQ()
  {
    AppMethodBeat.i(270401);
    if ((s.dAm().xPe.xPp) || (s.dAm().dAL() > 0))
    {
      this.xRJ.setVisibility(0);
      s.dAm();
      if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
      {
        this.xRK.setText(h.h.emoji_sync_syncing_in_wifi);
        this.xSq.setVisibility(8);
        this.xSr.setVisibility(0);
        AppMethodBeat.o(270401);
        return;
      }
      if (s.dAm().xPe.xPm)
      {
        this.xSq.setVisibility(8);
        this.xSr.setVisibility(0);
        this.xRK.setText(h.h.emoji_group_sync_no_wifi);
        AppMethodBeat.o(270401);
        return;
      }
      this.xSq.setVisibility(0);
      this.xSr.setVisibility(8);
      this.xRK.setText(h.h.emoji_panel_group_sync_content);
      AppMethodBeat.o(270401);
      return;
    }
    this.xRJ.setVisibility(8);
    AppMethodBeat.o(270401);
  }
  
  protected final void a(boolean paramBoolean1, m paramm, boolean paramBoolean2, boolean paramBoolean3) {}
  
  protected final int bC(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108941);
    int i = super.bC(paramArrayOfByte);
    AppMethodBeat.o(108941);
    return i;
  }
  
  protected final int dAR()
  {
    return 24;
  }
  
  protected final int dAS()
  {
    return 7;
  }
  
  protected final com.tencent.mm.plugin.emoji.a.a.a dAT()
  {
    AppMethodBeat.i(108940);
    com.tencent.mm.plugin.emoji.a.c localc = new com.tencent.mm.plugin.emoji.a.c(getContext());
    AppMethodBeat.o(108940);
    return localc;
  }
  
  protected final void dAU()
  {
    AppMethodBeat.i(108944);
    this.wGY = ((ViewGroup)View.inflate(getContext(), h.f.emoji_mine_header, null));
    this.xSw = ((TextView)this.wGY.findViewById(h.e.title_add_from_store));
    this.xSw.setText(h.h.settings_emoji_use_tip);
    this.xSw.setVisibility(8);
    this.mListView.addHeaderView(this.wGY, null, false);
    this.xSs = ((ViewGroup)View.inflate(getContext(), h.f.emoji_mine_footer, null));
    this.xSt = ((ViewGroup)this.wGY.findViewById(h.e.mine_more_custom));
    this.xSu = ((ViewGroup)this.wGY.findViewById(h.e.emoji_mine_capture));
    this.xSv = ((ViewGroup)this.xSs.findViewById(h.e.mine_more_paid));
    ((TextView)this.xSt.findViewById(16908310)).setText(h.h.emoji_custom);
    ((TextView)this.xSv.findViewById(16908310)).setText(h.h.emoji_paid);
    ((TextView)this.xSu.findViewById(h.e.emoji_mine_capture_title)).setText(h.h.emoji_capture_title);
    this.xSv.findViewById(h.e.content).setBackgroundResource(0);
    this.xSt.setOnClickListener(this);
    this.xSv.setOnClickListener(this);
    this.xSu.setOnClickListener(this);
    this.mListView.addFooterView(this.xSs, null, false);
    AppMethodBeat.o(108944);
  }
  
  protected final boolean dAW()
  {
    return false;
  }
  
  protected final boolean dAX()
  {
    return false;
  }
  
  protected final int dBa()
  {
    return 8;
  }
  
  protected final boolean dBf()
  {
    boolean bool = true;
    AppMethodBeat.i(108945);
    if (this.xNj != null)
    {
      this.xNj.notifyDataSetChanged();
      this.xQk = true;
      this.bEx.setVisibility(8);
    }
    for (;;)
    {
      dBn();
      AppMethodBeat.o(108945);
      return bool;
      bool = false;
    }
  }
  
  protected final boolean dBk()
  {
    return true;
  }
  
  protected final boolean dBm()
  {
    return false;
  }
  
  public final void dBn()
  {
    AppMethodBeat.i(108948);
    if (this.wGY != null)
    {
      if ((this.xNj != null) && (!this.xNj.isEmpty()))
      {
        this.xSw.setVisibility(0);
        AppMethodBeat.o(108948);
        return;
      }
      this.xSw.setVisibility(8);
    }
    AppMethodBeat.o(108948);
  }
  
  protected final void e(gog paramgog)
  {
    AppMethodBeat.i(108946);
    super.e(paramgog);
    AppMethodBeat.o(108946);
  }
  
  public int getLayoutId()
  {
    return h.f.emoji_store_mine;
  }
  
  public void initView()
  {
    AppMethodBeat.i(108937);
    setMMTitle(h.h.settings_emoji_mine);
    super.initView();
    this.xRJ = findViewById(h.e.sync_view);
    this.xRK = ((TextView)this.xRJ.findViewById(h.e.sync_status));
    this.xRK.setText(h.h.emoji_sync_syncing_in_wifi);
    this.xSq = this.xRJ.findViewById(h.e.emoji_mine_sync_btn);
    this.xSr = this.xRJ.findViewById(h.e.emoji_mine_sync_progress);
    s.dAm().dAK();
    aVQ();
    this.xSq.setOnClickListener(this);
    s.dAm().c(this.xSx);
    this.mListView.setOnScrollListener(null);
    AppMethodBeat.o(108937);
  }
  
  public final void k(String paramString1, int paramInt1, int paramInt2, String paramString2) {}
  
  public final void l(Message paramMessage)
  {
    AppMethodBeat.i(108947);
    if ((paramMessage.what == 8001) && (this.xRJ != null)) {
      this.xRJ.setVisibility(8);
    }
    super.l(paramMessage);
    AppMethodBeat.o(108947);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(108938);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/EmojiMineUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (paramView == this.xSt)
    {
      Kr(0);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiMineUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(108938);
      return;
    }
    if (paramView == this.xSv)
    {
      paramView = new Intent();
      paramView.setClass(this, EmojiPaidUI.class);
      paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramView.aYi(), "com/tencent/mm/plugin/emoji/ui/EmojiMineUI", "startEmojiPaid", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramView.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/emoji/ui/EmojiMineUI", "startEmojiPaid", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiMineUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(108938);
      return;
    }
    if (paramView == this.xSu)
    {
      Kr(1);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiMineUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(108938);
      return;
    }
    if (paramView == this.xSq)
    {
      paramView = s.dAm().xPe;
      paramView.xPm = true;
      paramView.dAN();
      aVQ();
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
    com.tencent.mm.plugin.report.service.h.OAn.kvStat(10931, String.valueOf(i));
    Log.i("MicroMsg.emoji.EmojiMineUI", "jacks statistics enter Emoji Setting UI:%d", new Object[] { Integer.valueOf(i) });
    setBackBtn(new EmojiMineUI.2(this));
    addTextOptionMenu(0, getString(h.h.emoji_sequence), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(270421);
        Object localObject = s.getEmojiStorageMgr().adjv.jdi();
        paramAnonymousMenuItem = new ArrayList();
        if (localObject != null)
        {
          localObject = ((ArrayList)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            EmojiGroupInfo localEmojiGroupInfo = (EmojiGroupInfo)((Iterator)localObject).next();
            if (localEmojiGroupInfo.field_type != EmojiGroupInfo.aklA) {
              paramAnonymousMenuItem.add(localEmojiGroupInfo);
            }
          }
        }
        if (paramAnonymousMenuItem.size() <= 1)
        {
          k.s(EmojiMineUI.this.getContext(), h.h.emoji_cant_sort_tip, h.h.app_tip);
          AppMethodBeat.o(270421);
          return true;
        }
        if (!NetStatusUtil.isConnected(MMApplicationContext.getContext()))
        {
          EmojiMineUI.b(EmojiMineUI.this);
          AppMethodBeat.o(270421);
          return true;
        }
        localObject = new Intent();
        ((Intent)localObject).setClass(EmojiMineUI.this, EmojiSortUI.class);
        paramAnonymousMenuItem = EmojiMineUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/emoji/ui/EmojiMineUI$3", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousMenuItem, "com/tencent/mm/plugin/emoji/ui/EmojiMineUI$3", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(270421);
        return true;
      }
    });
    if (!((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acHY, Boolean.FALSE)).booleanValue()) {
      EmojiPostTaskListener.nY(true);
    }
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(406L, 3L, 1L, false);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(406L, 5L, System.currentTimeMillis() - l, false);
    com.tencent.mm.plugin.report.service.h.OAn.b(12740, new Object[] { Integer.valueOf(4), "", "", "", Integer.valueOf(24), Integer.valueOf(24) });
    AppMethodBeat.o(108936);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(270417);
    super.onDestroy();
    s.dAm().d(this.xSx);
    AppMethodBeat.o(270417);
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
      dBx();
      gS(131074, 50);
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