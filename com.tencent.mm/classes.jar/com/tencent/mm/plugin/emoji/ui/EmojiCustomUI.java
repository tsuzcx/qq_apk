package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
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
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.emoji.b.b.ae;
import com.tencent.mm.emoji.b.b.y;
import com.tencent.mm.emoji.b.k;
import com.tencent.mm.emoji.b.l;
import com.tencent.mm.emoji.panel.a.i.a;
import com.tencent.mm.emoji.sync.EmojiSyncManager.b;
import com.tencent.mm.emoji.sync.g.i;
import com.tencent.mm.emoji.sync.j;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.i.d;
import com.tencent.mm.plugin.emoji.i.e;
import com.tencent.mm.plugin.emoji.i.f;
import com.tencent.mm.plugin.emoji.i.h;
import com.tencent.mm.plugin.emoji.model.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.b.b.a;
import java.util.ArrayList;
import java.util.List;

public class EmojiCustomUI
  extends MMActivity
  implements AdapterView.OnItemClickListener, com.tencent.mm.an.i
{
  private MMHandler mHandler;
  private ProgressDialog mRa;
  private GridLayoutManager tNm;
  private b uIL;
  private RecyclerView uIM;
  private com.tencent.mm.plugin.emoji.ui.a.a uIN;
  private com.tencent.mm.plugin.emoji.model.a<?> uIO;
  private View uIP;
  private Button uIQ;
  private Button uIR;
  private EmojiSyncManager.b uIS;
  private View uIT;
  private TextView uIU;
  private Button uIV;
  private boolean uIW;
  private boolean uIX;
  private a uIY;
  private ArrayList<String> uIZ;
  private int uJa;
  private j uJb;
  private View.OnClickListener uJc;
  private View.OnClickListener uJd;
  private View.OnClickListener uJe;
  private final MStorage.IOnStorageChange uJf;
  private final g.i uJg;
  private EmojiInfo uJh;
  
  public EmojiCustomUI()
  {
    AppMethodBeat.i(108895);
    this.uIL = b.uJs;
    this.uIS = EmojiSyncManager.b.jOF;
    this.uIW = false;
    this.uIX = false;
    this.uIY = a.uJq;
    this.uIZ = new ArrayList();
    this.uJa = 0;
    this.uJc = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(108859);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/EmojiCustomUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        switch (EmojiCustomUI.13.uJl[EmojiCustomUI.a(EmojiCustomUI.this).ordinal()])
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
    this.uJd = new EmojiCustomUI.12(this);
    this.uJe = new EmojiCustomUI.14(this);
    this.uJf = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(108872);
        if ((!Util.isNullOrNil(paramAnonymousString)) && ((paramAnonymousString.length() == 32) || (paramAnonymousString.equals("event_update_emoji")) || (paramAnonymousString.equals("delete_emoji_info_notify")))) {
          EmojiCustomUI.e(EmojiCustomUI.this).aCp();
        }
        AppMethodBeat.o(108872);
      }
    };
    this.uJg = new g.i()
    {
      public final void aCN()
      {
        AppMethodBeat.i(258069);
        EmojiCustomUI.e(EmojiCustomUI.this).aCp();
        EmojiCustomUI.f(EmojiCustomUI.this).aDl();
        AppMethodBeat.o(258069);
      }
    };
    this.mHandler = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(255797);
        switch (paramAnonymousMessage.what)
        {
        default: 
          Log.e("MicroMsg.emoji.EmojiCustomUI", "unknow Msg");
        case 1001: 
        case 1002: 
          do
          {
            AppMethodBeat.o(255797);
            return;
            EmojiCustomUI.g(EmojiCustomUI.this);
            AppMethodBeat.o(255797);
            return;
            EmojiCustomUI.e(EmojiCustomUI.this).aCp();
          } while (NetStatusUtil.isWifi(EmojiCustomUI.this));
          AppMethodBeat.o(255797);
          return;
        }
        EmojiCustomUI.h(EmojiCustomUI.this).setVisibility(8);
        AppMethodBeat.o(255797);
      }
    };
    AppMethodBeat.o(108895);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(108896);
    Log.i("MicroMsg.emoji.EmojiCustomUI", "dz[updateButtonType,button type:%s]", new Object[] { parama.toString() });
    this.uIY = parama;
    switch (13.uJl[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(108896);
      return;
      this.uIV.setVisibility(4);
      AppMethodBeat.o(108896);
      return;
      this.uIV.setVisibility(0);
      this.uIV.setText(i.h.emoji_sync_start_sync);
      AppMethodBeat.o(108896);
      return;
      this.uIV.setVisibility(0);
      this.uIV.setText(i.h.emoji_sync_stop_sync);
    }
  }
  
  private void a(b paramb)
  {
    AppMethodBeat.i(108906);
    long l = System.currentTimeMillis();
    this.uIL = paramb;
    this.uIN.b(paramb);
    int i;
    switch (13.uJn[paramb.ordinal()])
    {
    default: 
      this.uIN.alc.notifyChanged();
      if (this.uIL == b.uJt)
      {
        this.uIO.cUC();
        this.uIO.aCp();
        if (this.uIZ == null)
        {
          i = 0;
          label103:
          setMMTitle(getString(i.h.emoji_select_count, new Object[] { Integer.valueOf(i) }));
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
      addTextOptionMenu(0, getString(i.h.emoji_store_custom_mgr), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(108864);
          EmojiCustomUI.a(EmojiCustomUI.this, EmojiCustomUI.b.uJt);
          com.tencent.mm.plugin.report.service.h.IzE.a(11596, new Object[] { Integer.valueOf(1) });
          AppMethodBeat.o(108864);
          return true;
        }
      });
      this.uIP.setVisibility(8);
      cVX();
      cVT();
      for (;;)
      {
        cVU();
        break;
        setBackBtn(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(108865);
            EmojiCustomUI.a(EmojiCustomUI.this, EmojiCustomUI.b.uJs);
            AppMethodBeat.o(108865);
            return true;
          }
        });
        addTextOptionMenu(0, getString(i.h.app_finish), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(257905);
            EmojiCustomUI.a(EmojiCustomUI.this, EmojiCustomUI.b.uJs);
            AppMethodBeat.o(257905);
            return true;
          }
        });
        this.uIP.setVisibility(0);
        cVW();
        cVV();
      }
      cVU();
      break;
      i = this.uIZ.size();
      break label103;
      this.uIO.cUC();
      this.uIO.aCp();
    }
  }
  
  private boolean auR(String paramString)
  {
    AppMethodBeat.i(108910);
    com.tencent.mm.ui.base.h.c(getContext(), paramString, "", "", getString(i.h.i_know_it), null, null);
    AppMethodBeat.o(108910);
    return true;
  }
  
  private void auS(String paramString)
  {
    AppMethodBeat.i(108916);
    getString(i.h.app_tip);
    this.mRa = com.tencent.mm.ui.base.h.a(this, paramString, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    AppMethodBeat.o(108916);
  }
  
  private void cVG()
  {
    AppMethodBeat.i(108917);
    if ((this.mRa != null) && (this.mRa.isShowing())) {
      this.mRa.dismiss();
    }
    AppMethodBeat.o(108917);
  }
  
  private void cVT()
  {
    AppMethodBeat.i(108907);
    if (this.uIZ != null)
    {
      this.uIZ.clear();
      this.uIN.dj(this.uIZ);
    }
    Log.i("MicroMsg.emoji.EmojiCustomUI", "clear md5 list. updateMode NORMAL");
    AppMethodBeat.o(108907);
  }
  
  private void cVU()
  {
    AppMethodBeat.i(108908);
    View localView = this.uIP;
    if (this.uIL == b.uJt) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(108908);
      return;
    }
  }
  
  private void cVW()
  {
    AppMethodBeat.i(108911);
    if (this.mHandler != null) {
      this.mHandler.sendEmptyMessageDelayed(1003, 0L);
    }
    AppMethodBeat.o(108911);
  }
  
  private void cVX()
  {
    AppMethodBeat.i(108912);
    if (!NetStatusUtil.isConnected(this))
    {
      cVW();
      AppMethodBeat.o(108912);
      return;
    }
    AppMethodBeat.o(108912);
  }
  
  public final void cVV()
  {
    AppMethodBeat.i(108909);
    int i;
    if (this.uIL == b.uJt)
    {
      if (this.uIZ != null) {
        break label94;
      }
      i = 0;
      if (i <= 0) {
        break label105;
      }
      this.uIQ.setText(getResources().getString(i.h.app_delete));
      this.uIQ.setEnabled(true);
      this.uIR.setEnabled(true);
    }
    for (;;)
    {
      setMMTitle(getResources().getString(i.h.emoji_select_count, new Object[] { Integer.valueOf(i) }));
      AppMethodBeat.o(108909);
      return;
      label94:
      i = this.uIZ.size();
      break;
      label105:
      this.uIQ.setText(getResources().getString(i.h.app_delete));
      this.uIQ.setEnabled(false);
      this.uIR.setEnabled(false);
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return i.f.emoji_custom;
  }
  
  public void initView()
  {
    AppMethodBeat.i(108902);
    this.uIT = findViewById(i.e.sync_view);
    this.uIU = ((TextView)findViewById(i.e.sync_status));
    this.uIV = ((Button)findViewById(i.e.sync_action_btn));
    this.uIV.setOnClickListener(this.uJc);
    this.uIM = ((RecyclerView)findViewById(i.e.emoji_custom_recycler));
    this.uIM.setFocusable(false);
    this.uIM.setItemAnimator(null);
    this.tNm = new GridLayoutManager(5);
    this.tNm.ahK = new GridLayoutManager.b()
    {
      public final int cx(int paramAnonymousInt)
      {
        AppMethodBeat.i(257267);
        if (EmojiCustomUI.i(EmojiCustomUI.this).getItemViewType(paramAnonymousInt) == 8)
        {
          AppMethodBeat.o(257267);
          return 5;
        }
        AppMethodBeat.o(257267);
        return 1;
      }
    };
    this.uIM.setLayoutManager(this.tNm);
    Drawable localDrawable = getDrawable(i.d.emoji_custom_divider);
    this.uIM.a(new com.tencent.mm.plugin.emoji.ui.widget.a(localDrawable, localDrawable));
    this.uIN = new com.tencent.mm.plugin.emoji.ui.a.a();
    this.uIN.jLP = new com.tencent.mm.emoji.panel.a.p()
    {
      public final void a(View paramAnonymousView, Context paramAnonymousContext, int paramAnonymousInt) {}
      
      public final void a(View paramAnonymousView, Context paramAnonymousContext, int paramAnonymousInt, ae paramAnonymousae)
      {
        AppMethodBeat.i(257956);
        if ((paramAnonymousae instanceof com.tencent.mm.emoji.b.b.m))
        {
          EmojiCustomUI.j(EmojiCustomUI.this);
          AppMethodBeat.o(257956);
          return;
        }
        if ((paramAnonymousae instanceof com.tencent.mm.emoji.b.b.h))
        {
          paramAnonymousView = ((com.tencent.mm.emoji.b.b.h)paramAnonymousae).jHh;
          if (!EmojiCustomUI.k(EmojiCustomUI.this).contains(paramAnonymousView.getMd5())) {
            break label95;
          }
          EmojiCustomUI.a(EmojiCustomUI.this, paramAnonymousView.getMd5());
        }
        for (;;)
        {
          EmojiCustomUI.i(EmojiCustomUI.this).cL(paramAnonymousInt);
          EmojiCustomUI.this.cVV();
          AppMethodBeat.o(257956);
          return;
          label95:
          EmojiCustomUI.b(EmojiCustomUI.this, paramAnonymousView.field_md5);
        }
      }
    };
    this.uIM.setAdapter(this.uIN);
    if (this.uJa == 1) {}
    for (this.uIO = new e();; this.uIO = new com.tencent.mm.plugin.emoji.model.g())
    {
      this.uIO.a(new i.a(this.uIN)
      {
        private int uEg = 0;
        
        public final void b(y paramAnonymousy)
        {
          AppMethodBeat.i(257655);
          super.b(paramAnonymousy);
          this.uEg = paramAnonymousy.aCj().size();
          if (EmojiCustomUI.l(EmojiCustomUI.this) != EmojiCustomUI.b.uJt)
          {
            if (EmojiCustomUI.m(EmojiCustomUI.this) == 0)
            {
              EmojiCustomUI.this.setMMTitle(EmojiCustomUI.this.getString(i.h.emoji_custom_manager_title, new Object[] { Integer.valueOf(paramAnonymousy.getDataCount()) }));
              AppMethodBeat.o(257655);
              return;
            }
            EmojiCustomUI.this.setMMTitle(EmojiCustomUI.this.getString(i.h.emoji_capture_manager_title, new Object[] { Integer.valueOf(paramAnonymousy.getDataCount()) }));
          }
          AppMethodBeat.o(257655);
        }
      });
      this.uIN.aa(this.uIO.aCk().aCj());
      this.uIP = findViewById(i.e.settings_emoticons_custom_footer);
      this.uIQ = ((Button)findViewById(i.e.settings_emoticons_delete));
      this.uIQ.setOnClickListener(this.uJd);
      this.uIR = ((Button)findViewById(i.e.settings_emoticons_top));
      this.uIR.setOnClickListener(this.uJe);
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
        ((Intent)localObject).putExtra("CropImage_OutputPath", com.tencent.mm.plugin.emoji.i.b.bcb());
        com.tencent.mm.plugin.emoji.c.mIG.a((Intent)localObject, 206, this, paramIntent);
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
      localObject = com.tencent.mm.plugin.emoji.i.b.bcb() + paramIntent;
      this.uJh = com.tencent.mm.plugin.emoji.model.p.getEmojiStorageMgr().VFH.bxK(paramIntent);
      localObject = com.tencent.mm.ui.tools.b.b.bAJ((String)localObject);
      ((com.tencent.mm.ui.tools.b.b)localObject).mSize = com.tencent.mm.n.c.awG();
      ((com.tencent.mm.ui.tools.b.b)localObject).axw(com.tencent.mm.n.c.awH()).a(new b.a()
      {
        public final void a(com.tencent.mm.ui.tools.b.b paramAnonymousb)
        {
          AppMethodBeat.i(256134);
          if (EmojiCustomUI.n(EmojiCustomUI.this) == null)
          {
            if (paramInt1 != 0) {
              break label88;
            }
            EmojiCustomUI.a(EmojiCustomUI.this, com.tencent.mm.plugin.emoji.model.p.getEmojiStorageMgr().VFH.d(paramIntent, "", EmojiGroupInfo.YCx, EmojiInfo.YCE, paramAnonymousb.XVL, ""));
          }
          for (;;)
          {
            com.tencent.mm.plugin.emoji.model.p.cUO().a(EmojiCustomUI.this.getContext(), EmojiCustomUI.n(EmojiCustomUI.this), 1, z.bcZ());
            AppMethodBeat.o(256134);
            return;
            label88:
            EmojiCustomUI.a(EmojiCustomUI.this, com.tencent.mm.plugin.emoji.model.p.getEmojiStorageMgr().VFH.d(paramIntent, "", EmojiGroupInfo.YCx, EmojiInfo.YCF, paramAnonymousb.XVL, ""));
          }
        }
        
        public final void cVR()
        {
          AppMethodBeat.i(256135);
          com.tencent.mm.ui.base.h.a(EmojiCustomUI.this.getContext(), EmojiCustomUI.this.getContext().getString(i.h.emoji_custom_gif_max_size_limit), "", EmojiCustomUI.this.getContext().getString(i.h.i_know_it), false, null);
          AppMethodBeat.o(256135);
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
    if (this.uIL == b.uJt)
    {
      a(b.uJs);
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
    this.uJa = getIntent().getIntExtra("key_emoji_panel_type", this.uJa);
    if (this.uJa == 1)
    {
      this.uJb = com.tencent.mm.emoji.sync.g.aDs();
      initView();
      a(b.uJs);
      if (this.uJa != 1) {
        break label276;
      }
    }
    label276:
    for (boolean bool = ((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VgO, Boolean.TRUE)).booleanValue();; bool = ((Boolean)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VgN, Boolean.TRUE)).booleanValue())
    {
      Log.i("MicroMsg.emoji.EmojiCustomUI", "[cpan] touch batch emoji download from EmojiCustomUI needDownload:%b", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        new com.tencent.mm.emoji.sync.f(this.uJa).start();
      }
      com.tencent.mm.plugin.emoji.model.p.getEmojiStorageMgr().VFH.add(this.uJf);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(406L, 9L, 1L, false);
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(406L, 11L, System.currentTimeMillis() - l, false);
      com.tencent.mm.plugin.report.service.h.IzE.a(12740, new Object[] { Integer.valueOf(4), "", "", "", Integer.valueOf(28), Integer.valueOf(28) });
      this.uJb.a(this.uJg);
      this.uJb.eD(true);
      paramBundle = l.jIq;
      l.aBO();
      AppMethodBeat.o(108898);
      return;
      this.uJb = com.tencent.mm.emoji.sync.g.aDr();
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(108901);
    super.onDestroy();
    com.tencent.mm.plugin.emoji.model.p.getEmojiStorageMgr().VFH.remove(this.uJf);
    this.uJb.b(this.uJg);
    this.mHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(108901);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(108903);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramAdapterView);
    localb.bn(paramView);
    localb.sg(paramInt);
    localb.Fs(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/emoji/ui/EmojiCustomUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiCustomUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(108903);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(108900);
    super.onPause();
    com.tencent.mm.kernel.h.aHF().kcd.b(698, this);
    AppMethodBeat.o(108900);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(108899);
    super.onResume();
    cVX();
    com.tencent.mm.kernel.h.aHF().kcd.a(698, this);
    AppMethodBeat.o(108899);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(108915);
    Log.i("MicroMsg.emoji.EmojiCustomUI", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramq instanceof com.tencent.mm.plugin.emoji.f.c))
    {
      switch (((com.tencent.mm.plugin.emoji.f.c)paramq).mWz)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(108915);
        return;
        cVG();
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = new ArrayList(this.uIZ);
          com.tencent.mm.kernel.h.aHJ().postToWorker(new EmojiCustomUI.10(this, paramString));
          if (this.uJa == 0)
          {
            k.aBH().eu(true);
            k.aBH().et(true);
          }
          for (;;)
          {
            com.tencent.mm.plugin.emoji.model.p.getEmojiStorageMgr().VFH.J(this.uIZ, this.uJa);
            cVT();
            cVV();
            paramString = l.jIq;
            l.aBO();
            AppMethodBeat.o(108915);
            return;
            k.aBH().ew(true);
          }
        }
        Log.i("MicroMsg.emoji.EmojiCustomUI", "delete failed");
        auR(getString(i.h.emoji_top_failed));
        AppMethodBeat.o(108915);
        return;
        cVG();
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (this.uJa == 0)
          {
            k.aBH().eu(true);
            k.aBH().et(true);
          }
          for (;;)
          {
            com.tencent.mm.plugin.emoji.model.p.getEmojiStorageMgr().VFH.A(this.uJa, this.uIZ);
            cVT();
            cVV();
            this.uIN.alc.notifyChanged();
            AppMethodBeat.o(108915);
            return;
            k.aBH().ew(true);
          }
        }
        auR(getString(i.h.emoji_top_failed));
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
      uJo = new a("START", 0);
      uJp = new a("PAUSE", 1);
      uJq = new a("EMPTY", 2);
      uJr = new a[] { uJo, uJp, uJq };
      AppMethodBeat.o(108881);
    }
    
    private a() {}
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(108893);
      uJs = new b("NORMAL", 0);
      uJt = new b("EDIT", 1);
      uJu = new b("SYNCING", 2);
      uJv = new b("WITH_OUT_ADD", 3);
      uJw = new b[] { uJs, uJt, uJu, uJv };
      AppMethodBeat.o(108893);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiCustomUI
 * JD-Core Version:    0.7.0.1
 */