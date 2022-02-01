package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Display;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.co;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.EllipsizeTextView;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.MaskLayout.a;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import com.tencent.mm.ui.contact.p.a;
import com.tencent.mm.ui.contact.t;
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
  implements com.tencent.mm.ui.contact.o, p.a
{
  protected ah iXp;
  protected String jaK;
  protected int jaR;
  private MMEditText jjU;
  private View jkA;
  private View jkB;
  private SelectMemberScrollBar jkC;
  protected t jkD;
  protected b jkE;
  protected HashSet<String> jkF;
  private boolean jkG;
  private boolean jkH;
  private TextView jkI;
  private ListView mListView;
  protected String mTitle;
  
  protected static String a(ah paramah, String paramString)
  {
    AppMethodBeat.i(12976);
    if (paramah == null)
    {
      AppMethodBeat.o(12976);
      return null;
    }
    paramah = paramah.PJ(paramString);
    AppMethodBeat.o(12976);
    return paramah;
  }
  
  protected void B(int paramInt, boolean paramBoolean) {}
  
  protected void a(View paramView, int paramInt, long paramLong) {}
  
  public boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    return false;
  }
  
  public boolean atd()
  {
    return false;
  }
  
  protected void atg()
  {
    AppMethodBeat.i(12971);
    this.jaK = getIntent().getStringExtra("RoomInfo_Id");
    Log.i("MicroMsg.SelectMemberUI", "[getIntentParams] roomId:%s", new Object[] { this.jaK });
    this.iXp = ((com.tencent.mm.plugin.chatroom.a.b)h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rx(this.jaK);
    this.jaR = getIntent().getIntExtra("from_scene", 0);
    this.mTitle = getIntent().getStringExtra("title");
    this.jkG = getIntent().getBooleanExtra("is_show_owner", true);
    this.jkH = getIntent().getBooleanExtra("is_mulit_select_mode", false);
    this.jkF = new HashSet();
    AppMethodBeat.o(12971);
  }
  
  public boolean ath()
  {
    return this.jkH;
  }
  
  protected boolean ati()
  {
    return true;
  }
  
  protected HashSet<String> atj()
  {
    AppMethodBeat.i(12974);
    HashSet localHashSet = new HashSet();
    AppMethodBeat.o(12974);
    return localHashSet;
  }
  
  protected HashSet<String> atl()
  {
    AppMethodBeat.i(12973);
    HashSet localHashSet = new HashSet();
    AppMethodBeat.o(12973);
    return localHashSet;
  }
  
  protected boolean atm()
  {
    return true;
  }
  
  protected BaseAdapter atn()
  {
    return this.jkE;
  }
  
  protected List<String> ato()
  {
    AppMethodBeat.i(12975);
    List localList = this.iXp.bjL();
    AppMethodBeat.o(12975);
    return localList;
  }
  
  public final ah atq()
  {
    return this.iXp;
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    return false;
  }
  
  public final void g(final String paramString, final int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(186499);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(192318);
        if (Util.isNullOrNil(paramString))
        {
          SelectMemberUI.a(SelectMemberUI.this).setAdapter(SelectMemberUI.this.jkE);
          SelectMemberUI.c(SelectMemberUI.this).setVisibility(8);
          AppMethodBeat.o(192318);
          return;
        }
        SelectMemberUI.a(SelectMemberUI.this).setAdapter(SelectMemberUI.this.jkD);
        if (paramInt > 0)
        {
          SelectMemberUI.c(SelectMemberUI.this).setVisibility(8);
          AppMethodBeat.o(192318);
          return;
        }
        SelectMemberUI.c(SelectMemberUI.this).setText(com.tencent.mm.plugin.fts.a.f.a(SelectMemberUI.this.getString(a.i.search_contact_no_result_pre), SelectMemberUI.this.getString(a.i.search_contact_no_result_post), e.c(paramString, paramString)).BIp);
        SelectMemberUI.c(SelectMemberUI.this).setVisibility(0);
        AppMethodBeat.o(192318);
      }
    });
    AppMethodBeat.o(186499);
  }
  
  public Activity getActivity()
  {
    return this;
  }
  
  public ListView getContentLV()
  {
    return this.mListView;
  }
  
  public int getLayoutId()
  {
    return a.f.jer;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12972);
    setMMTitle(Util.nullAsNil(this.mTitle));
    this.mListView = ((ListView)findViewById(a.e.dMv));
    this.jkA = findViewById(a.e.jdn);
    this.jkB = findViewById(a.e.jdp);
    this.jkI = ((TextView)findViewById(a.e.empty_tv));
    this.jkE = new b(this, this.iXp, this.jaK, this.iXp.field_roomowner);
    Object localObject = new HashSet();
    if (!atd()) {
      ((HashSet)localObject).add(z.bcZ());
    }
    this.jkD = new t(this, this.jaK, ath(), (HashSet)localObject);
    this.jkD.XsV = this;
    this.mListView.setAdapter(atn());
    this.jkC = ((SelectMemberScrollBar)findViewById(a.e.dMw));
    this.jkC.setOnScrollBarTouchListener(new VerticalScrollBar.a()
    {
      public final void KH(String paramAnonymousString)
      {
        AppMethodBeat.i(12948);
        if ("↑".equals(paramAnonymousString))
        {
          SelectMemberUI.a(SelectMemberUI.this).setSelection(0);
          AppMethodBeat.o(12948);
          return;
        }
        SelectMemberUI.b localb = SelectMemberUI.this.jkE;
        if (localb.jkO.containsKey(paramAnonymousString)) {}
        for (int i = ((Integer)localb.jkO.get(paramAnonymousString)).intValue();; i = -1)
        {
          if (i != -1) {
            SelectMemberUI.a(SelectMemberUI.this).setSelection(i);
          }
          AppMethodBeat.o(12948);
          return;
        }
      }
    });
    if (atm()) {
      this.jkC.setVisibility(0);
    }
    for (;;)
    {
      this.jjU = ((MMEditText)findViewById(a.e.dTD));
      this.jjU.addTextChangedListener(new TextWatcher()
      {
        private MTimerHandler jkK;
        
        public final void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(12951);
          this.jkK.stopTimer();
          this.jkK.startTimer(500L);
          AppMethodBeat.o(12951);
        }
      });
      localObject = this.jkE;
      ((b)localObject).jkJ.jkB.setVisibility(0);
      h.aHJ().postToWorker(new SelectMemberUI.b.1((b)localObject));
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
      if (ati()) {
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(191061);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousAdapterView);
            localb.bn(paramAnonymousView);
            localb.sg(paramAnonymousInt);
            localb.Fs(paramAnonymousLong);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/SelectMemberUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
            if (SelectMemberUI.a(SelectMemberUI.this).getAdapter() == SelectMemberUI.this.jkD) {
              SelectMemberUI.this.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SelectMemberUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(191061);
          }
        });
      }
      AppMethodBeat.o(12972);
      return;
      this.jkC.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12970);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.SelectMemberUI", "[onCreate]");
    atg();
    initView();
    AppMethodBeat.o(12970);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(186497);
    this.jkD.finish();
    super.onDestroy();
    AppMethodBeat.o(186497);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final class a
  {
    public as contact;
    public int type = 1;
    
    public a(as paramas)
    {
      this.contact = paramas;
    }
  }
  
  public final class b
    extends BaseAdapter
  {
    private List<SelectMemberUI.a> fMr;
    private ah iXp;
    volatile boolean isLoading;
    private String jaK;
    public final String jkN;
    HashMap<String, Integer> jkO;
    public String jkc;
    private String jke;
    private List<SelectMemberUI.a> jkf;
    private Context mContext;
    
    public b(Context paramContext, ah paramah, String paramString1, String paramString2)
    {
      AppMethodBeat.i(12960);
      this.jkN = new String(Character.toChars(91));
      this.jke = null;
      this.jkf = new ArrayList(0);
      this.fMr = new ArrayList();
      this.isLoading = false;
      this.jkO = new HashMap();
      this.iXp = paramah;
      this.jaK = paramString1;
      this.jke = paramString2;
      this.mContext = paramContext;
      AppMethodBeat.o(12960);
    }
    
    private String b(as paramas)
    {
      AppMethodBeat.i(12965);
      String str1;
      if (!Util.isNullOrNil(paramas.field_conRemark))
      {
        str1 = paramas.field_conRemark;
        if (!Util.isNullOrNil(str1)) {
          break label114;
        }
        str1 = paramas.ayr();
      }
      label114:
      for (;;)
      {
        String str2 = str1;
        if (!d.rk(paramas.field_type))
        {
          paramas = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbM().aPj(paramas.field_username);
          str2 = str1;
          if (paramas != null)
          {
            str2 = str1;
            if (!Util.isNullOrNil(paramas.field_conRemark)) {
              str2 = paramas.field_conRemark;
            }
          }
        }
        AppMethodBeat.o(12965);
        return str2;
        str1 = SelectMemberUI.a(this.iXp, paramas.field_username);
        break;
      }
    }
    
    public final void KF(String paramString)
    {
      AppMethodBeat.i(12961);
      Log.i("MicroMsg.SelectMemberAdapter", "[setMemberListBySearch]");
      ArrayList localArrayList = new ArrayList();
      if (!Util.isNullOrNil(paramString))
      {
        Iterator localIterator = this.jkf.iterator();
        while (localIterator.hasNext())
        {
          SelectMemberUI.a locala = (SelectMemberUI.a)localIterator.next();
          if ((locala != null) && (locala.contact != null) && (locala.type == 1))
          {
            Object localObject = locala.contact;
            if ((((ax)localObject).field_conRemark != null) && (((ax)localObject).field_conRemark.contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((!Util.isNullOrNil(SeeRoomMemberUI.a(this.iXp, ((ax)localObject).field_username))) && (SeeRoomMemberUI.a(this.iXp, ((ax)localObject).field_username).contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((((as)localObject).ayr() != null) && (((as)localObject).ayr().contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((((as)localObject).aph() != null) && (((as)localObject).aph().contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((((as)localObject).apf() != null) && (((as)localObject).apf().contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((((ax)localObject).field_username != null) && (((ax)localObject).field_username.contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if (!d.rk(((ax)localObject).field_type))
            {
              localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbM().aPj(((ax)localObject).field_username);
              if ((localObject != null) && (((co)localObject).field_conRemark != null) && (((co)localObject).field_conRemark.contains(paramString))) {
                localArrayList.add(locala);
              }
            }
          }
        }
        this.fMr = localArrayList;
        AppMethodBeat.o(12961);
        return;
      }
      this.fMr = this.jkf;
      AppMethodBeat.o(12961);
    }
    
    public final void V(List<String> paramList)
    {
      AppMethodBeat.i(12966);
      if (paramList == null)
      {
        AppMethodBeat.o(12966);
        return;
      }
      this.fMr.clear();
      int i = 0;
      if (i < paramList.size())
      {
        as localas = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG((String)paramList.get(i));
        if ((SelectMemberUI.this.atd()) || (!z.PD(localas.field_username)))
        {
          boolean bool = localas.field_username.equals(this.jke);
          if (((!bool) || (SelectMemberUI.f(SelectMemberUI.this))) && (!SelectMemberUI.this.atl().contains(localas.field_username)))
          {
            if ((!bool) || (!SelectMemberUI.f(SelectMemberUI.this))) {
              break label178;
            }
            this.fMr.add(0, new SelectMemberUI.a(SelectMemberUI.this, localas));
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label178:
          this.fMr.add(new SelectMemberUI.a(SelectMemberUI.this, localas));
        }
      }
      Collections.sort(this.fMr, new Comparator() {});
      this.jkf = this.fMr;
      AppMethodBeat.o(12966);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(12962);
      if ((this.fMr == null) || (this.isLoading))
      {
        AppMethodBeat.o(12962);
        return 0;
      }
      int i = this.fMr.size();
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
        paramView = View.inflate(this.mContext, a.f.jeq, null);
        paramViewGroup = new SelectMemberUI.c();
        paramViewGroup.jkT = ((MaskLayout)paramView.findViewById(a.e.jdq));
        paramViewGroup.jbe = ((EllipsizeTextView)paramView.findViewById(a.e.jds));
        paramViewGroup.jbe = ((TextView)paramView.findViewById(a.e.jds));
        paramViewGroup.jkV = ((ImageButton)paramView.findViewById(a.e.jcn));
        paramViewGroup.jkW = ((LinearLayout)paramView.findViewById(a.e.jco));
        localObject = (WindowManager)this.mContext.getSystemService("window");
        paramViewGroup.jbe.setMaxWidth(((WindowManager)localObject).getDefaultDisplay().getWidth() * 2 / 3);
        paramViewGroup.jkU = ((TextView)paramView.findViewById(a.e.jdr));
        paramViewGroup.jkU.setMaxWidth(((WindowManager)localObject).getDefaultDisplay().getWidth() * 2 / 3);
        paramView.setTag(paramViewGroup);
        localObject = qC(paramInt);
        if (localObject != null)
        {
          if (SelectMemberUI.this.jkF.contains(((SelectMemberUI.a)localObject).contact.field_username))
          {
            paramViewGroup.jkV.setImageResource(a.d.checkbox_unselected);
            SelectMemberUI.this.B(paramInt, false);
          }
        }
        else
        {
          paramViewGroup.jkV.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(12956);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              paramViewGroup.jkW.performClick();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(12956);
            }
          });
          paramViewGroup.jkW.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(12957);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              int i = ((Integer)paramAnonymousView.getTag()).intValue();
              paramAnonymousView = SelectMemberUI.b.this.qC(i);
              if (paramAnonymousView == null)
              {
                Log.e("MicroMsg.SelectMemberAdapter", "item is null");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(12957);
                return;
              }
              if (SelectMemberUI.this.atj().contains(paramAnonymousView.contact.field_username))
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(12957);
                return;
              }
              if (SelectMemberUI.this.jkF.contains(paramAnonymousView.contact.field_username))
              {
                SelectMemberUI.this.jkF.remove(paramAnonymousView.contact.field_username);
                paramViewGroup.jkV.setImageResource(a.d.checkbox_unselected);
                SelectMemberUI.this.B(i, false);
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(12957);
                return;
                SelectMemberUI.this.jkF.add(paramAnonymousView.contact.field_username);
                paramViewGroup.jkV.setImageResource(a.h.checkbox_selected);
                SelectMemberUI.this.B(i, true);
              }
            }
          });
          paramView.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(12958);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
              localObject = (SelectMemberUI.c)paramAnonymousView.getTag();
              SelectMemberUI.this.a(paramAnonymousView, ((SelectMemberUI.c)localObject).position, paramAnonymousView.getId());
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(12958);
            }
          });
        }
      }
      SelectMemberUI.a locala;
      for (;;)
      {
        locala = qC(paramInt);
        paramViewGroup.jkW.setTag(Integer.valueOf(paramInt));
        if (locala != null) {
          break label365;
        }
        Log.e("MicroMsg.SelectMemberAdapter", "null == item! position:%s, count:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(getCount()) });
        AppMethodBeat.o(12964);
        return paramView;
        paramViewGroup.jkV.setImageResource(a.h.checkbox_selected);
        SelectMemberUI.this.B(paramInt, true);
        break;
        paramViewGroup = (SelectMemberUI.c)paramView.getTag();
      }
      label365:
      as localas = locala.contact;
      a.b.c((ImageView)paramViewGroup.jkT.getContentView(), localas.field_username);
      String str;
      label512:
      label565:
      int i;
      if (localas.field_verifyFlag != 0) {
        if (az.a.ltt != null)
        {
          localObject = az.a.ltt.uT(localas.field_verifyFlag);
          if (localObject != null)
          {
            localObject = com.tencent.mm.ao.o.US((String)localObject);
            paramViewGroup.jkT.a((Bitmap)localObject, MaskLayout.a.WnW);
            str = b(localas);
            localObject = "";
            if (d.rk(localas.field_type)) {
              localObject = localas.hDq;
            }
            if (Util.isNullOrNil((String)localObject)) {
              break label701;
            }
            paramViewGroup.jkU.setVisibility(0);
            paramViewGroup.jkU.setText(l.b(this.mContext, (CharSequence)localObject, paramViewGroup.jkU.getTextSize()));
            if (!as.bvK(localas.field_username)) {
              break label722;
            }
            ((com.tencent.mm.openim.a.a)h.ae(com.tencent.mm.openim.a.a.class)).a(this.mContext, paramViewGroup.jbe, str, localas.field_openImAppid, localas.field_descWordingId, (int)paramViewGroup.jbe.getTextSize());
            if (!SelectMemberUI.this.ath()) {
              break label819;
            }
            paramViewGroup.jkV.setVisibility(0);
            paramViewGroup.jkW.setVisibility(0);
            if (!SelectMemberUI.this.atj().contains(localas.field_username)) {
              break label756;
            }
            paramViewGroup.jkW.setEnabled(false);
            paramViewGroup.jkV.setEnabled(false);
            localObject = paramViewGroup.jkV;
            if (!ar.isDarkMode()) {
              break label748;
            }
            i = a.h.checkbox_selected_grey_dark;
            label642:
            ((ImageButton)localObject).setImageResource(i);
          }
        }
      }
      for (;;)
      {
        paramViewGroup.jkS = locala;
        paramViewGroup.position = paramInt;
        AppMethodBeat.o(12964);
        return paramView;
        paramViewGroup.jkT.setMaskDrawable(null);
        break;
        paramViewGroup.jkT.setMaskDrawable(null);
        break;
        paramViewGroup.jkT.setMaskDrawable(null);
        break;
        label701:
        paramViewGroup.jkU.setVisibility(8);
        paramViewGroup.jkU.setText("");
        break label512;
        label722:
        paramViewGroup.jbe.setText(l.b(this.mContext, str, paramViewGroup.jbe.getTextSize()));
        break label565;
        label748:
        i = a.h.checkbox_selected_grey;
        break label642;
        label756:
        paramViewGroup.jkW.setEnabled(true);
        paramViewGroup.jkV.setEnabled(true);
        if (SelectMemberUI.this.jkF.contains(locala.contact.field_username))
        {
          paramViewGroup.jkV.setImageResource(a.h.checkbox_selected);
        }
        else
        {
          paramViewGroup.jkV.setImageResource(a.d.checkbox_unselected);
          continue;
          label819:
          paramViewGroup.jkV.setVisibility(8);
          paramViewGroup.jkW.setVisibility(8);
        }
      }
    }
    
    public final SelectMemberUI.a qC(int paramInt)
    {
      AppMethodBeat.i(12963);
      if (this.fMr.size() > paramInt)
      {
        SelectMemberUI.a locala = (SelectMemberUI.a)this.fMr.get(paramInt);
        AppMethodBeat.o(12963);
        return locala;
      }
      AppMethodBeat.o(12963);
      return null;
    }
  }
  
  protected static final class c
  {
    public TextView jbe;
    public SelectMemberUI.a jkS;
    public MaskLayout jkT;
    public TextView jkU;
    public ImageButton jkV;
    public LinearLayout jkW;
    public int position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectMemberUI
 * JD-Core Version:    0.7.0.1
 */