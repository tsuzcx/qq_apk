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
import com.tencent.mm.al.n;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.c;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bz;
import com.tencent.mm.storage.x;
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
  private boolean fAa;
  protected x ftP;
  protected String fvZ;
  protected int fwc;
  private View fzU;
  private View fzV;
  private SelectMemberScrollBar fzW;
  protected b fzX;
  protected HashSet<String> fzY;
  private boolean fzZ;
  private MMEditText fzr;
  private ListView mListView;
  protected String mTitle;
  
  protected static String a(x paramx, String paramString)
  {
    AppMethodBeat.i(12976);
    if (paramx == null)
    {
      AppMethodBeat.o(12976);
      return null;
    }
    paramx = paramx.wk(paramString);
    AppMethodBeat.o(12976);
    return paramx;
  }
  
  public boolean WM()
  {
    return false;
  }
  
  protected void WQ()
  {
    AppMethodBeat.i(12971);
    this.fvZ = getIntent().getStringExtra("RoomInfo_Id");
    ac.i("MicroMsg.SelectMemberUI", "[getIntentParams] roomId:%s", new Object[] { this.fvZ });
    this.ftP = ((c)g.ab(c.class)).awK().xO(this.fvZ);
    this.fwc = getIntent().getIntExtra("from_scene", 0);
    this.mTitle = getIntent().getStringExtra("title");
    this.fzZ = getIntent().getBooleanExtra("is_show_owner", true);
    this.fAa = getIntent().getBooleanExtra("is_mulit_select_mode", false);
    this.fzY = new HashSet();
    AppMethodBeat.o(12971);
  }
  
  public boolean WR()
  {
    return this.fAa;
  }
  
  protected HashSet<String> WS()
  {
    AppMethodBeat.i(12974);
    HashSet localHashSet = new HashSet();
    AppMethodBeat.o(12974);
    return localHashSet;
  }
  
  protected HashSet<String> WU()
  {
    AppMethodBeat.i(12973);
    HashSet localHashSet = new HashSet();
    AppMethodBeat.o(12973);
    return localHashSet;
  }
  
  protected boolean WV()
  {
    return true;
  }
  
  protected BaseAdapter WW()
  {
    return this.fzX;
  }
  
  protected List<String> WX()
  {
    AppMethodBeat.i(12975);
    List localList = this.ftP.aDl();
    AppMethodBeat.o(12975);
    return localList;
  }
  
  public final x WZ()
  {
    return this.ftP;
  }
  
  protected void a(View paramView, int paramInt, long paramLong) {}
  
  public int getLayoutId()
  {
    return 2131495352;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12972);
    setMMTitle(bs.nullAsNil(this.mTitle));
    this.mListView = ((ListView)findViewById(2131302228));
    this.fzU = findViewById(2131304525);
    this.fzV = findViewById(2131304526);
    this.fzX = new b(this, this.ftP, this.fvZ, this.ftP.field_roomowner);
    this.mListView.setAdapter(WW());
    this.fzW = ((SelectMemberScrollBar)findViewById(2131302231));
    this.fzW.setOnScrollBarTouchListener(new VerticalScrollBar.a()
    {
      public final void sn(String paramAnonymousString)
      {
        AppMethodBeat.i(12948);
        if ("↑".equals(paramAnonymousString))
        {
          SelectMemberUI.a(SelectMemberUI.this).setSelection(0);
          AppMethodBeat.o(12948);
          return;
        }
        SelectMemberUI.b localb = SelectMemberUI.this.fzX;
        if (localb.fAf.containsKey(paramAnonymousString)) {}
        for (int i = ((Integer)localb.fAf.get(paramAnonymousString)).intValue();; i = -1)
        {
          if (i != -1) {
            SelectMemberUI.a(SelectMemberUI.this).setSelection(i);
          }
          AppMethodBeat.o(12948);
          return;
        }
      }
    });
    if (WV()) {
      this.fzW.setVisibility(0);
    }
    for (;;)
    {
      this.fzr = ((MMEditText)findViewById(2131304523));
      this.fzr.addTextChangedListener(new TextWatcher()
      {
        private au fAc;
        
        public final void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(12951);
          this.fAc.stopTimer();
          this.fAc.au(500L, 500L);
          AppMethodBeat.o(12951);
        }
      });
      b localb = this.fzX;
      localb.fAb.fzV.setVisibility(0);
      g.agU().az(new SelectMemberUI.b.1(localb));
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
      this.fzW.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12970);
    super.onCreate(paramBundle);
    ac.i("MicroMsg.SelectMemberUI", "[onCreate]");
    WQ();
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
    public ai contact;
    public int type = 1;
    
    public a(ai paramai)
    {
      this.contact = paramai;
    }
  }
  
  public final class b
    extends BaseAdapter
  {
    private List<SelectMemberUI.a> dom;
    public final String fAe;
    HashMap<String, Integer> fAf;
    private x ftP;
    private String fvZ;
    private List<SelectMemberUI.a> fzA;
    public String fzx;
    private String fzz;
    volatile boolean isLoading;
    private Context mContext;
    
    public b(Context paramContext, x paramx, String paramString1, String paramString2)
    {
      AppMethodBeat.i(12960);
      this.fAe = new String(Character.toChars(91));
      this.fzz = null;
      this.fzA = new ArrayList(0);
      this.dom = new ArrayList();
      this.isLoading = false;
      this.fAf = new HashMap();
      this.ftP = paramx;
      this.fvZ = paramString1;
      this.fzz = paramString2;
      this.mContext = paramContext;
      AppMethodBeat.o(12960);
    }
    
    private String b(ai paramai)
    {
      AppMethodBeat.i(12965);
      String str1;
      if (!bs.isNullOrNil(paramai.field_conRemark))
      {
        str1 = paramai.field_conRemark;
        if (!bs.isNullOrNil(str1)) {
          break label114;
        }
        str1 = paramai.aaR();
      }
      label114:
      for (;;)
      {
        String str2 = str1;
        if (!com.tencent.mm.n.b.ln(paramai.field_type))
        {
          paramai = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awC().alK(paramai.field_username);
          str2 = str1;
          if (paramai != null)
          {
            str2 = str1;
            if (!bs.isNullOrNil(paramai.field_conRemark)) {
              str2 = paramai.field_conRemark;
            }
          }
        }
        AppMethodBeat.o(12965);
        return str2;
        str1 = SelectMemberUI.a(this.ftP, paramai.field_username);
        break;
      }
    }
    
    public final void R(List<String> paramList)
    {
      AppMethodBeat.i(12966);
      if (paramList == null)
      {
        AppMethodBeat.o(12966);
        return;
      }
      this.dom.clear();
      int i = 0;
      if (i < paramList.size())
      {
        ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt((String)paramList.get(i));
        if ((SelectMemberUI.this.WM()) || (!u.wh(localai.field_username)))
        {
          boolean bool = localai.field_username.equals(this.fzz);
          if (((!bool) || (SelectMemberUI.e(SelectMemberUI.this))) && (!SelectMemberUI.this.WU().contains(localai.field_username)))
          {
            if ((!bool) || (!SelectMemberUI.e(SelectMemberUI.this))) {
              break label178;
            }
            this.dom.add(0, new SelectMemberUI.a(SelectMemberUI.this, localai));
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label178:
          this.dom.add(new SelectMemberUI.a(SelectMemberUI.this, localai));
        }
      }
      Collections.sort(this.dom, new Comparator() {});
      this.fzA = this.dom;
      AppMethodBeat.o(12966);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(12962);
      if ((this.dom == null) || (this.isLoading))
      {
        AppMethodBeat.o(12962);
        return 0;
      }
      int i = this.dom.size();
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
        paramViewGroup.fAk = ((MaskLayout)paramView.findViewById(2131304528));
        paramViewGroup.fwp = ((EllipsizeTextView)paramView.findViewById(2131304530));
        paramViewGroup.fwp = ((TextView)paramView.findViewById(2131304530));
        paramViewGroup.fAm = ((ImageButton)paramView.findViewById(2131297595));
        paramViewGroup.fAn = ((LinearLayout)paramView.findViewById(2131297596));
        localObject = (WindowManager)this.mContext.getSystemService("window");
        paramViewGroup.fwp.setMaxWidth(((WindowManager)localObject).getDefaultDisplay().getWidth() * 2 / 3);
        paramViewGroup.fAl = ((TextView)paramView.findViewById(2131304529));
        paramViewGroup.fAl.setMaxWidth(((WindowManager)localObject).getDefaultDisplay().getWidth() * 2 / 3);
        paramView.setTag(paramViewGroup);
        paramViewGroup.fAm.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(12956);
            paramViewGroup.fAn.performClick();
            AppMethodBeat.o(12956);
          }
        });
        paramViewGroup.fAn.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(12957);
            int i = ((Integer)paramAnonymousView.getTag()).intValue();
            paramAnonymousView = SelectMemberUI.b.this.kK(i);
            if (paramAnonymousView == null)
            {
              ac.e("MicroMsg.SelectMemberAdapter", "item is null");
              AppMethodBeat.o(12957);
              return;
            }
            if (SelectMemberUI.this.WS().contains(paramAnonymousView.contact.field_username))
            {
              AppMethodBeat.o(12957);
              return;
            }
            if (SelectMemberUI.this.fzY.contains(paramAnonymousView.contact.field_username))
            {
              SelectMemberUI.this.fzY.remove(paramAnonymousView.contact.field_username);
              paramViewGroup.fAm.setImageResource(2131231750);
              SelectMemberUI.this.v(i, false);
              AppMethodBeat.o(12957);
              return;
            }
            SelectMemberUI.this.fzY.add(paramAnonymousView.contact.field_username);
            paramViewGroup.fAm.setImageResource(2131689936);
            SelectMemberUI.this.v(i, true);
            AppMethodBeat.o(12957);
          }
        });
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(12958);
            SelectMemberUI.c localc = (SelectMemberUI.c)paramAnonymousView.getTag();
            SelectMemberUI.this.a(paramAnonymousView, localc.position, paramAnonymousView.getId());
            AppMethodBeat.o(12958);
          }
        });
      }
      SelectMemberUI.a locala;
      for (;;)
      {
        locala = kK(paramInt);
        paramViewGroup.fAn.setTag(Integer.valueOf(paramInt));
        if (locala != null) {
          break;
        }
        ac.e("MicroMsg.SelectMemberAdapter", "null == item! position:%s, count:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(getCount()) });
        AppMethodBeat.o(12964);
        return paramView;
        paramViewGroup = (SelectMemberUI.c)paramView.getTag();
      }
      ai localai = locala.contact;
      a.b.c((ImageView)paramViewGroup.fAk.getContentView(), localai.field_username);
      String str;
      label439:
      label492:
      int i;
      if (localai.field_verifyFlag != 0) {
        if (ar.a.hny != null)
        {
          localObject = ar.a.hny.nS(localai.field_verifyFlag);
          if (localObject != null)
          {
            localObject = n.Bh((String)localObject);
            paramViewGroup.fAk.a((Bitmap)localObject, MaskLayout.a.HBk);
            str = b(localai);
            localObject = "";
            if (com.tencent.mm.n.b.ln(localai.field_type)) {
              localObject = localai.eyf;
            }
            if (bs.isNullOrNil((String)localObject)) {
              break label628;
            }
            paramViewGroup.fAl.setVisibility(0);
            paramViewGroup.fAl.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, (CharSequence)localObject, paramViewGroup.fAl.getTextSize()));
            if (!ai.aNc(localai.field_username)) {
              break label649;
            }
            ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).a(this.mContext, paramViewGroup.fwp, str, localai.field_openImAppid, localai.field_descWordingId, (int)paramViewGroup.fwp.getTextSize());
            if (!SelectMemberUI.this.WR()) {
              break label746;
            }
            paramViewGroup.fAm.setVisibility(0);
            paramViewGroup.fAn.setVisibility(0);
            if (!SelectMemberUI.this.WS().contains(localai.field_username)) {
              break label683;
            }
            paramViewGroup.fAn.setEnabled(false);
            paramViewGroup.fAm.setEnabled(false);
            localObject = paramViewGroup.fAm;
            if (!com.tencent.mm.ui.aj.DT()) {
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
        paramViewGroup.fAj = locala;
        paramViewGroup.position = paramInt;
        AppMethodBeat.o(12964);
        return paramView;
        paramViewGroup.fAk.setMaskDrawable(null);
        break;
        paramViewGroup.fAk.setMaskDrawable(null);
        break;
        paramViewGroup.fAk.setMaskDrawable(null);
        break;
        label628:
        paramViewGroup.fAl.setVisibility(8);
        paramViewGroup.fAl.setText("");
        break label439;
        label649:
        paramViewGroup.fwp.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, str, paramViewGroup.fwp.getTextSize()));
        break label492;
        label675:
        i = 2131689938;
        break label569;
        label683:
        paramViewGroup.fAn.setEnabled(true);
        paramViewGroup.fAm.setEnabled(true);
        if (SelectMemberUI.this.fzY.contains(locala.contact.field_username))
        {
          paramViewGroup.fAm.setImageResource(2131689936);
        }
        else
        {
          paramViewGroup.fAm.setImageResource(2131231750);
          continue;
          label746:
          paramViewGroup.fAm.setVisibility(8);
          paramViewGroup.fAn.setVisibility(8);
        }
      }
    }
    
    public final SelectMemberUI.a kK(int paramInt)
    {
      AppMethodBeat.i(12963);
      if (this.dom.size() > paramInt)
      {
        SelectMemberUI.a locala = (SelectMemberUI.a)this.dom.get(paramInt);
        AppMethodBeat.o(12963);
        return locala;
      }
      AppMethodBeat.o(12963);
      return null;
    }
    
    public final void sl(String paramString)
    {
      AppMethodBeat.i(12961);
      ac.i("MicroMsg.SelectMemberAdapter", "[setMemberListBySearch]");
      ArrayList localArrayList = new ArrayList();
      if (!bs.isNullOrNil(paramString))
      {
        Iterator localIterator = this.fzA.iterator();
        while (localIterator.hasNext())
        {
          SelectMemberUI.a locala = (SelectMemberUI.a)localIterator.next();
          if ((locala != null) && (locala.contact != null) && (locala.type == 1))
          {
            Object localObject = locala.contact;
            if ((((av)localObject).field_conRemark != null) && (((av)localObject).field_conRemark.contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((!bs.isNullOrNil(SeeRoomMemberUI.a(this.ftP, ((av)localObject).field_username))) && (SeeRoomMemberUI.a(this.ftP, ((av)localObject).field_username).contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((((ai)localObject).aaR() != null) && (((ai)localObject).aaR().contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((((ai)localObject).To() != null) && (((ai)localObject).To().contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((((ai)localObject).Tl() != null) && (((ai)localObject).Tl().contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((((av)localObject).field_username != null) && (((av)localObject).field_username.contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if (!com.tencent.mm.n.b.ln(((av)localObject).field_type))
            {
              localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awC().alK(((av)localObject).field_username);
              if ((localObject != null) && (((bz)localObject).field_conRemark != null) && (((bz)localObject).field_conRemark.contains(paramString))) {
                localArrayList.add(locala);
              }
            }
          }
        }
        this.dom = localArrayList;
        AppMethodBeat.o(12961);
        return;
      }
      this.dom = this.fzA;
      AppMethodBeat.o(12961);
    }
  }
  
  protected static final class c
  {
    public SelectMemberUI.a fAj;
    public MaskLayout fAk;
    public TextView fAl;
    public ImageButton fAm;
    public LinearLayout fAn;
    public TextView fwp;
    public int position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectMemberUI
 * JD-Core Version:    0.7.0.1
 */