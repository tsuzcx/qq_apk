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
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.c;
import com.tencent.mm.model.z;
import com.tencent.mm.openim.api.e;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cr;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.EllipsizeTextView;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.MaskLayout.a;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import com.tencent.mm.ui.component.UIComponent;
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
  protected int lCR;
  private MMEditText lMy;
  private View lNe;
  private View lNf;
  private SelectMemberScrollBar lNg;
  protected t lNh;
  protected b lNi;
  protected HashSet<String> lNj;
  private boolean lNk;
  private boolean lNl;
  private TextView lNm;
  protected String lyn;
  protected aj lzy;
  private ListView mListView;
  protected String mTitle;
  
  protected static String a(aj paramaj, String paramString)
  {
    AppMethodBeat.i(12976);
    if (paramaj == null)
    {
      AppMethodBeat.o(12976);
      return null;
    }
    paramaj = paramaj.getDisplayName(paramString);
    AppMethodBeat.o(12976);
    return paramaj;
  }
  
  protected void a(View paramView, LinearLayout paramLinearLayout, ImageButton paramImageButton, int paramInt, String paramString)
  {
    AppMethodBeat.i(241646);
    if (aNq().contains(paramString))
    {
      AppMethodBeat.o(241646);
      return;
    }
    if (this.lNj.contains(paramString))
    {
      this.lNj.remove(paramString);
      paramImageButton.setImageResource(a.d.checkbox_unselected);
      paramLinearLayout.setTag(a.e.contact_item_selected, Boolean.FALSE);
      AppMethodBeat.o(241646);
      return;
    }
    this.lNj.add(paramString);
    paramImageButton.setImageResource(a.h.checkbox_selected);
    paramLinearLayout.setTag(a.e.contact_item_selected, Boolean.TRUE);
    AppMethodBeat.o(241646);
  }
  
  public boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    return false;
  }
  
  public boolean aNl()
  {
    return false;
  }
  
  protected void aNn()
  {
    AppMethodBeat.i(12971);
    this.lyn = getIntent().getStringExtra("RoomInfo_Id");
    Log.i("MicroMsg.SelectMemberUI", "[getIntentParams] roomId:%s", new Object[] { this.lyn });
    this.lzy = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Jv(this.lyn);
    this.lCR = getIntent().getIntExtra("from_scene", 0);
    this.mTitle = getIntent().getStringExtra("title");
    this.lNk = getIntent().getBooleanExtra("is_show_owner", true);
    this.lNl = getIntent().getBooleanExtra("is_mulit_select_mode", false);
    this.lNj = new HashSet();
    AppMethodBeat.o(12971);
  }
  
  public boolean aNo()
  {
    return this.lNl;
  }
  
  protected boolean aNp()
  {
    return true;
  }
  
  protected HashSet<String> aNq()
  {
    AppMethodBeat.i(12974);
    HashSet localHashSet = new HashSet();
    AppMethodBeat.o(12974);
    return localHashSet;
  }
  
  protected HashSet<String> aNs()
  {
    AppMethodBeat.i(12973);
    HashSet localHashSet = new HashSet();
    AppMethodBeat.o(12973);
    return localHashSet;
  }
  
  protected boolean aNt()
  {
    return true;
  }
  
  protected BaseAdapter aNu()
  {
    return this.lNi;
  }
  
  protected List<String> aNv()
  {
    AppMethodBeat.i(12975);
    List localList = this.lzy.bHw();
    AppMethodBeat.o(12975);
    return localList;
  }
  
  public final aj aNx()
  {
    return this.lzy;
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    return false;
  }
  
  public final String c(com.tencent.mm.ui.contact.a.a parama)
  {
    return null;
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
    return a.f.lGC;
  }
  
  public final void h(final String paramString, final int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(241665);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(241725);
        if (Util.isNullOrNil(paramString))
        {
          SelectMemberUI.a(SelectMemberUI.this).setAdapter(SelectMemberUI.this.lNi);
          SelectMemberUI.c(SelectMemberUI.this).setVisibility(8);
          AppMethodBeat.o(241725);
          return;
        }
        SelectMemberUI.a(SelectMemberUI.this).setAdapter(SelectMemberUI.this.lNh);
        if (paramInt > 0)
        {
          SelectMemberUI.c(SelectMemberUI.this).setVisibility(8);
          AppMethodBeat.o(241725);
          return;
        }
        SelectMemberUI.c(SelectMemberUI.this).setText(f.a(SelectMemberUI.this.getString(a.i.search_contact_no_result_pre), SelectMemberUI.this.getString(a.i.search_contact_no_result_post), g.c(paramString, paramString)).HsX);
        SelectMemberUI.c(SelectMemberUI.this).setVisibility(0);
        AppMethodBeat.o(241725);
      }
    });
    AppMethodBeat.o(241665);
  }
  
  public void initView()
  {
    AppMethodBeat.i(12972);
    setMMTitle(Util.nullAsNil(this.mTitle));
    this.mListView = ((ListView)findViewById(a.e.fOe));
    this.lNe = findViewById(a.e.lFv);
    this.lNf = findViewById(a.e.lFx);
    this.lNm = ((TextView)findViewById(a.e.empty_tv));
    this.lNi = new b(this, this.lzy, this.lyn, this.lzy.field_roomowner);
    Object localObject = new HashSet();
    if (!aNl()) {
      ((HashSet)localObject).add(z.bAM());
    }
    this.lNh = new t(this, this.lyn, aNo(), (HashSet)localObject);
    this.lNh.afew = this;
    this.mListView.setAdapter(aNu());
    this.lNg = ((SelectMemberScrollBar)findViewById(a.e.fOf));
    this.lNg.setOnScrollBarTouchListener(new VerticalScrollBar.a()
    {
      public final void onScollBarTouch(String paramAnonymousString)
      {
        AppMethodBeat.i(12948);
        if ("↑".equals(paramAnonymousString))
        {
          SelectMemberUI.a(SelectMemberUI.this).setSelection(0);
          AppMethodBeat.o(12948);
          return;
        }
        SelectMemberUI.b localb = SelectMemberUI.this.lNi;
        if (localb.lNs.containsKey(paramAnonymousString)) {}
        for (int i = ((Integer)localb.lNs.get(paramAnonymousString)).intValue();; i = -1)
        {
          if (i != -1) {
            SelectMemberUI.a(SelectMemberUI.this).setSelection(i);
          }
          AppMethodBeat.o(12948);
          return;
        }
      }
    });
    if (aNt()) {
      this.lNg.setVisibility(0);
    }
    for (;;)
    {
      this.lMy = ((MMEditText)findViewById(a.e.fVL));
      this.lMy.addTextChangedListener(new TextWatcher()
      {
        private MTimerHandler lNo;
        
        public final void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(12951);
          this.lNo.stopTimer();
          this.lNo.startTimer(500L);
          AppMethodBeat.o(12951);
        }
      });
      localObject = this.lNi;
      ((b)localObject).lNn.lNf.setVisibility(0);
      com.tencent.mm.kernel.h.baH().postToWorker(new SelectMemberUI.b.1((b)localObject));
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
      if (aNp()) {
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(241724);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousAdapterView);
            localb.cH(paramAnonymousView);
            localb.sc(paramAnonymousInt);
            localb.hB(paramAnonymousLong);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/SelectMemberUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
            if (SelectMemberUI.a(SelectMemberUI.this).getAdapter() == SelectMemberUI.this.lNh) {
              SelectMemberUI.this.onItemClick(paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SelectMemberUI$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(241724);
          }
        });
      }
      AppMethodBeat.o(12972);
      return;
      this.lNg.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12970);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.SelectMemberUI", "[onCreate]");
    aNn();
    initView();
    AppMethodBeat.o(12970);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(241662);
    this.lNh.finish();
    super.onDestroy();
    AppMethodBeat.o(241662);
  }
  
  protected void onItemClick(View paramView, int paramInt, long paramLong) {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(241631);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.chatroom.ui.a.b.class);
    AppMethodBeat.o(241631);
  }
  
  public final class a
  {
    public au contact;
    public int type = 1;
    
    public a(au paramau)
    {
      this.contact = paramau;
    }
  }
  
  public final class b
    extends BaseAdapter
  {
    private List<SelectMemberUI.a> hSb;
    volatile boolean isLoading;
    public String lMG;
    private String lMI;
    private List<SelectMemberUI.a> lMJ;
    public final String lNr;
    HashMap<String, Integer> lNs;
    private String lyn;
    private aj lzy;
    private Context mContext;
    
    public b(Context paramContext, aj paramaj, String paramString1, String paramString2)
    {
      AppMethodBeat.i(12960);
      this.lNr = new String(Character.toChars(91));
      this.lMI = null;
      this.lMJ = new ArrayList(0);
      this.hSb = new ArrayList();
      this.isLoading = false;
      this.lNs = new HashMap();
      this.lzy = paramaj;
      this.lyn = paramString1;
      this.lMI = paramString2;
      this.mContext = paramContext;
      AppMethodBeat.o(12960);
    }
    
    private String b(au paramau)
    {
      AppMethodBeat.i(12965);
      String str1;
      if (!Util.isNullOrNil(paramau.field_conRemark))
      {
        str1 = paramau.field_conRemark;
        if (!Util.isNullOrNil(str1)) {
          break label114;
        }
        str1 = paramau.aSU();
      }
      label114:
      for (;;)
      {
        String str2 = str1;
        if (!d.rs(paramau.field_type))
        {
          paramau = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzB().aMi(paramau.field_username);
          str2 = str1;
          if (paramau != null)
          {
            str2 = str1;
            if (!Util.isNullOrNil(paramau.field_conRemark)) {
              str2 = paramau.field_conRemark;
            }
          }
        }
        AppMethodBeat.o(12965);
        return str2;
        str1 = SelectMemberUI.a(this.lzy, paramau.field_username);
        break;
      }
    }
    
    public final void Dl(String paramString)
    {
      AppMethodBeat.i(12961);
      Log.i("MicroMsg.SelectMemberAdapter", "[setMemberListBySearch]");
      ArrayList localArrayList = new ArrayList();
      if (!Util.isNullOrNil(paramString))
      {
        Iterator localIterator = this.lMJ.iterator();
        while (localIterator.hasNext())
        {
          SelectMemberUI.a locala = (SelectMemberUI.a)localIterator.next();
          if ((locala != null) && (locala.contact != null) && (locala.type == 1))
          {
            Object localObject = locala.contact;
            if ((((az)localObject).field_conRemark != null) && (((az)localObject).field_conRemark.contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((!Util.isNullOrNil(SeeRoomMemberUI.a(this.lzy, ((az)localObject).field_username))) && (SeeRoomMemberUI.a(this.lzy, ((az)localObject).field_username).contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((((au)localObject).aSU() != null) && (((au)localObject).aSU().contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((((au)localObject).aJt() != null) && (((au)localObject).aJt().contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((((au)localObject).aJs() != null) && (((au)localObject).aJs().contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((((az)localObject).field_username != null) && (((az)localObject).field_username.contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if (!d.rs(((az)localObject).field_type))
            {
              localObject = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzB().aMi(((az)localObject).field_username);
              if ((localObject != null) && (((cr)localObject).field_conRemark != null) && (((cr)localObject).field_conRemark.contains(paramString))) {
                localArrayList.add(locala);
              }
            }
          }
        }
        this.hSb = localArrayList;
        AppMethodBeat.o(12961);
        return;
      }
      this.hSb = this.lMJ;
      AppMethodBeat.o(12961);
    }
    
    public final void bv(List<String> paramList)
    {
      AppMethodBeat.i(12966);
      if (paramList == null)
      {
        AppMethodBeat.o(12966);
        return;
      }
      this.hSb.clear();
      int i = 0;
      if (i < paramList.size())
      {
        au localau = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE((String)paramList.get(i));
        if ((SelectMemberUI.this.aNl()) || (!z.Iy(localau.field_username)))
        {
          boolean bool = localau.field_username.equals(this.lMI);
          if (((!bool) || (SelectMemberUI.f(SelectMemberUI.this))) && (!SelectMemberUI.this.aNs().contains(localau.field_username)))
          {
            if ((!bool) || (!SelectMemberUI.f(SelectMemberUI.this))) {
              break label178;
            }
            this.hSb.add(0, new SelectMemberUI.a(SelectMemberUI.this, localau));
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label178:
          this.hSb.add(new SelectMemberUI.a(SelectMemberUI.this, localau));
        }
      }
      Collections.sort(this.hSb, new Comparator() {});
      this.lMJ = this.hSb;
      AppMethodBeat.o(12966);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(12962);
      if ((this.hSb == null) || (this.isLoading))
      {
        AppMethodBeat.o(12962);
        return 0;
      }
      int i = this.hSb.size();
      AppMethodBeat.o(12962);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, final View paramView, final ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(12964);
      Object localObject;
      if (paramView == null)
      {
        paramView = View.inflate(this.mContext, a.f.lGB, null);
        paramViewGroup = new SelectMemberUI.c();
        paramViewGroup.lNC = ((LinearLayout)paramView.findViewById(a.e.item));
        paramViewGroup.lNy = ((MaskLayout)paramView.findViewById(a.e.lFy));
        paramViewGroup.lDe = ((EllipsizeTextView)paramView.findViewById(a.e.lFA));
        paramViewGroup.lDe = ((TextView)paramView.findViewById(a.e.lFA));
        paramViewGroup.lNA = ((ImageButton)paramView.findViewById(a.e.lEn));
        paramViewGroup.lNB = ((LinearLayout)paramView.findViewById(a.e.lEo));
        localObject = (WindowManager)this.mContext.getSystemService("window");
        paramViewGroup.lDe.setMaxWidth(((WindowManager)localObject).getDefaultDisplay().getWidth() * 2 / 3);
        paramViewGroup.lNz = ((TextView)paramView.findViewById(a.e.lFz));
        paramViewGroup.lNz.setMaxWidth(((WindowManager)localObject).getDefaultDisplay().getWidth() * 2 / 3);
        paramView.setTag(paramViewGroup);
        localObject = qF(paramInt);
        if (localObject != null)
        {
          if (SelectMemberUI.this.lNj.contains(((SelectMemberUI.a)localObject).contact.field_username))
          {
            paramViewGroup.lNA.setImageResource(a.d.checkbox_unselected);
            paramViewGroup.lNC.setTag(a.e.contact_item_selected, Boolean.FALSE);
          }
        }
        else
        {
          paramViewGroup.lNA.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(12956);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              paramViewGroup.lNB.performClick();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(12956);
            }
          });
          paramViewGroup.lNB.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(12957);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              int i = ((Integer)paramAnonymousView.getTag()).intValue();
              paramAnonymousView = SelectMemberUI.b.this.qF(i);
              if (paramAnonymousView == null)
              {
                Log.e("MicroMsg.SelectMemberAdapter", "item is null");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(12957);
                return;
              }
              SelectMemberUI.this.a(paramView, paramViewGroup.lNC, paramViewGroup.lNA, i, paramAnonymousView.contact.field_username);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(12957);
            }
          });
          paramView.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(12958);
              Object localObject = new com.tencent.mm.hellhoundlib.b.b();
              ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
              localObject = (SelectMemberUI.c)paramAnonymousView.getTag();
              SelectMemberUI.this.onItemClick(paramAnonymousView, ((SelectMemberUI.c)localObject).position, paramAnonymousView.getId());
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(12958);
            }
          });
        }
      }
      SelectMemberUI.a locala;
      for (;;)
      {
        locala = qF(paramInt);
        paramViewGroup.lNB.setTag(Integer.valueOf(paramInt));
        if (locala != null) {
          break label388;
        }
        Log.e("MicroMsg.SelectMemberAdapter", "null == item! position:%s, count:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(getCount()) });
        AppMethodBeat.o(12964);
        return paramView;
        paramViewGroup.lNA.setImageResource(a.h.checkbox_selected);
        paramViewGroup.lNC.setTag(a.e.contact_item_selected, Boolean.TRUE);
        break;
        paramViewGroup = (SelectMemberUI.c)paramView.getTag();
      }
      label388:
      au localau = locala.contact;
      a.b.g((ImageView)paramViewGroup.lNy.getContentView(), localau.field_username);
      String str;
      label535:
      label588:
      int i;
      if (localau.field_verifyFlag != 0) {
        if (az.a.okR != null)
        {
          localObject = az.a.okR.ve(localau.field_verifyFlag);
          if (localObject != null)
          {
            localObject = com.tencent.mm.an.o.MR((String)localObject);
            paramViewGroup.lNy.a((Bitmap)localObject, MaskLayout.a.adVl);
            str = b(localau);
            localObject = "";
            if (d.rs(localau.field_type)) {
              localObject = localau.kal;
            }
            if (Util.isNullOrNil((String)localObject)) {
              break label724;
            }
            paramViewGroup.lNz.setVisibility(0);
            paramViewGroup.lNz.setText(p.b(this.mContext, (CharSequence)localObject, paramViewGroup.lNz.getTextSize()));
            if (!au.bwO(localau.field_username)) {
              break label745;
            }
            ((e)com.tencent.mm.kernel.h.ax(e.class)).a(this.mContext, paramViewGroup.lDe, str, localau.field_openImAppid, localau.field_descWordingId, (int)paramViewGroup.lDe.getTextSize());
            if (!SelectMemberUI.this.aNo()) {
              break label868;
            }
            paramViewGroup.lNA.setVisibility(0);
            paramViewGroup.lNB.setVisibility(0);
            if (!SelectMemberUI.this.aNq().contains(localau.field_username)) {
              break label779;
            }
            paramViewGroup.lNB.setEnabled(false);
            paramViewGroup.lNA.setEnabled(false);
            localObject = paramViewGroup.lNA;
            if (!aw.isDarkMode()) {
              break label771;
            }
            i = a.h.checkbox_selected_grey_dark;
            label665:
            ((ImageButton)localObject).setImageResource(i);
          }
        }
      }
      for (;;)
      {
        paramViewGroup.lNx = locala;
        paramViewGroup.position = paramInt;
        AppMethodBeat.o(12964);
        return paramView;
        paramViewGroup.lNy.setMaskDrawable(null);
        break;
        paramViewGroup.lNy.setMaskDrawable(null);
        break;
        paramViewGroup.lNy.setMaskDrawable(null);
        break;
        label724:
        paramViewGroup.lNz.setVisibility(8);
        paramViewGroup.lNz.setText("");
        break label535;
        label745:
        paramViewGroup.lDe.setText(p.b(this.mContext, str, paramViewGroup.lDe.getTextSize()));
        break label588;
        label771:
        i = a.h.checkbox_selected_grey;
        break label665;
        label779:
        paramViewGroup.lNB.setEnabled(true);
        paramViewGroup.lNA.setEnabled(true);
        if (SelectMemberUI.this.lNj.contains(locala.contact.field_username))
        {
          paramViewGroup.lNA.setImageResource(a.h.checkbox_selected);
          paramViewGroup.lNC.setTag(a.e.contact_item_selected, Boolean.TRUE);
        }
        else
        {
          paramViewGroup.lNA.setImageResource(a.d.checkbox_unselected);
          paramViewGroup.lNC.setTag(a.e.contact_item_selected, Boolean.FALSE);
          continue;
          label868:
          paramViewGroup.lNA.setVisibility(8);
          paramViewGroup.lNB.setVisibility(8);
        }
      }
    }
    
    public final SelectMemberUI.a qF(int paramInt)
    {
      AppMethodBeat.i(12963);
      if (this.hSb.size() > paramInt)
      {
        SelectMemberUI.a locala = (SelectMemberUI.a)this.hSb.get(paramInt);
        AppMethodBeat.o(12963);
        return locala;
      }
      AppMethodBeat.o(12963);
      return null;
    }
  }
  
  protected static final class c
  {
    public TextView lDe;
    public ImageButton lNA;
    public LinearLayout lNB;
    public LinearLayout lNC;
    public SelectMemberUI.a lNx;
    public MaskLayout lNy;
    public TextView lNz;
    public int position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectMemberUI
 * JD-Core Version:    0.7.0.1
 */