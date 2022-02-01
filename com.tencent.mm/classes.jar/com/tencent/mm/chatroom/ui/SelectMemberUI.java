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
import com.tencent.mm.am.n;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.c;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;
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
  protected w fql;
  protected String fss;
  protected int fsv;
  private MMEditText fvK;
  private View fwn;
  private View fwo;
  private SelectMemberScrollBar fwp;
  protected b fwq;
  protected HashSet<String> fwr;
  private boolean fws;
  private boolean fwt;
  private ListView mListView;
  protected String mTitle;
  
  protected static String a(w paramw, String paramString)
  {
    AppMethodBeat.i(12976);
    if (paramw == null)
    {
      AppMethodBeat.o(12976);
      return null;
    }
    paramw = paramw.sh(paramString);
    AppMethodBeat.o(12976);
    return paramw;
  }
  
  public boolean VO()
  {
    return false;
  }
  
  protected void VS()
  {
    AppMethodBeat.i(12971);
    this.fss = getIntent().getStringExtra("RoomInfo_Id");
    ad.i("MicroMsg.SelectMemberUI", "[getIntentParams] roomId:%s", new Object[] { this.fss });
    this.fql = ((c)g.ab(c.class)).apV().tI(this.fss);
    this.fsv = getIntent().getIntExtra("from_scene", 0);
    this.mTitle = getIntent().getStringExtra("title");
    this.fws = getIntent().getBooleanExtra("is_show_owner", true);
    this.fwt = getIntent().getBooleanExtra("is_mulit_select_mode", false);
    this.fwr = new HashSet();
    AppMethodBeat.o(12971);
  }
  
  public boolean VT()
  {
    return this.fwt;
  }
  
  protected HashSet<String> VU()
  {
    AppMethodBeat.i(12974);
    HashSet localHashSet = new HashSet();
    AppMethodBeat.o(12974);
    return localHashSet;
  }
  
  protected HashSet<String> VW()
  {
    AppMethodBeat.i(12973);
    HashSet localHashSet = new HashSet();
    AppMethodBeat.o(12973);
    return localHashSet;
  }
  
  protected boolean VX()
  {
    return true;
  }
  
  protected BaseAdapter VY()
  {
    return this.fwq;
  }
  
  protected List<String> VZ()
  {
    AppMethodBeat.i(12975);
    List localList = this.fql.awt();
    AppMethodBeat.o(12975);
    return localList;
  }
  
  public final w Wb()
  {
    return this.fql;
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
    this.fwn = findViewById(2131304525);
    this.fwo = findViewById(2131304526);
    this.fwq = new b(this, this.fql, this.fss, this.fql.field_roomowner);
    this.mListView.setAdapter(VY());
    this.fwp = ((SelectMemberScrollBar)findViewById(2131302231));
    this.fwp.setOnScrollBarTouchListener(new VerticalScrollBar.a()
    {
      public final void pb(String paramAnonymousString)
      {
        AppMethodBeat.i(12948);
        if ("↑".equals(paramAnonymousString))
        {
          SelectMemberUI.a(SelectMemberUI.this).setSelection(0);
          AppMethodBeat.o(12948);
          return;
        }
        SelectMemberUI.b localb = SelectMemberUI.this.fwq;
        if (localb.fwy.containsKey(paramAnonymousString)) {}
        for (int i = ((Integer)localb.fwy.get(paramAnonymousString)).intValue();; i = -1)
        {
          if (i != -1) {
            SelectMemberUI.a(SelectMemberUI.this).setSelection(i);
          }
          AppMethodBeat.o(12948);
          return;
        }
      }
    });
    if (VX()) {
      this.fwp.setVisibility(0);
    }
    for (;;)
    {
      this.fvK = ((MMEditText)findViewById(2131304523));
      this.fvK.addTextChangedListener(new TextWatcher()
      {
        private av fwv;
        
        public final void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(12951);
          this.fwv.stopTimer();
          this.fwv.av(500L, 500L);
          AppMethodBeat.o(12951);
        }
      });
      b localb = this.fwq;
      localb.fwu.fwo.setVisibility(0);
      g.afE().ax(new SelectMemberUI.b.1(localb));
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
      this.fwp.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12970);
    super.onCreate(paramBundle);
    ad.i("MicroMsg.SelectMemberUI", "[onCreate]");
    VS();
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
    public af contact;
    public int type = 1;
    
    public a(af paramaf)
    {
      this.contact = paramaf;
    }
  }
  
  public final class b
    extends BaseAdapter
  {
    private List<SelectMemberUI.a> dqB;
    private w fql;
    private String fss;
    public String fvQ;
    private String fvS;
    private List<SelectMemberUI.a> fvT;
    public final String fwx;
    HashMap<String, Integer> fwy;
    volatile boolean isLoading;
    private Context mContext;
    
    public b(Context paramContext, w paramw, String paramString1, String paramString2)
    {
      AppMethodBeat.i(12960);
      this.fwx = new String(Character.toChars(91));
      this.fvS = null;
      this.fvT = new ArrayList(0);
      this.dqB = new ArrayList();
      this.isLoading = false;
      this.fwy = new HashMap();
      this.fql = paramw;
      this.fss = paramString1;
      this.fvS = paramString2;
      this.mContext = paramContext;
      AppMethodBeat.o(12960);
    }
    
    private String b(af paramaf)
    {
      AppMethodBeat.i(12965);
      String str1;
      if (!bt.isNullOrNil(paramaf.field_conRemark))
      {
        str1 = paramaf.field_conRemark;
        if (!bt.isNullOrNil(str1)) {
          break label114;
        }
        str1 = paramaf.ZW();
      }
      label114:
      for (;;)
      {
        String str2 = str1;
        if (!com.tencent.mm.n.b.ls(paramaf.field_type))
        {
          paramaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apN().agQ(paramaf.field_username);
          str2 = str1;
          if (paramaf != null)
          {
            str2 = str1;
            if (!bt.isNullOrNil(paramaf.field_conRemark)) {
              str2 = paramaf.field_conRemark;
            }
          }
        }
        AppMethodBeat.o(12965);
        return str2;
        str1 = SelectMemberUI.a(this.fql, paramaf.field_username);
        break;
      }
    }
    
    public final void aa(List<String> paramList)
    {
      AppMethodBeat.i(12966);
      if (paramList == null)
      {
        AppMethodBeat.o(12966);
        return;
      }
      this.dqB.clear();
      int i = 0;
      if (i < paramList.size())
      {
        af localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY((String)paramList.get(i));
        if ((SelectMemberUI.this.VO()) || (!u.se(localaf.field_username)))
        {
          boolean bool = localaf.field_username.equals(this.fvS);
          if (((!bool) || (SelectMemberUI.e(SelectMemberUI.this))) && (!SelectMemberUI.this.VW().contains(localaf.field_username)))
          {
            if ((!bool) || (!SelectMemberUI.e(SelectMemberUI.this))) {
              break label178;
            }
            this.dqB.add(0, new SelectMemberUI.a(SelectMemberUI.this, localaf));
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label178:
          this.dqB.add(new SelectMemberUI.a(SelectMemberUI.this, localaf));
        }
      }
      Collections.sort(this.dqB, new Comparator() {});
      this.fvT = this.dqB;
      AppMethodBeat.o(12966);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(12962);
      if ((this.dqB == null) || (this.isLoading))
      {
        AppMethodBeat.o(12962);
        return 0;
      }
      int i = this.dqB.size();
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
        paramViewGroup.fwD = ((MaskLayout)paramView.findViewById(2131304528));
        paramViewGroup.fsI = ((EllipsizeTextView)paramView.findViewById(2131304530));
        paramViewGroup.fsI = ((TextView)paramView.findViewById(2131304530));
        paramViewGroup.fwF = ((ImageButton)paramView.findViewById(2131297595));
        paramViewGroup.fwG = ((LinearLayout)paramView.findViewById(2131297596));
        localObject = (WindowManager)this.mContext.getSystemService("window");
        paramViewGroup.fsI.setMaxWidth(((WindowManager)localObject).getDefaultDisplay().getWidth() * 2 / 3);
        paramViewGroup.fwE = ((TextView)paramView.findViewById(2131304529));
        paramViewGroup.fwE.setMaxWidth(((WindowManager)localObject).getDefaultDisplay().getWidth() * 2 / 3);
        paramView.setTag(paramViewGroup);
        paramViewGroup.fwF.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(12956);
            paramViewGroup.fwG.performClick();
            AppMethodBeat.o(12956);
          }
        });
        paramViewGroup.fwG.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(12957);
            int i = ((Integer)paramAnonymousView.getTag()).intValue();
            paramAnonymousView = SelectMemberUI.b.this.kQ(i);
            if (paramAnonymousView == null)
            {
              ad.e("MicroMsg.SelectMemberAdapter", "item is null");
              AppMethodBeat.o(12957);
              return;
            }
            if (SelectMemberUI.this.VU().contains(paramAnonymousView.contact.field_username))
            {
              AppMethodBeat.o(12957);
              return;
            }
            if (SelectMemberUI.this.fwr.contains(paramAnonymousView.contact.field_username))
            {
              SelectMemberUI.this.fwr.remove(paramAnonymousView.contact.field_username);
              paramViewGroup.fwF.setImageResource(2131231750);
              SelectMemberUI.this.v(i, false);
              AppMethodBeat.o(12957);
              return;
            }
            SelectMemberUI.this.fwr.add(paramAnonymousView.contact.field_username);
            paramViewGroup.fwF.setImageResource(2131689936);
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
        locala = kQ(paramInt);
        paramViewGroup.fwG.setTag(Integer.valueOf(paramInt));
        if (locala != null) {
          break;
        }
        ad.e("MicroMsg.SelectMemberAdapter", "null == item! position:%s, count:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(getCount()) });
        AppMethodBeat.o(12964);
        return paramView;
        paramViewGroup = (SelectMemberUI.c)paramView.getTag();
      }
      af localaf = locala.contact;
      a.b.c((ImageView)paramViewGroup.fwD.getContentView(), localaf.field_username);
      String str;
      label439:
      label492:
      int i;
      if (localaf.field_verifyFlag != 0) {
        if (ar.a.gMY != null)
        {
          localObject = ar.a.gMY.ne(localaf.field_verifyFlag);
          if (localObject != null)
          {
            localObject = n.xb((String)localObject);
            paramViewGroup.fwD.a((Bitmap)localObject, MaskLayout.a.Gbv);
            str = b(localaf);
            localObject = "";
            if (com.tencent.mm.n.b.ls(localaf.field_type)) {
              localObject = localaf.evI;
            }
            if (bt.isNullOrNil((String)localObject)) {
              break label628;
            }
            paramViewGroup.fwE.setVisibility(0);
            paramViewGroup.fwE.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, (CharSequence)localObject, paramViewGroup.fwE.getTextSize()));
            if (!af.aHH(localaf.field_username)) {
              break label649;
            }
            ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).a(this.mContext, paramViewGroup.fsI, str, localaf.field_openImAppid, localaf.field_descWordingId, (int)paramViewGroup.fsI.getTextSize());
            if (!SelectMemberUI.this.VT()) {
              break label746;
            }
            paramViewGroup.fwF.setVisibility(0);
            paramViewGroup.fwG.setVisibility(0);
            if (!SelectMemberUI.this.VU().contains(localaf.field_username)) {
              break label683;
            }
            paramViewGroup.fwG.setEnabled(false);
            paramViewGroup.fwF.setEnabled(false);
            localObject = paramViewGroup.fwF;
            if (!ai.Eq()) {
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
        paramViewGroup.fwC = locala;
        paramViewGroup.position = paramInt;
        AppMethodBeat.o(12964);
        return paramView;
        paramViewGroup.fwD.setMaskDrawable(null);
        break;
        paramViewGroup.fwD.setMaskDrawable(null);
        break;
        paramViewGroup.fwD.setMaskDrawable(null);
        break;
        label628:
        paramViewGroup.fwE.setVisibility(8);
        paramViewGroup.fwE.setText("");
        break label439;
        label649:
        paramViewGroup.fsI.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.mContext, str, paramViewGroup.fsI.getTextSize()));
        break label492;
        label675:
        i = 2131689938;
        break label569;
        label683:
        paramViewGroup.fwG.setEnabled(true);
        paramViewGroup.fwF.setEnabled(true);
        if (SelectMemberUI.this.fwr.contains(locala.contact.field_username))
        {
          paramViewGroup.fwF.setImageResource(2131689936);
        }
        else
        {
          paramViewGroup.fwF.setImageResource(2131231750);
          continue;
          label746:
          paramViewGroup.fwF.setVisibility(8);
          paramViewGroup.fwG.setVisibility(8);
        }
      }
    }
    
    public final SelectMemberUI.a kQ(int paramInt)
    {
      AppMethodBeat.i(12963);
      if (this.dqB.size() > paramInt)
      {
        SelectMemberUI.a locala = (SelectMemberUI.a)this.dqB.get(paramInt);
        AppMethodBeat.o(12963);
        return locala;
      }
      AppMethodBeat.o(12963);
      return null;
    }
    
    public final void oZ(String paramString)
    {
      AppMethodBeat.i(12961);
      ad.i("MicroMsg.SelectMemberAdapter", "[setMemberListBySearch]");
      ArrayList localArrayList = new ArrayList();
      if (!bt.isNullOrNil(paramString))
      {
        Iterator localIterator = this.fvT.iterator();
        while (localIterator.hasNext())
        {
          SelectMemberUI.a locala = (SelectMemberUI.a)localIterator.next();
          if ((locala != null) && (locala.contact != null) && (locala.type == 1))
          {
            Object localObject = locala.contact;
            if ((((au)localObject).field_conRemark != null) && (((au)localObject).field_conRemark.contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((!bt.isNullOrNil(SeeRoomMemberUI.a(this.fql, ((au)localObject).field_username))) && (SeeRoomMemberUI.a(this.fql, ((au)localObject).field_username).contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((((af)localObject).ZW() != null) && (((af)localObject).ZW().contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((((af)localObject).Sv() != null) && (((af)localObject).Sv().contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((((af)localObject).Ss() != null) && (((af)localObject).Ss().contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((((au)localObject).field_username != null) && (((au)localObject).field_username.contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if (!com.tencent.mm.n.b.ls(((au)localObject).field_type))
            {
              localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apN().agQ(((au)localObject).field_username);
              if ((localObject != null) && (((bw)localObject).field_conRemark != null) && (((bw)localObject).field_conRemark.contains(paramString))) {
                localArrayList.add(locala);
              }
            }
          }
        }
        this.dqB = localArrayList;
        AppMethodBeat.o(12961);
        return;
      }
      this.dqB = this.fvT;
      AppMethodBeat.o(12961);
    }
  }
  
  protected static final class c
  {
    public TextView fsI;
    public SelectMemberUI.a fwC;
    public MaskLayout fwD;
    public TextView fwE;
    public ImageButton fwF;
    public LinearLayout fwG;
    public int position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectMemberUI
 * JD-Core Version:    0.7.0.1
 */