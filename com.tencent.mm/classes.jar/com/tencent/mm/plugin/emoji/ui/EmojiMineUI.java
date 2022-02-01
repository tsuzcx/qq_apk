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
import com.tencent.mm.plugin.emoji.model.f;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.protocal.protobuf.GetEmotionListResponse;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmojiMineUI
  extends BaseEmojiStoreUI
  implements View.OnClickListener
{
  private final String TAG = "MicroMsg.emoji.EmojiMineUI";
  private ViewGroup oTj;
  private ViewGroup pPW;
  private ViewGroup pPX;
  private ViewGroup pPY;
  private ViewGroup pPZ;
  private View pPl;
  private TextView pPm;
  private TextView pQa;
  
  private boolean Co(int paramInt)
  {
    AppMethodBeat.i(108939);
    Object localObject = new Intent();
    ((Intent)localObject).setClass(this, EmojiCustomUI.class);
    ((Intent)localObject).putExtra("key_emoji_panel_type", paramInt);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/emoji/ui/EmojiMineUI", "startEmojiCustom", "(I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiMineUI", "startEmojiCustom", "(I)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(108939);
    return true;
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(108943);
    if ((paramString != null) && (paramString.equals("event_update_group")))
    {
      cji();
      fm(131074, 50);
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
  
  protected final int ciJ()
  {
    return 24;
  }
  
  protected final int ciK()
  {
    return 7;
  }
  
  protected final com.tencent.mm.plugin.emoji.a.a.a ciL()
  {
    AppMethodBeat.i(108940);
    com.tencent.mm.plugin.emoji.a.c localc = new com.tencent.mm.plugin.emoji.a.c(getContext());
    AppMethodBeat.o(108940);
    return localc;
  }
  
  protected final void ciM()
  {
    AppMethodBeat.i(108944);
    this.oTj = ((ViewGroup)View.inflate(getContext(), 2131493775, null));
    this.pQa = ((TextView)this.oTj.findViewById(2131305907));
    this.pQa.setText(2131763216);
    this.pQa.setVisibility(8);
    this.mListView.addHeaderView(this.oTj, null, false);
    this.pPW = ((ViewGroup)View.inflate(getContext(), 2131493772, null));
    this.pPX = ((ViewGroup)this.oTj.findViewById(2131302276));
    this.pPY = ((ViewGroup)this.oTj.findViewById(2131299388));
    this.pPZ = ((ViewGroup)this.pPW.findViewById(2131302277));
    ((TextView)this.pPX.findViewById(16908310)).setText(2131758244);
    ((TextView)this.pPZ.findViewById(16908310)).setText(2131758274);
    ((TextView)this.pPY.findViewById(2131299390)).setText(2131758236);
    this.pPZ.findViewById(2131298739).setBackgroundResource(2131231820);
    this.pPX.setOnClickListener(this);
    this.pPZ.setOnClickListener(this);
    this.pPY.setOnClickListener(this);
    this.mListView.addFooterView(this.pPW, null, false);
    AppMethodBeat.o(108944);
  }
  
  protected final boolean ciO()
  {
    return false;
  }
  
  protected final boolean ciP()
  {
    return false;
  }
  
  protected final int ciS()
  {
    return 8;
  }
  
  protected final boolean ciX()
  {
    boolean bool = true;
    AppMethodBeat.i(108945);
    if (this.pLl != null)
    {
      this.pLl.notifyDataSetChanged();
      this.pOd = true;
      this.GG.setVisibility(8);
    }
    for (;;)
    {
      cjb();
      AppMethodBeat.o(108945);
      return bool;
      bool = false;
    }
  }
  
  protected final boolean ciZ()
  {
    return true;
  }
  
  protected final boolean cja()
  {
    return false;
  }
  
  public final void cjb()
  {
    AppMethodBeat.i(108948);
    if (this.oTj != null)
    {
      if ((this.pLl != null) && (!this.pLl.isEmpty()))
      {
        this.pQa.setVisibility(0);
        AppMethodBeat.o(108948);
        return;
      }
      this.pQa.setVisibility(8);
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
  
  public final void i(String paramString1, int paramInt1, int paramInt2, String paramString2) {}
  
  public void initView()
  {
    AppMethodBeat.i(108937);
    setMMTitle(2131763214);
    super.initView();
    this.pPl = findViewById(2131305594);
    this.pPm = ((TextView)this.pPl.findViewById(2131305593));
    this.pPm.setText(2131758401);
    if (k.cih().pMY.pNi)
    {
      k.cih();
      if (BKGLoaderManager.ciH())
      {
        this.pPl.setVisibility(0);
        fm(8001, 3000);
      }
    }
    for (;;)
    {
      this.mListView.setOnScrollListener(null);
      AppMethodBeat.o(108937);
      return;
      this.pPl.setVisibility(8);
    }
  }
  
  public final void m(Message paramMessage)
  {
    AppMethodBeat.i(108947);
    if ((paramMessage.what == 8001) && (this.pPl != null)) {
      this.pPl.setVisibility(8);
    }
    super.m(paramMessage);
    AppMethodBeat.o(108947);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(108938);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/EmojiMineUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if (paramView == this.pPX)
    {
      Co(0);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiMineUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(108938);
      return;
    }
    if (paramView == this.pPZ)
    {
      paramView = new Intent();
      paramView.setClass(this, EmojiPaidUI.class);
      paramView = new com.tencent.mm.hellhoundlib.b.a().bc(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, paramView.ahE(), "com/tencent/mm/plugin/emoji/ui/EmojiMineUI", "startEmojiPaid", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramView.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiMineUI", "startEmojiPaid", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiMineUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(108938);
      return;
    }
    if (paramView == this.pPY)
    {
      Co(1);
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
    com.tencent.mm.plugin.report.service.g.yxI.kvStat(10931, String.valueOf(i));
    ae.i("MicroMsg.emoji.EmojiMineUI", "jacks statistics enter Emoji Setting UI:%d", new Object[] { Integer.valueOf(i) });
    setBackBtn(new EmojiMineUI.1(this));
    addTextOptionMenu(0, getString(2131758299), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(108935);
        Object localObject = k.getEmojiStorageMgr().JfV.fxf();
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
          h.l(EmojiMineUI.this.getContext(), 2131758214, 2131755906);
          AppMethodBeat.o(108935);
          return true;
        }
        if (!az.isConnected(ak.getContext()))
        {
          EmojiMineUI.a(EmojiMineUI.this);
          AppMethodBeat.o(108935);
          return true;
        }
        localObject = new Intent();
        ((Intent)localObject).setClass(EmojiMineUI.this, EmojiSortUI.class);
        paramAnonymousMenuItem = EmojiMineUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/emoji/ui/EmojiMineUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousMenuItem, "com/tencent/mm/plugin/emoji/ui/EmojiMineUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(108935);
        return true;
      }
    });
    if (!((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IKN, Boolean.FALSE)).booleanValue()) {
      com.tencent.mm.plugin.emoji.c.a.ko(true);
    }
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(406L, 3L, 1L, false);
    com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(406L, 5L, System.currentTimeMillis() - l, false);
    com.tencent.mm.plugin.report.service.g.yxI.f(12740, new Object[] { Integer.valueOf(4), "", "", "", Integer.valueOf(24), Integer.valueOf(24) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiMineUI
 * JD-Core Version:    0.7.0.1
 */