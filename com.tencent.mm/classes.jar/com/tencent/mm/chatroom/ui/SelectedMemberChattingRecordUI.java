package com.tencent.mm.chatroom.ui;

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
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.br;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.findersdk.a.j;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.bvh;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.protocal.protobuf.bvn;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cc.a;
import com.tencent.mm.storage.cc.c;
import com.tencent.mm.storage.cc.f;
import com.tencent.mm.storage.cr;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.MMLoadMoreListView.a;
import com.tencent.mm.ui.x;
import java.util.Map;

public class SelectedMemberChattingRecordUI
  extends MMActivity
{
  private static final com.tencent.mm.b.f<Integer, com.tencent.mm.protocal.b.a.c> lNS;
  private int eQx = 0;
  private MMLoadMoreListView lNP;
  private a lNQ;
  private String lNR;
  private View lNe;
  private View lNf;
  private String lyn;
  private String mTitle;
  
  static
  {
    AppMethodBeat.i(12991);
    lNS = new com.tencent.mm.memory.a.c(32);
    AppMethodBeat.o(12991);
  }
  
  public static String a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(12989);
    String str = "";
    k.b localb = k.b.Hf(paramString1);
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
      label320:
      do
      {
        for (;;)
        {
          AppMethodBeat.o(12989);
          return localObject;
          localObject = paramString1.substring(paramString1.indexOf(":\n") + 1);
          continue;
          paramString1 = new com.tencent.mm.modelvoice.p(paramString1);
          localObject = paramContext.getString(a.i.gSW, new Object[] { Integer.valueOf((int)s.jh(paramString1.time)) });
          continue;
          localObject = paramContext.getString(a.i.app_pic);
          continue;
          if (62 == paramInt1) {}
          for (paramInt1 = a.i.app_shortvideo;; paramInt1 = a.i.app_video)
          {
            localObject = paramContext.getString(paramInt1);
            break;
          }
          paramString1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().aLV(paramString1);
          localObject = paramContext.getString(a.i.gSN, new Object[] { paramString1.label });
        }
        localObject = str;
      } while (Util.nullAsNil(paramString1).length() <= 0);
      localObject = br.JJ(paramString1);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
    }
    for (;;)
    {
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().aLU(paramString1);
      paramString2 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramString2).aSV();
      paramString1 = paramString2;
      if (au.bwE(paramString2)) {
        paramString1 = v.e(v.Io(paramString2), paramString2);
      }
      if (paramInt2 == 1)
      {
        localObject = paramContext.getString(a.i.gIn, new Object[] { paramString1, ((cc.a)localObject).getDisplayName() });
        break;
      }
      localObject = paramContext.getString(a.i.gIo, new Object[] { paramString1, ((cc.a)localObject).getDisplayName() });
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
        localObject = paramContext.getString(a.i.gSM, new Object[] { localb.title });
        break;
      case 5: 
        localObject = paramContext.getString(a.i.gSU, new Object[] { localb.getTitle() });
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
        localObject = paramContext.getString(a.i.gSN, new Object[] { localb.title });
        break;
      case 19: 
        localObject = paramContext.getString(a.i.gSQ, new Object[] { localb.title });
        break;
      case 24: 
        paramString2 = localb.nRF;
        if (Util.isNullOrNil(paramString2))
        {
          Log.e("MicroMsg.SelectedMemberChattingRecordUI", "xml is null");
          paramString1 = null;
          if (paramString1 != null) {
            break label1222;
          }
        }
        for (paramString1 = "";; paramString1 = paramString1.desc)
        {
          localObject = paramContext.getString(a.i.gSP, new Object[] { Util.nullAs(paramString1, "") });
          break;
          paramInt1 = paramString2.hashCode();
          paramString1 = (com.tencent.mm.protocal.b.a.c)lNS.get(Integer.valueOf(paramInt1));
          if (paramString1 != null)
          {
            Log.d("MicroMsg.SelectedMemberChattingRecordUI", "get record msg data from cache");
            break label998;
          }
          if (paramString2.trim().startsWith("<recordinfo>")) {}
          for (paramString1 = XmlParser.parseXml(paramString2, "recordinfo", null);; paramString1 = XmlParser.parseXml("<recordinfo>" + paramString2 + "</recordinfo>", "recordinfo", null))
          {
            if (paramString1 != null) {
              break label1147;
            }
            Log.e("MicroMsg.SelectedMemberChattingRecordUI", "values is null: %s", new Object[] { paramString2 });
            paramString1 = null;
            break;
          }
          paramString2 = new com.tencent.mm.protocal.b.a.c();
          paramString2.title = ((String)paramString1.get(".recordinfo.title"));
          paramString2.desc = ((String)paramString1.get(".recordinfo.desc"));
          paramString2.NAa = ((String)paramString1.get(".recordinfo.favusername"));
          lNS.put(Integer.valueOf(paramInt1), paramString2);
          paramString1 = paramString2;
          break label998;
        }
      case 3: 
        localObject = paramContext.getString(a.i.gSO, new Object[] { localb.title });
        break;
      case 4: 
        localObject = paramContext.getString(a.i.gSV, new Object[] { localb.title });
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
        label998:
        label1147:
        if (Util.isNullOrNil(localb.title))
        {
          localObject = paramContext.getString(a.i.lHO, new Object[] { "" });
          break;
        }
        label1222:
        localObject = paramContext.getString(a.i.lHO, new Object[] { localb.title });
        break;
        localObject = paramContext.getString(a.i.app_emoji);
        break;
        localObject = paramContext.getString(a.i.gSR);
        if (localb == null) {
          break;
        }
        if (paramInt2 == 1) {}
        for (paramInt1 = 1;; paramInt1 = 0) {
          switch (localb.nSh)
          {
          case 2: 
          default: 
            localObject = Util.nullAsNil(localb.title);
            break label320;
          }
        }
        if (paramInt1 != 0)
        {
          localObject = paramContext.getString(a.i.lGQ);
          break;
        }
        localObject = paramContext.getString(a.i.lGT);
        break;
        if (paramInt1 != 0)
        {
          localObject = paramContext.getString(a.i.lGR);
          break;
        }
        localObject = paramContext.getString(a.i.lGO);
        break;
        if (paramInt1 != 0)
        {
          localObject = paramContext.getString(a.i.lGS);
          break;
        }
        localObject = paramContext.getString(a.i.lGP);
        break;
        if (localb == null)
        {
          Log.e("MicroMsg.SelectedMemberChattingRecordUI", "decode msg content failed");
          AppMethodBeat.o(12989);
          return "";
        }
        if (paramInt2 == 1)
        {
          localObject = paramContext.getString(a.i.gSK, new Object[] { localb.nSI, localb.nSF });
          break;
        }
        localObject = paramContext.getString(a.i.gSK, new Object[] { localb.nSI, localb.nSE });
        break;
        if (localb == null)
        {
          Log.e("MicroMsg.SelectedMemberChattingRecordUI", "decode msg content failed");
          AppMethodBeat.o(12989);
          return "";
        }
        if (paramInt2 == 1)
        {
          localObject = paramContext.getString(a.i.gSK, new Object[] { localb.nSI, localb.nSW });
          break;
        }
        localObject = paramContext.getString(a.i.gSK, new Object[] { localb.nSI, localb.nSV });
        break;
        localObject = paramContext.getString(a.i.gSL, new Object[] { localb.title });
        break;
        localObject = paramContext.getString(a.i.gSL, new Object[] { "" });
        break;
        localObject = paramContext.getString(a.i.gSJ, new Object[] { localb.title });
        break;
        localObject = paramContext.getString(a.i.gST, new Object[] { localb.title });
        break;
        localObject = str;
        if (paramString1 == null) {
          break;
        }
        localObject = str;
        if (paramString1.length() <= 0) {
          break;
        }
        paramString1 = cc.f.byv(paramString1);
        localObject = str;
        if (paramString1 == null) {
          break;
        }
        localObject = str;
        if (paramString1.hgk == null) {
          break;
        }
        localObject = str;
        if (paramString1.hgk.length() <= 0) {
          break;
        }
        switch (paramString1.scene)
        {
        case 19: 
        case 20: 
        case 21: 
        default: 
          localObject = paramContext.getString(a.i.gIN, new Object[] { paramString1.getDisplayName() });
          break;
        case 18: 
          localObject = paramContext.getString(a.i.gII, new Object[] { paramString1.getDisplayName() });
          break;
        case 22: 
        case 23: 
        case 24: 
        case 26: 
        case 27: 
        case 28: 
        case 29: 
          localObject = paramContext.getString(a.i.gIL, new Object[] { paramString1.getDisplayName() });
          break;
        case 25: 
          localObject = paramContext.getString(a.i.gIm, new Object[] { paramString1.getDisplayName() });
          break;
          localObject = paramContext.getString(a.i.lHS, new Object[] { localb.title });
          break;
          paramString2 = paramContext.getString(a.i.app_finder);
          localObject = (com.tencent.mm.plugin.findersdk.a.f)localb.aK(com.tencent.mm.plugin.findersdk.a.f.class);
          paramString1 = paramString2;
          if (localObject != null)
          {
            paramString1 = paramString2;
            if (((com.tencent.mm.plugin.findersdk.a.f)localObject).oUc != null)
            {
              paramString1 = paramString2;
              if (!Util.isNullOrNil(((com.tencent.mm.plugin.findersdk.a.f)localObject).getNickname()))
              {
                if (Util.isNullOrNil(((com.tencent.mm.plugin.findersdk.a.f)localObject).oUc.desc)) {}
                for (paramContext = paramContext.getString(a.i.lHQ, new Object[] { ((com.tencent.mm.plugin.findersdk.a.f)localObject).getNickname() });; paramContext = ((com.tencent.mm.plugin.findersdk.a.f)localObject).oUc.desc)
                {
                  localObject = paramString2 + paramContext;
                  break;
                }
                paramString2 = paramContext.getString(a.i.app_finder);
                localObject = (j)localb.aK(j.class);
                paramString1 = paramString2;
                if (localObject != null)
                {
                  paramString1 = paramString2;
                  if (((j)localObject).oUe != null)
                  {
                    paramString1 = paramString2;
                    if (!Util.isNullOrNil(((j)localObject).oUe.nickname))
                    {
                      if (Util.isNullOrNil(((j)localObject).oUe.desc)) {}
                      for (paramContext = paramContext.getString(a.i.lHQ, new Object[] { ((j)localObject).oUe.nickname });; paramContext = ((j)localObject).oUe.desc)
                      {
                        localObject = paramString2 + paramContext;
                        break;
                      }
                      paramContext = paramContext.getString(a.i.app_finder);
                      paramString2 = (com.tencent.mm.plugin.findersdk.a.i)localb.aK(com.tencent.mm.plugin.findersdk.a.i.class);
                      paramString1 = paramContext;
                      if (paramString2 != null)
                      {
                        paramString1 = paramContext;
                        if (paramString2.oTZ != null)
                        {
                          paramString1 = paramContext;
                          if (!Util.isNullOrNil(paramString2.oTZ.topic))
                          {
                            if (paramString2.oTZ.Auy == 1)
                            {
                              localObject = paramContext + MMApplicationContext.getContext().getString(a.i.lHP, new Object[] { paramString2.oTZ.topic });
                              break;
                            }
                            localObject = paramContext + paramString2.oTZ.topic;
                            break;
                            localObject = paramContext.getString(a.i.app_finder);
                            paramContext = (com.tencent.mm.plugin.findersdk.a.d)localb.aK(com.tencent.mm.plugin.findersdk.a.d.class);
                            if ((paramContext != null) && (!Util.isNullOrNil(paramContext.oUa.title)))
                            {
                              localObject = (String)localObject + paramContext.oUa.title;
                              break;
                              localObject = paramContext.getString(a.i.gSO, new Object[] { localb.title });
                              break;
                              localObject = paramContext.getString(a.i.lHR);
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
  
  protected static String a(aj paramaj, String paramString)
  {
    AppMethodBeat.i(12988);
    if (paramaj == null)
    {
      AppMethodBeat.o(12988);
      return null;
    }
    paramaj = paramaj.getDisplayName(paramString);
    AppMethodBeat.o(12988);
    return paramaj;
  }
  
  public int getLayoutId()
  {
    return a.f.lGA;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12987);
    super.initView();
    this.lNf.setVisibility(8);
    this.lNP = ((MMLoadMoreListView)findViewById(a.e.fOe));
    this.lNP.jms();
    this.lNQ = new a(this, this.lyn, this.lNR, this.eQx);
    this.lNP.setAdapter(this.lNQ);
    this.lNe = findViewById(a.e.lFv);
    if (this.eQx == 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.lNe.setVisibility(0);
        this.lNP.setVisibility(8);
      }
      this.lNP.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(241773);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousAdapterView);
          localb.cH(paramAnonymousView);
          localb.sc(paramAnonymousInt);
          localb.hB(paramAnonymousLong);
          a.c("com/tencent/mm/chatroom/ui/SelectedMemberChattingRecordUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
          paramAnonymousAdapterView = (cc)SelectedMemberChattingRecordUI.c(SelectedMemberChattingRecordUI.this).getItem(paramAnonymousInt);
          if (paramAnonymousAdapterView != null) {
            SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this, paramAnonymousAdapterView.field_msgId);
          }
          a.a(this, "com/tencent/mm/chatroom/ui/SelectedMemberChattingRecordUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(241773);
        }
      });
      this.lNP.setOnLoadMoreListener(new MMLoadMoreListView.a()
      {
        public final void onLoadMore()
        {
          AppMethodBeat.i(241779);
          SelectedMemberChattingRecordUI.a locala;
          if (SelectedMemberChattingRecordUI.c(SelectedMemberChattingRecordUI.this) != null)
          {
            locala = SelectedMemberChattingRecordUI.c(SelectedMemberChattingRecordUI.this);
            locala.lNW -= 16;
            if ((Util.isNullOrNil(SelectedMemberChattingRecordUI.a(locala.lNT))) || (!z.Iy(SelectedMemberChattingRecordUI.a(locala.lNT)))) {
              break label111;
            }
            locala.w(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().ga(locala.lMU, locala.lNX - locala.lNW));
          }
          for (;;)
          {
            SelectedMemberChattingRecordUI.c(SelectedMemberChattingRecordUI.this).notifyDataSetChanged();
            AppMethodBeat.o(241779);
            return;
            label111:
            if (!z.Iy(SelectedMemberChattingRecordUI.a(locala.lNT))) {
              locala.w(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().ar(locala.lMU, locala.lNV, locala.lNX - locala.lNW));
            }
          }
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(241760);
          SelectedMemberChattingRecordUI.this.setResult(0);
          SelectedMemberChattingRecordUI.this.finish();
          AppMethodBeat.o(241760);
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
    this.lyn = getIntent().getStringExtra("RoomInfo_Id");
    this.lNR = getIntent().getStringExtra("room_member");
    Log.i("MicroMsg.SelectedMemberChattingRecordUI", "roomId:%s", new Object[] { this.lyn });
    this.mTitle = getIntent().getStringExtra("title");
    setMMTitle(Util.nullAsNil(this.mTitle));
    this.lNf = findViewById(a.e.lFw);
    com.tencent.threadpool.h.ahAA.bn(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(241771);
        if ((!Util.isNullOrNil(SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this))) && (z.Iy(SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this)))) {
          SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this, ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().aMc(SelectedMemberChattingRecordUI.b(SelectedMemberChattingRecordUI.this)));
        }
        while ((SelectedMemberChattingRecordUI.this.isFinishing()) || (SelectedMemberChattingRecordUI.this.isDestroyed()))
        {
          AppMethodBeat.o(241771);
          return;
          if (!z.Iy(SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this))) {
            SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this, ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().kh(SelectedMemberChattingRecordUI.b(SelectedMemberChattingRecordUI.this), SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this)));
          }
        }
        SelectedMemberChattingRecordUI.this.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(241723);
            try
            {
              SelectedMemberChattingRecordUI.this.initView();
              AppMethodBeat.o(241723);
              return;
            }
            finally
            {
              Log.e("MicroMsg.SelectedMemberChattingRecordUI", "initView failed, exception : " + localObject.getMessage());
              AppMethodBeat.o(241723);
            }
          }
        });
        AppMethodBeat.o(241771);
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
    extends x<cc>
  {
    String lMU;
    String lNV;
    int lNW;
    int lNX;
    private aj lNY;
    Context mContext;
    
    public a(Context paramContext, String paramString1, String paramString2, int paramInt)
    {
      super(new cc());
      AppMethodBeat.i(12980);
      this.lNW = -1;
      this.lNX = -1;
      this.mContext = paramContext;
      this.lNX = paramInt;
      this.lMU = paramString1;
      this.lNV = paramString2;
      this.lNY = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Jv(SelectedMemberChattingRecordUI.b(SelectedMemberChattingRecordUI.this));
      AppMethodBeat.o(12980);
    }
    
    private static boolean a(CharSequence paramCharSequence, TextView paramTextView)
    {
      AppMethodBeat.i(12984);
      if ((paramCharSequence != null) && (paramCharSequence.length() != 0))
      {
        paramTextView.setText(com.tencent.mm.pluginsdk.ui.span.p.b(paramTextView.getContext(), paramCharSequence));
        paramTextView.setVisibility(0);
        AppMethodBeat.o(12984);
        return true;
      }
      paramTextView.setVisibility(8);
      AppMethodBeat.o(12984);
      return false;
    }
    
    public final void aNy()
    {
      AppMethodBeat.i(12981);
      if ((this.lNW < 0) || (this.lNW > this.lNX)) {
        this.lNW = (this.lNX - 16);
      }
      if ((!Util.isNullOrNil(SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this))) && (z.Iy(SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this))))
      {
        w(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().ga(this.lMU, this.lNX - this.lNW));
        AppMethodBeat.o(12981);
        return;
      }
      if (!z.Iy(SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this))) {
        w(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().ar(this.lMU, this.lNV, this.lNX - this.lNW));
      }
      AppMethodBeat.o(12981);
    }
    
    public final void aNz()
    {
      AppMethodBeat.i(12982);
      aNy();
      AppMethodBeat.o(12982);
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(12983);
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramViewGroup = LayoutInflater.from(this.context).inflate(a.f.lGn, null, false);
        paramView = new SelectedMemberChattingRecordUI.b((byte)0);
        paramView.lBC = ((ImageView)paramViewGroup.findViewById(a.e.avatar_iv));
        paramView.lBD = ((TextView)paramViewGroup.findViewById(a.e.nickname_tv));
        paramView.lNZ = ((TextView)paramViewGroup.findViewById(a.e.msg_tv));
        paramView.timeTV = ((TextView)paramViewGroup.findViewById(a.e.update_time_tv));
        paramViewGroup.setTag(paramView);
      }
      cc localcc = (cc)getItem(paramInt);
      SelectedMemberChattingRecordUI.b localb = (SelectedMemberChattingRecordUI.b)paramViewGroup.getTag();
      a.b.g(localb.lBC, this.lNV);
      paramView = this.lNV;
      Object localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramView);
      if (!Util.isNullOrNil(((az)localObject2).field_conRemark))
      {
        paramView = ((az)localObject2).field_conRemark;
        if (!Util.isNullOrNil(paramView)) {
          break label349;
        }
        paramView = ((au)localObject2).aSU();
      }
      label349:
      for (;;)
      {
        Object localObject1 = paramView;
        if (!com.tencent.mm.contact.d.rs(((az)localObject2).field_type))
        {
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzB().aMi(((az)localObject2).field_username);
          localObject1 = paramView;
          if (localObject2 != null)
          {
            localObject1 = paramView;
            if (!Util.isNullOrNil(((cr)localObject2).field_conRemark)) {
              localObject1 = ((cr)localObject2).field_conRemark;
            }
          }
        }
        a((CharSequence)localObject1, localb.lBD);
        paramView = this.lNV;
        a(SelectedMemberChattingRecordUI.a(MMApplicationContext.getContext(), localcc.getType(), localcc.field_content, paramView, localcc.field_isSend).trim(), localb.lNZ);
        a(com.tencent.mm.pluginsdk.platformtools.f.d(SelectedMemberChattingRecordUI.this, localcc.getCreateTime(), true), localb.timeTV);
        AppMethodBeat.o(12983);
        return paramViewGroup;
        paramView = SelectedMemberChattingRecordUI.a(this.lNY, ((az)localObject2).field_username);
        break;
      }
    }
  }
  
  static final class b
  {
    public ImageView lBC;
    public TextView lBD;
    public TextView lNZ;
    public TextView timeTV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectedMemberChattingRecordUI
 * JD-Core Version:    0.7.0.1
 */