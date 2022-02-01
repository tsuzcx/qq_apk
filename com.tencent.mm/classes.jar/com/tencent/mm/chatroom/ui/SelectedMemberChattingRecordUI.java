package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.b.f;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.ary;
import com.tencent.mm.protocal.protobuf.arz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bv.a;
import com.tencent.mm.storage.bv.b;
import com.tencent.mm.storage.bv.d;
import com.tencent.mm.storage.cg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.MMLoadMoreListView.a;
import java.util.Map;

public class SelectedMemberChattingRecordUI
  extends MMActivity
{
  private static final f<Integer, com.tencent.mm.protocal.b.a.c> fVO;
  private String fRo;
  private MMLoadMoreListView fVK;
  private a fVL;
  private String fVM;
  private int fVN = 0;
  private View fVq;
  private View fVr;
  private String mTitle;
  
  static
  {
    AppMethodBeat.i(12991);
    fVO = new com.tencent.mm.memory.a.c(32);
    AppMethodBeat.o(12991);
  }
  
  public static String a(Context paramContext, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(12989);
    String str = "";
    k.b localb = k.b.zb(paramString1);
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
      label272:
      do
      {
        for (;;)
        {
          AppMethodBeat.o(12989);
          return localObject;
          localObject = paramString1.substring(paramString1.indexOf(":\n") + 1);
          continue;
          localObject = paramContext.getString(2131762255, new Object[] { Integer.valueOf((int)s.sI(new p(paramString1).time)) });
          continue;
          localObject = paramContext.getString(2131755853);
          continue;
          if (62 == paramInt1) {}
          for (paramInt1 = 2131755895;; paramInt1 = 2131755926)
          {
            localObject = paramContext.getString(paramInt1);
            break;
          }
          localObject = paramContext.getString(2131762242, new Object[] { ((l)g.ab(l.class)).doJ().arq(paramString1).label });
        }
        localObject = str;
      } while (bu.nullAsNil(paramString1).length() <= 0);
      localObject = bl.BM(paramString1);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
    }
    for (;;)
    {
      localObject = ((l)g.ab(l.class)).doJ().arp(paramString1);
      paramString2 = ((l)g.ab(l.class)).azF().BH(paramString2).adG();
      paramString1 = paramString2;
      if (x.wb(paramString2)) {
        paramString1 = com.tencent.mm.model.r.ae(com.tencent.mm.model.r.zD(paramString2));
      }
      if (paramInt2 == 1)
      {
        localObject = paramContext.getString(2131759492, new Object[] { paramString1, ((bv.a)localObject).getDisplayName() });
        break;
      }
      localObject = paramContext.getString(2131759493, new Object[] { paramString1, ((bv.a)localObject).getDisplayName() });
      break;
      if (localb == null)
      {
        ae.e("MicroMsg.SelectedMemberChattingRecordUI", "decode msg content failed");
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
        localObject = paramContext.getString(2131762239, new Object[] { localb.title });
        break;
      case 5: 
        localObject = paramContext.getString(2131762253, new Object[] { localb.getTitle() });
        break;
      case 8: 
        localObject = paramContext.getString(2131755723);
        break;
      case 15: 
      case 26: 
      case 27: 
        localObject = paramContext.getString(2131755722);
        break;
      case 25: 
        localObject = paramContext.getString(2131755710);
        break;
      case 17: 
        localObject = paramContext.getString(2131762242, new Object[] { localb.title });
        break;
      case 19: 
        localObject = paramContext.getString(2131762245, new Object[] { localb.title });
        break;
      case 24: 
        paramString2 = localb.hDg;
        if (bu.isNullOrNil(paramString2))
        {
          ae.e("MicroMsg.SelectedMemberChattingRecordUI", "xml is null");
          paramString1 = null;
          if (paramString1 != null) {
            break label1142;
          }
        }
        for (paramString1 = "";; paramString1 = paramString1.desc)
        {
          localObject = paramContext.getString(2131762244, new Object[] { bu.bI(paramString1, "") });
          break;
          paramInt1 = paramString2.hashCode();
          paramString1 = (com.tencent.mm.protocal.b.a.c)fVO.get(Integer.valueOf(paramInt1));
          if (paramString1 != null)
          {
            ae.d("MicroMsg.SelectedMemberChattingRecordUI", "get record msg data from cache");
            break label922;
          }
          if (paramString2.trim().startsWith("<recordinfo>")) {}
          for (paramString1 = bx.M(paramString2, "recordinfo");; paramString1 = bx.M("<recordinfo>" + paramString2 + "</recordinfo>", "recordinfo"))
          {
            if (paramString1 != null) {
              break label1067;
            }
            ae.e("MicroMsg.SelectedMemberChattingRecordUI", "values is null: %s", new Object[] { paramString2 });
            paramString1 = null;
            break;
          }
          paramString2 = new com.tencent.mm.protocal.b.a.c();
          paramString2.title = ((String)paramString1.get(".recordinfo.title"));
          paramString2.desc = ((String)paramString1.get(".recordinfo.desc"));
          paramString2.xGt = ((String)paramString1.get(".recordinfo.favusername"));
          fVO.put(Integer.valueOf(paramInt1), paramString2);
          paramString1 = paramString2;
          break label922;
        }
      case 3: 
        localObject = paramContext.getString(2131762243, new Object[] { localb.title });
        break;
      case 4: 
        localObject = paramContext.getString(2131762254, new Object[] { localb.title });
        break;
      case 2: 
        localObject = paramContext.getString(2131755853);
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
        label922:
        label1067:
        label1142:
        if (bu.isNullOrNil(localb.title))
        {
          localObject = paramContext.getString(2131766379, new Object[] { "" });
          break;
        }
        localObject = paramContext.getString(2131766379, new Object[] { localb.title });
        break;
        localObject = paramContext.getString(2131755722);
        break;
        localObject = paramContext.getString(2131762246);
        if (localb == null) {
          break;
        }
        if (paramInt2 == 1) {}
        for (paramInt1 = 1;; paramInt1 = 0) {
          switch (localb.hDI)
          {
          case 2: 
          default: 
            localObject = bu.nullAsNil(localb.title);
            break label272;
          }
        }
        if (paramInt1 != 0)
        {
          localObject = paramContext.getString(2131756072);
          break;
        }
        localObject = paramContext.getString(2131756075);
        break;
        if (paramInt1 != 0)
        {
          localObject = paramContext.getString(2131756073);
          break;
        }
        localObject = paramContext.getString(2131756070);
        break;
        if (paramInt1 != 0)
        {
          localObject = paramContext.getString(2131756074);
          break;
        }
        localObject = paramContext.getString(2131756071);
        break;
        if (localb == null)
        {
          ae.e("MicroMsg.SelectedMemberChattingRecordUI", "decode msg content failed");
          AppMethodBeat.o(12989);
          return "";
        }
        if (paramInt2 == 1)
        {
          localObject = paramContext.getString(2131762234, new Object[] { localb.hEi, localb.hEf });
          break;
        }
        localObject = paramContext.getString(2131762234, new Object[] { localb.hEi, localb.hEe });
        break;
        if (localb == null)
        {
          ae.e("MicroMsg.SelectedMemberChattingRecordUI", "decode msg content failed");
          AppMethodBeat.o(12989);
          return "";
        }
        if (paramInt2 == 1)
        {
          localObject = paramContext.getString(2131762234, new Object[] { localb.hEi, localb.hEw });
          break;
        }
        localObject = paramContext.getString(2131762234, new Object[] { localb.hEi, localb.hEv });
        break;
        localObject = paramContext.getString(2131762235, new Object[] { localb.title });
        break;
        localObject = paramContext.getString(2131762235, new Object[] { "" });
        break;
        localObject = paramContext.getString(2131762233, new Object[] { localb.title });
        break;
        localObject = paramContext.getString(2131762248, new Object[] { localb.title });
        break;
        localObject = str;
        if (paramString1 == null) {
          break;
        }
        localObject = str;
        if (paramString1.length() <= 0) {
          break;
        }
        paramString1 = bv.d.aVF(paramString1);
        localObject = str;
        if (paramString1.cUA == null) {
          break;
        }
        localObject = str;
        if (paramString1.cUA.length() <= 0) {
          break;
        }
        switch (paramString1.scene)
        {
        case 19: 
        case 20: 
        case 21: 
        default: 
          localObject = paramContext.getString(2131759578, new Object[] { paramString1.getDisplayName() });
          break;
        case 18: 
          localObject = paramContext.getString(2131759559, new Object[] { paramString1.getDisplayName() });
          break;
        case 22: 
        case 23: 
        case 24: 
        case 26: 
        case 27: 
        case 28: 
        case 29: 
          localObject = paramContext.getString(2131759569, new Object[] { paramString1.getDisplayName() });
          break;
        case 25: 
          localObject = paramContext.getString(2131759491, new Object[] { paramString1.getDisplayName() });
          break;
          localObject = paramContext.getString(2131766955, new Object[] { localb.title });
          break;
          paramString2 = paramContext.getString(2131755775);
          localObject = (com.tencent.mm.plugin.i.a.b)localb.ao(com.tencent.mm.plugin.i.a.b.class);
          paramString1 = paramString2;
          if (localObject != null)
          {
            paramString1 = paramString2;
            if (((com.tencent.mm.plugin.i.a.b)localObject).ipW != null)
            {
              paramString1 = paramString2;
              if (!bu.isNullOrNil(((com.tencent.mm.plugin.i.a.b)localObject).ipW.nickname))
              {
                localObject = paramString2 + paramContext.getString(2131766954, new Object[] { ((com.tencent.mm.plugin.i.a.b)localObject).ipW.nickname });
                break;
                paramContext = paramContext.getString(2131755775);
                paramString2 = (com.tencent.mm.plugin.i.a.c)localb.ao(com.tencent.mm.plugin.i.a.c.class);
                paramString1 = paramContext;
                if (paramString2 != null)
                {
                  paramString1 = paramContext;
                  if (paramString2.ipX != null)
                  {
                    paramString1 = paramContext;
                    if (!bu.isNullOrNil(paramString2.ipX.dBe))
                    {
                      if (paramString2.ipX.sXu == 1)
                      {
                        localObject = paramContext + ak.getContext().getString(2131766953, new Object[] { paramString2.ipX.dBe });
                        break;
                      }
                      localObject = paramContext + paramString2.ipX.dBe;
                      break;
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
  
  protected static String a(ac paramac, String paramString)
  {
    AppMethodBeat.i(12988);
    if (paramac == null)
    {
      AppMethodBeat.o(12988);
      return null;
    }
    paramac = paramac.zP(paramString);
    AppMethodBeat.o(12988);
    return paramac;
  }
  
  public int getLayoutId()
  {
    return 2131495350;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12987);
    super.initView();
    this.fVr.setVisibility(8);
    this.fVK = ((MMLoadMoreListView)findViewById(2131302228));
    this.fVK.fCN();
    this.fVL = new a(this, this.fRo, this.fVM, this.fVN);
    this.fVK.setAdapter(this.fVL);
    this.fVq = findViewById(2131304525);
    if (this.fVN == 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.fVq.setVisibility(0);
        this.fVK.setVisibility(8);
      }
      this.fVK.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(224393);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mu(paramAnonymousInt);
          localb.rl(paramAnonymousLong);
          a.b("com/tencent/mm/chatroom/ui/SelectedMemberChattingRecordUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
          paramAnonymousAdapterView = (bv)SelectedMemberChattingRecordUI.c(SelectedMemberChattingRecordUI.this).getItem(paramAnonymousInt);
          if (paramAnonymousAdapterView != null) {
            SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this, paramAnonymousAdapterView.field_msgId);
          }
          a.a(this, "com/tencent/mm/chatroom/ui/SelectedMemberChattingRecordUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(224393);
        }
      });
      this.fVK.setOnLoadMoreListener(new MMLoadMoreListView.a()
      {
        public final void ZC()
        {
          AppMethodBeat.i(224394);
          SelectedMemberChattingRecordUI.a locala;
          if (SelectedMemberChattingRecordUI.c(SelectedMemberChattingRecordUI.this) != null)
          {
            locala = SelectedMemberChattingRecordUI.c(SelectedMemberChattingRecordUI.this);
            locala.fVR -= 16;
            if ((bu.isNullOrNil(SelectedMemberChattingRecordUI.a(locala.fVP))) || (!v.zK(SelectedMemberChattingRecordUI.a(locala.fVP)))) {
              break label111;
            }
            locala.setCursor(((l)g.ab(l.class)).doJ().es(locala.fVg, locala.fVS - locala.fVR));
          }
          for (;;)
          {
            SelectedMemberChattingRecordUI.c(SelectedMemberChattingRecordUI.this).notifyDataSetChanged();
            AppMethodBeat.o(224394);
            return;
            label111:
            if (!v.zK(SelectedMemberChattingRecordUI.a(locala.fVP))) {
              locala.setCursor(((l)g.ab(l.class)).doJ().ab(locala.fVg, locala.fVQ, locala.fVS - locala.fVR));
            }
          }
        }
      });
      setBackBtn(new SelectedMemberChattingRecordUI.4(this));
      AppMethodBeat.o(12987);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12986);
    super.onCreate(paramBundle);
    ae.i("MicroMsg.SelectedMemberChattingRecordUI", "[onCreate]");
    this.fRo = getIntent().getStringExtra("RoomInfo_Id");
    this.fVM = getIntent().getStringExtra("room_member");
    ae.i("MicroMsg.SelectedMemberChattingRecordUI", "roomId:%s", new Object[] { this.fRo });
    this.mTitle = getIntent().getStringExtra("title");
    setMMTitle(bu.nullAsNil(this.mTitle));
    this.fVr = findViewById(2131308107);
    h.MqF.aP(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(224392);
        if ((!bu.isNullOrNil(SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this))) && (v.zK(SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this)))) {
          SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this, ((l)g.ab(l.class)).doJ().ary(SelectedMemberChattingRecordUI.b(SelectedMemberChattingRecordUI.this)));
        }
        while ((SelectedMemberChattingRecordUI.this.isFinishing()) || (SelectedMemberChattingRecordUI.this.isDestroyed()))
        {
          AppMethodBeat.o(224392);
          return;
          if (!v.zK(SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this))) {
            SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this, ((l)g.ab(l.class)).doJ().hZ(SelectedMemberChattingRecordUI.b(SelectedMemberChattingRecordUI.this), SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this)));
          }
        }
        SelectedMemberChattingRecordUI.this.runOnUiThread(new SelectedMemberChattingRecordUI.1.1(this));
        AppMethodBeat.o(224392);
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
    extends com.tencent.mm.ui.r<bv>
  {
    String fVQ;
    int fVR;
    int fVS;
    private ac fVT;
    String fVg;
    Context mContext;
    
    public a(Context paramContext, String paramString1, String paramString2, int paramInt)
    {
      super(new bv());
      AppMethodBeat.i(12980);
      this.fVR = -1;
      this.fVS = -1;
      this.mContext = paramContext;
      this.fVS = paramInt;
      this.fVg = paramString1;
      this.fVQ = paramString2;
      this.fVT = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().By(SelectedMemberChattingRecordUI.b(SelectedMemberChattingRecordUI.this));
      AppMethodBeat.o(12980);
    }
    
    private static boolean a(CharSequence paramCharSequence, TextView paramTextView)
    {
      AppMethodBeat.i(12984);
      if ((paramCharSequence != null) && (paramCharSequence.length() != 0))
      {
        paramTextView.setText(k.c(paramTextView.getContext(), paramCharSequence));
        paramTextView.setVisibility(0);
        AppMethodBeat.o(12984);
        return true;
      }
      paramTextView.setVisibility(8);
      AppMethodBeat.o(12984);
      return false;
    }
    
    public final void ZD()
    {
      AppMethodBeat.i(12981);
      if ((this.fVR < 0) || (this.fVR > this.fVS)) {
        this.fVR = (this.fVS - 16);
      }
      if ((!bu.isNullOrNil(SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this))) && (v.zK(SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this))))
      {
        setCursor(((l)g.ab(l.class)).doJ().es(this.fVg, this.fVS - this.fVR));
        AppMethodBeat.o(12981);
        return;
      }
      if (!v.zK(SelectedMemberChattingRecordUI.a(SelectedMemberChattingRecordUI.this))) {
        setCursor(((l)g.ab(l.class)).doJ().ab(this.fVg, this.fVQ, this.fVS - this.fVR));
      }
      AppMethodBeat.o(12981);
    }
    
    public final void ZE()
    {
      AppMethodBeat.i(12982);
      ZD();
      AppMethodBeat.o(12982);
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(12983);
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramViewGroup = LayoutInflater.from(this.context).inflate(2131494753, null, false);
        paramView = new SelectedMemberChattingRecordUI.b((byte)0);
        paramView.fQl = ((ImageView)paramViewGroup.findViewById(2131297008));
        paramView.fQm = ((TextView)paramViewGroup.findViewById(2131302867));
        paramView.fVU = ((TextView)paramViewGroup.findViewById(2131302555));
        paramView.fVV = ((TextView)paramViewGroup.findViewById(2131306207));
        paramViewGroup.setTag(paramView);
      }
      bv localbv = (bv)getItem(paramInt);
      SelectedMemberChattingRecordUI.b localb = (SelectedMemberChattingRecordUI.b)paramViewGroup.getTag();
      a.b.c(localb.fQl, this.fVQ);
      paramView = this.fVQ;
      Object localObject2 = ((l)g.ab(l.class)).azF().BH(paramView);
      if (!bu.isNullOrNil(((aw)localObject2).field_conRemark))
      {
        paramView = ((aw)localObject2).field_conRemark;
        if (!bu.isNullOrNil(paramView)) {
          break label344;
        }
        paramView = ((an)localObject2).adF();
      }
      label344:
      for (;;)
      {
        Object localObject1 = paramView;
        if (!com.tencent.mm.contact.c.lO(((aw)localObject2).field_type))
        {
          localObject2 = ((l)g.ab(l.class)).azG().arE(((aw)localObject2).field_username);
          localObject1 = paramView;
          if (localObject2 != null)
          {
            localObject1 = paramView;
            if (!bu.isNullOrNil(((cg)localObject2).field_conRemark)) {
              localObject1 = ((cg)localObject2).field_conRemark;
            }
          }
        }
        a((CharSequence)localObject1, localb.fQm);
        paramView = this.fVQ;
        a(SelectedMemberChattingRecordUI.a(ak.getContext(), localbv.getType(), localbv.field_content, paramView, localbv.field_isSend).trim(), localb.fVU);
        a(com.tencent.mm.pluginsdk.i.i.c(SelectedMemberChattingRecordUI.this, localbv.field_createTime, true), localb.fVV);
        AppMethodBeat.o(12983);
        return paramViewGroup;
        paramView = SelectedMemberChattingRecordUI.a(this.fVT, ((aw)localObject2).field_username);
        break;
      }
    }
  }
  
  static final class b
  {
    public ImageView fQl;
    public TextView fQm;
    public TextView fVU;
    public TextView fVV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectedMemberChattingRecordUI
 * JD-Core Version:    0.7.0.1
 */