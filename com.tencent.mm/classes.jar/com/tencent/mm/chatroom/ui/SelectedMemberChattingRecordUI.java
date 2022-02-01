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
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.plugin.i.a.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.bcf;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.protocal.protobuf.bcl;
import com.tencent.mm.protocal.protobuf.col;
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
import com.tencent.mm.storage.cn;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.MMLoadMoreListView.a;
import java.util.Map;

public class SelectedMemberChattingRecordUI
  extends MMActivity
{
  private static final com.tencent.mm.b.f<Integer, com.tencent.mm.protocal.b.a.c> gAU;
  private int cSs = 0;
  private MMLoadMoreListView gAR;
  private a gAS;
  private String gAT;
  private View gAx;
  private View gAy;
  private String gwx;
  private String mTitle;
  
  static
  {
    AppMethodBeat.i(12991);
    gAU = new com.tencent.mm.memory.a.c(32);
    AppMethodBeat.o(12991);
  }
  
  public static String a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(12989);
    String str = "";
    k.b localb = k.b.HD(paramString1);
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
      label304:
      do
      {
        for (;;)
        {
          AppMethodBeat.o(12989);
          return localObject;
          localObject = paramString1.substring(paramString1.indexOf(":\n") + 1);
          continue;
          localObject = paramContext.getString(2131764321, new Object[] { Integer.valueOf((int)com.tencent.mm.modelvoice.s.AO(new p(paramString1).time)) });
          continue;
          localObject = paramContext.getString(2131755939);
          continue;
          if (62 == paramInt1) {}
          for (paramInt1 = 2131755987;; paramInt1 = 2131756018)
          {
            localObject = paramContext.getString(paramInt1);
            break;
          }
          localObject = paramContext.getString(2131764288, new Object[] { ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aEL(paramString1).label });
        }
        localObject = str;
      } while (Util.nullAsNil(paramString1).length() <= 0);
      localObject = bp.Ks(paramString1);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
    }
    for (;;)
    {
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aEK(paramString1);
      paramString2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramString2).arJ();
      paramString1 = paramString2;
      if (ab.Eq(paramString2)) {
        paramString1 = v.an(v.If(paramString2));
      }
      if (paramInt2 == 1)
      {
        localObject = paramContext.getString(2131760807, new Object[] { paramString1, ((ca.a)localObject).getDisplayName() });
        break;
      }
      localObject = paramContext.getString(2131760808, new Object[] { paramString1, ((ca.a)localObject).getDisplayName() });
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
        localObject = paramContext.getString(2131764270, new Object[] { localb.title });
        break;
      case 5: 
        localObject = paramContext.getString(2131764316, new Object[] { localb.getTitle() });
        break;
      case 8: 
        localObject = paramContext.getString(2131755794);
        break;
      case 15: 
      case 26: 
      case 27: 
        localObject = paramContext.getString(2131755793);
        break;
      case 25: 
        localObject = paramContext.getString(2131755781);
        break;
      case 17: 
        localObject = paramContext.getString(2131764288, new Object[] { localb.title });
        break;
      case 19: 
        localObject = paramContext.getString(2131764296, new Object[] { localb.title });
        break;
      case 24: 
        paramString2 = localb.ixl;
        if (Util.isNullOrNil(paramString2))
        {
          Log.e("MicroMsg.SelectedMemberChattingRecordUI", "xml is null");
          paramString1 = null;
          if (paramString1 != null) {
            break label1176;
          }
        }
        for (paramString1 = "";; paramString1 = paramString1.desc)
        {
          localObject = paramContext.getString(2131764295, new Object[] { Util.nullAs(paramString1, "") });
          break;
          paramInt1 = paramString2.hashCode();
          paramString1 = (com.tencent.mm.protocal.b.a.c)gAU.get(Integer.valueOf(paramInt1));
          if (paramString1 != null)
          {
            Log.d("MicroMsg.SelectedMemberChattingRecordUI", "get record msg data from cache");
            break label954;
          }
          if (paramString2.trim().startsWith("<recordinfo>")) {}
          for (paramString1 = XmlParser.parseXml(paramString2, "recordinfo", null);; paramString1 = XmlParser.parseXml("<recordinfo>" + paramString2 + "</recordinfo>", "recordinfo", null))
          {
            if (paramString1 != null) {
              break label1101;
            }
            Log.e("MicroMsg.SelectedMemberChattingRecordUI", "values is null: %s", new Object[] { paramString2 });
            paramString1 = null;
            break;
          }
          paramString2 = new com.tencent.mm.protocal.b.a.c();
          paramString2.title = ((String)paramString1.get(".recordinfo.title"));
          paramString2.desc = ((String)paramString1.get(".recordinfo.desc"));
          paramString2.BGs = ((String)paramString1.get(".recordinfo.favusername"));
          gAU.put(Integer.valueOf(paramInt1), paramString2);
          paramString1 = paramString2;
          break label954;
        }
      case 3: 
        localObject = paramContext.getString(2131764294, new Object[] { localb.title });
        break;
      case 4: 
        localObject = paramContext.getString(2131764317, new Object[] { localb.title });
        break;
      case 2: 
        localObject = paramContext.getString(2131755939);
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
        label954:
        label1101:
        if (Util.isNullOrNil(localb.title))
        {
          localObject = paramContext.getString(2131764258, new Object[] { "" });
          break;
        }
        label1176:
        localObject = paramContext.getString(2131764258, new Object[] { localb.title });
        break;
        localObject = paramContext.getString(2131755793);
        break;
        localObject = paramContext.getString(2131764297);
        if (localb == null) {
          break;
        }
        if (paramInt2 == 1) {}
        for (paramInt1 = 1;; paramInt1 = 0) {
          switch (localb.ixN)
          {
          case 2: 
          default: 
            localObject = Util.nullAsNil(localb.title);
            break label304;
          }
        }
        if (paramInt1 != 0)
        {
          localObject = paramContext.getString(2131756199);
          break;
        }
        localObject = paramContext.getString(2131756205);
        break;
        if (paramInt1 != 0)
        {
          localObject = paramContext.getString(2131756200);
          break;
        }
        localObject = paramContext.getString(2131756197);
        break;
        if (paramInt1 != 0)
        {
          localObject = paramContext.getString(2131756203);
          break;
        }
        localObject = paramContext.getString(2131756198);
        break;
        if (localb == null)
        {
          Log.e("MicroMsg.SelectedMemberChattingRecordUI", "decode msg content failed");
          AppMethodBeat.o(12989);
          return "";
        }
        if (paramInt2 == 1)
        {
          localObject = paramContext.getString(2131764264, new Object[] { localb.iyo, localb.iyl });
          break;
        }
        localObject = paramContext.getString(2131764264, new Object[] { localb.iyo, localb.iyk });
        break;
        if (localb == null)
        {
          Log.e("MicroMsg.SelectedMemberChattingRecordUI", "decode msg content failed");
          AppMethodBeat.o(12989);
          return "";
        }
        if (paramInt2 == 1)
        {
          localObject = paramContext.getString(2131764264, new Object[] { localb.iyo, localb.iyC });
          break;
        }
        localObject = paramContext.getString(2131764264, new Object[] { localb.iyo, localb.iyB });
        break;
        localObject = paramContext.getString(2131764265, new Object[] { localb.title });
        break;
        localObject = paramContext.getString(2131764265, new Object[] { "" });
        break;
        localObject = paramContext.getString(2131764257, new Object[] { localb.title });
        break;
        localObject = paramContext.getString(2131764302, new Object[] { localb.title });
        break;
        localObject = str;
        if (paramString1 == null) {
          break;
        }
        localObject = str;
        if (paramString1.length() <= 0) {
          break;
        }
        paramString1 = ca.d.bkD(paramString1);
        localObject = str;
        if (paramString1.dkU == null) {
          break;
        }
        localObject = str;
        if (paramString1.dkU.length() <= 0) {
          break;
        }
        switch (paramString1.scene)
        {
        case 19: 
        case 20: 
        case 21: 
        default: 
          localObject = paramContext.getString(2131760895, new Object[] { paramString1.getDisplayName() });
          break;
        case 18: 
          localObject = paramContext.getString(2131760876, new Object[] { paramString1.getDisplayName() });
          break;
        case 22: 
        case 23: 
        case 24: 
        case 26: 
        case 27: 
        case 28: 
        case 29: 
          localObject = paramContext.getString(2131760886, new Object[] { paramString1.getDisplayName() });
          break;
        case 25: 
          localObject = paramContext.getString(2131760806, new Object[] { paramString1.getDisplayName() });
          break;
          localObject = paramContext.getString(2131764301, new Object[] { localb.title });
          break;
          paramString2 = paramContext.getString(2131755853);
          localObject = (com.tencent.mm.plugin.i.a.f)localb.as(com.tencent.mm.plugin.i.a.f.class);
          paramString1 = paramString2;
          if (localObject != null)
          {
            paramString1 = paramString2;
            if (((com.tencent.mm.plugin.i.a.f)localObject).jlg != null)
            {
              paramString1 = paramString2;
              if (!Util.isNullOrNil(((com.tencent.mm.plugin.i.a.f)localObject).jlg.nickname))
              {
                if (Util.isNullOrNil(((com.tencent.mm.plugin.i.a.f)localObject).jlg.desc)) {}
                for (paramContext = paramContext.getString(2131764300, new Object[] { ((com.tencent.mm.plugin.i.a.f)localObject).jlg.nickname });; paramContext = ((com.tencent.mm.plugin.i.a.f)localObject).jlg.desc)
                {
                  localObject = paramString2 + paramContext;
                  break;
                }
                paramString2 = paramContext.getString(2131755853);
                localObject = (com.tencent.mm.plugin.i.a.i)localb.as(com.tencent.mm.plugin.i.a.i.class);
                paramString1 = paramString2;
                if (localObject != null)
                {
                  paramString1 = paramString2;
                  if (((com.tencent.mm.plugin.i.a.i)localObject).jlh != null)
                  {
                    paramString1 = paramString2;
                    if (!Util.isNullOrNil(((com.tencent.mm.plugin.i.a.i)localObject).jlh.nickname))
                    {
                      if (Util.isNullOrNil(((com.tencent.mm.plugin.i.a.i)localObject).jlh.desc)) {}
                      for (paramContext = paramContext.getString(2131764300, new Object[] { ((com.tencent.mm.plugin.i.a.i)localObject).jlh.nickname });; paramContext = ((com.tencent.mm.plugin.i.a.i)localObject).jlh.desc)
                      {
                        localObject = paramString2 + paramContext;
                        break;
                      }
                      paramContext = paramContext.getString(2131755853);
                      paramString2 = (com.tencent.mm.plugin.i.a.h)localb.as(com.tencent.mm.plugin.i.a.h.class);
                      paramString1 = paramContext;
                      if (paramString2 != null)
                      {
                        paramString1 = paramContext;
                        if (paramString2.jld != null)
                        {
                          paramString1 = paramContext;
                          if (!Util.isNullOrNil(paramString2.jld.dST))
                          {
                            if (paramString2.jld.tvC == 1)
                            {
                              localObject = paramContext + MMApplicationContext.getContext().getString(2131764281, new Object[] { paramString2.jld.dST });
                              break;
                            }
                            localObject = paramContext + paramString2.jld.dST;
                            break;
                            localObject = paramContext.getString(2131755853);
                            paramContext = (d)localb.as(d.class);
                            if ((paramContext != null) && (!Util.isNullOrNil(paramContext.jle.title)))
                            {
                              localObject = (String)localObject + paramContext.jle.title;
                              break;
                              localObject = paramContext.getString(2131764294, new Object[] { localb.title });
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
    paramah = paramah.getDisplayName(paramString);
    AppMethodBeat.o(12988);
    return paramah;
  }
  
  public int getLayoutId()
  {
    return 2131496211;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12987);
    super.initView();
    this.gAy.setVisibility(8);
    this.gAR = ((MMLoadMoreListView)findViewById(2131304594));
    this.gAR.gKM();
    this.gAS = new a(this, this.gwx, this.gAT, this.cSs);
    this.gAR.setAdapter(this.gAS);
    this.gAx = findViewById(2131307540);
    if (this.cSs == 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.gAx.setVisibility(0);
        this.gAR.setVisibility(8);
      }
      this.gAR.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(194196);
          b localb = new b();
          localb.bm(paramAnonymousAdapterView);
          localb.bm(paramAnonymousView);
          localb.pH(paramAnonymousInt);
          localb.zo(paramAnonymousLong);
          a.b("com/tencent/mm/chatroom/ui/SelectedMemberChattingRecordUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
          paramAnonymousAdapterView = (ca)SelectedMemberChattingRecordUI.c(SelectedMemberChattingRecordUI.this).getItem(paramAnonymousInt);
          if (paramAnonymousAdapterView != null) {
            SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this, paramAnonymousAdapterView.field_msgId);
          }
          a.a(this, "com/tencent/mm/chatroom/ui/SelectedMemberChattingRecordUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(194196);
        }
      });
      this.gAR.setOnLoadMoreListener(new MMLoadMoreListView.a()
      {
        public final void onLoadMore()
        {
          AppMethodBeat.i(194197);
          SelectedMemberChattingRecordUI.a locala;
          if (SelectedMemberChattingRecordUI.c(SelectedMemberChattingRecordUI.this) != null)
          {
            locala = SelectedMemberChattingRecordUI.c(SelectedMemberChattingRecordUI.this);
            locala.gAY -= 16;
            if ((Util.isNullOrNil(SelectedMemberChattingRecordUI.a(locala.gAV))) || (!z.Im(SelectedMemberChattingRecordUI.a(locala.gAV)))) {
              break label111;
            }
            locala.setCursor(((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().eG(locala.gAn, locala.gAZ - locala.gAY));
          }
          for (;;)
          {
            SelectedMemberChattingRecordUI.c(SelectedMemberChattingRecordUI.this).notifyDataSetChanged();
            AppMethodBeat.o(194197);
            return;
            label111:
            if (!z.Im(SelectedMemberChattingRecordUI.a(locala.gAV))) {
              locala.setCursor(((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().ae(locala.gAn, locala.gAX, locala.gAZ - locala.gAY));
            }
          }
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(194198);
          SelectedMemberChattingRecordUI.this.setResult(0);
          SelectedMemberChattingRecordUI.this.finish();
          AppMethodBeat.o(194198);
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
    this.gwx = getIntent().getStringExtra("RoomInfo_Id");
    this.gAT = getIntent().getStringExtra("room_member");
    Log.i("MicroMsg.SelectedMemberChattingRecordUI", "roomId:%s", new Object[] { this.gwx });
    this.mTitle = getIntent().getStringExtra("title");
    setMMTitle(Util.nullAsNil(this.mTitle));
    this.gAy = findViewById(2131307541);
    com.tencent.f.h.RTc.aY(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194195);
        if ((!Util.isNullOrNil(SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this))) && (z.Im(SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this)))) {
          SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this, ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aET(SelectedMemberChattingRecordUI.b(SelectedMemberChattingRecordUI.this)));
        }
        while ((SelectedMemberChattingRecordUI.this.isFinishing()) || (SelectedMemberChattingRecordUI.this.isDestroyed()))
        {
          AppMethodBeat.o(194195);
          return;
          if (!z.Im(SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this))) {
            SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this, ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().iI(SelectedMemberChattingRecordUI.b(SelectedMemberChattingRecordUI.this), SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this)));
          }
        }
        SelectedMemberChattingRecordUI.this.runOnUiThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(194194);
            try
            {
              SelectedMemberChattingRecordUI.this.initView();
              AppMethodBeat.o(194194);
              return;
            }
            catch (Throwable localThrowable)
            {
              Log.e("MicroMsg.SelectedMemberChattingRecordUI", "initView failed, exception : " + localThrowable.getMessage());
              AppMethodBeat.o(194194);
            }
          }
        });
        AppMethodBeat.o(194195);
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
    extends com.tencent.mm.ui.s<ca>
  {
    String gAX;
    int gAY;
    int gAZ;
    String gAn;
    private ah gBa;
    Context mContext;
    
    public a(Context paramContext, String paramString1, String paramString2, int paramInt)
    {
      super(new ca());
      AppMethodBeat.i(12980);
      this.gAY = -1;
      this.gAZ = -1;
      this.mContext = paramContext;
      this.gAZ = paramInt;
      this.gAn = paramString1;
      this.gAX = paramString2;
      this.gBa = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Ke(SelectedMemberChattingRecordUI.b(SelectedMemberChattingRecordUI.this));
      AppMethodBeat.o(12980);
    }
    
    private static boolean a(CharSequence paramCharSequence, TextView paramTextView)
    {
      AppMethodBeat.i(12984);
      if ((paramCharSequence != null) && (paramCharSequence.length() != 0))
      {
        paramTextView.setText(com.tencent.mm.pluginsdk.ui.span.l.c(paramTextView.getContext(), paramCharSequence));
        paramTextView.setVisibility(0);
        AppMethodBeat.o(12984);
        return true;
      }
      paramTextView.setVisibility(8);
      AppMethodBeat.o(12984);
      return false;
    }
    
    public final void anp()
    {
      AppMethodBeat.i(12981);
      if ((this.gAY < 0) || (this.gAY > this.gAZ)) {
        this.gAY = (this.gAZ - 16);
      }
      if ((!Util.isNullOrNil(SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this))) && (z.Im(SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this))))
      {
        setCursor(((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().eG(this.gAn, this.gAZ - this.gAY));
        AppMethodBeat.o(12981);
        return;
      }
      if (!z.Im(SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this))) {
        setCursor(((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().ae(this.gAn, this.gAX, this.gAZ - this.gAY));
      }
      AppMethodBeat.o(12981);
    }
    
    public final void anq()
    {
      AppMethodBeat.i(12982);
      anp();
      AppMethodBeat.o(12982);
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(12983);
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramViewGroup = LayoutInflater.from(this.context).inflate(2131495483, null, false);
        paramView = new SelectedMemberChattingRecordUI.b((byte)0);
        paramView.gvv = ((ImageView)paramViewGroup.findViewById(2131297134));
        paramView.gvw = ((TextView)paramViewGroup.findViewById(2131305440));
        paramView.gBb = ((TextView)paramViewGroup.findViewById(2131304987));
        paramView.timeTV = ((TextView)paramViewGroup.findViewById(2131309606));
        paramViewGroup.setTag(paramView);
      }
      ca localca = (ca)getItem(paramInt);
      SelectedMemberChattingRecordUI.b localb = (SelectedMemberChattingRecordUI.b)paramViewGroup.getTag();
      a.b.c(localb.gvv, this.gAX);
      paramView = this.gAX;
      Object localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramView);
      if (!Util.isNullOrNil(((ax)localObject2).field_conRemark))
      {
        paramView = ((ax)localObject2).field_conRemark;
        if (!Util.isNullOrNil(paramView)) {
          break label344;
        }
        paramView = ((as)localObject2).arI();
      }
      label344:
      for (;;)
      {
        Object localObject1 = paramView;
        if (!com.tencent.mm.contact.c.oR(((ax)localObject2).field_type))
        {
          localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSO().aEZ(((ax)localObject2).field_username);
          localObject1 = paramView;
          if (localObject2 != null)
          {
            localObject1 = paramView;
            if (!Util.isNullOrNil(((cn)localObject2).field_conRemark)) {
              localObject1 = ((cn)localObject2).field_conRemark;
            }
          }
        }
        a((CharSequence)localObject1, localb.gvw);
        paramView = this.gAX;
        a(SelectedMemberChattingRecordUI.a(MMApplicationContext.getContext(), localca.getType(), localca.field_content, paramView, localca.field_isSend).trim(), localb.gBb);
        a(com.tencent.mm.pluginsdk.i.f.c(SelectedMemberChattingRecordUI.this, localca.field_createTime, true), localb.timeTV);
        AppMethodBeat.o(12983);
        return paramViewGroup;
        paramView = SelectedMemberChattingRecordUI.a(this.gBa, ((ax)localObject2).field_username);
        break;
      }
    }
  }
  
  static final class b
  {
    public TextView gBb;
    public ImageView gvv;
    public TextView gvw;
    public TextView timeTV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectedMemberChattingRecordUI
 * JD-Core Version:    0.7.0.1
 */