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
import com.tencent.mm.emoji.a.j;
import com.tencent.mm.emoji.sync.EmojiSyncManager;
import com.tencent.mm.emoji.sync.EmojiSyncManager.a;
import com.tencent.mm.emoji.sync.EmojiSyncManager.b;
import com.tencent.mm.emoji.sync.EmojiSyncManager.e;
import com.tencent.mm.emoji.sync.EmojiSyncManager.h;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.emoji.model.k;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.HeaderGridView;
import com.tencent.mm.ui.base.HeaderGridView.a;
import com.tencent.mm.ui.base.HeaderGridView.b;
import com.tencent.mm.ui.base.HeaderGridView.c;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.tools.b.b.a;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import java.util.ArrayList;
import java.util.List;

public class EmojiCustomUI
  extends MMActivity
  implements AdapterView.OnItemClickListener, com.tencent.mm.ak.f
{
  private static com.tencent.mm.av.a.c.n igY;
  private static com.tencent.mm.av.a.c.e pPA;
  private ProgressDialog jbE;
  private aq mHandler;
  private EmojiInfo pPB;
  private c pPe;
  private b pPf;
  private HeaderGridView pPg;
  private View pPh;
  private Button pPi;
  private Button pPj;
  private EmojiSyncManager.b pPk;
  private View pPl;
  private TextView pPm;
  private Button pPn;
  private boolean pPo;
  private boolean pPp;
  private boolean pPq;
  private a pPr;
  private ArrayList<String> pPs;
  private int pPt;
  private EmojiSyncManager pPu;
  private View.OnClickListener pPv;
  private View.OnClickListener pPw;
  private View.OnClickListener pPx;
  private final k.a pPy;
  private final com.tencent.mm.emoji.sync.f pPz;
  
  static
  {
    AppMethodBeat.i(108926);
    pPA = new com.tencent.mm.av.a.c.e()
    {
      public final byte[] i(Object... paramAnonymousVarArgs)
      {
        AppMethodBeat.i(108875);
        if ((paramAnonymousVarArgs != null) && (paramAnonymousVarArgs.length > 0))
        {
          paramAnonymousVarArgs = paramAnonymousVarArgs[0];
          if ((paramAnonymousVarArgs != null) && ((paramAnonymousVarArgs instanceof EmojiInfo)))
          {
            paramAnonymousVarArgs = com.tencent.mm.emoji.decode.a.aeE().a((EmojiInfo)paramAnonymousVarArgs);
            AppMethodBeat.o(108875);
            return paramAnonymousVarArgs;
          }
        }
        AppMethodBeat.o(108875);
        return null;
      }
    };
    igY = new com.tencent.mm.av.a.c.n()
    {
      public final Bitmap Gp(String paramAnonymousString)
      {
        AppMethodBeat.i(108877);
        paramAnonymousString = com.tencent.mm.plugin.gif.i.bo(o.bb(paramAnonymousString, 0, -1));
        AppMethodBeat.o(108877);
        return paramAnonymousString;
      }
      
      public final Bitmap ab(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(108876);
        paramAnonymousArrayOfByte = com.tencent.mm.plugin.gif.i.bo(paramAnonymousArrayOfByte);
        AppMethodBeat.o(108876);
        return paramAnonymousArrayOfByte;
      }
    };
    AppMethodBeat.o(108926);
  }
  
  public EmojiCustomUI()
  {
    AppMethodBeat.i(108895);
    this.pPe = c.pPN;
    this.pPk = EmojiSyncManager.b.grR;
    this.pPo = false;
    this.pPp = false;
    this.pPq = false;
    this.pPr = a.pPK;
    this.pPs = new ArrayList();
    this.pPt = 0;
    this.pPv = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(108859);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/EmojiCustomUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        switch (EmojiCustomUI.11.pPF[EmojiCustomUI.a(EmojiCustomUI.this).ordinal()])
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
    this.pPw = new EmojiCustomUI.12(this);
    this.pPx = new EmojiCustomUI.13(this);
    this.pPy = new k.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
      {
        AppMethodBeat.i(108872);
        if ((!bu.isNullOrNil(paramAnonymousString)) && ((paramAnonymousString.length() == 32) || (paramAnonymousString.equals("event_update_emoji"))) && (EmojiCustomUI.f(EmojiCustomUI.this) != null))
        {
          EmojiCustomUI.f(EmojiCustomUI.this).cjs();
          EmojiCustomUI.f(EmojiCustomUI.this).notifyDataSetChanged();
        }
        AppMethodBeat.o(108872);
      }
    };
    this.pPz = new com.tencent.mm.emoji.sync.f()
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
      
      public final void agz()
      {
        AppMethodBeat.i(108873);
        if (EmojiCustomUI.g(EmojiCustomUI.this) != null) {
          EmojiCustomUI.g(EmojiCustomUI.this).sendEmptyMessage(1002);
        }
        AppMethodBeat.o(108873);
      }
    };
    this.mHandler = new aq()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(108878);
        switch (paramAnonymousMessage.what)
        {
        default: 
          ae.e("MicroMsg.emoji.EmojiCustomUI", "unknow Msg");
        case 1001: 
        case 1002: 
          do
          {
            AppMethodBeat.o(108878);
            return;
            EmojiCustomUI.h(EmojiCustomUI.this);
            AppMethodBeat.o(108878);
            return;
          } while (az.isWifi(EmojiCustomUI.this));
          if (EmojiCustomUI.c(EmojiCustomUI.this).grH == EmojiSyncManager.b.grS)
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
          EmojiCustomUI.f(EmojiCustomUI.this).cjs();
          EmojiCustomUI.f(EmojiCustomUI.this).notifyDataSetChanged();
        }
        EmojiCustomUI.cjq();
        AppMethodBeat.o(108878);
      }
    };
    AppMethodBeat.o(108895);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(108896);
    ae.i("MicroMsg.emoji.EmojiCustomUI", "dz[updateButtonType,button type:%s]", new Object[] { parama.toString() });
    this.pPr = parama;
    switch (11.pPF[parama.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(108896);
      return;
      this.pPn.setVisibility(4);
      AppMethodBeat.o(108896);
      return;
      this.pPn.setVisibility(0);
      this.pPn.setText(2131758397);
      AppMethodBeat.o(108896);
      return;
      this.pPn.setVisibility(0);
      this.pPn.setText(2131758398);
    }
  }
  
  private void a(c paramc)
  {
    AppMethodBeat.i(108906);
    long l = System.currentTimeMillis();
    this.pPe = paramc;
    switch (11.pPH[paramc.ordinal()])
    {
    }
    for (;;)
    {
      if (this.pPf != null)
      {
        this.pPf.cjs();
        this.pPf.notifyDataSetChanged();
      }
      ae.d("MicroMsg.emoji.EmojiCustomUI", "updateMode use time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
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
      addTextOptionMenu(0, getString(2131758315), new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(108863);
          EmojiCustomUI.a(EmojiCustomUI.this, EmojiCustomUI.c.pPO);
          com.tencent.mm.plugin.report.service.g.yxI.f(11596, new Object[] { Integer.valueOf(1) });
          AppMethodBeat.o(108863);
          return true;
        }
      });
      this.pPh.setVisibility(8);
      cjn();
      cjj();
      for (;;)
      {
        cjk();
        break;
        setBackBtn(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(108864);
            EmojiCustomUI.a(EmojiCustomUI.this, EmojiCustomUI.c.pPN);
            AppMethodBeat.o(108864);
            return true;
          }
        });
        addTextOptionMenu(0, getString(2131755779), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(108865);
            EmojiCustomUI.a(EmojiCustomUI.this, EmojiCustomUI.c.pPN);
            AppMethodBeat.o(108865);
            return true;
          }
        });
        this.pPh.setVisibility(0);
        cjm();
        cjl();
      }
      cjk();
    }
  }
  
  private boolean acQ(String paramString)
  {
    AppMethodBeat.i(108910);
    h.e(getContext(), paramString, "", "", getString(2131760315), null, null);
    AppMethodBeat.o(108910);
    return true;
  }
  
  private void acR(String paramString)
  {
    AppMethodBeat.i(108916);
    getString(2131755906);
    this.jbE = h.b(this, paramString, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
    AppMethodBeat.o(108916);
  }
  
  private void ciY()
  {
    AppMethodBeat.i(108917);
    if ((this.jbE != null) && (this.jbE.isShowing())) {
      this.jbE.dismiss();
    }
    AppMethodBeat.o(108917);
  }
  
  private void cjj()
  {
    AppMethodBeat.i(108907);
    if (this.pPs != null) {
      this.pPs.clear();
    }
    ae.i("MicroMsg.emoji.EmojiCustomUI", "clear md5 list. updateMode NORMAL");
    AppMethodBeat.o(108907);
  }
  
  private void cjk()
  {
    AppMethodBeat.i(108908);
    View localView = this.pPh;
    if (this.pPe == c.pPO) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(108908);
      return;
    }
  }
  
  private void cjl()
  {
    AppMethodBeat.i(108909);
    int i;
    if (this.pPe == c.pPO)
    {
      if (this.pPs != null) {
        break label94;
      }
      i = 0;
      if (i <= 0) {
        break label105;
      }
      this.pPi.setText(getResources().getString(2131755707));
      this.pPi.setEnabled(true);
      this.pPj.setEnabled(true);
    }
    for (;;)
    {
      setMMTitle(getResources().getString(2131758296, new Object[] { Integer.valueOf(i) }));
      AppMethodBeat.o(108909);
      return;
      label94:
      i = this.pPs.size();
      break;
      label105:
      this.pPi.setText(getResources().getString(2131755707));
      this.pPi.setEnabled(false);
      this.pPj.setEnabled(false);
    }
  }
  
  private void cjm()
  {
    AppMethodBeat.i(108911);
    if (this.mHandler != null) {
      this.mHandler.sendEmptyMessageDelayed(1003, 0L);
    }
    AppMethodBeat.o(108911);
  }
  
  private void cjn()
  {
    AppMethodBeat.i(108912);
    if (!az.isConnected(this))
    {
      cjm();
      AppMethodBeat.o(108912);
      return;
    }
    if (cjo())
    {
      AppMethodBeat.o(108912);
      return;
    }
    this.pPp = false;
    AppMethodBeat.o(108912);
  }
  
  private boolean cjo()
  {
    AppMethodBeat.i(108913);
    if ((this.pPf != null) && (this.pPf.getRealCount() > com.tencent.mm.emoji.a.m.afk()))
    {
      this.pPo = true;
      this.pPl.setVisibility(0);
      cjp();
      this.pPn.setVisibility(8);
      this.pPf.notifyDataSetChanged();
      enableOptionMenu(0, true);
      this.pPp = true;
      AppMethodBeat.o(108913);
      return true;
    }
    AppMethodBeat.o(108913);
    return false;
  }
  
  private void cjp()
  {
    AppMethodBeat.i(108914);
    this.pPm.setTextColor(getResources().getColor(2131100798));
    this.pPm.setText(getString(2131758393, new Object[] { Integer.valueOf(com.tencent.mm.emoji.a.m.afk()) }));
    AppMethodBeat.o(108914);
  }
  
  private void kq(boolean paramBoolean)
  {
    AppMethodBeat.i(108897);
    int j = this.pPu.grI.size();
    int k = this.pPu.cdl;
    if ((j == k) && (!paramBoolean))
    {
      this.pPm.setText(2131758400);
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
    for (int i = 2131758402;; i = 2131758395)
    {
      this.pPm.setText(String.format(getString(i), new Object[] { Integer.valueOf(k - j), Integer.valueOf(k) }));
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
    return 2131493766;
  }
  
  public void initView()
  {
    AppMethodBeat.i(108902);
    this.pPl = getLayoutInflater().inflate(2131493768, null);
    this.pPm = ((TextView)this.pPl.findViewById(2131305593));
    this.pPn = ((Button)this.pPl.findViewById(2131305592));
    this.pPn.setOnClickListener(this.pPv);
    this.pPg = ((HeaderGridView)findViewById(2131304643));
    Object localObject = this.pPg;
    View localView = this.pPl;
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
    locala.JDv = localb;
    locala.data = null;
    locala.isSelectable = false;
    ((HeaderGridView)localObject).JDu.add(locala);
    if (localListAdapter != null) {
      ((HeaderGridView.c)localListAdapter).mDataSetObservable.notifyChanged();
    }
    this.pPg.setAdapter$159aa965(this.pPf);
    this.pPg.setOnItemClickListener(this);
    this.pPg.setFocusableInTouchMode(false);
    this.pPh = findViewById(2131304642);
    this.pPi = ((Button)findViewById(2131304644));
    this.pPi.setOnClickListener(this.pPw);
    this.pPj = ((Button)findViewById(2131304645));
    this.pPj.setOnClickListener(this.pPx);
    AppMethodBeat.o(108902);
  }
  
  public void onActivityResult(final int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(108904);
    ae.d("MicroMsg.emoji.EmojiCustomUI", "onActivityResult: requestCode[%d],resultCode:[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 == -1)
    {
      Object localObject;
      com.tencent.mm.emoji.d.a locala;
      switch (paramInt1)
      {
      default: 
        ae.e("MicroMsg.emoji.EmojiCustomUI", "onActivityResult: not found this requestCode");
        AppMethodBeat.o(108904);
        return;
      case 214: 
        if (this.pPf != null)
        {
          this.pPf.cjs();
          this.pPf.notifyDataSetChanged();
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
        locala = com.tencent.mm.emoji.d.a.gsI;
        ((Intent)localObject).putExtra("CropImage_OutputPath", com.tencent.mm.emoji.d.a.agD());
        com.tencent.mm.plugin.emoji.b.iUz.a((Intent)localObject, 206, this, paramIntent);
        AppMethodBeat.o(108904);
        return;
      case 206: 
        if (paramIntent == null)
        {
          ae.e("MicroMsg.emoji.EmojiCustomUI", "onActivityResult MAT_IMAGE_IN_CROP_ACTIVITY return null.");
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
        locala = com.tencent.mm.emoji.d.a.gsI;
        localObject = com.tencent.mm.emoji.d.a.agD() + paramIntent;
        this.pPB = k.getEmojiStorageMgr().JfU.aWl(paramIntent);
        localObject = com.tencent.mm.ui.tools.b.b.aYR((String)localObject);
        ((com.tencent.mm.ui.tools.b.b)localObject).mSize = com.tencent.mm.n.b.aco();
        ((com.tencent.mm.ui.tools.b.b)localObject).afC(com.tencent.mm.n.b.acp()).a(new b.a()
        {
          public final void a(com.tencent.mm.ui.tools.b.b paramAnonymousb)
          {
            AppMethodBeat.i(108860);
            if (EmojiCustomUI.j(EmojiCustomUI.this) == null)
            {
              if (paramInt1 != 0) {
                break label119;
              }
              EmojiCustomUI.a(EmojiCustomUI.this, k.getEmojiStorageMgr().JfU.d(paramIntent, "", EmojiGroupInfo.OzU, EmojiInfo.OAb, paramAnonymousb.LiH, ""));
            }
            for (;;)
            {
              k.cig().a(EmojiCustomUI.this.getContext(), EmojiCustomUI.j(EmojiCustomUI.this), 1, v.aAC());
              if (EmojiCustomUI.f(EmojiCustomUI.this) != null)
              {
                EmojiCustomUI.f(EmojiCustomUI.this).cjs();
                EmojiCustomUI.f(EmojiCustomUI.this).notifyDataSetChanged();
              }
              AppMethodBeat.o(108860);
              return;
              label119:
              EmojiCustomUI.a(EmojiCustomUI.this, k.getEmojiStorageMgr().JfU.d(paramIntent, "", EmojiGroupInfo.OzU, EmojiInfo.OAc, paramAnonymousb.LiH, ""));
            }
          }
          
          public final void cjh()
          {
            AppMethodBeat.i(108861);
            h.a(EmojiCustomUI.this.getContext(), EmojiCustomUI.this.getContext().getString(2131758245), "", EmojiCustomUI.this.getContext().getString(2131760315), false, null);
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
    if (this.pPe == c.pPO)
    {
      a(c.pPN);
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
    this.pPt = getIntent().getIntExtra("key_emoji_panel_type", this.pPt);
    if (this.pPt == 1)
    {
      paramBundle = EmojiSyncManager.grP;
      this.pPu = EmojiSyncManager.a.agy();
      this.pPf = new b(this.pPt);
      this.pPf.cjs();
      initView();
      a(c.pPN);
      if (this.pPt != 1) {
        break label367;
      }
    }
    label367:
    for (boolean bool = ((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IKS, Boolean.TRUE)).booleanValue();; bool = ((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IKR, Boolean.TRUE)).booleanValue())
    {
      ae.i("MicroMsg.emoji.EmojiCustomUI", "[cpan] touch batch emoji download from EmojiCustomUI needDownload:%b", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        paramBundle = new com.tencent.mm.plugin.emoji.f.e(this.pPt);
        com.tencent.mm.kernel.g.ajQ().gDv.a(paramBundle, 0);
      }
      k.getEmojiStorageMgr().JfU.add(this.pPy);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(406L, 9L, 1L, false);
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(406L, 11L, System.currentTimeMillis() - l, false);
      com.tencent.mm.plugin.report.service.g.yxI.f(12740, new Object[] { Integer.valueOf(4), "", "", "", Integer.valueOf(28), Integer.valueOf(28) });
      paramBundle = this.pPu;
      com.tencent.mm.emoji.sync.f localf = this.pPz;
      p.h(localf, "callback");
      com.tencent.mm.ac.c.h((d.g.a.a)new EmojiSyncManager.e(paramBundle, localf));
      this.pPu.dt(true);
      paramBundle = j.gmz;
      j.afe();
      this.pPk = this.pPu.grH;
      if (this.mHandler != null) {
        this.mHandler.sendEmptyMessage(1001);
      }
      AppMethodBeat.o(108898);
      return;
      paramBundle = EmojiSyncManager.grP;
      this.pPu = EmojiSyncManager.a.agx();
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(108901);
    super.onDestroy();
    k.getEmojiStorageMgr().JfU.remove(this.pPy);
    k.cih().pMY.cFc = false;
    Object localObject = k.cih().pMY;
    if (((BKGLoaderManager)localObject).pNj) {
      ((BKGLoaderManager)localObject).pNj = false;
    }
    localObject = this.pPu;
    com.tencent.mm.emoji.sync.f localf = this.pPz;
    p.h(localf, "callback");
    com.tencent.mm.ac.c.h((d.g.a.a)new EmojiSyncManager.h((EmojiSyncManager)localObject, localf));
    this.mHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(108901);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(108903);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAdapterView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramInt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject).rl(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emoji/ui/EmojiCustomUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
    if (this.pPf != null)
    {
      paramInt -= this.pPg.getHeaderViewCount() * 5;
      if ((this.pPe == c.pPN) && (paramInt == 0))
      {
        if (1 == this.pPt)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiCustomUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(108903);
          return;
        }
        if (!com.tencent.mm.kernel.g.ajR().isSDCardAvailable())
        {
          t.g(this, null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiCustomUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(108903);
          return;
        }
        if (this.pPf.getRealCount() < com.tencent.mm.emoji.a.m.afk()) {
          break label328;
        }
        h.d(this, getString(2131758413), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        com.tencent.mm.plugin.report.service.g.yxI.f(11596, new Object[] { Integer.valueOf(0) });
      }
      if ((this.pPe == c.pPO) && (paramInt < this.pPf.getRealCount()))
      {
        localObject = this.pPf.Cn(paramInt);
        paramAdapterView = null;
        if (paramView != null) {
          paramAdapterView = (d)paramView.getTag();
        }
        if (((EmojiInfo)localObject).field_catalog != EmojiGroupInfo.OzS) {
          break label336;
        }
        h.l(getContext(), 2131757146, 2131757146).show();
      }
    }
    for (;;)
    {
      cjl();
      if (paramAdapterView == null) {
        this.pPf.notifyDataSetChanged();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emoji/ui/EmojiCustomUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(108903);
      return;
      label328:
      com.tencent.mm.pluginsdk.ui.tools.q.aT(this);
      break;
      label336:
      if (!this.pPs.contains(((EmojiInfo)localObject).Lj()))
      {
        paramView = ((EmojiInfo)localObject).Lj();
        if (this.pPs != null) {
          this.pPs.add(paramView);
        }
        if (paramAdapterView != null) {
          paramAdapterView.pPS.setChecked(true);
        }
        ae.i("MicroMsg.emoji.EmojiCustomUI", "selected md5:%s", new Object[] { ((EmojiInfo)localObject).Lj() });
      }
      else
      {
        paramView = ((EmojiInfo)localObject).Lj();
        if (this.pPs != null) {
          this.pPs.remove(paramView);
        }
        if (paramAdapterView != null)
        {
          paramAdapterView.pPS.setChecked(false);
          this.pPf.notifyDataSetChanged();
        }
        ae.i("MicroMsg.emoji.EmojiCustomUI", "unselected md5:%s", new Object[] { ((EmojiInfo)localObject).Lj() });
      }
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(108900);
    super.onPause();
    com.tencent.mm.kernel.g.ajQ().gDv.b(698, this);
    AppMethodBeat.o(108900);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(108899);
    super.onResume();
    cjn();
    com.tencent.mm.kernel.g.ajQ().gDv.a(698, this);
    AppMethodBeat.o(108899);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(108915);
    ae.i("MicroMsg.emoji.EmojiCustomUI", "errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramn instanceof com.tencent.mm.plugin.emoji.f.c))
    {
      switch (((com.tencent.mm.plugin.emoji.f.c)paramn).jgW)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(108915);
        return;
        ciY();
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = new ArrayList(this.pPs);
          com.tencent.mm.kernel.g.ajU().aw(new EmojiCustomUI.9(this, paramString));
          if (this.pPt == 0)
          {
            com.tencent.mm.emoji.a.i.aeX().dm(true);
            com.tencent.mm.emoji.a.i.aeX().dl(true);
            paramString = j.gmz;
            j.dp(false);
          }
          for (;;)
          {
            k.getEmojiStorageMgr().JfU.C(this.pPs, this.pPt);
            cjj();
            cjl();
            this.mHandler.sendEmptyMessageDelayed(1004, 100L);
            AppMethodBeat.o(108915);
            return;
            com.tencent.mm.emoji.a.i.aeX().jdMethod_do(true);
            paramString = j.gmz;
            j.dq(false);
          }
        }
        ae.i("MicroMsg.emoji.EmojiCustomUI", "delete failed");
        acQ(getString(2131758409));
        AppMethodBeat.o(108915);
        return;
        ciY();
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if (this.pPt == 0)
          {
            com.tencent.mm.emoji.a.i.aeX().dm(true);
            com.tencent.mm.emoji.a.i.aeX().dl(true);
          }
          for (;;)
          {
            k.getEmojiStorageMgr().JfU.s(this.pPt, this.pPs);
            cjj();
            cjl();
            this.mHandler.sendEmptyMessageDelayed(1004, 100L);
            AppMethodBeat.o(108915);
            return;
            com.tencent.mm.emoji.a.i.aeX().jdMethod_do(true);
          }
        }
        acQ(getString(2131758409));
      }
    }
    ae.w("MicroMsg.emoji.EmojiCustomUI", "no emoji operate");
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
      pPI = new a("START", 0);
      pPJ = new a("PAUSE", 1);
      pPK = new a("EMPTY", 2);
      pPL = new a[] { pPI, pPJ, pPK };
      AppMethodBeat.o(108881);
    }
    
    private a() {}
  }
  
  final class b
    extends BaseAdapter
  {
    private int grL;
    private ArrayList<EmojiInfo> pMe;
    private Animation pPM;
    
    public b(int paramInt)
    {
      AppMethodBeat.i(108882);
      this.grL = paramInt;
      this.pPM = AnimationUtils.loadAnimation(EmojiCustomUI.this, 2130772121);
      this$1 = new LinearInterpolator();
      this.pPM.setInterpolator(EmojiCustomUI.this);
      AppMethodBeat.o(108882);
    }
    
    private static void a(ImageView paramImageView, EmojiInfo paramEmojiInfo)
    {
      AppMethodBeat.i(108889);
      com.tencent.mm.emoji.loader.e locale = com.tencent.mm.emoji.loader.e.gkR;
      com.tencent.mm.emoji.loader.e.a(paramEmojiInfo, paramImageView);
      AppMethodBeat.o(108889);
    }
    
    private int cjr()
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
    
    public final EmojiInfo Cn(int paramInt)
    {
      AppMethodBeat.i(108886);
      if (paramInt >= getRealCount())
      {
        AppMethodBeat.o(108886);
        return null;
      }
      if (this.pMe == null)
      {
        AppMethodBeat.o(108886);
        return null;
      }
      EmojiInfo localEmojiInfo = (EmojiInfo)this.pMe.get(paramInt);
      AppMethodBeat.o(108886);
      return localEmojiInfo;
    }
    
    public final boolean cjs()
    {
      AppMethodBeat.i(108888);
      int i;
      if (com.tencent.mm.kernel.g.ajR().isSDCardAvailable()) {
        if (this.grL == 0)
        {
          this.pMe = com.tencent.mm.emoji.a.i.aeX().afa();
          if (EmojiCustomUI.m(EmojiCustomUI.this) != EmojiCustomUI.c.pPO) {
            break label132;
          }
          if (EmojiCustomUI.n(EmojiCustomUI.this) != null) {
            break label118;
          }
          i = 0;
          label56:
          EmojiCustomUI.this.setMMTitle(EmojiCustomUI.this.getString(2131758296, new Object[] { Integer.valueOf(i) }));
        }
      }
      for (;;)
      {
        AppMethodBeat.o(108888);
        return true;
        this.pMe = com.tencent.mm.emoji.a.i.aeX().dk(false);
        break;
        this.pMe = new ArrayList();
        break;
        label118:
        i = EmojiCustomUI.n(EmojiCustomUI.this).size();
        break label56;
        label132:
        if (this.grL == 0) {
          EmojiCustomUI.this.setMMTitle(EmojiCustomUI.this.getString(2131758247, new Object[] { Integer.valueOf(this.pMe.size()) }));
        } else {
          EmojiCustomUI.this.setMMTitle(EmojiCustomUI.this.getString(2131758225, new Object[] { Integer.valueOf(this.pMe.size()) }));
        }
      }
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(108883);
      int i = getRealCount();
      int j = cjr();
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
      if (this.pMe == null)
      {
        AppMethodBeat.o(108885);
        return 0;
      }
      int i = this.pMe.size();
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
        paramView = LayoutInflater.from(EmojiCustomUI.this.getContext()).inflate(2131493767, null);
        paramView.setVisibility(0);
        paramViewGroup = new EmojiCustomUI.d(paramView);
        paramView.setTag(paramViewGroup);
        if ((EmojiCustomUI.m(EmojiCustomUI.this) != EmojiCustomUI.c.pPQ) && (EmojiCustomUI.m(EmojiCustomUI.this) != EmojiCustomUI.c.pPO)) {
          break label195;
        }
        i = cjr();
        label84:
        if (paramInt >= getCount() - i) {
          break label235;
        }
        if (paramInt % 5 != 0) {
          break label223;
        }
        paramViewGroup.kFh.setBackgroundResource(2131232028);
      }
      for (;;)
      {
        paramViewGroup.image.clearAnimation();
        paramViewGroup.image.setScaleType(ImageView.ScaleType.FIT_CENTER);
        switch (EmojiCustomUI.11.pPH[EmojiCustomUI.m(EmojiCustomUI.this).ordinal()])
        {
        default: 
          AppMethodBeat.o(108887);
          return paramView;
          paramView.setVisibility(0);
          paramViewGroup = (EmojiCustomUI.d)paramView.getTag();
          break label52;
          label195:
          if (1 == this.grL)
          {
            i = cjr();
            break label84;
          }
          i = cjr() - 1;
          break label84;
          label223:
          paramViewGroup.kFh.setBackgroundResource(2131232033);
          continue;
          label235:
          if (paramInt == getCount() - i) {
            paramViewGroup.kFh.setBackgroundResource(2131232032);
          } else {
            paramViewGroup.kFh.setBackgroundColor(0);
          }
          break;
        }
      }
      Object localObject;
      if (paramInt == getCount() - cjr() + 1)
      {
        localObject = com.tencent.mm.emoji.loader.e.gkR;
        com.tencent.mm.emoji.loader.e.cv(paramViewGroup.image);
        paramViewGroup.image.setImageBitmap(null);
      }
      for (;;)
      {
        paramViewGroup.pPS.setVisibility(8);
        break;
        if (paramInt == 0)
        {
          if (this.grL == 0)
          {
            localObject = com.tencent.mm.emoji.loader.e.gkR;
            com.tencent.mm.emoji.loader.e.cv(paramViewGroup.image);
            paramViewGroup.image.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            paramViewGroup.image.setImageResource(2131690097);
          }
          else if (paramInt != getRealCount())
          {
            localObject = (EmojiInfo)this.pMe.get(paramInt);
            a(paramViewGroup.image, (EmojiInfo)localObject);
          }
        }
        else if (this.grL == 0)
        {
          localObject = (EmojiInfo)this.pMe.get(paramInt - 1);
          a(paramViewGroup.image, (EmojiInfo)localObject);
        }
        else if (paramInt != getRealCount())
        {
          localObject = (EmojiInfo)this.pMe.get(paramInt);
          a(paramViewGroup.image, (EmojiInfo)localObject);
        }
        else
        {
          localObject = com.tencent.mm.emoji.loader.e.gkR;
          com.tencent.mm.emoji.loader.e.cv(paramViewGroup.image);
          paramViewGroup.image.setImageBitmap(null);
        }
      }
      if (paramInt == getCount() - cjr() + 1)
      {
        localObject = com.tencent.mm.emoji.loader.e.gkR;
        com.tencent.mm.emoji.loader.e.cv(paramViewGroup.image);
        paramViewGroup.image.setImageBitmap(null);
      }
      for (;;)
      {
        paramViewGroup.pPS.setVisibility(8);
        break;
        if (paramInt == getRealCount())
        {
          localObject = com.tencent.mm.emoji.loader.e.gkR;
          com.tencent.mm.emoji.loader.e.cv(paramViewGroup.image);
          paramViewGroup.image.setImageResource(2131233679);
          paramViewGroup.image.startAnimation(this.pPM);
        }
        else
        {
          localObject = (EmojiInfo)this.pMe.get(paramInt);
          a(paramViewGroup.image, (EmojiInfo)localObject);
        }
      }
      if (paramInt == getCount() - cjr() + 1)
      {
        localObject = com.tencent.mm.emoji.loader.e.gkR;
        com.tencent.mm.emoji.loader.e.cv(paramViewGroup.image);
        paramViewGroup.image.setImageBitmap(null);
      }
      for (;;)
      {
        paramViewGroup.pPS.setVisibility(8);
        break;
        if (paramInt == getRealCount())
        {
          localObject = com.tencent.mm.emoji.loader.e.gkR;
          com.tencent.mm.emoji.loader.e.cv(paramViewGroup.image);
          paramViewGroup.image.setImageBitmap(null);
        }
        else
        {
          localObject = (EmojiInfo)this.pMe.get(paramInt);
          a(paramViewGroup.image, (EmojiInfo)localObject);
          if (((EmojiInfo)localObject).field_catalog != EmojiGroupInfo.OzS)
          {
            paramViewGroup.pPS.setVisibility(0);
            paramViewGroup.pPS.setChecked(EmojiCustomUI.n(EmojiCustomUI.this).contains(((EmojiInfo)localObject).Lj()));
            break;
            if (paramInt == getCount() - cjr() + 1)
            {
              localObject = com.tencent.mm.emoji.loader.e.gkR;
              com.tencent.mm.emoji.loader.e.cv(paramViewGroup.image);
              paramViewGroup.image.setImageBitmap(null);
            }
            else if (paramInt == getRealCount())
            {
              localObject = com.tencent.mm.emoji.loader.e.gkR;
              com.tencent.mm.emoji.loader.e.cv(paramViewGroup.image);
              paramViewGroup.image.setImageBitmap(null);
            }
            else
            {
              localObject = (EmojiInfo)this.pMe.get(paramInt);
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
      pPN = new c("NORMAL", 0);
      pPO = new c("EDIT", 1);
      pPP = new c("SYNCING", 2);
      pPQ = new c("WITH_OUT_ADD", 3);
      pPR = new c[] { pPN, pPO, pPP, pPQ };
      AppMethodBeat.o(108893);
    }
    
    private c() {}
  }
  
  static final class d
  {
    ImageView image;
    View kFh;
    CheckBox pPS;
    
    public d(View paramView)
    {
      AppMethodBeat.i(108894);
      this.kFh = paramView.findViewById(2131301137);
      this.image = ((ImageView)paramView.findViewById(2131300914));
      this.pPS = ((CheckBox)paramView.findViewById(2131298264));
      AppMethodBeat.o(108894);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiCustomUI
 * JD-Core Version:    0.7.0.1
 */