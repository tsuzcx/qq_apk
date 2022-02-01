package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.database.DataSetObservable;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.emoji.b.j;
import com.tencent.mm.emoji.sync.EmojiSyncManager;
import com.tencent.mm.emoji.sync.EmojiSyncManager.a;
import com.tencent.mm.emoji.sync.EmojiSyncManager.b;
import com.tencent.mm.emoji.sync.EmojiSyncManager.e;
import com.tencent.mm.emoji.sync.EmojiSyncManager.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.pluginsdk.m;
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
import com.tencent.mm.ui.base.HeaderGridView;
import com.tencent.mm.ui.base.HeaderGridView.a;
import com.tencent.mm.ui.base.HeaderGridView.b;
import com.tencent.mm.ui.base.HeaderGridView.c;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.tools.b.b.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;

public class EmojiCustomUI
  extends MMActivity
  implements AdapterView.OnItemClickListener, com.tencent.mm.ak.i
{
  private static com.tencent.mm.av.a.c.n jbT;
  private static com.tencent.mm.av.a.c.e rfY;
  private ProgressDialog jZH;
  private MMHandler mHandler;
  private c rfC;
  private b rfD;
  private HeaderGridView rfE;
  private View rfF;
  private Button rfG;
  private Button rfH;
  private EmojiSyncManager.b rfI;
  private View rfJ;
  private TextView rfK;
  private Button rfL;
  private boolean rfM;
  private boolean rfN;
  private boolean rfO;
  private a rfP;
  private ArrayList<String> rfQ;
  private int rfR;
  private EmojiSyncManager rfS;
  private View.OnClickListener rfT;
  private View.OnClickListener rfU;
  private View.OnClickListener rfV;
  private final MStorage.IOnStorageChange rfW;
  private final com.tencent.mm.emoji.sync.f rfX;
  private EmojiInfo rfZ;
  
  static
  {
    AppMethodBeat.i(108926);
    rfY = new com.tencent.mm.av.a.c.e()
    {
      public final byte[] i(Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(108875);
        if ((paramAnonymousVarArgs != null) && (paramAnonymousVarArgs.length > 0))
        {
          paramAnonymousVarArgs = paramAnonymousVarArgs[0];
          if ((paramAnonymousVarArgs != null) && ((paramAnonymousVarArgs instanceof EmojiInfo)))
          {
            paramAnonymousVarArgs = com.tencent.mm.emoji.decode.a.aum().a((EmojiInfo)paramAnonymousVarArgs);
            AppMethodBeat.o(108875);
            return paramAnonymousVarArgs;
          }
        }
        AppMethodBeat.o(108875);
        return null;
      }
    };
    jbT = new com.tencent.mm.av.a.c.n()
    {
      public final Bitmap Pb(String paramAnonymousString)
      {
        AppMethodBeat.i(108877);
        paramAnonymousString = com.tencent.mm.plugin.gif.i.bF(com.tencent.mm.vfs.s.aW(paramAnonymousString, 0, -1));
        AppMethodBeat.o(108877);
        return paramAnonymousString;
      }
      
      public final Bitmap aq(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(108876);
        paramAnonymousArrayOfByte = com.tencent.mm.plugin.gif.i.bF(paramAnonymousArrayOfByte);
        AppMethodBeat.o(108876);
        return paramAnonymousArrayOfByte;
      }
    };
    AppMethodBeat.o(108926);
  }
  
  public EmojiCustomUI()
  {
    AppMethodBeat.i(108895);
    this.rfC = c.rgl;
    this.rfI = EmojiSyncManager.b.hdc;
    this.rfM = false;
    this.rfN = false;
    this.rfO = false;
    this.rfP = a.rgi;
    this.rfQ = new ArrayList();
    this.rfR = 0;
    this.rfT = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(108859);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/EmojiCustomUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        switch (EmojiCustomUI.11.rgd[EmojiCustomUI.a(EmojiCustomUI.this).ordinal()])
        {
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiCustomUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(108859);
          return;
          EmojiCustomUI.b(EmojiCustomUI.this);
          continue;
          EmojiCustomUI.c(EmojiCustomUI.this).stop();
        }
      }
    };
    this.rfU = new EmojiCustomUI.12(this);
    this.rfV = new EmojiCustomUI.13(this);
    this.rfW = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(108872);
        if ((!Util.isNullOrNil(paramAnonymousString)) && ((paramAnonymousString.length() == 32) || (paramAnonymousString.equals("event_update_emoji"))) && (EmojiCustomUI.f(EmojiCustomUI.this) != null))
        {
          EmojiCustomUI.f(EmojiCustomUI.this).cHq();
          EmojiCustomUI.f(EmojiCustomUI.this).notifyDataSetChanged();
        }
        AppMethodBeat.o(108872);
      }
    };
    this.rfX = new com.tencent.mm.emoji.sync.f()
    {
      public final void a(EmojiSyncManager.b paramAnonymousb)
      {
        AppMethodBeat.i(108874);
        EmojiCustomUI.a(EmojiCustomUI.this, paramAnonymousb);
        if (EmojiCustomUI.g(EmojiCustomUI.this) != null) {
          EmojiCustomUI.g(EmojiCustomUI.this).sendEmptyMessage(1001);
        }
        AppMethodBeat.o(108874);
      }
      
      public final void awp()
      {
        AppMethodBeat.i(108873);
        if (EmojiCustomUI.g(EmojiCustomUI.this) != null) {
          EmojiCustomUI.g(EmojiCustomUI.this).sendEmptyMessage(1002);
        }
        AppMethodBeat.o(108873);
      }
    };
    this.mHandler = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(108878);
        switch (paramAnonymousMessage.what)
        {
        default: 
          Log.e("MicroMsg.emoji.EmojiCustomUI", "unknow Msg");
        case 1001: 
        case 1002: 
          do
          {
            AppMethodBeat.o(108878);
            return;
            EmojiCustomUI.h(EmojiCustomUI.this);
            AppMethodBeat.o(108878);
            return;
          } while (NetStatusUtil.isWifi(EmojiCustomUI.this));
          if (EmojiCustomUI.c(EmojiCustomUI.this).hcS == EmojiSyncManager.b.hdd)
          {
            EmojiCustomUI.a(EmojiCustomUI.this, true);
            AppMethodBeat.o(108878);
            return;
          }
          EmojiCustomUI.a(EmojiCustomUI.this, false);
          AppMethodBeat.o(108878);
          return;
        case 1003: 
          EmojiCustomUI.i(EmojiCustomUI.this).setVisibility(8);
          EmojiCustomUI.f(EmojiCustomUI.this).notifyDataSetChanged();
          AppMethodBeat.o(108878);
          return;
        }
        if (EmojiCustomUI.f(EmojiCustomUI.this) != null)
        {
          EmojiCustomUI.f(EmojiCustomUI.this).cHq();
          EmojiCustomUI.f(EmojiCustomUI.this).notifyDataSetChanged();
        }
        EmojiCustomUI.cHo();
        AppMethodBeat.o(108878);
      }
    };
    AppMethodBeat.o(108895);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(108896);
    Log.i("MicroMsg.emoji.EmojiCustomUI", "dz[updateButtonType,button type:%s]", new Object[] { parama.toString() });
    this.rfP = parama;
    switch (11.rgd[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(108896);
      return;
      this.rfL.setVisibility(4);
      AppMethodBeat.o(108896);
      return;
      this.rfL.setVisibility(0);
      this.rfL.setText(2131758691);
      AppMethodBeat.o(108896);
      return;
      this.rfL.setVisibility(0);
      this.rfL.setText(2131758692);
    }
  }
  
  private void a(c paramc)
  {
    AppMethodBeat.i(108906);
    long l = System.currentTimeMillis();
    this.rfC = paramc;
    switch (11.rgf[paramc.ordinal()])
    {
    }
    for (;;)
    {
      if (this.rfD != null)
      {
        this.rfD.cHq();
        this.rfD.notifyDataSetChanged();
      }
      Log.d("MicroMsg.emoji.EmojiCustomUI", "updateMode use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(108906);
      return;
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(108862);
          EmojiCustomUI.this.finish();
          AppMethodBeat.o(108862);
          return true;
        }
      });
      enableBackMenu(true);
      addTextOptionMenu(0, getString(2131758609), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(108863);
          EmojiCustomUI.a(EmojiCustomUI.this, EmojiCustomUI.c.rgm);
          com.tencent.mm.plugin.report.service.h.CyF.a(11596, new Object[] { Integer.valueOf(1) });
          AppMethodBeat.o(108863);
          return true;
        }
      });
      this.rfF.setVisibility(8);
      cHl();
      cHh();
      for (;;)
      {
        cHi();
        break;
        setBackBtn(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(108864);
            EmojiCustomUI.a(EmojiCustomUI.this, EmojiCustomUI.c.rgl);
            AppMethodBeat.o(108864);
            return true;
          }
        });
        addTextOptionMenu(0, getString(2131755858), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(108865);
            EmojiCustomUI.a(EmojiCustomUI.this, EmojiCustomUI.c.rgl);
            AppMethodBeat.o(108865);
            return true;
          }
        });
        this.rfF.setVisibility(0);
        cHk();
        cHj();
      }
      cHi();
    }
  }
  
  private boolean amX(String paramString)
  {
    AppMethodBeat.i(108910);
    com.tencent.mm.ui.base.h.c(getContext(), paramString, "", "", getString(2131761757), null, null);
    AppMethodBeat.o(108910);
    return true;
  }
  
  private void amY(String paramString)
  {
    AppMethodBeat.i(108916);
    getString(2131755998);
    this.jZH = com.tencent.mm.ui.base.h.a(this, paramString, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    AppMethodBeat.o(108916);
  }
  
  private void cGW()
  {
    AppMethodBeat.i(108917);
    if ((this.jZH != null) && (this.jZH.isShowing())) {
      this.jZH.dismiss();
    }
    AppMethodBeat.o(108917);
  }
  
  private void cHh()
  {
    AppMethodBeat.i(108907);
    if (this.rfQ != null) {
      this.rfQ.clear();
    }
    Log.i("MicroMsg.emoji.EmojiCustomUI", "clear md5 list. updateMode NORMAL");
    AppMethodBeat.o(108907);
  }
  
  private void cHi()
  {
    AppMethodBeat.i(108908);
    View localView = this.rfF;
    if (this.rfC == c.rgm) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(108908);
      return;
    }
  }
  
  private void cHj()
  {
    AppMethodBeat.i(108909);
    int i;
    if (this.rfC == c.rgm)
    {
      if (this.rfQ != null) {
        break label94;
      }
      i = 0;
      if (i <= 0) {
        break label105;
      }
      this.rfG.setText(getResources().getString(2131755778));
      this.rfG.setEnabled(true);
      this.rfH.setEnabled(true);
    }
    for (;;)
    {
      setMMTitle(getResources().getString(2131758588, new Object[] { Integer.valueOf(i) }));
      AppMethodBeat.o(108909);
      return;
      label94:
      i = this.rfQ.size();
      break;
      label105:
      this.rfG.setText(getResources().getString(2131755778));
      this.rfG.setEnabled(false);
      this.rfH.setEnabled(false);
    }
  }
  
  private void cHk()
  {
    AppMethodBeat.i(108911);
    if (this.mHandler != null) {
      this.mHandler.sendEmptyMessageDelayed(1003, 0L);
    }
    AppMethodBeat.o(108911);
  }
  
  private void cHl()
  {
    AppMethodBeat.i(108912);
    if (!NetStatusUtil.isConnected(this))
    {
      cHk();
      AppMethodBeat.o(108912);
      return;
    }
    if (cHm())
    {
      AppMethodBeat.o(108912);
      return;
    }
    this.rfN = false;
    AppMethodBeat.o(108912);
  }
  
  private boolean cHm()
  {
    AppMethodBeat.i(108913);
    if ((this.rfD != null) && (this.rfD.getRealCount() > com.tencent.mm.emoji.b.n.auY()))
    {
      this.rfM = true;
      this.rfJ.setVisibility(0);
      cHn();
      this.rfL.setVisibility(8);
      this.rfD.notifyDataSetChanged();
      enableOptionMenu(0, true);
      this.rfN = true;
      AppMethodBeat.o(108913);
      return true;
    }
    AppMethodBeat.o(108913);
    return false;
  }
  
  private void cHn()
  {
    AppMethodBeat.i(108914);
    this.rfK.setTextColor(getResources().getColor(2131100994));
    this.rfK.setText(getString(2131758687, new Object[] { Integer.valueOf(com.tencent.mm.emoji.b.n.auY()) }));
    AppMethodBeat.o(108914);
  }
  
  private void ls(boolean paramBoolean)
  {
    AppMethodBeat.i(108897);
    int j = this.rfS.hcT.size();
    int k = this.rfS.cnR;
    if ((j == k) && (!paramBoolean))
    {
      this.rfK.setText(2131758694);
      AppMethodBeat.o(108897);
      return;
    }
    if (k == 0)
    {
      i = j;
      k += i;
      if (!paramBoolean) {
        break label125;
      }
    }
    label125:
    for (int i = 2131758696;; i = 2131758689)
    {
      this.rfK.setText(String.format(getString(i), new Object[] { Integer.valueOf(k - j), Integer.valueOf(k) }));
      AppMethodBeat.o(108897);
      return;
      i = 0;
      break;
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131493915;
  }
  
  public void initView()
  {
    AppMethodBeat.i(108902);
    this.rfJ = getLayoutInflater().inflate(2131493917, null);
    this.rfK = ((TextView)this.rfJ.findViewById(2131308815));
    this.rfL = ((Button)this.rfJ.findViewById(2131308814));
    this.rfL.setOnClickListener(this.rfT);
    this.rfE = ((HeaderGridView)findViewById(2131307696));
    Object localObject = this.rfE;
    View localView = this.rfJ;
    ListAdapter localListAdapter = ((HeaderGridView)localObject).getAdapter();
    if ((localListAdapter != null) && (!(localListAdapter instanceof HeaderGridView.c)))
    {
      localObject = new IllegalStateException("Cannot add header view to grid -- setAdapter has already been called.");
      AppMethodBeat.o(108902);
      throw ((Throwable)localObject);
    }
    HeaderGridView.a locala = new HeaderGridView.a((byte)0);
    HeaderGridView.b localb = new HeaderGridView.b((HeaderGridView)localObject, ((HeaderGridView)localObject).getContext());
    localb.addView(localView);
    locala.view = localView;
    locala.OOn = localb;
    locala.data = null;
    locala.isSelectable = false;
    ((HeaderGridView)localObject).OOm.add(locala);
    if (localListAdapter != null) {
      ((HeaderGridView.c)localListAdapter).mDataSetObservable.notifyChanged();
    }
    this.rfE.setAdapter$159aa965(this.rfD);
    this.rfE.setOnItemClickListener(this);
    this.rfE.setFocusableInTouchMode(false);
    this.rfF = findViewById(2131307695);
    this.rfG = ((Button)findViewById(2131307697));
    this.rfG.setOnClickListener(this.rfU);
    this.rfH = ((Button)findViewById(2131307698));
    this.rfH.setOnClickListener(this.rfV);
    AppMethodBeat.o(108902);
  }
  
  public void onActivityResult(final int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(108904);
    Log.d("MicroMsg.emoji.EmojiCustomUI", "onActivityResult: requestCode[%d],resultCode:[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 == -1)
    {
      Object localObject;
      com.tencent.mm.emoji.e.a locala;
      switch (paramInt1)
      {
      default: 
        Log.e("MicroMsg.emoji.EmojiCustomUI", "onActivityResult: not found this requestCode");
        AppMethodBeat.o(108904);
        return;
      case 214: 
        if (this.rfD != null)
        {
          this.rfD.cHq();
          this.rfD.notifyDataSetChanged();
          AppMethodBeat.o(108904);
          return;
        }
        break;
      case 205: 
        if (paramIntent == null)
        {
          AppMethodBeat.o(108904);
          return;
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("CropImageMode", 3);
        locala = com.tencent.mm.emoji.e.a.hdT;
        ((Intent)localObject).putExtra("CropImage_OutputPath", com.tencent.mm.emoji.e.a.awt());
        com.tencent.mm.plugin.emoji.c.jRt.a((Intent)localObject, 206, this, paramIntent);
        AppMethodBeat.o(108904);
        return;
      case 206: 
        if (paramIntent == null)
        {
          Log.e("MicroMsg.emoji.EmojiCustomUI", "onActivityResult MAT_IMAGE_IN_CROP_ACTIVITY return null.");
          AppMethodBeat.o(108904);
          return;
        }
        localObject = paramIntent.getStringExtra("CropImage_OutputPath");
        paramInt1 = paramIntent.getIntExtra("emoji_type", 0);
        if ((localObject == null) || (((String)localObject).length() <= 0))
        {
          AppMethodBeat.o(108904);
          return;
        }
        paramIntent = ((String)localObject).substring(((String)localObject).lastIndexOf('/') + 1);
        localObject = new StringBuilder();
        locala = com.tencent.mm.emoji.e.a.hdT;
        localObject = com.tencent.mm.emoji.e.a.awt() + paramIntent;
        this.rfZ = com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.blk(paramIntent);
        localObject = com.tencent.mm.ui.tools.b.b.bnW((String)localObject);
        ((com.tencent.mm.ui.tools.b.b)localObject).mSize = com.tencent.mm.n.c.aqn();
        ((com.tencent.mm.ui.tools.b.b)localObject).aop(com.tencent.mm.n.c.aqo()).a(new b.a()
        {
          public final void a(com.tencent.mm.ui.tools.b.b paramAnonymousb)
          {
            AppMethodBeat.i(108860);
            if (EmojiCustomUI.j(EmojiCustomUI.this) == null)
            {
              if (paramInt1 != 0) {
                break label119;
              }
              EmojiCustomUI.a(EmojiCustomUI.this, com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.d(paramIntent, "", EmojiGroupInfo.Uup, EmojiInfo.Uuw, paramAnonymousb.QxG, ""));
            }
            for (;;)
            {
              com.tencent.mm.plugin.emoji.model.k.cGf().a(EmojiCustomUI.this.getContext(), EmojiCustomUI.j(EmojiCustomUI.this), 1, z.aTY());
              if (EmojiCustomUI.f(EmojiCustomUI.this) != null)
              {
                EmojiCustomUI.f(EmojiCustomUI.this).cHq();
                EmojiCustomUI.f(EmojiCustomUI.this).notifyDataSetChanged();
              }
              AppMethodBeat.o(108860);
              return;
              label119:
              EmojiCustomUI.a(EmojiCustomUI.this, com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.d(paramIntent, "", EmojiGroupInfo.Uup, EmojiInfo.Uux, paramAnonymousb.QxG, ""));
            }
          }
          
          public final void cHf()
          {
            AppMethodBeat.i(108861);
            com.tencent.mm.ui.base.h.a(EmojiCustomUI.this.getContext(), EmojiCustomUI.this.getContext().getString(2131758533), "", EmojiCustomUI.this.getContext().getString(2131761757), false, null);
            AppMethodBeat.o(108861);
          }
        });
        AppMethodBeat.o(108904);
        return;
      }
    }
    AppMethodBeat.o(108904);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(108905);
    if (this.rfC == c.rgm)
    {
      a(c.rgl);
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
    this.rfR = getIntent().getIntExtra("key_emoji_panel_type", this.rfR);
    if (this.rfR == 1)
    {
      paramBundle = EmojiSyncManager.hda;
      this.rfS = EmojiSyncManager.a.awo();
      this.rfD = new b(this.rfR);
      this.rfD.cHq();
      initView();
      a(c.rgl);
      if (this.rfR != 1) {
        break label367;
      }
    }
    label367:
    for (boolean bool = ((Boolean)g.aAh().azQ().get(ar.a.NSQ, Boolean.TRUE)).booleanValue();; bool = ((Boolean)g.aAh().azQ().get(ar.a.NSP, Boolean.TRUE)).booleanValue())
    {
      Log.i("MicroMsg.emoji.EmojiCustomUI", "[cpan] touch batch emoji download from EmojiCustomUI needDownload:%b", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        paramBundle = new com.tencent.mm.plugin.emoji.f.e(this.rfR);
        g.aAg().hqi.a(paramBundle, 0);
      }
      com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.add(this.rfW);
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(406L, 9L, 1L, false);
      com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(406L, 11L, System.currentTimeMillis() - l, false);
      com.tencent.mm.plugin.report.service.h.CyF.a(12740, new Object[] { Integer.valueOf(4), "", "", "", Integer.valueOf(28), Integer.valueOf(28) });
      paramBundle = this.rfS;
      com.tencent.mm.emoji.sync.f localf = this.rfX;
      p.h(localf, "callback");
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new EmojiSyncManager.e(paramBundle, localf));
      this.rfS.eg(true);
      paramBundle = com.tencent.mm.emoji.b.k.gXr;
      com.tencent.mm.emoji.b.k.auS();
      this.rfI = this.rfS.hcS;
      if (this.mHandler != null) {
        this.mHandler.sendEmptyMessage(1001);
      }
      AppMethodBeat.o(108898);
      return;
      paramBundle = EmojiSyncManager.hda;
      this.rfS = EmojiSyncManager.a.awn();
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(108901);
    super.onDestroy();
    com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.remove(this.rfW);
    com.tencent.mm.plugin.emoji.model.k.cGg().rds.mIsForeground = false;
    Object localObject = com.tencent.mm.plugin.emoji.model.k.cGg().rds;
    if (((BKGLoaderManager)localObject).rdD) {
      ((BKGLoaderManager)localObject).rdD = false;
    }
    localObject = this.rfS;
    com.tencent.mm.emoji.sync.f localf = this.rfX;
    p.h(localf, "callback");
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new EmojiSyncManager.h((EmojiSyncManager)localObject, localf));
    this.mHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(108901);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(108903);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAdapterView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).zo(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/EmojiCustomUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    if (this.rfD != null)
    {
      paramInt -= this.rfE.getHeaderViewCount() * 5;
      if ((this.rfC == c.rgl) && (paramInt == 0))
      {
        if (1 == this.rfR)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiCustomUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(108903);
          return;
        }
        if (!g.aAh().isSDCardAvailable())
        {
          u.g(this, null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiCustomUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(108903);
          return;
        }
        if (this.rfD.getRealCount() < com.tencent.mm.emoji.b.n.auY()) {
          break label328;
        }
        com.tencent.mm.ui.base.h.d(this, getString(2131758707), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        com.tencent.mm.plugin.report.service.h.CyF.a(11596, new Object[] { Integer.valueOf(0) });
      }
      if ((this.rfC == c.rgm) && (paramInt < this.rfD.getRealCount()))
      {
        localObject = this.rfD.FY(paramInt);
        paramAdapterView = null;
        if (paramView != null) {
          paramAdapterView = (d)paramView.getTag();
        }
        if (((EmojiInfo)localObject).field_catalog != EmojiGroupInfo.Uun) {
          break label336;
        }
        com.tencent.mm.ui.base.h.n(getContext(), 2131757350, 2131757350).show();
      }
    }
    for (;;)
    {
      cHj();
      if (paramAdapterView == null) {
        this.rfD.notifyDataSetChanged();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiCustomUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(108903);
      return;
      label328:
      com.tencent.mm.pluginsdk.ui.tools.s.aZ(this);
      break;
      label336:
      if (!this.rfQ.contains(((EmojiInfo)localObject).getMd5()))
      {
        paramView = ((EmojiInfo)localObject).getMd5();
        if (this.rfQ != null) {
          this.rfQ.add(paramView);
        }
        if (paramAdapterView != null) {
          paramAdapterView.rgq.setChecked(true);
        }
        Log.i("MicroMsg.emoji.EmojiCustomUI", "selected md5:%s", new Object[] { ((EmojiInfo)localObject).getMd5() });
      }
      else
      {
        paramView = ((EmojiInfo)localObject).getMd5();
        if (this.rfQ != null) {
          this.rfQ.remove(paramView);
        }
        if (paramAdapterView != null)
        {
          paramAdapterView.rgq.setChecked(false);
          this.rfD.notifyDataSetChanged();
        }
        Log.i("MicroMsg.emoji.EmojiCustomUI", "unselected md5:%s", new Object[] { ((EmojiInfo)localObject).getMd5() });
      }
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(108900);
    super.onPause();
    g.aAg().hqi.b(698, this);
    AppMethodBeat.o(108900);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(108899);
    super.onResume();
    cHl();
    g.aAg().hqi.a(698, this);
    AppMethodBeat.o(108899);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(108915);
    Log.i("MicroMsg.emoji.EmojiCustomUI", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramq instanceof com.tencent.mm.plugin.emoji.f.c))
    {
      switch (((com.tencent.mm.plugin.emoji.f.c)paramq).kfa)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(108915);
        return;
        cGW();
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = new ArrayList(this.rfQ);
          g.aAk().postToWorker(new EmojiCustomUI.9(this, paramString));
          if (this.rfR == 0)
          {
            j.auL().dW(true);
            j.auL().dV(true);
            paramString = com.tencent.mm.emoji.b.k.gXr;
            com.tencent.mm.emoji.b.k.dZ(false);
          }
          for (;;)
          {
            com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.I(this.rfQ, this.rfR);
            cHh();
            cHj();
            this.mHandler.sendEmptyMessageDelayed(1004, 100L);
            AppMethodBeat.o(108915);
            return;
            j.auL().dY(true);
            paramString = com.tencent.mm.emoji.b.k.gXr;
            com.tencent.mm.emoji.b.k.ea(false);
          }
        }
        Log.i("MicroMsg.emoji.EmojiCustomUI", "delete failed");
        amX(getString(2131758703));
        AppMethodBeat.o(108915);
        return;
        cGW();
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (this.rfR == 0)
          {
            j.auL().dW(true);
            j.auL().dV(true);
          }
          for (;;)
          {
            com.tencent.mm.plugin.emoji.model.k.getEmojiStorageMgr().OpN.x(this.rfR, this.rfQ);
            cHh();
            cHj();
            this.mHandler.sendEmptyMessageDelayed(1004, 100L);
            AppMethodBeat.o(108915);
            return;
            j.auL().dY(true);
          }
        }
        amX(getString(2131758703));
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
      rgg = new a("START", 0);
      rgh = new a("PAUSE", 1);
      rgi = new a("EMPTY", 2);
      rgj = new a[] { rgg, rgh, rgi };
      AppMethodBeat.o(108881);
    }
    
    private a() {}
  }
  
  final class b
    extends BaseAdapter
  {
    private int hcW;
    private ArrayList<EmojiInfo> rcx;
    private Animation rgk;
    
    public b(int paramInt)
    {
      AppMethodBeat.i(108882);
      this.hcW = paramInt;
      this.rgk = AnimationUtils.loadAnimation(EmojiCustomUI.this, 2130772145);
      this$1 = new LinearInterpolator();
      this.rgk.setInterpolator(EmojiCustomUI.this);
      AppMethodBeat.o(108882);
    }
    
    private static void a(ImageView paramImageView, EmojiInfo paramEmojiInfo)
    {
      AppMethodBeat.i(108889);
      com.tencent.mm.emoji.loader.e locale = com.tencent.mm.emoji.loader.e.gVM;
      com.tencent.mm.emoji.loader.e.a(paramEmojiInfo, paramImageView);
      AppMethodBeat.o(108889);
    }
    
    private int cHp()
    {
      AppMethodBeat.i(108884);
      if ((getRealCount() > 0) && ((getRealCount() + 1) % 5 == 0))
      {
        AppMethodBeat.o(108884);
        return 1;
      }
      AppMethodBeat.o(108884);
      return 2;
    }
    
    public final EmojiInfo FY(int paramInt)
    {
      AppMethodBeat.i(108886);
      if (paramInt >= getRealCount())
      {
        AppMethodBeat.o(108886);
        return null;
      }
      if (this.rcx == null)
      {
        AppMethodBeat.o(108886);
        return null;
      }
      EmojiInfo localEmojiInfo = (EmojiInfo)this.rcx.get(paramInt);
      AppMethodBeat.o(108886);
      return localEmojiInfo;
    }
    
    public final boolean cHq()
    {
      AppMethodBeat.i(108888);
      int i;
      if (g.aAh().isSDCardAvailable()) {
        if (this.hcW == 0)
        {
          this.rcx = j.auL().auO();
          if (EmojiCustomUI.m(EmojiCustomUI.this) != EmojiCustomUI.c.rgm) {
            break label132;
          }
          if (EmojiCustomUI.n(EmojiCustomUI.this) != null) {
            break label118;
          }
          i = 0;
          label56:
          EmojiCustomUI.this.setMMTitle(EmojiCustomUI.this.getString(2131758588, new Object[] { Integer.valueOf(i) }));
        }
      }
      for (;;)
      {
        AppMethodBeat.o(108888);
        return true;
        this.rcx = j.auL().dU(false);
        break;
        this.rcx = new ArrayList();
        break;
        label118:
        i = EmojiCustomUI.n(EmojiCustomUI.this).size();
        break label56;
        label132:
        if (this.hcW == 0) {
          EmojiCustomUI.this.setMMTitle(EmojiCustomUI.this.getString(2131758535, new Object[] { Integer.valueOf(this.rcx.size()) }));
        } else {
          EmojiCustomUI.this.setMMTitle(EmojiCustomUI.this.getString(2131758513, new Object[] { Integer.valueOf(this.rcx.size()) }));
        }
      }
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(108883);
      int i = getRealCount();
      int j = cHp();
      AppMethodBeat.o(108883);
      return i + j;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getRealCount()
    {
      AppMethodBeat.i(108885);
      if (this.rcx == null)
      {
        AppMethodBeat.o(108885);
        return 0;
      }
      int i = this.rcx.size();
      AppMethodBeat.o(108885);
      return i;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(108887);
      label52:
      int i;
      if ((paramView == null) || (paramView.getTag() == null))
      {
        paramView = LayoutInflater.from(EmojiCustomUI.this.getContext()).inflate(2131493916, null);
        paramView.setVisibility(0);
        paramViewGroup = new EmojiCustomUI.d(paramView);
        paramView.setTag(paramViewGroup);
        if ((EmojiCustomUI.m(EmojiCustomUI.this) != EmojiCustomUI.c.rgo) && (EmojiCustomUI.m(EmojiCustomUI.this) != EmojiCustomUI.c.rgm)) {
          break label195;
        }
        i = cHp();
        label84:
        if (paramInt >= getCount() - i) {
          break label235;
        }
        if (paramInt % 5 != 0) {
          break label223;
        }
        paramViewGroup.lJI.setBackgroundResource(2131232119);
      }
      for (;;)
      {
        paramViewGroup.image.clearAnimation();
        paramViewGroup.image.setScaleType(ImageView.ScaleType.FIT_CENTER);
        switch (EmojiCustomUI.11.rgf[EmojiCustomUI.m(EmojiCustomUI.this).ordinal()])
        {
        default: 
          AppMethodBeat.o(108887);
          return paramView;
          paramView.setVisibility(0);
          paramViewGroup = (EmojiCustomUI.d)paramView.getTag();
          break label52;
          label195:
          if (1 == this.hcW)
          {
            i = cHp();
            break label84;
          }
          i = cHp() - 1;
          break label84;
          label223:
          paramViewGroup.lJI.setBackgroundResource(2131232124);
          continue;
          label235:
          if (paramInt == getCount() - i) {
            paramViewGroup.lJI.setBackgroundResource(2131232123);
          } else {
            paramViewGroup.lJI.setBackgroundColor(0);
          }
          break;
        }
      }
      Object localObject;
      if (paramInt == getCount() - cHp() + 1)
      {
        localObject = com.tencent.mm.emoji.loader.e.gVM;
        com.tencent.mm.emoji.loader.e.cl(paramViewGroup.image);
        paramViewGroup.image.setImageBitmap(null);
      }
      for (;;)
      {
        paramViewGroup.rgq.setVisibility(8);
        break;
        if (paramInt == 0)
        {
          if (this.hcW == 0)
          {
            localObject = com.tencent.mm.emoji.loader.e.gVM;
            com.tencent.mm.emoji.loader.e.cl(paramViewGroup.image);
            paramViewGroup.image.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            paramViewGroup.image.setImageResource(2131690129);
          }
          else if (paramInt != getRealCount())
          {
            localObject = (EmojiInfo)this.rcx.get(paramInt);
            a(paramViewGroup.image, (EmojiInfo)localObject);
          }
        }
        else if (this.hcW == 0)
        {
          localObject = (EmojiInfo)this.rcx.get(paramInt - 1);
          a(paramViewGroup.image, (EmojiInfo)localObject);
        }
        else if (paramInt != getRealCount())
        {
          localObject = (EmojiInfo)this.rcx.get(paramInt);
          a(paramViewGroup.image, (EmojiInfo)localObject);
        }
        else
        {
          localObject = com.tencent.mm.emoji.loader.e.gVM;
          com.tencent.mm.emoji.loader.e.cl(paramViewGroup.image);
          paramViewGroup.image.setImageBitmap(null);
        }
      }
      if (paramInt == getCount() - cHp() + 1)
      {
        localObject = com.tencent.mm.emoji.loader.e.gVM;
        com.tencent.mm.emoji.loader.e.cl(paramViewGroup.image);
        paramViewGroup.image.setImageBitmap(null);
      }
      for (;;)
      {
        paramViewGroup.rgq.setVisibility(8);
        break;
        if (paramInt == getRealCount())
        {
          localObject = com.tencent.mm.emoji.loader.e.gVM;
          com.tencent.mm.emoji.loader.e.cl(paramViewGroup.image);
          paramViewGroup.image.setImageResource(2131234493);
          paramViewGroup.image.startAnimation(this.rgk);
        }
        else
        {
          localObject = (EmojiInfo)this.rcx.get(paramInt);
          a(paramViewGroup.image, (EmojiInfo)localObject);
        }
      }
      if (paramInt == getCount() - cHp() + 1)
      {
        localObject = com.tencent.mm.emoji.loader.e.gVM;
        com.tencent.mm.emoji.loader.e.cl(paramViewGroup.image);
        paramViewGroup.image.setImageBitmap(null);
      }
      for (;;)
      {
        paramViewGroup.rgq.setVisibility(8);
        break;
        if (paramInt == getRealCount())
        {
          localObject = com.tencent.mm.emoji.loader.e.gVM;
          com.tencent.mm.emoji.loader.e.cl(paramViewGroup.image);
          paramViewGroup.image.setImageBitmap(null);
        }
        else
        {
          localObject = (EmojiInfo)this.rcx.get(paramInt);
          a(paramViewGroup.image, (EmojiInfo)localObject);
          if (((EmojiInfo)localObject).field_catalog != EmojiGroupInfo.Uun)
          {
            paramViewGroup.rgq.setVisibility(0);
            paramViewGroup.rgq.setChecked(EmojiCustomUI.n(EmojiCustomUI.this).contains(((EmojiInfo)localObject).getMd5()));
            break;
            if (paramInt == getCount() - cHp() + 1)
            {
              localObject = com.tencent.mm.emoji.loader.e.gVM;
              com.tencent.mm.emoji.loader.e.cl(paramViewGroup.image);
              paramViewGroup.image.setImageBitmap(null);
            }
            else if (paramInt == getRealCount())
            {
              localObject = com.tencent.mm.emoji.loader.e.gVM;
              com.tencent.mm.emoji.loader.e.cl(paramViewGroup.image);
              paramViewGroup.image.setImageBitmap(null);
            }
            else
            {
              localObject = (EmojiInfo)this.rcx.get(paramInt);
              a(paramViewGroup.image, (EmojiInfo)localObject);
            }
          }
        }
      }
    }
  }
  
  static enum c
  {
    static
    {
      AppMethodBeat.i(108893);
      rgl = new c("NORMAL", 0);
      rgm = new c("EDIT", 1);
      rgn = new c("SYNCING", 2);
      rgo = new c("WITH_OUT_ADD", 3);
      rgp = new c[] { rgl, rgm, rgn, rgo };
      AppMethodBeat.o(108893);
    }
    
    private c() {}
  }
  
  static final class d
  {
    ImageView image;
    View lJI;
    CheckBox rgq;
    
    public d(View paramView)
    {
      AppMethodBeat.i(108894);
      this.lJI = paramView.findViewById(2131302791);
      this.image = ((ImageView)paramView.findViewById(2131302526));
      this.rgq = ((CheckBox)paramView.findViewById(2131298648));
      AppMethodBeat.o(108894);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiCustomUI
 * JD-Core Version:    0.7.0.1
 */