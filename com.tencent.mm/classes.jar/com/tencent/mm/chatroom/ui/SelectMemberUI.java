package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.HandlerThread;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Display;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.o;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.c;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.cf;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.EllipsizeTextView;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.MaskLayout.a;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SelectMemberUI
  extends MMActivity
{
  protected ab fLO;
  protected String fPi;
  protected int fPp;
  private MMEditText fSE;
  private View fTk;
  private View fTl;
  private SelectMemberScrollBar fTm;
  protected b fTn;
  protected HashSet<String> fTo;
  private boolean fTp;
  private boolean fTq;
  private ListView mListView;
  protected String mTitle;
  
  protected static String a(ab paramab, String paramString)
  {
    AppMethodBeat.i(12976);
    if (paramab == null)
    {
      AppMethodBeat.o(12976);
      return null;
    }
    paramab = paramab.zf(paramString);
    AppMethodBeat.o(12976);
    return paramab;
  }
  
  public boolean Zg()
  {
    return false;
  }
  
  protected void Zj()
  {
    AppMethodBeat.i(12971);
    this.fPi = getIntent().getStringExtra("RoomInfo_Id");
    ad.i("MicroMsg.SelectMemberUI", "[getIntentParams] roomId:%s", new Object[] { this.fPi });
    this.fLO = ((c)g.ab(c.class)).azz().AO(this.fPi);
    this.fPp = getIntent().getIntExtra("from_scene", 0);
    this.mTitle = getIntent().getStringExtra("title");
    this.fTp = getIntent().getBooleanExtra("is_show_owner", true);
    this.fTq = getIntent().getBooleanExtra("is_mulit_select_mode", false);
    this.fTo = new HashSet();
    AppMethodBeat.o(12971);
  }
  
  public boolean Zk()
  {
    return this.fTq;
  }
  
  protected HashSet<String> Zl()
  {
    AppMethodBeat.i(12974);
    HashSet localHashSet = new HashSet();
    AppMethodBeat.o(12974);
    return localHashSet;
  }
  
  protected HashSet<String> Zn()
  {
    AppMethodBeat.i(12973);
    HashSet localHashSet = new HashSet();
    AppMethodBeat.o(12973);
    return localHashSet;
  }
  
  protected boolean Zo()
  {
    return true;
  }
  
  protected BaseAdapter Zp()
  {
    return this.fTn;
  }
  
  protected List<String> Zq()
  {
    AppMethodBeat.i(12975);
    List localList = this.fLO.aGo();
    AppMethodBeat.o(12975);
    return localList;
  }
  
  public final ab Zs()
  {
    return this.fLO;
  }
  
  protected void a(View paramView, int paramInt, long paramLong) {}
  
  public int getLayoutId()
  {
    return 2131495352;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12972);
    setMMTitle(bt.nullAsNil(this.mTitle));
    this.mListView = ((ListView)findViewById(2131302228));
    this.fTk = findViewById(2131304525);
    this.fTl = findViewById(2131304526);
    this.fTn = new b(this, this.fLO, this.fPi, this.fLO.field_roomowner);
    this.mListView.setAdapter(Zp());
    this.fTm = ((SelectMemberScrollBar)findViewById(2131302231));
    this.fTm.setOnScrollBarTouchListener(new VerticalScrollBar.a()
    {
      public final void vc(String paramAnonymousString)
      {
        AppMethodBeat.i(12948);
        if ("↑".equals(paramAnonymousString))
        {
          SelectMemberUI.a(SelectMemberUI.this).setSelection(0);
          AppMethodBeat.o(12948);
          return;
        }
        SelectMemberUI.b localb = SelectMemberUI.this.fTn;
        if (localb.fTv.containsKey(paramAnonymousString)) {}
        for (int i = ((Integer)localb.fTv.get(paramAnonymousString)).intValue();; i = -1)
        {
          if (i != -1) {
            SelectMemberUI.a(SelectMemberUI.this).setSelection(i);
          }
          AppMethodBeat.o(12948);
          return;
        }
      }
    });
    if (Zo()) {
      this.fTm.setVisibility(0);
    }
    for (;;)
    {
      this.fSE = ((MMEditText)findViewById(2131304523));
      this.fSE.addTextChangedListener(new TextWatcher()
      {
        private av fTs;
        
        public final void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(12951);
          this.fTs.stopTimer();
          this.fTs.az(500L, 500L);
          AppMethodBeat.o(12951);
        }
      });
      b localb = this.fTn;
      localb.fTr.fTl.setVisibility(0);
      g.ajF().ay(new SelectMemberUI.b.1(localb));
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(12952);
          paramAnonymousMenuItem = new Intent();
          SelectMemberUI.this.setResult(0, paramAnonymousMenuItem);
          SelectMemberUI.this.finish();
          AppMethodBeat.o(12952);
          return true;
        }
      });
      AppMethodBeat.o(12972);
      return;
      this.fTm.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12970);
    super.onCreate(paramBundle);
    ad.i("MicroMsg.SelectMemberUI", "[onCreate]");
    Zj();
    initView();
    AppMethodBeat.o(12970);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected void v(int paramInt, boolean paramBoolean) {}
  
  public final class a
  {
    public am contact;
    public int type = 1;
    
    public a(am paramam)
    {
      this.contact = paramam;
    }
  }
  
  public final class b
    extends BaseAdapter
  {
    private List<SelectMemberUI.a> dAa;
    private ab fLO;
    private String fPi;
    public String fSM;
    private String fSO;
    private List<SelectMemberUI.a> fSP;
    public final String fTu;
    HashMap<String, Integer> fTv;
    volatile boolean isLoading;
    private Context mContext;
    
    public b(Context paramContext, ab paramab, String paramString1, String paramString2)
    {
      AppMethodBeat.i(12960);
      this.fTu = new String(Character.toChars(91));
      this.fSO = null;
      this.fSP = new ArrayList(0);
      this.dAa = new ArrayList();
      this.isLoading = false;
      this.fTv = new HashMap();
      this.fLO = paramab;
      this.fPi = paramString1;
      this.fSO = paramString2;
      this.mContext = paramContext;
      AppMethodBeat.o(12960);
    }
    
    private String b(am paramam)
    {
      AppMethodBeat.i(12965);
      String str1;
      if (!bt.isNullOrNil(paramam.field_conRemark))
      {
        str1 = paramam.field_conRemark;
        if (!bt.isNullOrNil(str1)) {
          break label114;
        }
        str1 = paramam.adu();
      }
      label114:
      for (;;)
      {
        String str2 = str1;
        if (!com.tencent.mm.o.b.lM(paramam.field_type))
        {
          paramam = ((l)g.ab(l.class)).azq().aqz(paramam.field_username);
          str2 = str1;
          if (paramam != null)
          {
            str2 = str1;
            if (!bt.isNullOrNil(paramam.field_conRemark)) {
              str2 = paramam.field_conRemark;
            }
          }
        }
        AppMethodBeat.o(12965);
        return str2;
        str1 = SelectMemberUI.a(this.fLO, paramam.field_username);
        break;
      }
    }
    
    public final void S(List<String> paramList)
    {
      AppMethodBeat.i(12966);
      if (paramList == null)
      {
        AppMethodBeat.o(12966);
        return;
      }
      this.dAa.clear();
      int i = 0;
      if (i < paramList.size())
      {
        am localam = ((l)g.ab(l.class)).azp().Bf((String)paramList.get(i));
        if ((SelectMemberUI.this.Zg()) || (!u.za(localam.field_username)))
        {
          boolean bool = localam.field_username.equals(this.fSO);
          if (((!bool) || (SelectMemberUI.e(SelectMemberUI.this))) && (!SelectMemberUI.this.Zn().contains(localam.field_username)))
          {
            if ((!bool) || (!SelectMemberUI.e(SelectMemberUI.this))) {
              break label178;
            }
            this.dAa.add(0, new SelectMemberUI.a(SelectMemberUI.this, localam));
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label178:
          this.dAa.add(new SelectMemberUI.a(SelectMemberUI.this, localam));
        }
      }
      Collections.sort(this.dAa, new Comparator() {});
      this.fSP = this.dAa;
      AppMethodBeat.o(12966);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(12962);
      if ((this.dAa == null) || (this.isLoading))
      {
        AppMethodBeat.o(12962);
        return 0;
      }
      int i = this.dAa.size();
      AppMethodBeat.o(12962);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, final ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(12964);
      Object localObject;
      if (paramView == null)
      {
        paramView = View.inflate(this.mContext, 2131495351, null);
        paramViewGroup = new SelectMemberUI.c();
        paramViewGroup.fTA = ((MaskLayout)paramView.findViewById(2131304528));
        paramViewGroup.fPC = ((EllipsizeTextView)paramView.findViewById(2131304530));
        paramViewGroup.fPC = ((TextView)paramView.findViewById(2131304530));
        paramViewGroup.fTC = ((ImageButton)paramView.findViewById(2131297595));
        paramViewGroup.fTD = ((LinearLayout)paramView.findViewById(2131297596));
        localObject = (WindowManager)this.mContext.getSystemService("window");
        paramViewGroup.fPC.setMaxWidth(((WindowManager)localObject).getDefaultDisplay().getWidth() * 2 / 3);
        paramViewGroup.fTB = ((TextView)paramView.findViewById(2131304529));
        paramViewGroup.fTB.setMaxWidth(((WindowManager)localObject).getDefaultDisplay().getWidth() * 2 / 3);
        paramView.setTag(paramViewGroup);
        paramViewGroup.fTC.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(12956);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            a.b("com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            paramViewGroup.fTD.performClick();
            a.a(this, "com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(12956);
          }
        });
        paramViewGroup.fTD.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(12957);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            a.b("com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            int i = ((Integer)paramAnonymousView.getTag()).intValue();
            paramAnonymousView = SelectMemberUI.b.this.lj(i);
            if (paramAnonymousView == null)
            {
              ad.e("MicroMsg.SelectMemberAdapter", "item is null");
              a.a(this, "com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(12957);
              return;
            }
            if (SelectMemberUI.this.Zl().contains(paramAnonymousView.contact.field_username))
            {
              a.a(this, "com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(12957);
              return;
            }
            if (SelectMemberUI.this.fTo.contains(paramAnonymousView.contact.field_username))
            {
              SelectMemberUI.this.fTo.remove(paramAnonymousView.contact.field_username);
              paramViewGroup.fTC.setImageResource(2131231750);
              SelectMemberUI.this.v(i, false);
            }
            for (;;)
            {
              a.a(this, "com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(12957);
              return;
              SelectMemberUI.this.fTo.add(paramAnonymousView.contact.field_username);
              paramViewGroup.fTC.setImageResource(2131689936);
              SelectMemberUI.this.v(i, true);
            }
          }
        });
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(12958);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            a.b("com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
            localObject = (SelectMemberUI.c)paramAnonymousView.getTag();
            SelectMemberUI.this.a(paramAnonymousView, ((SelectMemberUI.c)localObject).position, paramAnonymousView.getId());
            a.a(this, "com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(12958);
          }
        });
      }
      SelectMemberUI.a locala;
      for (;;)
      {
        locala = lj(paramInt);
        paramViewGroup.fTD.setTag(Integer.valueOf(paramInt));
        if (locala != null) {
          break;
        }
        ad.e("MicroMsg.SelectMemberAdapter", "null == item! position:%s, count:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(getCount()) });
        AppMethodBeat.o(12964);
        return paramView;
        paramViewGroup = (SelectMemberUI.c)paramView.getTag();
      }
      am localam = locala.contact;
      a.b.c((ImageView)paramViewGroup.fTA.getContentView(), localam.field_username);
      String str;
      label439:
      label492:
      int i;
      if (localam.field_verifyFlag != 0) {
        if (as.a.hFQ != null)
        {
          localObject = as.a.hFQ.os(localam.field_verifyFlag);
          if (localObject != null)
          {
            localObject = o.Eg((String)localObject);
            paramViewGroup.fTA.a((Bitmap)localObject, MaskLayout.a.Jpb);
            str = b(localam);
            localObject = "";
            if (com.tencent.mm.o.b.lM(localam.field_type)) {
              localObject = localam.ePD;
            }
            if (bt.isNullOrNil((String)localObject)) {
              break label628;
            }
            paramViewGroup.fTB.setVisibility(0);
            paramViewGroup.fTB.setText(k.b(this.mContext, (CharSequence)localObject, paramViewGroup.fTB.getTextSize()));
            if (!am.aSQ(localam.field_username)) {
              break label649;
            }
            ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).a(this.mContext, paramViewGroup.fPC, str, localam.field_openImAppid, localam.field_descWordingId, (int)paramViewGroup.fPC.getTextSize());
            if (!SelectMemberUI.this.Zk()) {
              break label746;
            }
            paramViewGroup.fTC.setVisibility(0);
            paramViewGroup.fTD.setVisibility(0);
            if (!SelectMemberUI.this.Zl().contains(localam.field_username)) {
              break label683;
            }
            paramViewGroup.fTD.setEnabled(false);
            paramViewGroup.fTC.setEnabled(false);
            localObject = paramViewGroup.fTC;
            if (!al.isDarkMode()) {
              break label675;
            }
            i = 2131689939;
            label569:
            ((ImageButton)localObject).setImageResource(i);
          }
        }
      }
      for (;;)
      {
        paramViewGroup.fTz = locala;
        paramViewGroup.position = paramInt;
        AppMethodBeat.o(12964);
        return paramView;
        paramViewGroup.fTA.setMaskDrawable(null);
        break;
        paramViewGroup.fTA.setMaskDrawable(null);
        break;
        paramViewGroup.fTA.setMaskDrawable(null);
        break;
        label628:
        paramViewGroup.fTB.setVisibility(8);
        paramViewGroup.fTB.setText("");
        break label439;
        label649:
        paramViewGroup.fPC.setText(k.b(this.mContext, str, paramViewGroup.fPC.getTextSize()));
        break label492;
        label675:
        i = 2131689938;
        break label569;
        label683:
        paramViewGroup.fTD.setEnabled(true);
        paramViewGroup.fTC.setEnabled(true);
        if (SelectMemberUI.this.fTo.contains(locala.contact.field_username))
        {
          paramViewGroup.fTC.setImageResource(2131689936);
        }
        else
        {
          paramViewGroup.fTC.setImageResource(2131231750);
          continue;
          label746:
          paramViewGroup.fTC.setVisibility(8);
          paramViewGroup.fTD.setVisibility(8);
        }
      }
    }
    
    public final SelectMemberUI.a lj(int paramInt)
    {
      AppMethodBeat.i(12963);
      if (this.dAa.size() > paramInt)
      {
        SelectMemberUI.a locala = (SelectMemberUI.a)this.dAa.get(paramInt);
        AppMethodBeat.o(12963);
        return locala;
      }
      AppMethodBeat.o(12963);
      return null;
    }
    
    public final void va(String paramString)
    {
      AppMethodBeat.i(12961);
      ad.i("MicroMsg.SelectMemberAdapter", "[setMemberListBySearch]");
      ArrayList localArrayList = new ArrayList();
      if (!bt.isNullOrNil(paramString))
      {
        Iterator localIterator = this.fSP.iterator();
        while (localIterator.hasNext())
        {
          SelectMemberUI.a locala = (SelectMemberUI.a)localIterator.next();
          if ((locala != null) && (locala.contact != null) && (locala.type == 1))
          {
            Object localObject = locala.contact;
            if ((((aw)localObject).field_conRemark != null) && (((aw)localObject).field_conRemark.contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((!bt.isNullOrNil(SeeRoomMemberUI.a(this.fLO, ((aw)localObject).field_username))) && (SeeRoomMemberUI.a(this.fLO, ((aw)localObject).field_username).contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((((am)localObject).adu() != null) && (((am)localObject).adu().contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((((am)localObject).VD() != null) && (((am)localObject).VD().contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((((am)localObject).VA() != null) && (((am)localObject).VA().contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((((aw)localObject).field_username != null) && (((aw)localObject).field_username.contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if (!com.tencent.mm.o.b.lM(((aw)localObject).field_type))
            {
              localObject = ((l)g.ab(l.class)).azq().aqz(((aw)localObject).field_username);
              if ((localObject != null) && (((cf)localObject).field_conRemark != null) && (((cf)localObject).field_conRemark.contains(paramString))) {
                localArrayList.add(locala);
              }
            }
          }
        }
        this.dAa = localArrayList;
        AppMethodBeat.o(12961);
        return;
      }
      this.dAa = this.fSP;
      AppMethodBeat.o(12961);
    }
  }
  
  protected static final class c
  {
    public TextView fPC;
    public MaskLayout fTA;
    public TextView fTB;
    public ImageButton fTC;
    public LinearLayout fTD;
    public SelectMemberUI.a fTz;
    public int position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectMemberUI
 * JD-Core Version:    0.7.0.1
 */