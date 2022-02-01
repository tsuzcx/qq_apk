package com.tencent.mm.plugin.emoji.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.b;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.emoji.c.b.ae;
import com.tencent.mm.emoji.c.b.y;
import com.tencent.mm.emoji.c.l;
import com.tencent.mm.emoji.panel.a.g.a;
import com.tencent.mm.emoji.panel.a.n;
import com.tencent.mm.emoji.sync.EmojiSyncManager.b;
import com.tencent.mm.emoji.sync.g.i;
import com.tencent.mm.emoji.sync.j;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.g.d;
import com.tencent.mm.plugin.emoji.h.d;
import com.tencent.mm.plugin.emoji.h.e;
import com.tencent.mm.plugin.emoji.h.f;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.plugin.emoji.model.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.tools.b.b.a;
import java.util.ArrayList;
import java.util.List;

public class EmojiCustomUI
  extends MMActivity
  implements AdapterView.OnItemClickListener, com.tencent.mm.am.h
{
  private MMHandler mHandler;
  private ProgressDialog pNH;
  private GridLayoutManager wQC;
  private b xRB;
  private RecyclerView xRC;
  private com.tencent.mm.plugin.emoji.ui.a.a xRD;
  private com.tencent.mm.plugin.emoji.model.a<?> xRE;
  private View xRF;
  private Button xRG;
  private Button xRH;
  private EmojiSyncManager.b xRI;
  private View xRJ;
  private TextView xRK;
  private Button xRL;
  private boolean xRM;
  private boolean xRN;
  private a xRO;
  private ArrayList<String> xRP;
  private int xRQ;
  private j xRR;
  private View.OnClickListener xRS;
  private View.OnClickListener xRT;
  private View.OnClickListener xRU;
  private final MStorage.IOnStorageChange xRV;
  private final g.i xRW;
  private EmojiInfo xRX;
  
  public EmojiCustomUI()
  {
    AppMethodBeat.i(108895);
    this.xRB = b.xSi;
    this.xRI = EmojiSyncManager.b.mnz;
    this.xRM = false;
    this.xRN = false;
    this.xRO = a.xSg;
    this.xRP = new ArrayList();
    this.xRQ = 0;
    this.xRS = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(108859);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/EmojiCustomUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        switch (EmojiCustomUI.13.xSb[EmojiCustomUI.a(EmojiCustomUI.this).ordinal()])
        {
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiCustomUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(108859);
          return;
          EmojiCustomUI.b(EmojiCustomUI.this);
        }
      }
    };
    this.xRT = new EmojiCustomUI.12(this);
    this.xRU = new EmojiCustomUI.14(this);
    this.xRV = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(108872);
        if ((!Util.isNullOrNil(paramAnonymousString)) && ((paramAnonymousString.length() == 32) || (paramAnonymousString.equals("event_update_emoji")) || (paramAnonymousString.equals("delete_emoji_info_notify")))) {
          EmojiCustomUI.e(EmojiCustomUI.this).aVl();
        }
        AppMethodBeat.o(108872);
      }
    };
    this.xRW = new g.i()
    {
      public final void aVL()
      {
        AppMethodBeat.i(270412);
        EmojiCustomUI.e(EmojiCustomUI.this).aVl();
        EmojiCustomUI.f(EmojiCustomUI.this).aWl();
        AppMethodBeat.o(270412);
      }
    };
    this.mHandler = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(270411);
        switch (paramAnonymousMessage.what)
        {
        default: 
          Log.e("MicroMsg.emoji.EmojiCustomUI", "unknow Msg");
        case 1001: 
        case 1002: 
          do
          {
            AppMethodBeat.o(270411);
            return;
            EmojiCustomUI.g(EmojiCustomUI.this);
            AppMethodBeat.o(270411);
            return;
            EmojiCustomUI.e(EmojiCustomUI.this).aVl();
          } while (NetStatusUtil.isWifi(EmojiCustomUI.this));
          AppMethodBeat.o(270411);
          return;
        }
        EmojiCustomUI.h(EmojiCustomUI.this).setVisibility(8);
        AppMethodBeat.o(270411);
      }
    };
    AppMethodBeat.o(108895);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(108896);
    Log.i("MicroMsg.emoji.EmojiCustomUI", "dz[updateButtonType,button type:%s]", new Object[] { parama.toString() });
    this.xRO = parama;
    switch (13.xSb[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(108896);
      return;
      this.xRL.setVisibility(4);
      AppMethodBeat.o(108896);
      return;
      this.xRL.setVisibility(0);
      this.xRL.setText(h.h.emoji_sync_start_sync);
      AppMethodBeat.o(108896);
      return;
      this.xRL.setVisibility(0);
      this.xRL.setText(h.h.emoji_sync_stop_sync);
    }
  }
  
  private void a(b paramb)
  {
    AppMethodBeat.i(108906);
    long l = System.currentTimeMillis();
    this.xRB = paramb;
    this.xRD.b(paramb);
    int i;
    switch (13.xSd[paramb.ordinal()])
    {
    default: 
      this.xRD.bZE.notifyChanged();
      if (this.xRB == b.xSj)
      {
        this.xRE.dzJ();
        this.xRE.aVl();
        if (this.xRP == null)
        {
          i = 0;
          label103:
          setMMTitle(getString(h.h.emoji_select_count, new Object[] { Integer.valueOf(i) }));
        }
      }
      break;
    }
    for (;;)
    {
      Log.d("MicroMsg.emoji.EmojiCustomUI", "updateMode use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(108906);
      return;
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(108863);
          EmojiCustomUI.this.finish();
          AppMethodBeat.o(108863);
          return true;
        }
      });
      enableBackMenu(true);
      addTextOptionMenu(0, getString(h.h.emoji_store_custom_mgr), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(108864);
          EmojiCustomUI.a(EmojiCustomUI.this, EmojiCustomUI.b.xSj);
          com.tencent.mm.plugin.report.service.h.OAn.b(11596, new Object[] { Integer.valueOf(1) });
          AppMethodBeat.o(108864);
          return true;
        }
      });
      this.xRF.setVisibility(8);
      dBC();
      dBy();
      for (;;)
      {
        dBz();
        break;
        setBackBtn(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(108865);
            EmojiCustomUI.a(EmojiCustomUI.this, EmojiCustomUI.b.xSi);
            AppMethodBeat.o(108865);
            return true;
          }
        });
        addTextOptionMenu(0, getString(h.h.app_finish), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(270353);
            EmojiCustomUI.a(EmojiCustomUI.this, EmojiCustomUI.b.xSi);
            AppMethodBeat.o(270353);
            return true;
          }
        });
        this.xRF.setVisibility(0);
        dBB();
        dBA();
      }
      dBz();
      break;
      i = this.xRP.size();
      break label103;
      this.xRE.dzJ();
      this.xRE.aVl();
    }
  }
  
  private boolean aoQ(String paramString)
  {
    AppMethodBeat.i(108910);
    k.b(getContext(), paramString, "", "", getString(h.h.i_know_it), null, null);
    AppMethodBeat.o(108910);
    return true;
  }
  
  private void aoR(String paramString)
  {
    AppMethodBeat.i(108916);
    getString(h.h.app_tip);
    this.pNH = k.a(this, paramString, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    AppMethodBeat.o(108916);
  }
  
  private void dBB()
  {
    AppMethodBeat.i(108911);
    if (this.mHandler != null) {
      this.mHandler.sendEmptyMessageDelayed(1003, 0L);
    }
    AppMethodBeat.o(108911);
  }
  
  private void dBC()
  {
    AppMethodBeat.i(108912);
    if (!NetStatusUtil.isConnected(this))
    {
      dBB();
      AppMethodBeat.o(108912);
      return;
    }
    AppMethodBeat.o(108912);
  }
  
  private void dBy()
  {
    AppMethodBeat.i(108907);
    if (this.xRP != null)
    {
      this.xRP.clear();
      this.xRD.ff(this.xRP);
    }
    Log.i("MicroMsg.emoji.EmojiCustomUI", "clear md5 list. updateMode NORMAL");
    AppMethodBeat.o(108907);
  }
  
  private void dBz()
  {
    AppMethodBeat.i(108908);
    View localView = this.xRF;
    if (this.xRB == b.xSj) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(108908);
      return;
    }
  }
  
  private void dismissLoadingDialog()
  {
    AppMethodBeat.i(108917);
    if ((this.pNH != null) && (this.pNH.isShowing())) {
      this.pNH.dismiss();
    }
    AppMethodBeat.o(108917);
  }
  
  public final void dBA()
  {
    AppMethodBeat.i(108909);
    int i;
    if (this.xRB == b.xSj)
    {
      if (this.xRP != null) {
        break label94;
      }
      i = 0;
      if (i <= 0) {
        break label105;
      }
      this.xRG.setText(getResources().getString(h.h.app_delete));
      this.xRG.setEnabled(true);
      this.xRH.setEnabled(true);
    }
    for (;;)
    {
      setMMTitle(getResources().getString(h.h.emoji_select_count, new Object[] { Integer.valueOf(i) }));
      AppMethodBeat.o(108909);
      return;
      label94:
      i = this.xRP.size();
      break;
      label105:
      this.xRG.setText(getResources().getString(h.h.app_delete));
      this.xRG.setEnabled(false);
      this.xRH.setEnabled(false);
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return h.f.emoji_custom;
  }
  
  public void initView()
  {
    AppMethodBeat.i(108902);
    this.xRJ = findViewById(h.e.sync_view);
    this.xRK = ((TextView)findViewById(h.e.sync_status));
    this.xRL = ((Button)findViewById(h.e.sync_action_btn));
    this.xRL.setOnClickListener(this.xRS);
    this.xRC = ((RecyclerView)findViewById(h.e.emoji_custom_recycler));
    this.xRC.setFocusable(false);
    this.xRC.setItemAnimator(null);
    this.wQC = new GridLayoutManager(5);
    this.wQC.bWq = new GridLayoutManager.b()
    {
      public final int fJ(int paramAnonymousInt)
      {
        AppMethodBeat.i(270407);
        if (EmojiCustomUI.i(EmojiCustomUI.this).getItemViewType(paramAnonymousInt) == 8)
        {
          AppMethodBeat.o(270407);
          return 5;
        }
        AppMethodBeat.o(270407);
        return 1;
      }
    };
    this.xRC.setLayoutManager(this.wQC);
    Drawable localDrawable = getDrawable(h.d.emoji_custom_divider);
    this.xRC.a(new com.tencent.mm.plugin.emoji.ui.widget.a(localDrawable, localDrawable));
    this.xRD = new com.tencent.mm.plugin.emoji.ui.a.a();
    this.xRD.mkY = new n()
    {
      public final void a(View paramAnonymousView, Context paramAnonymousContext, int paramAnonymousInt) {}
      
      public final void a(View paramAnonymousView, Context paramAnonymousContext, int paramAnonymousInt, ae paramAnonymousae)
      {
        AppMethodBeat.i(270404);
        if ((paramAnonymousae instanceof com.tencent.mm.emoji.c.b.m))
        {
          EmojiCustomUI.j(EmojiCustomUI.this);
          AppMethodBeat.o(270404);
          return;
        }
        if ((paramAnonymousae instanceof com.tencent.mm.emoji.c.b.h))
        {
          paramAnonymousView = ((com.tencent.mm.emoji.c.b.h)paramAnonymousae).mgK;
          if (!EmojiCustomUI.k(EmojiCustomUI.this).contains(paramAnonymousView.getMd5())) {
            break label95;
          }
          EmojiCustomUI.a(EmojiCustomUI.this, paramAnonymousView.getMd5());
        }
        for (;;)
        {
          EmojiCustomUI.i(EmojiCustomUI.this).fV(paramAnonymousInt);
          EmojiCustomUI.this.dBA();
          AppMethodBeat.o(270404);
          return;
          label95:
          EmojiCustomUI.b(EmojiCustomUI.this, paramAnonymousView.field_md5);
        }
      }
    };
    this.xRC.setAdapter(this.xRD);
    if (this.xRQ == 1) {}
    for (this.xRE = new e();; this.xRE = new com.tencent.mm.plugin.emoji.model.g())
    {
      this.xRE.a(new g.a(this.xRD)
      {
        private int xMx = 0;
        
        public final void b(y paramAnonymousy)
        {
          AppMethodBeat.i(270399);
          super.b(paramAnonymousy);
          this.xMx = paramAnonymousy.aVf().size();
          if (EmojiCustomUI.l(EmojiCustomUI.this) != EmojiCustomUI.b.xSj)
          {
            if (EmojiCustomUI.m(EmojiCustomUI.this) == 0)
            {
              EmojiCustomUI.this.setMMTitle(EmojiCustomUI.this.getString(h.h.emoji_custom_manager_title, new Object[] { Integer.valueOf(paramAnonymousy.getDataCount()) }));
              AppMethodBeat.o(270399);
              return;
            }
            EmojiCustomUI.this.setMMTitle(EmojiCustomUI.this.getString(h.h.emoji_capture_manager_title, new Object[] { Integer.valueOf(paramAnonymousy.getDataCount()) }));
          }
          AppMethodBeat.o(270399);
        }
      });
      this.xRD.bz(this.xRE.aVh().aVf());
      this.xRF = findViewById(h.e.settings_emoticons_custom_footer);
      this.xRG = ((Button)findViewById(h.e.settings_emoticons_delete));
      this.xRG.setOnClickListener(this.xRT);
      this.xRH = ((Button)findViewById(h.e.settings_emoticons_top));
      this.xRH.setOnClickListener(this.xRU);
      AppMethodBeat.o(108902);
      return;
    }
  }
  
  public void onActivityResult(final int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(108904);
    Log.d("MicroMsg.emoji.EmojiCustomUI", "onActivityResult: requestCode[%d],resultCode:[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 == -1)
    {
      switch (paramInt1)
      {
      default: 
        Log.e("MicroMsg.emoji.EmojiCustomUI", "onActivityResult: not found this requestCode");
        AppMethodBeat.o(108904);
        return;
      case 205: 
        if (paramIntent == null)
        {
          AppMethodBeat.o(108904);
          return;
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("CropImageMode", 3);
        ((Intent)localObject).putExtra("CropImage_OutputPath", d.bzQ());
        com.tencent.mm.plugin.emoji.c.pFn.a((Intent)localObject, 206, this, paramIntent);
        AppMethodBeat.o(108904);
        return;
      }
      if (paramIntent == null)
      {
        Log.e("MicroMsg.emoji.EmojiCustomUI", "onActivityResult MAT_IMAGE_IN_CROP_ACTIVITY return null.");
        AppMethodBeat.o(108904);
        return;
      }
      Object localObject = paramIntent.getStringExtra("CropImage_OutputPath");
      paramInt1 = paramIntent.getIntExtra("emoji_type", 0);
      if ((localObject == null) || (((String)localObject).length() <= 0))
      {
        AppMethodBeat.o(108904);
        return;
      }
      paramIntent = ((String)localObject).substring(((String)localObject).lastIndexOf('/') + 1);
      localObject = d.bzQ() + paramIntent;
      this.xRX = com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.bza(paramIntent);
      localObject = com.tencent.mm.ui.tools.b.b.bCH((String)localObject);
      ((com.tencent.mm.ui.tools.b.b)localObject).mSize = com.tencent.mm.k.c.aRg();
      ((com.tencent.mm.ui.tools.b.b)localObject).aEf(com.tencent.mm.k.c.aRh()).a(new b.a()
      {
        public final void a(com.tencent.mm.ui.tools.b.b paramAnonymousb)
        {
          AppMethodBeat.i(270366);
          if (EmojiCustomUI.n(EmojiCustomUI.this) == null)
          {
            if (paramInt1 != 0) {
              break label88;
            }
            EmojiCustomUI.a(EmojiCustomUI.this, com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.d(paramIntent, "", EmojiGroupInfo.aklG, EmojiInfo.aklN, paramAnonymousb.afMa, ""));
          }
          for (;;)
          {
            com.tencent.mm.plugin.emoji.model.s.dAl().a(EmojiCustomUI.this.getContext(), EmojiCustomUI.n(EmojiCustomUI.this), 1, z.bAM());
            AppMethodBeat.o(270366);
            return;
            label88:
            EmojiCustomUI.a(EmojiCustomUI.this, com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.d(paramIntent, "", EmojiGroupInfo.aklG, EmojiInfo.aklO, paramAnonymousb.afMa, ""));
          }
        }
        
        public final void dBw()
        {
          AppMethodBeat.i(270371);
          k.a(EmojiCustomUI.this.getContext(), EmojiCustomUI.this.getContext().getString(h.h.emoji_custom_gif_max_size_limit), "", EmojiCustomUI.this.getContext().getString(h.h.i_know_it), false, null);
          AppMethodBeat.o(270371);
        }
      });
      AppMethodBeat.o(108904);
      return;
    }
    AppMethodBeat.o(108904);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(108905);
    if (this.xRB == b.xSj)
    {
      a(b.xSi);
      AppMethodBeat.o(108905);
      return;
    }
    super.onBackPressed();
    AppMethodBeat.o(108905);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(108898);
    long l = System.currentTimeMillis();
    super.onCreate(paramBundle);
    this.xRQ = getIntent().getIntExtra("key_emoji_panel_type", this.xRQ);
    if (this.xRQ == 1)
    {
      this.xRR = com.tencent.mm.emoji.sync.g.aWo();
      initView();
      a(b.xSi);
      if (this.xRQ != 1) {
        break label276;
      }
    }
    label276:
    for (boolean bool = ((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acIe, Boolean.TRUE)).booleanValue();; bool = ((Boolean)com.tencent.mm.kernel.h.baE().ban().get(at.a.acId, Boolean.TRUE)).booleanValue())
    {
      Log.i("MicroMsg.emoji.EmojiCustomUI", "[cpan] touch batch emoji download from EmojiCustomUI needDownload:%b", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        new com.tencent.mm.emoji.sync.f(this.xRQ).start();
      }
      com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.add(this.xRV);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(406L, 9L, 1L, false);
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(406L, 11L, System.currentTimeMillis() - l, false);
      com.tencent.mm.plugin.report.service.h.OAn.b(12740, new Object[] { Integer.valueOf(4), "", "", "", Integer.valueOf(28), Integer.valueOf(28) });
      this.xRR.a(this.xRW);
      this.xRR.fo(true);
      paramBundle = com.tencent.mm.emoji.c.m.mhY;
      com.tencent.mm.emoji.c.m.aUM();
      AppMethodBeat.o(108898);
      return;
      this.xRR = com.tencent.mm.emoji.sync.g.aWn();
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(108901);
    super.onDestroy();
    com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.remove(this.xRV);
    this.xRR.b(this.xRW);
    this.mHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(108901);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(108903);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramAdapterView);
    localb.cH(paramView);
    localb.sc(paramInt);
    localb.hB(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/EmojiCustomUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiCustomUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(108903);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(108900);
    super.onPause();
    com.tencent.mm.kernel.h.baD().mCm.b(698, this);
    AppMethodBeat.o(108900);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(108899);
    super.onResume();
    dBC();
    com.tencent.mm.kernel.h.baD().mCm.a(698, this);
    AppMethodBeat.o(108899);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(108915);
    Log.i("MicroMsg.emoji.EmojiCustomUI", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramp instanceof com.tencent.mm.plugin.emoji.e.c))
    {
      switch (((com.tencent.mm.plugin.emoji.e.c)paramp).pTf)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(108915);
        return;
        dismissLoadingDialog();
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = new ArrayList(this.xRP);
          com.tencent.mm.kernel.h.baH().postToWorker(new EmojiCustomUI.10(this, paramString));
          if (this.xRQ == 0)
          {
            l.aUF().fg(true);
            l.aUF().ff(true);
          }
          for (;;)
          {
            com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.ab(this.xRP, this.xRQ);
            dBy();
            dBA();
            paramString = com.tencent.mm.emoji.c.m.mhY;
            com.tencent.mm.emoji.c.m.aUM();
            AppMethodBeat.o(108915);
            return;
            l.aUF().fi(true);
          }
        }
        Log.i("MicroMsg.emoji.EmojiCustomUI", "delete failed");
        aoQ(getString(h.h.emoji_top_failed));
        AppMethodBeat.o(108915);
        return;
        dismissLoadingDialog();
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (this.xRQ == 0)
          {
            l.aUF().fg(true);
            l.aUF().ff(true);
          }
          for (;;)
          {
            com.tencent.mm.plugin.emoji.model.s.getEmojiStorageMgr().adju.V(this.xRQ, this.xRP);
            dBy();
            dBA();
            this.xRD.bZE.notifyChanged();
            AppMethodBeat.o(108915);
            return;
            l.aUF().fi(true);
          }
        }
        aoQ(getString(h.h.emoji_top_failed));
      }
    }
    Log.w("MicroMsg.emoji.EmojiCustomUI", "no emoji operate");
    AppMethodBeat.o(108915);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(108881);
      xSe = new a("START", 0);
      xSf = new a("PAUSE", 1);
      xSg = new a("EMPTY", 2);
      xSh = new a[] { xSe, xSf, xSg };
      AppMethodBeat.o(108881);
    }
    
    private a() {}
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(108893);
      xSi = new b("NORMAL", 0);
      xSj = new b("EDIT", 1);
      xSk = new b("SYNCING", 2);
      xSl = new b("WITH_OUT_ADD", 3);
      xSm = new b[] { xSi, xSj, xSk, xSl };
      AppMethodBeat.o(108893);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiCustomUI
 * JD-Core Version:    0.7.0.1
 */