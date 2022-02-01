package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.bja;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.protocal.protobuf.bjg;
import com.tencent.mm.protocal.protobuf.cwx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ca.a;
import com.tencent.mm.storage.ca.b;
import com.tencent.mm.storage.ca.d;
import com.tencent.mm.storage.co;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.MMLoadMoreListView.a;
import java.util.Map;

public class SelectedMemberChattingRecordUI
  extends MMActivity
{
  private static final com.tencent.mm.b.f<Integer, com.tencent.mm.protocal.b.a.c> jla;
  private int cUX = 0;
  private String jaK;
  private View jkA;
  private View jkB;
  private MMLoadMoreListView jkX;
  private a jkY;
  private String jkZ;
  private String mTitle;
  
  static
  {
    AppMethodBeat.i(12991);
    jla = new com.tencent.mm.memory.a.c(32);
    AppMethodBeat.o(12991);
  }
  
  public static String a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(12989);
    String str = "";
    k.b localb = k.b.OQ(paramString1);
    Object localObject;
    switch (paramInt1)
    {
    default: 
      localObject = str;
    case 1: 
    case 34: 
    case 3: 
    case 23: 
    case 33: 
    case 43: 
    case 62: 
    case 486539313: 
    case 48: 
    case 42: 
    case 66: 
      label312:
      do
      {
        for (;;)
        {
          AppMethodBeat.o(12989);
          return localObject;
          localObject = paramString1.substring(paramString1.indexOf(":\n") + 1);
          continue;
          paramString1 = new p(paramString1);
          localObject = paramContext.getString(a.i.eQr, new Object[] { Integer.valueOf((int)s.GW(paramString1.time)) });
          continue;
          localObject = paramContext.getString(a.i.app_pic);
          continue;
          if (62 == paramInt1) {}
          for (paramInt1 = a.i.app_shortvideo;; paramInt1 = a.i.app_video)
          {
            localObject = paramContext.getString(paramInt1);
            break;
          }
          paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().aOV(paramString1);
          localObject = paramContext.getString(a.i.eQi, new Object[] { paramString1.label });
        }
        localObject = str;
      } while (Util.nullAsNil(paramString1).length() <= 0);
      localObject = bq.RL(paramString1);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
    }
    for (;;)
    {
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().aOU(paramString1);
      paramString2 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(paramString2).ays();
      paramString1 = paramString2;
      if (ab.Lj(paramString2)) {
        paramString1 = com.tencent.mm.model.v.al(com.tencent.mm.model.v.Pv(paramString2));
      }
      if (paramInt2 == 1)
      {
        localObject = paramContext.getString(a.i.eFt, new Object[] { paramString1, ((ca.a)localObject).getDisplayName() });
        break;
      }
      localObject = paramContext.getString(a.i.eFu, new Object[] { paramString1, ((ca.a)localObject).getDisplayName() });
      break;
      if (localb == null)
      {
        Log.e("MicroMsg.SelectedMemberChattingRecordUI", "decode msg content failed");
        AppMethodBeat.o(12989);
        return "";
      }
      localObject = str;
      switch (localb.type)
      {
      case 7: 
      default: 
        localObject = "";
        break;
      case 6: 
      case 74: 
        localObject = paramContext.getString(a.i.eQh, new Object[] { localb.title });
        break;
      case 5: 
        localObject = paramContext.getString(a.i.eQp, new Object[] { localb.getTitle() });
        break;
      case 8: 
        localObject = paramContext.getString(a.i.app_emoji2);
        break;
      case 15: 
      case 26: 
      case 27: 
        localObject = paramContext.getString(a.i.app_emoji);
        break;
      case 25: 
        localObject = paramContext.getString(a.i.app_designer_share);
        break;
      case 17: 
        localObject = paramContext.getString(a.i.eQi, new Object[] { localb.title });
        break;
      case 19: 
        localObject = paramContext.getString(a.i.eQl, new Object[] { localb.title });
        break;
      case 24: 
        paramString2 = localb.lmA;
        if (Util.isNullOrNil(paramString2))
        {
          Log.e("MicroMsg.SelectedMemberChattingRecordUI", "xml is null");
          paramString1 = null;
          if (paramString1 != null) {
            break label1214;
          }
        }
        for (paramString1 = "";; paramString1 = paramString1.desc)
        {
          localObject = paramContext.getString(a.i.eQk, new Object[] { Util.nullAs(paramString1, "") });
          break;
          paramInt1 = paramString2.hashCode();
          paramString1 = (com.tencent.mm.protocal.b.a.c)jla.get(Integer.valueOf(paramInt1));
          if (paramString1 != null)
          {
            Log.d("MicroMsg.SelectedMemberChattingRecordUI", "get record msg data from cache");
            break label990;
          }
          if (paramString2.trim().startsWith("<recordinfo>")) {}
          for (paramString1 = XmlParser.parseXml(paramString2, "recordinfo", null);; paramString1 = XmlParser.parseXml("<recordinfo>" + paramString2 + "</recordinfo>", "recordinfo", null))
          {
            if (paramString1 != null) {
              break label1139;
            }
            Log.e("MicroMsg.SelectedMemberChattingRecordUI", "values is null: %s", new Object[] { paramString2 });
            paramString1 = null;
            break;
          }
          paramString2 = new com.tencent.mm.protocal.b.a.c();
          paramString2.title = ((String)paramString1.get(".recordinfo.title"));
          paramString2.desc = ((String)paramString1.get(".recordinfo.desc"));
          paramString2.HCx = ((String)paramString1.get(".recordinfo.favusername"));
          jla.put(Integer.valueOf(paramInt1), paramString2);
          paramString1 = paramString2;
          break label990;
        }
      case 3: 
        localObject = paramContext.getString(a.i.eQj, new Object[] { localb.title });
        break;
      case 4: 
        localObject = paramContext.getString(a.i.eQq, new Object[] { localb.title });
        break;
      case 2: 
        localObject = paramContext.getString(a.i.app_pic);
        break;
      case 1: 
      case 53: 
      case 57: 
        localObject = localb.title;
        break;
      case 33: 
      case 36: 
      case 44: 
      case 48: 
        label990:
        label1139:
        if (Util.isNullOrNil(localb.title))
        {
          localObject = paramContext.getString(a.i.jfD, new Object[] { "" });
          break;
        }
        label1214:
        localObject = paramContext.getString(a.i.jfD, new Object[] { localb.title });
        break;
        localObject = paramContext.getString(a.i.app_emoji);
        break;
        localObject = paramContext.getString(a.i.eQm);
        if (localb == null) {
          break;
        }
        if (paramInt2 == 1) {}
        for (paramInt1 = 1;; paramInt1 = 0) {
          switch (localb.lnc)
          {
          case 2: 
          default: 
            localObject = Util.nullAsNil(localb.title);
            break label312;
          }
        }
        if (paramInt1 != 0)
        {
          localObject = paramContext.getString(a.i.jeF);
          break;
        }
        localObject = paramContext.getString(a.i.jeI);
        break;
        if (paramInt1 != 0)
        {
          localObject = paramContext.getString(a.i.jeG);
          break;
        }
        localObject = paramContext.getString(a.i.jeD);
        break;
        if (paramInt1 != 0)
        {
          localObject = paramContext.getString(a.i.jeH);
          break;
        }
        localObject = paramContext.getString(a.i.jeE);
        break;
        if (localb == null)
        {
          Log.e("MicroMsg.SelectedMemberChattingRecordUI", "decode msg content failed");
          AppMethodBeat.o(12989);
          return "";
        }
        if (paramInt2 == 1)
        {
          localObject = paramContext.getString(a.i.eQf, new Object[] { localb.lnE, localb.lnB });
          break;
        }
        localObject = paramContext.getString(a.i.eQf, new Object[] { localb.lnE, localb.lnA });
        break;
        if (localb == null)
        {
          Log.e("MicroMsg.SelectedMemberChattingRecordUI", "decode msg content failed");
          AppMethodBeat.o(12989);
          return "";
        }
        if (paramInt2 == 1)
        {
          localObject = paramContext.getString(a.i.eQf, new Object[] { localb.lnE, localb.lnS });
          break;
        }
        localObject = paramContext.getString(a.i.eQf, new Object[] { localb.lnE, localb.lnR });
        break;
        localObject = paramContext.getString(a.i.eQg, new Object[] { localb.title });
        break;
        localObject = paramContext.getString(a.i.eQg, new Object[] { "" });
        break;
        localObject = paramContext.getString(a.i.eQe, new Object[] { localb.title });
        break;
        localObject = paramContext.getString(a.i.eQo, new Object[] { localb.title });
        break;
        localObject = str;
        if (paramString1 == null) {
          break;
        }
        localObject = str;
        if (paramString1.length() <= 0) {
          break;
        }
        paramString1 = ca.d.bxc(paramString1);
        localObject = str;
        if (paramString1.fcC == null) {
          break;
        }
        localObject = str;
        if (paramString1.fcC.length() <= 0) {
          break;
        }
        switch (paramString1.scene)
        {
        case 19: 
        case 20: 
        case 21: 
        default: 
          localObject = paramContext.getString(a.i.eFS, new Object[] { paramString1.getDisplayName() });
          break;
        case 18: 
          localObject = paramContext.getString(a.i.eFN, new Object[] { paramString1.getDisplayName() });
          break;
        case 22: 
        case 23: 
        case 24: 
        case 26: 
        case 27: 
        case 28: 
        case 29: 
          localObject = paramContext.getString(a.i.eFQ, new Object[] { paramString1.getDisplayName() });
          break;
        case 25: 
          localObject = paramContext.getString(a.i.eFs, new Object[] { paramString1.getDisplayName() });
          break;
          localObject = paramContext.getString(a.i.jfG, new Object[] { localb.title });
          break;
          paramString2 = paramContext.getString(a.i.app_finder);
          localObject = (com.tencent.mm.plugin.findersdk.a.f)localb.ar(com.tencent.mm.plugin.findersdk.a.f.class);
          paramString1 = paramString2;
          if (localObject != null)
          {
            paramString1 = paramString2;
            if (((com.tencent.mm.plugin.findersdk.a.f)localObject).mbi != null)
            {
              paramString1 = paramString2;
              if (!Util.isNullOrNil(((com.tencent.mm.plugin.findersdk.a.f)localObject).mbi.nickname))
              {
                if (Util.isNullOrNil(((com.tencent.mm.plugin.findersdk.a.f)localObject).mbi.desc)) {}
                for (paramContext = paramContext.getString(a.i.jfF, new Object[] { ((com.tencent.mm.plugin.findersdk.a.f)localObject).mbi.nickname });; paramContext = ((com.tencent.mm.plugin.findersdk.a.f)localObject).mbi.desc)
                {
                  localObject = paramString2 + paramContext;
                  break;
                }
                paramString2 = paramContext.getString(a.i.app_finder);
                localObject = (com.tencent.mm.plugin.findersdk.a.i)localb.ar(com.tencent.mm.plugin.findersdk.a.i.class);
                paramString1 = paramString2;
                if (localObject != null)
                {
                  paramString1 = paramString2;
                  if (((com.tencent.mm.plugin.findersdk.a.i)localObject).mbk != null)
                  {
                    paramString1 = paramString2;
                    if (!Util.isNullOrNil(((com.tencent.mm.plugin.findersdk.a.i)localObject).mbk.nickname))
                    {
                      if (Util.isNullOrNil(((com.tencent.mm.plugin.findersdk.a.i)localObject).mbk.desc)) {}
                      for (paramContext = paramContext.getString(a.i.jfF, new Object[] { ((com.tencent.mm.plugin.findersdk.a.i)localObject).mbk.nickname });; paramContext = ((com.tencent.mm.plugin.findersdk.a.i)localObject).mbk.desc)
                      {
                        localObject = paramString2 + paramContext;
                        break;
                      }
                      paramContext = paramContext.getString(a.i.app_finder);
                      paramString2 = (com.tencent.mm.plugin.findersdk.a.h)localb.ar(com.tencent.mm.plugin.findersdk.a.h.class);
                      paramString1 = paramContext;
                      if (paramString2 != null)
                      {
                        paramString1 = paramContext;
                        if (paramString2.mbf != null)
                        {
                          paramString1 = paramContext;
                          if (!Util.isNullOrNil(paramString2.mbf.topic))
                          {
                            if (paramString2.mbf.wXA == 1)
                            {
                              localObject = paramContext + MMApplicationContext.getContext().getString(a.i.jfE, new Object[] { paramString2.mbf.topic });
                              break;
                            }
                            localObject = paramContext + paramString2.mbf.topic;
                            break;
                            localObject = paramContext.getString(a.i.app_finder);
                            paramContext = (com.tencent.mm.plugin.findersdk.a.d)localb.ar(com.tencent.mm.plugin.findersdk.a.d.class);
                            if ((paramContext != null) && (!Util.isNullOrNil(paramContext.mbg.title)))
                            {
                              localObject = (String)localObject + paramContext.mbg.title;
                              break;
                              localObject = paramContext.getString(a.i.eQj, new Object[] { localb.title });
                              break;
                            }
                            break;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          localObject = paramString1;
          break;
          paramString2 = (String)localObject;
        }
        break;
      }
    }
  }
  
  protected static String a(ah paramah, String paramString)
  {
    AppMethodBeat.i(12988);
    if (paramah == null)
    {
      AppMethodBeat.o(12988);
      return null;
    }
    paramah = paramah.PJ(paramString);
    AppMethodBeat.o(12988);
    return paramah;
  }
  
  public int getLayoutId()
  {
    return a.f.jep;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12987);
    super.initView();
    this.jkB.setVisibility(8);
    this.jkX = ((MMLoadMoreListView)findViewById(a.e.dMv));
    this.jkX.hJK();
    this.jkY = new a(this, this.jaK, this.jkZ, this.cUX);
    this.jkX.setAdapter(this.jkY);
    this.jkA = findViewById(a.e.jdn);
    if (this.cUX == 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.jkA.setVisibility(0);
        this.jkX.setVisibility(8);
      }
      this.jkX.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(192299);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousAdapterView);
          localb.bn(paramAnonymousView);
          localb.sg(paramAnonymousInt);
          localb.Fs(paramAnonymousLong);
          a.c("com/tencent/mm/chatroom/ui/SelectedMemberChattingRecordUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
          paramAnonymousAdapterView = (ca)SelectedMemberChattingRecordUI.c(SelectedMemberChattingRecordUI.this).getItem(paramAnonymousInt);
          if (paramAnonymousAdapterView != null) {
            SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this, paramAnonymousAdapterView.field_msgId);
          }
          a.a(this, "com/tencent/mm/chatroom/ui/SelectedMemberChattingRecordUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(192299);
        }
      });
      this.jkX.setOnLoadMoreListener(new MMLoadMoreListView.a()
      {
        public final void onLoadMore()
        {
          AppMethodBeat.i(187463);
          SelectedMemberChattingRecordUI.a locala;
          if (SelectedMemberChattingRecordUI.c(SelectedMemberChattingRecordUI.this) != null)
          {
            locala = SelectedMemberChattingRecordUI.c(SelectedMemberChattingRecordUI.this);
            locala.jle -= 16;
            if ((Util.isNullOrNil(SelectedMemberChattingRecordUI.a(locala.jlb))) || (!z.PD(SelectedMemberChattingRecordUI.a(locala.jlb)))) {
              break label111;
            }
            locala.v(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().fh(locala.jkq, locala.jlf - locala.jle));
          }
          for (;;)
          {
            SelectedMemberChattingRecordUI.c(SelectedMemberChattingRecordUI.this).notifyDataSetChanged();
            AppMethodBeat.o(187463);
            return;
            label111:
            if (!z.PD(SelectedMemberChattingRecordUI.a(locala.jlb))) {
              locala.v(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().aj(locala.jkq, locala.jld, locala.jlf - locala.jle));
            }
          }
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(191578);
          SelectedMemberChattingRecordUI.this.setResult(0);
          SelectedMemberChattingRecordUI.this.finish();
          AppMethodBeat.o(191578);
          return true;
        }
      });
      AppMethodBeat.o(12987);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12986);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.SelectedMemberChattingRecordUI", "[onCreate]");
    this.jaK = getIntent().getStringExtra("RoomInfo_Id");
    this.jkZ = getIntent().getStringExtra("room_member");
    Log.i("MicroMsg.SelectedMemberChattingRecordUI", "roomId:%s", new Object[] { this.jaK });
    this.mTitle = getIntent().getStringExtra("title");
    setMMTitle(Util.nullAsNil(this.mTitle));
    this.jkB = findViewById(a.e.jdo);
    com.tencent.e.h.ZvG.bf(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(191041);
        if ((!Util.isNullOrNil(SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this))) && (z.PD(SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this)))) {
          SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this, ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().aPd(SelectedMemberChattingRecordUI.b(SelectedMemberChattingRecordUI.this)));
        }
        while ((SelectedMemberChattingRecordUI.this.isFinishing()) || (SelectedMemberChattingRecordUI.this.isDestroyed()))
        {
          AppMethodBeat.o(191041);
          return;
          if (!z.PD(SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this))) {
            SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this, ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().iT(SelectedMemberChattingRecordUI.b(SelectedMemberChattingRecordUI.this), SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this)));
          }
        }
        SelectedMemberChattingRecordUI.this.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(191330);
            try
            {
              SelectedMemberChattingRecordUI.this.initView();
              AppMethodBeat.o(191330);
              return;
            }
            catch (Throwable localThrowable)
            {
              Log.e("MicroMsg.SelectedMemberChattingRecordUI", "initView failed, exception : " + localThrowable.getMessage());
              AppMethodBeat.o(191330);
            }
          }
        });
        AppMethodBeat.o(191041);
      }
    });
    AppMethodBeat.o(12986);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final class a
    extends com.tencent.mm.ui.v<ca>
  {
    String jkq;
    String jld;
    int jle;
    int jlf;
    private ah jlg;
    Context mContext;
    
    public a(Context paramContext, String paramString1, String paramString2, int paramInt)
    {
      super(new ca());
      AppMethodBeat.i(12980);
      this.jle = -1;
      this.jlf = -1;
      this.mContext = paramContext;
      this.jlf = paramInt;
      this.jkq = paramString1;
      this.jld = paramString2;
      this.jlg = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rx(SelectedMemberChattingRecordUI.b(SelectedMemberChattingRecordUI.this));
      AppMethodBeat.o(12980);
    }
    
    private static boolean a(CharSequence paramCharSequence, TextView paramTextView)
    {
      AppMethodBeat.i(12984);
      if ((paramCharSequence != null) && (paramCharSequence.length() != 0))
      {
        paramTextView.setText(l.c(paramTextView.getContext(), paramCharSequence));
        paramTextView.setVisibility(0);
        AppMethodBeat.o(12984);
        return true;
      }
      paramTextView.setVisibility(8);
      AppMethodBeat.o(12984);
      return false;
    }
    
    public final void atr()
    {
      AppMethodBeat.i(12981);
      if ((this.jle < 0) || (this.jle > this.jlf)) {
        this.jle = (this.jlf - 16);
      }
      if ((!Util.isNullOrNil(SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this))) && (z.PD(SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this))))
      {
        v(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().fh(this.jkq, this.jlf - this.jle));
        AppMethodBeat.o(12981);
        return;
      }
      if (!z.PD(SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this))) {
        v(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().aj(this.jkq, this.jld, this.jlf - this.jle));
      }
      AppMethodBeat.o(12981);
    }
    
    public final void ats()
    {
      AppMethodBeat.i(12982);
      atr();
      AppMethodBeat.o(12982);
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(12983);
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramViewGroup = LayoutInflater.from(this.context).inflate(a.f.jed, null, false);
        paramView = new SelectedMemberChattingRecordUI.b((byte)0);
        paramView.iZG = ((ImageView)paramViewGroup.findViewById(a.e.avatar_iv));
        paramView.iZH = ((TextView)paramViewGroup.findViewById(a.e.nickname_tv));
        paramView.jlh = ((TextView)paramViewGroup.findViewById(a.e.msg_tv));
        paramView.timeTV = ((TextView)paramViewGroup.findViewById(a.e.update_time_tv));
        paramViewGroup.setTag(paramView);
      }
      ca localca = (ca)getItem(paramInt);
      SelectedMemberChattingRecordUI.b localb = (SelectedMemberChattingRecordUI.b)paramViewGroup.getTag();
      a.b.c(localb.iZG, this.jld);
      paramView = this.jld;
      Object localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(paramView);
      if (!Util.isNullOrNil(((ax)localObject2).field_conRemark))
      {
        paramView = ((ax)localObject2).field_conRemark;
        if (!Util.isNullOrNil(paramView)) {
          break label349;
        }
        paramView = ((as)localObject2).ayr();
      }
      label349:
      for (;;)
      {
        Object localObject1 = paramView;
        if (!com.tencent.mm.contact.d.rk(((ax)localObject2).field_type))
        {
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbM().aPj(((ax)localObject2).field_username);
          localObject1 = paramView;
          if (localObject2 != null)
          {
            localObject1 = paramView;
            if (!Util.isNullOrNil(((co)localObject2).field_conRemark)) {
              localObject1 = ((co)localObject2).field_conRemark;
            }
          }
        }
        a((CharSequence)localObject1, localb.iZH);
        paramView = this.jld;
        a(SelectedMemberChattingRecordUI.a(MMApplicationContext.getContext(), localca.getType(), localca.field_content, paramView, localca.field_isSend).trim(), localb.jlh);
        a(com.tencent.mm.pluginsdk.j.f.d(SelectedMemberChattingRecordUI.this, localca.field_createTime, true), localb.timeTV);
        AppMethodBeat.o(12983);
        return paramViewGroup;
        paramView = SelectedMemberChattingRecordUI.a(this.jlg, ((ax)localObject2).field_username);
        break;
      }
    }
  }
  
  static final class b
  {
    public ImageView iZG;
    public TextView iZH;
    public TextView jlh;
    public TextView timeTV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectedMemberChattingRecordUI
 * JD-Core Version:    0.7.0.1
 */