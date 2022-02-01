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
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.o;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.cn;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
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
  protected b gAA;
  protected HashSet<String> gAB;
  private boolean gAC;
  private boolean gAD;
  private View gAx;
  private View gAy;
  private SelectMemberScrollBar gAz;
  protected ah gtd;
  protected int gwE;
  protected String gwx;
  private MMEditText gzR;
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
    paramah = paramah.getDisplayName(paramString);
    AppMethodBeat.o(12976);
    return paramah;
  }
  
  protected void a(View paramView, int paramInt, long paramLong) {}
  
  public boolean anc()
  {
    return false;
  }
  
  protected void anf()
  {
    AppMethodBeat.i(12971);
    this.gwx = getIntent().getStringExtra("RoomInfo_Id");
    Log.i("MicroMsg.SelectMemberUI", "[getIntentParams] roomId:%s", new Object[] { this.gwx });
    this.gtd = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Ke(this.gwx);
    this.gwE = getIntent().getIntExtra("from_scene", 0);
    this.mTitle = getIntent().getStringExtra("title");
    this.gAC = getIntent().getBooleanExtra("is_show_owner", true);
    this.gAD = getIntent().getBooleanExtra("is_mulit_select_mode", false);
    this.gAB = new HashSet();
    AppMethodBeat.o(12971);
  }
  
  public boolean ang()
  {
    return this.gAD;
  }
  
  protected HashSet<String> anh()
  {
    AppMethodBeat.i(12974);
    HashSet localHashSet = new HashSet();
    AppMethodBeat.o(12974);
    return localHashSet;
  }
  
  protected HashSet<String> anj()
  {
    AppMethodBeat.i(12973);
    HashSet localHashSet = new HashSet();
    AppMethodBeat.o(12973);
    return localHashSet;
  }
  
  protected boolean ank()
  {
    return true;
  }
  
  protected BaseAdapter anl()
  {
    return this.gAA;
  }
  
  protected List<String> anm()
  {
    AppMethodBeat.i(12975);
    List localList = this.gtd.bax();
    AppMethodBeat.o(12975);
    return localList;
  }
  
  public final ah ano()
  {
    return this.gtd;
  }
  
  public int getLayoutId()
  {
    return 2131496213;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12972);
    setMMTitle(Util.nullAsNil(this.mTitle));
    this.mListView = ((ListView)findViewById(2131304594));
    this.gAx = findViewById(2131307540);
    this.gAy = findViewById(2131307542);
    this.gAA = new b(this, this.gtd, this.gwx, this.gtd.field_roomowner);
    this.mListView.setAdapter(anl());
    this.gAz = ((SelectMemberScrollBar)findViewById(2131304597));
    this.gAz.setOnScrollBarTouchListener(new VerticalScrollBar.a()
    {
      public final void DP(String paramAnonymousString)
      {
        AppMethodBeat.i(12948);
        if ("↑".equals(paramAnonymousString))
        {
          SelectMemberUI.a(SelectMemberUI.this).setSelection(0);
          AppMethodBeat.o(12948);
          return;
        }
        SelectMemberUI.b localb = SelectMemberUI.this.gAA;
        if (localb.gAI.containsKey(paramAnonymousString)) {}
        for (int i = ((Integer)localb.gAI.get(paramAnonymousString)).intValue();; i = -1)
        {
          if (i != -1) {
            SelectMemberUI.a(SelectMemberUI.this).setSelection(i);
          }
          AppMethodBeat.o(12948);
          return;
        }
      }
    });
    if (ank()) {
      this.gAz.setVisibility(0);
    }
    for (;;)
    {
      this.gzR = ((MMEditText)findViewById(2131307538));
      this.gzR.addTextChangedListener(new TextWatcher()
      {
        private MTimerHandler gAF;
        
        public final void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(12951);
          this.gAF.stopTimer();
          this.gAF.startTimer(500L);
          AppMethodBeat.o(12951);
        }
      });
      b localb = this.gAA;
      localb.gAE.gAy.setVisibility(0);
      g.aAk().postToWorker(new SelectMemberUI.b.1(localb));
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
      this.gAz.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12970);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.SelectMemberUI", "[onCreate]");
    anf();
    initView();
    AppMethodBeat.o(12970);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected void z(int paramInt, boolean paramBoolean) {}
  
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
    private List<SelectMemberUI.a> dSU;
    public final String gAH;
    HashMap<String, Integer> gAI;
    private String gAb;
    private List<SelectMemberUI.a> gAc;
    private ah gtd;
    private String gwx;
    public String gzZ;
    volatile boolean isLoading;
    private Context mContext;
    
    public b(Context paramContext, ah paramah, String paramString1, String paramString2)
    {
      AppMethodBeat.i(12960);
      this.gAH = new String(Character.toChars(91));
      this.gAb = null;
      this.gAc = new ArrayList(0);
      this.dSU = new ArrayList();
      this.isLoading = false;
      this.gAI = new HashMap();
      this.gtd = paramah;
      this.gwx = paramString1;
      this.gAb = paramString2;
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
        str1 = paramas.arI();
      }
      label114:
      for (;;)
      {
        String str2 = str1;
        if (!com.tencent.mm.contact.c.oR(paramas.field_type))
        {
          paramas = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSO().aEZ(paramas.field_username);
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
        str1 = SelectMemberUI.a(this.gtd, paramas.field_username);
        break;
      }
    }
    
    public final void DN(String paramString)
    {
      AppMethodBeat.i(12961);
      Log.i("MicroMsg.SelectMemberAdapter", "[setMemberListBySearch]");
      ArrayList localArrayList = new ArrayList();
      if (!Util.isNullOrNil(paramString))
      {
        Iterator localIterator = this.gAc.iterator();
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
            else if ((!Util.isNullOrNil(SeeRoomMemberUI.a(this.gtd, ((ax)localObject).field_username))) && (SeeRoomMemberUI.a(this.gtd, ((ax)localObject).field_username).contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((((as)localObject).arI() != null) && (((as)localObject).arI().contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((((as)localObject).ajz() != null) && (((as)localObject).ajz().contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((((as)localObject).ajx() != null) && (((as)localObject).ajx().contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if ((((ax)localObject).field_username != null) && (((ax)localObject).field_username.contains(paramString)))
            {
              localArrayList.add(locala);
            }
            else if (!com.tencent.mm.contact.c.oR(((ax)localObject).field_type))
            {
              localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSO().aEZ(((ax)localObject).field_username);
              if ((localObject != null) && (((cn)localObject).field_conRemark != null) && (((cn)localObject).field_conRemark.contains(paramString))) {
                localArrayList.add(locala);
              }
            }
          }
        }
        this.dSU = localArrayList;
        AppMethodBeat.o(12961);
        return;
      }
      this.dSU = this.gAc;
      AppMethodBeat.o(12961);
    }
    
    public final void Y(List<String> paramList)
    {
      AppMethodBeat.i(12966);
      if (paramList == null)
      {
        AppMethodBeat.o(12966);
        return;
      }
      this.dSU.clear();
      int i = 0;
      if (i < paramList.size())
      {
        as localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn((String)paramList.get(i));
        if ((SelectMemberUI.this.anc()) || (!z.Im(localas.field_username)))
        {
          boolean bool = localas.field_username.equals(this.gAb);
          if (((!bool) || (SelectMemberUI.e(SelectMemberUI.this))) && (!SelectMemberUI.this.anj().contains(localas.field_username)))
          {
            if ((!bool) || (!SelectMemberUI.e(SelectMemberUI.this))) {
              break label178;
            }
            this.dSU.add(0, new SelectMemberUI.a(SelectMemberUI.this, localas));
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label178:
          this.dSU.add(new SelectMemberUI.a(SelectMemberUI.this, localas));
        }
      }
      Collections.sort(this.dSU, new Comparator() {});
      this.gAc = this.dSU;
      AppMethodBeat.o(12966);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(12962);
      if ((this.dSU == null) || (this.isLoading))
      {
        AppMethodBeat.o(12962);
        return 0;
      }
      int i = this.dSU.size();
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
        paramView = View.inflate(this.mContext, 2131496212, null);
        paramViewGroup = new SelectMemberUI.c();
        paramViewGroup.gAN = ((MaskLayout)paramView.findViewById(2131307544));
        paramViewGroup.gwR = ((EllipsizeTextView)paramView.findViewById(2131307546));
        paramViewGroup.gwR = ((TextView)paramView.findViewById(2131307546));
        paramViewGroup.gAP = ((ImageButton)paramView.findViewById(2131297845));
        paramViewGroup.gAQ = ((LinearLayout)paramView.findViewById(2131297846));
        localObject = (WindowManager)this.mContext.getSystemService("window");
        paramViewGroup.gwR.setMaxWidth(((WindowManager)localObject).getDefaultDisplay().getWidth() * 2 / 3);
        paramViewGroup.gAO = ((TextView)paramView.findViewById(2131307545));
        paramViewGroup.gAO.setMaxWidth(((WindowManager)localObject).getDefaultDisplay().getWidth() * 2 / 3);
        paramView.setTag(paramViewGroup);
        paramViewGroup.gAP.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(12956);
            b localb = new b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            paramViewGroup.gAQ.performClick();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(12956);
          }
        });
        paramViewGroup.gAQ.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(12957);
            b localb = new b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            int i = ((Integer)paramAnonymousView.getTag()).intValue();
            paramAnonymousView = SelectMemberUI.b.this.on(i);
            if (paramAnonymousView == null)
            {
              Log.e("MicroMsg.SelectMemberAdapter", "item is null");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(12957);
              return;
            }
            if (SelectMemberUI.this.anh().contains(paramAnonymousView.contact.field_username))
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(12957);
              return;
            }
            if (SelectMemberUI.this.gAB.contains(paramAnonymousView.contact.field_username))
            {
              SelectMemberUI.this.gAB.remove(paramAnonymousView.contact.field_username);
              paramViewGroup.gAP.setImageResource(2131231825);
              SelectMemberUI.this.z(i, false);
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(12957);
              return;
              SelectMemberUI.this.gAB.add(paramAnonymousView.contact.field_username);
              paramViewGroup.gAP.setImageResource(2131689951);
              SelectMemberUI.this.z(i, true);
            }
          }
        });
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(12958);
            Object localObject = new b();
            ((b)localObject).bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/SelectMemberUI$SelectMemberAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
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
        locala = on(paramInt);
        paramViewGroup.gAQ.setTag(Integer.valueOf(paramInt));
        if (locala != null) {
          break;
        }
        Log.e("MicroMsg.SelectMemberAdapter", "null == item! position:%s, count:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(getCount()) });
        AppMethodBeat.o(12964);
        return paramView;
        paramViewGroup = (SelectMemberUI.c)paramView.getTag();
      }
      as localas = locala.contact;
      a.b.c((ImageView)paramViewGroup.gAN.getContentView(), localas.field_username);
      String str;
      label438:
      label491:
      int i;
      if (localas.field_verifyFlag != 0) {
        if (ay.a.iDs != null)
        {
          localObject = ay.a.iDs.rW(localas.field_verifyFlag);
          if (localObject != null)
          {
            localObject = o.Nw((String)localObject);
            paramViewGroup.gAN.a((Bitmap)localObject, MaskLayout.a.OUJ);
            str = b(localas);
            localObject = "";
            if (com.tencent.mm.contact.c.oR(localas.field_type)) {
              localObject = localas.fuR;
            }
            if (Util.isNullOrNil((String)localObject)) {
              break label627;
            }
            paramViewGroup.gAO.setVisibility(0);
            paramViewGroup.gAO.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.mContext, (CharSequence)localObject, paramViewGroup.gAO.getTextSize()));
            if (!as.bjp(localas.field_username)) {
              break label648;
            }
            ((com.tencent.mm.openim.a.a)g.af(com.tencent.mm.openim.a.a.class)).a(this.mContext, paramViewGroup.gwR, str, localas.field_openImAppid, localas.field_descWordingId, (int)paramViewGroup.gwR.getTextSize());
            if (!SelectMemberUI.this.ang()) {
              break label745;
            }
            paramViewGroup.gAP.setVisibility(0);
            paramViewGroup.gAQ.setVisibility(0);
            if (!SelectMemberUI.this.anh().contains(localas.field_username)) {
              break label682;
            }
            paramViewGroup.gAQ.setEnabled(false);
            paramViewGroup.gAP.setEnabled(false);
            localObject = paramViewGroup.gAP;
            if (!ao.isDarkMode()) {
              break label674;
            }
            i = 2131689955;
            label568:
            ((ImageButton)localObject).setImageResource(i);
          }
        }
      }
      for (;;)
      {
        paramViewGroup.gAM = locala;
        paramViewGroup.position = paramInt;
        AppMethodBeat.o(12964);
        return paramView;
        paramViewGroup.gAN.setMaskDrawable(null);
        break;
        paramViewGroup.gAN.setMaskDrawable(null);
        break;
        paramViewGroup.gAN.setMaskDrawable(null);
        break;
        label627:
        paramViewGroup.gAO.setVisibility(8);
        paramViewGroup.gAO.setText("");
        break label438;
        label648:
        paramViewGroup.gwR.setText(com.tencent.mm.pluginsdk.ui.span.l.b(this.mContext, str, paramViewGroup.gwR.getTextSize()));
        break label491;
        label674:
        i = 2131689954;
        break label568;
        label682:
        paramViewGroup.gAQ.setEnabled(true);
        paramViewGroup.gAP.setEnabled(true);
        if (SelectMemberUI.this.gAB.contains(locala.contact.field_username))
        {
          paramViewGroup.gAP.setImageResource(2131689951);
        }
        else
        {
          paramViewGroup.gAP.setImageResource(2131231825);
          continue;
          label745:
          paramViewGroup.gAP.setVisibility(8);
          paramViewGroup.gAQ.setVisibility(8);
        }
      }
    }
    
    public final SelectMemberUI.a on(int paramInt)
    {
      AppMethodBeat.i(12963);
      if (this.dSU.size() > paramInt)
      {
        SelectMemberUI.a locala = (SelectMemberUI.a)this.dSU.get(paramInt);
        AppMethodBeat.o(12963);
        return locala;
      }
      AppMethodBeat.o(12963);
      return null;
    }
  }
  
  protected static final class c
  {
    public SelectMemberUI.a gAM;
    public MaskLayout gAN;
    public TextView gAO;
    public ImageButton gAP;
    public LinearLayout gAQ;
    public TextView gwR;
    public int position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SelectMemberUI
 * JD-Core Version:    0.7.0.1
 */