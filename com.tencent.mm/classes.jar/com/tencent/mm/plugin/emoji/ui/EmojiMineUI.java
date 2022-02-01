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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.protocal.protobuf.GetEmotionListResponse;
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
  private final String TAG = "MicroMsg.emoji.EmojiMineUI";
  private ViewGroup qgZ;
  private View rfJ;
  private TextView rfK;
  private ViewGroup rgu;
  private ViewGroup rgv;
  private ViewGroup rgw;
  private ViewGroup rgx;
  private TextView rgy;
  
  private boolean FZ(int paramInt)
  {
    AppMethodBeat.i(108939);
    Object localObject = new Intent();
    ((Intent)localObject).setClass(this, EmojiCustomUI.class);
    ((Intent)localObject).putExtra("key_emoji_panel_type", paramInt);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/emoji/ui/EmojiMineUI", "startEmojiCustom", "(I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiMineUI", "startEmojiCustom", "(I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(108939);
    return true;
  }
  
  protected final void a(boolean paramBoolean1, com.tencent.mm.plugin.emoji.model.g paramg, boolean paramBoolean2, boolean paramBoolean3) {}
  
  protected final int bp(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108941);
    int i = super.bp(paramArrayOfByte);
    AppMethodBeat.o(108941);
    return i;
  }
  
  protected final void c(GetEmotionListResponse paramGetEmotionListResponse)
  {
    AppMethodBeat.i(108946);
    super.c(paramGetEmotionListResponse);
    AppMethodBeat.o(108946);
  }
  
  protected final int cGH()
  {
    return 24;
  }
  
  protected final int cGI()
  {
    return 7;
  }
  
  protected final com.tencent.mm.plugin.emoji.a.a.a cGJ()
  {
    AppMethodBeat.i(108940);
    com.tencent.mm.plugin.emoji.a.c localc = new com.tencent.mm.plugin.emoji.a.c(getContext());
    AppMethodBeat.o(108940);
    return localc;
  }
  
  protected final void cGK()
  {
    AppMethodBeat.i(108944);
    this.qgZ = ((ViewGroup)View.inflate(getContext(), 2131493924, null));
    this.rgy = ((TextView)this.qgZ.findViewById(2131309201));
    this.rgy.setText(2131765384);
    this.rgy.setVisibility(8);
    this.mListView.addHeaderView(this.qgZ, null, false);
    this.rgu = ((ViewGroup)View.inflate(getContext(), 2131493921, null));
    this.rgv = ((ViewGroup)this.qgZ.findViewById(2131304670));
    this.rgw = ((ViewGroup)this.qgZ.findViewById(2131300001));
    this.rgx = ((ViewGroup)this.rgu.findViewById(2131304671));
    ((TextView)this.rgv.findViewById(16908310)).setText(2131758532);
    ((TextView)this.rgx.findViewById(16908310)).setText(2131758562);
    ((TextView)this.rgw.findViewById(2131300003)).setText(2131758524);
    this.rgx.findViewById(2131299180).setBackgroundResource(2131231901);
    this.rgv.setOnClickListener(this);
    this.rgx.setOnClickListener(this);
    this.rgw.setOnClickListener(this);
    this.mListView.addFooterView(this.rgu, null, false);
    AppMethodBeat.o(108944);
  }
  
  protected final boolean cGM()
  {
    return false;
  }
  
  protected final boolean cGN()
  {
    return false;
  }
  
  protected final int cGQ()
  {
    return 8;
  }
  
  protected final boolean cGV()
  {
    boolean bool = true;
    AppMethodBeat.i(108945);
    if (this.rbD != null)
    {
      this.rbD.notifyDataSetChanged();
      this.reA = true;
      this.GQ.setVisibility(8);
    }
    for (;;)
    {
      cGZ();
      AppMethodBeat.o(108945);
      return bool;
      bool = false;
    }
  }
  
  protected final boolean cGX()
  {
    return true;
  }
  
  protected final boolean cGY()
  {
    return false;
  }
  
  public final void cGZ()
  {
    AppMethodBeat.i(108948);
    if (this.qgZ != null)
    {
      if ((this.rbD != null) && (!this.rbD.isEmpty()))
      {
        this.rgy.setVisibility(0);
        AppMethodBeat.o(108948);
        return;
      }
      this.rgy.setVisibility(8);
    }
    AppMethodBeat.o(108948);
  }
  
  public int getLayoutId()
  {
    return 2131493955;
  }
  
  public final void i(String paramString1, int paramInt1, int paramInt2, String paramString2) {}
  
  public void initView()
  {
    AppMethodBeat.i(108937);
    setMMTitle(2131765382);
    super.initView();
    this.rfJ = findViewById(2131308816);
    this.rfK = ((TextView)this.rfJ.findViewById(2131308815));
    this.rfK.setText(2131758695);
    if (k.cGg().rds.rdC)
    {
      k.cGg();
      if (BKGLoaderManager.cGF())
      {
        this.rfJ.setVisibility(0);
        fC(8001, 3000);
      }
    }
    for (;;)
    {
      this.mListView.setOnScrollListener(null);
      AppMethodBeat.o(108937);
      return;
      this.rfJ.setVisibility(8);
    }
  }
  
  public final void k(Message paramMessage)
  {
    AppMethodBeat.i(108947);
    if ((paramMessage.what == 8001) && (this.rfJ != null)) {
      this.rfJ.setVisibility(8);
    }
    super.k(paramMessage);
    AppMethodBeat.o(108947);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(108938);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/EmojiMineUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (paramView == this.rgv)
    {
      FZ(0);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiMineUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(108938);
      return;
    }
    if (paramView == this.rgx)
    {
      paramView = new Intent();
      paramView.setClass(this, EmojiPaidUI.class);
      paramView = new com.tencent.mm.hellhoundlib.b.a().bl(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramView.axQ(), "com/tencent/mm/plugin/emoji/ui/EmojiMineUI", "startEmojiPaid", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramView.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiMineUI", "startEmojiPaid", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiMineUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(108938);
      return;
    }
    if (paramView == this.rgw)
    {
      FZ(1);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiMineUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(108938);
      return;
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
    com.tencent.mm.plugin.report.service.h.CyF.kvStat(10931, String.valueOf(i));
    Log.i("MicroMsg.emoji.EmojiMineUI", "jacks statistics enter Emoji Setting UI:%d", new Object[] { Integer.valueOf(i) });
    setBackBtn(new EmojiMineUI.1(this));
    addTextOptionMenu(0, getString(2131758593), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(108935);
        Object localObject = k.getEmojiStorageMgr().OpO.gES();
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
          com.tencent.mm.ui.base.h.n(EmojiMineUI.this.getContext(), 2131758502, 2131755998);
          AppMethodBeat.o(108935);
          return true;
        }
        if (!NetStatusUtil.isConnected(MMApplicationContext.getContext()))
        {
          EmojiMineUI.a(EmojiMineUI.this);
          AppMethodBeat.o(108935);
          return true;
        }
        localObject = new Intent();
        ((Intent)localObject).setClass(EmojiMineUI.this, EmojiSortUI.class);
        paramAnonymousMenuItem = EmojiMineUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/emoji/ui/EmojiMineUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/plugin/emoji/ui/EmojiMineUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(108935);
        return true;
      }
    });
    if (!((Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.NSL, Boolean.FALSE)).booleanValue()) {
      com.tencent.mm.plugin.emoji.c.a.lq(true);
    }
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(406L, 3L, 1L, false);
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(406L, 5L, System.currentTimeMillis() - l, false);
    com.tencent.mm.plugin.report.service.h.CyF.a(12740, new Object[] { Integer.valueOf(4), "", "", "", Integer.valueOf(24), Integer.valueOf(24) });
    AppMethodBeat.o(108936);
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
      cHg();
      fC(131074, 50);
    }
    AppMethodBeat.o(108943);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiMineUI
 * JD-Core Version:    0.7.0.1
 */