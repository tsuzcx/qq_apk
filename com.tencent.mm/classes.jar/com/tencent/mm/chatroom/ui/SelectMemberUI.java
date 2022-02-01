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
import com.tencent.mm.al.o;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.c;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.cg;
import com.tencent.mm.ui.MMActivity;
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
  protected ac fNS;
  protected String fRo;
  protected int fRv;
  private MMEditText fUK;
  private View fVq;
  private View fVr;
  private SelectMemberScrollBar fVs;
  protected b fVt;
  protected HashSet<String> fVu;
  private boolean fVv;
  private boolean fVw;
  private ListView mListView;
  protected String mTitle;
  
  protected static String a(ac paramac, String paramString)
  {
    AppMethodBeat.i(12976);
    if (paramac == null)
    {
      AppMethodBeat.o(12976);
      return null;
    }
    paramac = paramac.zP(paramString);
    AppMethodBeat.o(12976);
    return paramac;
  }
  
  public final ac ZB()
  {
    return this.fNS;
  }
  
  public boolean Zp()
  {
    return false;
  }
  
  protected void Zs()
  {
    AppMethodBeat.i(12971);
    this.fRo = getIntent().getStringExtra("RoomInfo_Id");
    ae.i("MicroMsg.SelectMemberUI", "[getIntentParams] roomId:%s", new Object[] { this.fRo });
    this.fNS = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().By(this.fRo);
    this.fRv = getIntent().getIntExtra("from_scene", 0);
    this.mTitle = getIntent().getStringExtra("title");
    this.fVv = getIntent().getBooleanExtra("is_show_owner", true);
    this.fVw = getIntent().getBooleanExtra("is_mulit_select_mode", false);
    this.fVu = new HashSet();
    AppMethodBeat.o(12971);
  }
  
  public boolean Zt()
  {
    return this.fVw;
  }
  
  protected HashSet<String> Zu()
  {
    AppMethodBeat.i(12974);
    HashSet localHashSet = new HashSet();
    AppMethodBeat.o(12974);
    return localHashSet;
  }
  
  protected HashSet<String> Zw()
  {
    AppMethodBeat.i(12973);
    HashSet localHashSet = new HashSet();
    AppMethodBeat.o(12973);
    return localHashSet;
  }
  
  protected boolean Zx()
  {
    return true;
  }
  
  protected BaseAdapter Zy()
  {
    return this.fVt;
  }
  
  protected List<String> Zz()
  {
    AppMethodBeat.i(12975);
    List localList = this.fNS.aGE();
    AppMethodBeat.o(12975);
    return localList;
  }
  
  protected void a(View paramView, int paramInt, long paramLong) {}
  
  public int getLayoutId()
  {
    return 2131495352;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12972);
    setMMTitle(bu.nullAsNil(this.mTitle));
    this.mListView = ((ListView)findViewById(2131302228));
    this.fVq = findViewById(2131304525);
    this.fVr = findViewById(2131304526);
    this.fVt = new b(this, this.fNS, this.fRo, this.fNS.field_roomowner);
    this.mListView.setAdapter(Zy());
    this.fVs = ((SelectMemberScrollBar)findViewById(2131302231));
    this.fVs.setOnScrollBarTouchListener(new VerticalScrollBar.a()
    {
      public final void vy(String paramAnonymousString)
      {
        AppMethodBeat.i(12948);
        if ("↑".equals(paramAnonymousString))
        {
          SelectMemberUI.a(SelectMemberUI.this).setSelection(0);
          AppMethodBeat.o(12948);
          return;
        }
        SelectMemberUI.b localb = SelectMemberUI.this.fVt;
        if (localb.fVB.containsKey(paramAnonymousString)) {}
        for (int i = ((Integer)localb.fVB.get(paramAnonymousString)).intValue();; i = -1)
        {
          if (i != -1) {
            SelectMemberUI.a(SelectMemberUI.this).setSelection(i);
          }
          AppMethodBeat.o(12948);
          return;
        }
      }
    });
    if (Zx()) {
      this.fVs.setVisibility(0);
    }
    for (;;)
    {
      this.fUK = ((MMEditText)findViewById(2131304523));
      this.fUK.addTextChangedListener(new TextWatcher()
      {
        private com.tencent.mm.sdk.platformtools.aw fVy;
        
        public final void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(12951);
          this.fVy.stopTimer();
          this.fVy.ay(500L, 500L);
          AppMethodBeat.o(12951);
        }
      });
      b localb = this.fVt;
      localb.fVx.fVr.setVisibility(0);
      g.ajU().aw(new SelectMemberUI.b.1(localb));
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
      this.fVs.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12970);
    super.onCreate(paramBundle);
    ae.i("MicroMsg.SelectMemberUI", "[onCreate]");
    Zs();
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
    public an contact;
    public int type = 1;
    
    public a(an paraman)
    {
      this.contact = paraman;
    }
  }
  
  public final class b
    extends BaseAdapter
  {
    private List<SelectMemberUI.a> dBf;
    private ac fNS;
    private String fRo;
    public String fUS;
    private String fUU;
    private List<SelectMemberUI.a> fUV;
    public final String fVA;
    HashMap<String, Integer> fVB;
    volatile boolean isLoading;
    private Context mContext;
    
    public b(Context paramContext, ac paramac, String paramString1, String paramString2)
    {
      AppMethodBeat.i(12960);
      this.fVA = new String(Character.toChars(91));
      this.fUU = null;
      this.fUV = new ArrayList(0);
      this.dBf = new ArrayList();
      this.isLoading = false;
      this.fVB = new HashMap();
      this.fNS = paramac;
      this.fRo = paramString1;
      this.fUU = paramString2;
      this.mContext = paramContext;
      AppMethodBeat.o(12960);
    }
    
    private String b(an paraman)
    {
      AppMethodBeat.i(12965);
      String str1;
      if (!bu.isNullOrNil(paraman.field_conRemark))
      {
        str1 = paraman.field_conRemark;
        if (!bu.isNullOrNil(str1)) {
          break label114;
        }
        str1 = paraman.adF();
      }
      label114:
      for (;;)
      {
        String str2 = str1;
        if (!com.tencent.mm.contact.c.lO(paraman.field_type))
        {
          paraman = ((l)g.ab(l.class)).azG().arE(paraman.field_username);
          str2 = str1;
          if (paraman != null)
          {
            str2 = str1;
            if (!bu.isNullOrNil(paraman.field_conRemark)) {
              str2 = paraman.field_conRemark;
            }
          }
        }
        AppMethodBeat.o(12965);
        return str2;
        str1 = SelectMemberUI.a(this.fNS, paraman.field_username);
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
      this.dBf.clear();
      int i = 0;
      if (i < paramList.size())
      {
        an localan = ((l)g.ab(l.class)).azF().BH((String)paramList.get(i));
        if ((SelectMemberUI.this.Zp()) || (!v.zK(localan.field_username)))
        {
          boolean bool = localan.field_username.equals(this.fUU);
          if (((!bool) || (SelectMemberUI.e(SelectMemberUI.this))) && (!SelectMemberUI.this.Zw().contains(localan.field_username)))
          {
            if ((!bool) || (!SelectMemberUI.e(SelectMemberUI.this))) {
              break label178;
            }
            this.dBf.add(0, new SelectMemberUI.a(SelectMemberUI.this, localan));
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label178:
          this.dBf.add(new SelectMemberUI.a(SelectMemberUI.this, localan));
        }
      }
      Collections.sort(this.dBf, new Comparator() {});
      this.fUV = this.dBf;
      AppMethodBeat.o(12966);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(12962);
      if ((this.dBf == null) || (this.isLoading))
      {
        AppMethodBeat.o(12962);
        return 0;
      }
      int i = this.dBf.size();
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
        paramViewGroup.fVG = ((MaskLayout)paramView.findViewById(2131304528));
        paramViewGroup.fRI = ((EllipsizeTextView)paramView.findViewById(2131304530));
        paramViewGroup.fRI = ((TextView)paramView.findViewById(2131304530));
        paramViewGroup.fVI = ((ImageButton)paramView.findViewById(2131297595));
        paramViewGroup.fVJ = ((LinearLayout)paramView.findViewById(2131297596));
        localObject = (WindowManager)this.mContext.getSystemService("window");
        paramViewGroup.fRI.setMaxWidth(((WindowManager)localObject).getDefaultDisplay().getWidth() * 2 / 3);
        paramViewGroup.fVH = ((TextView)paramView.findViewById(2131304529));
        paramViewGroup.fVH.setMaxWidth(((WindowManager)localObject).getDefaultDisplay().getWidth() * 2 / 3);
        paramView.setTag(paramViewGroup);
        paramViewGroup.fVI.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(12956);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            paramViewGroup.fVJ.performClick();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(12956);
          }
        });
        paramViewGroup.fVJ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(12957);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            int i = ((Integer)paramAnonymousView.getTag()).intValue();
            paramAnonymousView = SelectMemberUI.b.this.ll(i);
            if (paramAnonymousView == null)
            {
              ae.e("MicroMsg.SelectMemberAdapter", "item is null");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(12957);
              return;
            }
            if (SelectMemberUI.this.Zu().contains(paramAnonymousView.contact.field_username))
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(12957);
              return;
            }
            if (SelectMemberUI.this.fVu.contains(paramAnonymousView.contact.field_username))
            {
              SelectMemberUI.this.fVu.remove(paramAnonymousView.contact.field_username);
              paramViewGroup.fVI.setImageResource(2131231750);
              SelectMemberUI.this.v(i, false);
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(12957);
              return;
              SelectMemberUI.this.fVu.add(paramAnonymousView.contact.field_username);
              paramViewGroup.fVI.setImageResource(2131689936);
              SelectMemberUI.this.v(i, true);
            }
          }
        });
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(12958);
            Object localObject = new b();
            ((b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
            localObject = (SelectMemberUI.c)paramAnonymousView.getTag();
            SelectMemberUI.this.a(paramAnonymousView, ((SelectMemberUI.c)localObject).position, paramAnonymousView.getId());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(12958);
          }
        });
      }
      SelectMemberUI.a locala;
      for (;;)
      {
        locala = ll(paramInt);
        paramViewGroup.fVJ.setTag(Integer.valueOf(paramInt));
        if (locala != null) {
          break;
        }
        ae.e("MicroMsg.SelectMemberAdapter", "null == item! position:%s, count:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(getCount()) });
        AppMethodBeat.o(12964);
        return paramView;
        paramViewGroup = (SelectMemberUI.c)paramView.getTag();
      }
      an localan = locala.contact;
      a.b.c((ImageView)paramViewGroup.fVG.getContentView(), localan.field_username);
      String str;
      label439:
      label492:
      int i;
      if (localan.field_verifyFlag != 0) {
        if (au.a.hII != null)
        {
          localObject = au.a.hII.ov(localan.field_verifyFlag);
          if (localObject != null)
          {
            localObject = o.EI((String)localObject);
            paramViewGroup.fVG.a((Bitmap)localObject, MaskLayout.a.JJQ);
            str = b(localan);
            localObject = "";
            if (com.tencent.mm.contact.c.lO(localan.field_type)) {
              localObject = localan.eRo;
            }
            if (bu.isNullOrNil((String)localObject)) {
              break label628;
            }
            paramViewGroup.fVH.setVisibility(0);
            paramViewGroup.fVH.setText(k.b(this.mContext, (CharSequence)localObject, paramViewGroup.fVH.getTextSize()));
            if (!an.aUq(localan.field_username)) {
              break label649;
            }
            ((com.tencent.mm.openim.a.a)g.ab(com.tencent.mm.openim.a.a.class)).a(this.mContext, paramViewGroup.fRI, str, localan.field_openImAppid, localan.field_descWordingId, (int)paramViewGroup.fRI.getTextSize());
            if (!SelectMemberUI.this.Zt()) {
              break label746;
            }
            paramViewGroup.fVI.setVisibility(0);
            paramViewGroup.fVJ.setVisibility(0);
            if (!SelectMemberUI.this.Zu().contains(localan.field_username)) {
              break label683;
            }
            paramViewGroup.fVJ.setEnabled(false);
            paramViewGroup.fVI.setEnabled(false);
            localObject = paramViewGroup.fVI;
            if (!com.tencent.mm.ui.al.isDarkMode()) {
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
        paramViewGroup.fVF = locala;
        paramViewGroup.position = paramInt;
        AppMethodBeat.o(12964);
        return paramView;
        paramViewGroup.fVG.setMaskDrawable(null);
        break;
        paramViewGroup.fVG.setMaskDrawable(null);
        break;
        paramViewGroup.fVG.setMaskDrawable(null);
        break;
        label628:
        paramViewGroup.fVH.setVisibility(8);
        paramViewGroup.fVH.setText("");
        break label439;
        label649:
        paramViewGroup.fRI.setText(k.b(this.mContext, str, paramViewGroup.fRI.getTextSize()));
        break label492;
        label675:
        i = 2131689938;
        break label569;
        label683:
        paramViewGroup.fVJ.setEnabled(true);
        paramViewGroup.fVI.setEnabled(true);
        if (SelectMemberUI.this.fVu.contains(locala.contact.field_username))
        {
          paramViewGroup.fVI.setImageResource(2131689936);
        }
        else
        {
          paramViewGroup.fVI.setImageResource(2131231750);
          continue;
          label746:
          paramViewGroup.fVI.setVisibility(8);
          paramViewGroup.fVJ.setVisibility(8);
        }
      }
    }
    
    public final SelectMemberUI.a ll(int paramInt)
    {
      AppMethodBeat.i(12963);
      if (this.dBf.size() > paramInt)
      {
        SelectMemberUI.a locala = (SelectMemberUI.a)this.dBf.get(paramInt);
        AppMethodBeat.o(12963);
        return locala;
      }
      AppMethodBeat.o(12963);
      return null;
    }
    
    public final void vw(String paramString)
    {
      AppMethodBeat.i(12961);
      ae.i("MicroMsg.SelectMemberAdapter", "[setMemberListBySearch]");
      ArrayList localArrayList = new ArrayList();
      if (!bu.isNullOrNil(paramString))
      {
        Iterator localIterator = this.fUV.iterator();
        while (localIterator.hasNext())
        {
          SelectMemberUI.a locala = (SelectMemberUI.a)localIterator.next();
          if ((locala != null) && (locala.contact != null) && (locala.type == 1))
          {
            Object localObject = locala.contact;
            if ((((com.tencent.mm.g.c.aw)localObject).field_conRemark != null) && (((com.tencent.mm.g.c.aw)localObject).field_conRemark.contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((!bu.isNullOrNil(SeeRoomMemberUI.a(this.fNS, ((com.tencent.mm.g.c.aw)localObject).field_username))) && (SeeRoomMemberUI.a(this.fNS, ((com.tencent.mm.g.c.aw)localObject).field_username).contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((((an)localObject).adF() != null) && (((an)localObject).adF().contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((((an)localObject).VL() != null) && (((an)localObject).VL().contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((((an)localObject).VI() != null) && (((an)localObject).VI().contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((((com.tencent.mm.g.c.aw)localObject).field_username != null) && (((com.tencent.mm.g.c.aw)localObject).field_username.contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if (!com.tencent.mm.contact.c.lO(((com.tencent.mm.g.c.aw)localObject).field_type))
            {
              localObject = ((l)g.ab(l.class)).azG().arE(((com.tencent.mm.g.c.aw)localObject).field_username);
              if ((localObject != null) && (((cg)localObject).field_conRemark != null) && (((cg)localObject).field_conRemark.contains(paramString))) {
                localArrayList.add(locala);
              }
            }
          }
        }
        this.dBf = localArrayList;
        AppMethodBeat.o(12961);
        return;
      }
      this.dBf = this.fUV;
      AppMethodBeat.o(12961);
    }
  }
  
  protected static final class c
  {
    public TextView fRI;
    public SelectMemberUI.a fVF;
    public MaskLayout fVG;
    public TextView fVH;
    public ImageButton fVI;
    public LinearLayout fVJ;
    public int position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectMemberUI
 * JD-Core Version:    0.7.0.1
 */