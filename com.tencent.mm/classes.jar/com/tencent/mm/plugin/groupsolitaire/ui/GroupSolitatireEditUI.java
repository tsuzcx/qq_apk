package com.tencent.mm.plugin.groupsolitaire.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Pair;
import android.view.Display;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.picker.CustomDatePicker;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class GroupSolitatireEditUI
  extends MMActivity
  implements com.tencent.mm.ui.tools.g
{
  private GestureDetector aNR;
  private TextWatcher auC;
  private boolean cXa;
  private x ftP;
  private com.tencent.mm.ui.tools.h fxG;
  private ScrollView kqh;
  private TextView lgw;
  private RelativeLayout mws;
  private boolean qPu;
  private int scene;
  private boolean tzA;
  private boolean tzB;
  private boolean tzC;
  private ArrayList<View> tzD;
  private Rect tzE;
  private Rect tzF;
  private a tzG;
  private View.OnTouchListener tzH;
  private CdnImageView tzg;
  private MMEditText tzh;
  private View tzi;
  private View tzj;
  private LinearLayout tzk;
  private ImageButton tzl;
  private MMEditText tzm;
  private LinearLayout tzn;
  private RelativeLayout tzo;
  private RelativeLayout tzp;
  private RelativeLayout tzq;
  private View tzr;
  private View tzs;
  private boolean tzt;
  private int tzu;
  private int tzv;
  private com.tencent.mm.plugin.groupsolitaire.c.a tzw;
  private com.tencent.mm.plugin.groupsolitaire.c.a tzx;
  private String tzy;
  private boolean tzz;
  
  public GroupSolitatireEditUI()
  {
    AppMethodBeat.i(110460);
    this.tzt = false;
    this.tzw = null;
    this.tzx = null;
    this.tzy = "";
    this.tzz = false;
    this.tzA = false;
    this.qPu = false;
    this.tzB = false;
    this.tzC = false;
    this.tzD = new ArrayList();
    this.cXa = false;
    this.auC = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(110427);
        long l = System.currentTimeMillis();
        GroupSolitatireEditUI.a(GroupSolitatireEditUI.this);
        if ((GroupSolitatireEditUI.b(GroupSolitatireEditUI.this) instanceof MMEditText)) {
          localObject1 = paramAnonymousEditable.toString();
        }
        try
        {
          String str = ((com.tencent.mm.plugin.emoji.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.a.class)).Xw((String)localObject1);
          localObject1 = str;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int i;
            int j;
            ac.e("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "afterTextChanged() emojiSoftBank2Unicode %s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
            continue;
            Object localObject2 = localObject1;
            if (j > com.tencent.mm.plugin.groupsolitaire.b.b.cSi() * 2)
            {
              i = com.tencent.mm.plugin.groupsolitaire.b.b.dA((String)localObject1, com.tencent.mm.plugin.groupsolitaire.b.b.cSi() * 2);
              paramAnonymousEditable.delete(i, ((String)localObject1).length());
              localObject2 = ((String)localObject1).substring(0, i);
            }
            GroupSolitatireEditUI.c(GroupSolitatireEditUI.this).header = ((String)localObject2);
            GroupSolitatireEditUI.c(GroupSolitatireEditUI.this).tyQ = 1;
            continue;
            GroupSolitatireEditUI.c(GroupSolitatireEditUI.this).tyO = ((String)localObject1);
            continue;
            com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)((MMEditText)GroupSolitatireEditUI.b(GroupSolitatireEditUI.this)).getTag(2131300641);
            if (localb != null)
            {
              localObject2 = localObject1;
              if (j > com.tencent.mm.plugin.groupsolitaire.b.b.cSh() * 2)
              {
                i = com.tencent.mm.plugin.groupsolitaire.b.b.dA((String)localObject1, com.tencent.mm.plugin.groupsolitaire.b.b.cSh() * 2);
                paramAnonymousEditable.delete(i, ((String)localObject1).length());
                localObject2 = ((String)localObject1).substring(0, i);
              }
              localb.content = ((String)localObject2);
              continue;
              localObject2 = localObject1;
              if (j > com.tencent.mm.plugin.groupsolitaire.b.b.cSj() * 2)
              {
                i = com.tencent.mm.plugin.groupsolitaire.b.b.dA((String)localObject1, com.tencent.mm.plugin.groupsolitaire.b.b.cSj() * 2);
                paramAnonymousEditable.delete(i, ((String)localObject1).length());
                localObject2 = ((String)localObject1).substring(0, i);
              }
              GroupSolitatireEditUI.c(GroupSolitatireEditUI.this).tyP = ((String)localObject2);
            }
          }
        }
        i = ((Integer)((MMEditText)GroupSolitatireEditUI.b(GroupSolitatireEditUI.this)).getTag(2131300643)).intValue();
        ac.d("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "afterTextChanged() str:%s type:%s", new Object[] { localObject1, Integer.valueOf(i) });
        j = com.tencent.mm.plugin.groupsolitaire.b.b.aie((String)localObject1);
        switch (i)
        {
        default: 
          GroupSolitatireEditUI.d(GroupSolitatireEditUI.this);
          GroupSolitatireEditUI.b(GroupSolitatireEditUI.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(110426);
              GroupSolitatireEditUI.a(GroupSolitatireEditUI.this, GroupSolitatireEditUI.e(GroupSolitatireEditUI.this));
              AppMethodBeat.o(110426);
            }
          }, 100L);
          ac.d("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "startTime:%s interTime:%s", new Object[] { Long.valueOf(l), Long.valueOf(System.currentTimeMillis() - l) });
          AppMethodBeat.o(110427);
          return;
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    this.tzH = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(110438);
        if ((paramAnonymousMotionEvent.getActionMasked() == 1) && ((paramAnonymousView instanceof MMEditText)) && (GroupSolitatireEditUI.f(GroupSolitatireEditUI.this))) {
          ((MMEditText)paramAnonymousView).setCursorVisible(true);
        }
        if ((paramAnonymousMotionEvent.getActionMasked() == 1) && ((paramAnonymousView instanceof MMEditText)) && (((Integer)((MMEditText)paramAnonymousView).getTag(2131300643)).intValue() == 3) && (GroupSolitatireEditUI.g(GroupSolitatireEditUI.this))) {
          ((MMEditText)paramAnonymousView).setCursorVisible(true);
        }
        if (GroupSolitatireEditUI.c((MMEditText)paramAnonymousView))
        {
          paramAnonymousView.getParent().requestDisallowInterceptTouchEvent(true);
          GroupSolitatireEditUI.b(GroupSolitatireEditUI.this, true);
          if (paramAnonymousMotionEvent.getAction() == 1)
          {
            GroupSolitatireEditUI.b(GroupSolitatireEditUI.this, false);
            paramAnonymousView.getParent().requestDisallowInterceptTouchEvent(false);
          }
        }
        AppMethodBeat.o(110438);
        return false;
      }
    };
    AppMethodBeat.o(110460);
  }
  
  private void Q(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2) {
      this.qPu = paramBoolean1;
    }
  }
  
  private boolean Wt()
  {
    AppMethodBeat.i(110464);
    if (this.qPu) {
      com.tencent.mm.ui.base.h.a(this, getString(2131760092), "", getString(2131760091), getString(2131760090), false, new DialogInterface.OnClickListener()new GroupSolitatireEditUI.4
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(110429);
          ac.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "back_dialot ok");
          ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
          com.tencent.mm.plugin.groupsolitaire.b.d.a(GroupSolitatireEditUI.c(GroupSolitatireEditUI.this), GroupSolitatireEditUI.o(GroupSolitatireEditUI.this), 2, GroupSolitatireEditUI.f(GroupSolitatireEditUI.this));
          GroupSolitatireEditUI.this.finish();
          AppMethodBeat.o(110429);
        }
      }, new GroupSolitatireEditUI.4(this), 2131100798);
    }
    for (;;)
    {
      AppMethodBeat.o(110464);
      return true;
      ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
      com.tencent.mm.plugin.groupsolitaire.b.d.a(this.tzw, cSp(), 1, this.tzz);
      finish();
    }
  }
  
  private void a(final MMEditText paramMMEditText)
  {
    AppMethodBeat.i(110483);
    paramMMEditText.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(193006);
        if ((paramAnonymousBoolean) && (GroupSolitatireEditUI.b(GroupSolitatireEditUI.this) != null) && (GroupSolitatireEditUI.e(GroupSolitatireEditUI.this)))
        {
          GroupSolitatireEditUI.b(GroupSolitatireEditUI.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(193004);
              GroupSolitatireEditUI.a(GroupSolitatireEditUI.this);
              AppMethodBeat.o(193004);
            }
          }, 200L);
          GroupSolitatireEditUI.b(GroupSolitatireEditUI.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(193005);
              GroupSolitatireEditUI.a(GroupSolitatireEditUI.this, GroupSolitatireEditUI.e(GroupSolitatireEditUI.this));
              AppMethodBeat.o(193005);
            }
          }, 200L);
          AppMethodBeat.o(193006);
          return;
        }
        paramMMEditText.setSelection(0);
        AppMethodBeat.o(193006);
      }
    });
    AppMethodBeat.o(110483);
  }
  
  private void aij(String paramString)
  {
    AppMethodBeat.i(110481);
    ((MMEditText)this.tzs).requestFocus();
    this.tzk.postDelayed(new GroupSolitatireEditUI.16(this), 200L);
    ((MMEditText)this.tzs).getText().insert(this.tzv, paramString + "; ");
    AppMethodBeat.o(110481);
  }
  
  private int b(MMEditText paramMMEditText)
  {
    AppMethodBeat.i(110484);
    if (this.tzu == 0)
    {
      AppMethodBeat.o(110484);
      return 10;
    }
    int i = ((WindowManager)getSystemService("window")).getDefaultDisplay().getHeight();
    float f = paramMMEditText.getLineHeight();
    i = (int)((i - (this.tzu + this.tzn.getHeight() + ao.fromDPToPix(this, 145))) / f);
    AppMethodBeat.o(110484);
    return i;
  }
  
  private CharSequence bm(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(110472);
    com.tencent.mm.kernel.g.agS();
    ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramString);
    if ((paramBoolean) && (!bs.isNullOrNil(localai.field_conRemark))) {}
    for (String str = localai.field_conRemark;; str = se(localai.field_username))
    {
      paramString = str;
      if (bs.isNullOrNil(str)) {
        paramString = localai.field_conRemark;
      }
      str = paramString;
      if (bs.isNullOrNil(paramString)) {
        str = localai.aaR();
      }
      paramString = str;
      if (bs.isNullOrNil(str)) {
        paramString = localai.field_username;
      }
      paramString = com.tencent.mm.pluginsdk.ui.span.k.c(getContext(), paramString);
      AppMethodBeat.o(110472);
      return paramString;
    }
  }
  
  private int cSp()
  {
    AppMethodBeat.i(110465);
    if (cSq())
    {
      AppMethodBeat.o(110465);
      return 3;
    }
    int i = this.scene;
    AppMethodBeat.o(110465);
    return i;
  }
  
  private boolean cSq()
  {
    return (this.scene == 3) || (this.scene == 4);
  }
  
  private boolean cSr()
  {
    return (this.scene == 4) || (this.scene == 5);
  }
  
  private void cSs()
  {
    AppMethodBeat.i(110466);
    int j = 1;
    int i = 1;
    MMEditText localMMEditText;
    if (j <= this.tzw.tyS.size())
    {
      com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)this.tzw.tyS.get(Integer.valueOf(j));
      if (localb == null) {
        break label287;
      }
      View localView = getLayoutInflater().inflate(2131494425, null);
      ((TextView)localView.findViewById(2131300637)).setText(String.valueOf(i));
      localMMEditText = (MMEditText)localView.findViewById(2131300636);
      localMMEditText.setTag(2131300643, Integer.valueOf(3));
      localMMEditText.setTag(2131300641, localb);
      localMMEditText.setText(com.tencent.mm.pluginsdk.ui.span.k.b(localMMEditText.getContext(), localb.content, (int)localMMEditText.getTextSize()));
      if (bs.lr(localb.username, u.axw()))
      {
        this.tzC = true;
        localMMEditText.requestFocus();
        localMMEditText.setFocusable(true);
        localMMEditText.setFocusableInTouchMode(true);
        localMMEditText.addTextChangedListener(this.auC);
        if (this.scene == 1) {
          localMMEditText.setCursorVisible(false);
        }
        label193:
        localMMEditText.setOnTouchListener(this.tzH);
        localMMEditText.setMaxLines(10);
        this.tzk.addView(localView);
        this.tzD.add(localView);
        a(localMMEditText);
        i += 1;
      }
    }
    label287:
    for (;;)
    {
      j += 1;
      break;
      this.tzC = false;
      localMMEditText.setTextColor(getResources().getColor(2131099676));
      localMMEditText.setKeyListener(null);
      localMMEditText.setTextIsSelectable(true);
      break label193;
      AppMethodBeat.o(110466);
      return;
    }
  }
  
  private Pair<Boolean, Boolean> cSt()
  {
    boolean bool4 = false;
    AppMethodBeat.i(193009);
    Object localObject1 = new HashSet();
    int i = 1;
    while (i <= this.tzx.tyS.size())
    {
      localObject2 = (com.tencent.mm.plugin.groupsolitaire.c.b)this.tzx.tyS.get(Integer.valueOf(i));
      if (bs.lr(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject2).username, u.axw())) {
        ((Set)localObject1).add(localObject2);
      }
      i += 1;
    }
    Object localObject2 = new ArrayList();
    HashSet localHashSet = new HashSet();
    i = 1;
    while (i <= this.tzw.tyS.size())
    {
      com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)this.tzw.tyS.get(Integer.valueOf(i));
      if ((bs.lr(localb.username, u.axw())) && (!bs.isNullOrNil(localb.content.trim())))
      {
        ((ArrayList)localObject2).add(localb);
        localHashSet.add(localb);
      }
      i += 1;
    }
    boolean bool1;
    boolean bool3;
    boolean bool2;
    if (((Set)localObject1).size() == ((ArrayList)localObject2).size()) {
      if (((ArrayList)localObject2).size() != localHashSet.size())
      {
        bool1 = true;
        localObject2 = ((ArrayList)localObject2).iterator();
        do
        {
          bool3 = bool1;
          bool2 = bool4;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
        } while (((Set)localObject1).contains((com.tencent.mm.plugin.groupsolitaire.c.b)((Iterator)localObject2).next()));
      }
    }
    for (;;)
    {
      bool2 = true;
      bool3 = bool1;
      localObject1 = new Pair(Boolean.valueOf(bool2), Boolean.valueOf(bool3));
      AppMethodBeat.o(193009);
      return localObject1;
      bool1 = false;
      break;
      bool1 = false;
    }
  }
  
  private void cSu()
  {
    AppMethodBeat.i(110480);
    if (com.tencent.mm.aw.b.CQ((String)com.tencent.mm.kernel.g.agR().agA().get(274436, null)))
    {
      if (!com.tencent.mm.pluginsdk.permission.b.o(this, "android.permission.ACCESS_COARSE_LOCATION"))
      {
        if (!((Boolean)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GRN, Boolean.FALSE)).booleanValue())
        {
          com.tencent.mm.plugin.account.a.b.a.b(this, getResources().getString(2131760740, new Object[] { ab.eUO() }), 30764, true);
          AppMethodBeat.o(110480);
          return;
        }
        com.tencent.mm.pluginsdk.permission.b.b(this, "android.permission.ACCESS_COARSE_LOCATION", 64);
        AppMethodBeat.o(110480);
      }
    }
    else
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null);
      ac.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        AppMethodBeat.o(110480);
        return;
      }
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("MMActivity.OverrideExitAnimation", 2130772106);
    localIntent.putExtra("MMActivity.OverrideEnterAnimation", 2130772047);
    localIntent.putExtra("map_view_type", 3);
    com.tencent.mm.br.d.b(this, "location", ".ui.RedirectUI", localIntent, 4097);
    AppMethodBeat.o(110480);
  }
  
  private void cSv()
  {
    AppMethodBeat.i(110482);
    if (this.mws.findFocus() == null)
    {
      ac.d("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "mRootContainer.findFocus() is null");
      AppMethodBeat.o(110482);
      return;
    }
    this.tzs = this.mws.findFocus();
    this.tzv = ((MMEditText)this.tzs).getSelectionStart();
    AppMethodBeat.o(110482);
  }
  
  private void mU(boolean paramBoolean)
  {
    AppMethodBeat.i(193008);
    com.tencent.mm.plugin.groupsolitaire.c.b localb = new com.tencent.mm.plugin.groupsolitaire.c.b();
    View localView = getLayoutInflater().inflate(2131494425, null);
    ((TextView)localView.findViewById(2131300637)).setText(this.tzw.tyS.size() + 1);
    MMEditText localMMEditText = (MMEditText)localView.findViewById(2131300636);
    CharSequence localCharSequence = bm(u.axw(), false);
    if (!bs.aj(localCharSequence))
    {
      localMMEditText.setText(localCharSequence + " ");
      localb.content = String.valueOf(localCharSequence);
    }
    localb.username = u.axw();
    localb.separator = this.tzw.separator;
    localb.tyW = (this.tzw.tyS.size() + 1);
    localMMEditText.setTag(2131300643, Integer.valueOf(3));
    localMMEditText.setTag(2131300641, localb);
    localMMEditText.requestFocus();
    localMMEditText.setFocusable(true);
    localMMEditText.setFocusableInTouchMode(true);
    localMMEditText.addTextChangedListener(this.auC);
    localMMEditText.setOnTouchListener(this.tzH);
    a(localMMEditText);
    localMMEditText.setMaxLines(10);
    this.tzw.tyS.put(Integer.valueOf(this.tzw.tyS.size() + 1), localb);
    this.tzk.addView(localView);
    this.tzD.add(localView);
    localView.post(new GroupSolitatireEditUI.8(this));
    mV(paramBoolean);
    AppMethodBeat.o(193008);
  }
  
  private void mV(boolean paramBoolean)
  {
    AppMethodBeat.i(110475);
    int i = 1;
    Object localObject;
    if (i <= this.tzw.tyS.size())
    {
      localObject = (com.tencent.mm.plugin.groupsolitaire.c.b)this.tzw.tyS.get(Integer.valueOf(i));
      if ((localObject == null) || (bs.isNullOrNil(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject).content.trim()))) {}
    }
    for (i = 1;; i = 0)
    {
      if (this.tzz)
      {
        if (i != 0)
        {
          enableOptionMenu(0, true);
          if (paramBoolean) {
            break label317;
          }
          if ((this.tzx != null) && (bs.lr(this.tzw.header, this.tzx.header)) && (bs.lr(this.tzw.tyO, this.tzx.tyO)) && (bs.lr(this.tzw.tyP, this.tzx.tyP)))
          {
            localObject = cSt();
            bool1 = ((Boolean)((Pair)localObject).first).booleanValue();
            bool2 = ((Boolean)((Pair)localObject).second).booleanValue();
            if ((!bool1) && (!bool2))
            {
              Q(false, paramBoolean);
              AppMethodBeat.o(110475);
              return;
              i += 1;
              break;
            }
          }
          Q(true, paramBoolean);
          AppMethodBeat.o(110475);
          return;
        }
        enableOptionMenu(0, false);
        Q(false, paramBoolean);
        AppMethodBeat.o(110475);
        return;
      }
      localObject = cSt();
      boolean bool1 = ((Boolean)((Pair)localObject).first).booleanValue();
      boolean bool2 = ((Boolean)((Pair)localObject).second).booleanValue();
      if ((i != 0) && ((bool1) || (bool2)))
      {
        enableOptionMenu(0, true);
        Q(true, paramBoolean);
        AppMethodBeat.o(110475);
        return;
      }
      enableOptionMenu(0, false);
      Q(false, paramBoolean);
      label317:
      AppMethodBeat.o(110475);
      return;
    }
  }
  
  private String se(String paramString)
  {
    AppMethodBeat.i(110473);
    if (this.ftP == null)
    {
      AppMethodBeat.o(110473);
      return null;
    }
    paramString = this.ftP.wk(paramString);
    AppMethodBeat.o(110473);
    return paramString;
  }
  
  public final void GM(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(110476);
    if ((this.tzs == null) || (!(this.tzs instanceof MMEditText)))
    {
      ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
      com.tencent.mm.plugin.groupsolitaire.b.d.a(this.tzw, paramInt, 0);
      AppMethodBeat.o(110476);
      return;
    }
    switch (((Integer)((MMEditText)this.tzs).getTag(2131300643)).intValue())
    {
    }
    for (;;)
    {
      ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
      com.tencent.mm.plugin.groupsolitaire.b.d.a(this.tzw, paramInt, i);
      AppMethodBeat.o(110476);
      return;
      i = 1;
      continue;
      i = 3;
      continue;
      i = 4;
      continue;
      i = 2;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(110485);
    this.aNR.onTouchEvent(paramMotionEvent);
    super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(110485);
    return false;
  }
  
  public void finish()
  {
    AppMethodBeat.i(110469);
    super.finish();
    try
    {
      hideVKB();
      AppMethodBeat.o(110469);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "finish() hideVKB() %s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
      AppMethodBeat.o(110469);
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494426;
  }
  
  public void initView()
  {
    AppMethodBeat.i(110463);
    super.initView();
    setMMTitle(getString(2131760115));
    hideActionbarLine();
    setActionbarColor(getResources().getColor(2131099679));
    setBackGroundColorResource(2131101179);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(110448);
        boolean bool = GroupSolitatireEditUI.h(GroupSolitatireEditUI.this);
        AppMethodBeat.o(110448);
        return bool;
      }
    });
    this.fxG = new com.tencent.mm.ui.tools.h(getContext());
    this.fxG.IRL = this;
    this.kqh = ((ScrollView)findViewById(2131304251));
    this.mws = ((RelativeLayout)findViewById(2131304241));
    this.tzg = ((CdnImageView)findViewById(2131300638));
    this.lgw = ((TextView)findViewById(2131300639));
    this.tzh = ((MMEditText)findViewById(2131300644));
    this.tzi = findViewById(2131300650);
    this.tzj = findViewById(2131300651);
    this.tzk = ((LinearLayout)findViewById(2131300640));
    this.tzl = ((ImageButton)findViewById(2131300642));
    this.tzm = ((MMEditText)findViewById(2131300653));
    this.tzn = ((LinearLayout)findViewById(2131300645));
    this.tzo = ((RelativeLayout)findViewById(2131300646));
    this.tzp = ((RelativeLayout)findViewById(2131300647));
    this.tzq = ((RelativeLayout)findViewById(2131300648));
    this.tzr = findViewById(2131300652);
    this.tzo.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110450);
        GroupSolitatireEditUI.a(GroupSolitatireEditUI.this);
        GroupSolitatireEditUI.j(GroupSolitatireEditUI.this);
        GroupSolitatireEditUI.this.GM(2);
        AppMethodBeat.o(110450);
      }
    });
    this.tzp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(110453);
        GroupSolitatireEditUI.a(GroupSolitatireEditUI.this);
        if (((GroupSolitatireEditUI.b(GroupSolitatireEditUI.this) instanceof MMEditText)) && ((GroupSolitatireEditUI.b(GroupSolitatireEditUI.this).getParent() instanceof RelativeLayout))) {
          ((RelativeLayout)GroupSolitatireEditUI.b(GroupSolitatireEditUI.this).getParent()).setTag(Integer.valueOf(1));
        }
        paramAnonymousView = new a(GroupSolitatireEditUI.this);
        paramAnonymousView.tzb = new a.a()
        {
          public final void aii(String paramAnonymous2String)
          {
            AppMethodBeat.i(110451);
            paramAnonymousView.hide();
            GroupSolitatireEditUI.a(GroupSolitatireEditUI.this, paramAnonymous2String);
            GroupSolitatireEditUI.this.GM(5);
            AppMethodBeat.o(110451);
          }
          
          public final void onCancel()
          {
            AppMethodBeat.i(110452);
            paramAnonymousView.hide();
            AppMethodBeat.o(110452);
          }
        };
        GroupSolitatireEditUI.a(GroupSolitatireEditUI.this, paramAnonymousView);
        paramAnonymousView.show();
        GroupSolitatireEditUI.this.GM(4);
        AppMethodBeat.o(110453);
      }
    });
    this.tzq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110455);
        GroupSolitatireEditUI.a(GroupSolitatireEditUI.this);
        if (((GroupSolitatireEditUI.b(GroupSolitatireEditUI.this) instanceof MMEditText)) && ((GroupSolitatireEditUI.b(GroupSolitatireEditUI.this).getParent() instanceof RelativeLayout))) {
          ((RelativeLayout)GroupSolitatireEditUI.b(GroupSolitatireEditUI.this).getParent()).setTag(Integer.valueOf(1));
        }
        paramAnonymousView = new b(GroupSolitatireEditUI.this);
        int i;
        int j;
        label103:
        int k;
        if (paramAnonymousView.tzd != null)
        {
          i = paramAnonymousView.tzd.getYear();
          if (paramAnonymousView.tzd == null) {
            break label267;
          }
          j = paramAnonymousView.tzd.getMonth();
          if (paramAnonymousView.tzd == null) {
            break label272;
          }
          k = paramAnonymousView.tzd.getDayOfMonth();
          label119:
          paramAnonymousView.tze = new b.a()
          {
            public final void onResult(boolean paramAnonymous2Boolean, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
            {
              AppMethodBeat.i(110454);
              if (paramAnonymous2Boolean)
              {
                ac.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "group solitaire time :%s", new Object[] { String.format(Locale.US, "%04d-%02d-%02d", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) }) });
                GroupSolitatireEditUI.a(GroupSolitatireEditUI.this, String.format(Locale.US, "%04d/%02d/%02d", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) }));
                GroupSolitatireEditUI.this.GM(1);
              }
              AppMethodBeat.o(110454);
            }
          };
          if ((i >= 0) && (j >= 0) && (k >= 0)) {
            break label278;
          }
        }
        for (;;)
        {
          Calendar localCalendar = Calendar.getInstance(Locale.US);
          localCalendar.set(2009, 0, 1);
          if (paramAnonymousView.tzd != null) {
            paramAnonymousView.tzd.setMinDate(localCalendar.getTimeInMillis());
          }
          localCalendar = Calendar.getInstance(Locale.US);
          localCalendar.set(2029, 11, 31);
          if (paramAnonymousView.tzd != null) {
            paramAnonymousView.tzd.setMaxDate(localCalendar.getTimeInMillis());
          }
          if (paramAnonymousView.tyZ != null)
          {
            if (paramAnonymousView.tzd != null) {
              paramAnonymousView.tzd.bBg();
            }
            paramAnonymousView.tyZ.show();
          }
          GroupSolitatireEditUI.this.GM(0);
          AppMethodBeat.o(110455);
          return;
          i = 0;
          break;
          label267:
          j = 0;
          break label103;
          label272:
          k = 0;
          break label119;
          label278:
          if (paramAnonymousView.tzd != null) {
            paramAnonymousView.tzd.a(i, j, k, null);
          }
        }
      }
    });
    addTextOptionMenu(0, getString(2131760107), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(110458);
        ac.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "send group solitaire(sending:%s)", new Object[] { Boolean.valueOf(GroupSolitatireEditUI.k(GroupSolitatireEditUI.this)) });
        if (GroupSolitatireEditUI.k(GroupSolitatireEditUI.this))
        {
          AppMethodBeat.o(110458);
          return true;
        }
        com.tencent.mm.plugin.groupsolitaire.b.b.a(GroupSolitatireEditUI.l(GroupSolitatireEditUI.this), u.axw(), GroupSolitatireEditUI.c(GroupSolitatireEditUI.this));
        if (GroupSolitatireEditUI.c(GroupSolitatireEditUI.this).tyT) {
          com.tencent.mm.ui.base.h.d(GroupSolitatireEditUI.this.getContext(), GroupSolitatireEditUI.this.getString(2131760105), "", GroupSolitatireEditUI.this.getString(2131760104), GroupSolitatireEditUI.this.getString(2131760103), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(110456);
              ac.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "group solitatire repeat dialog ok");
              GroupSolitatireEditUI.m(GroupSolitatireEditUI.this);
              AppMethodBeat.o(110456);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(110457);
              ac.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "group solitatire repeat dialog cancel");
              AppMethodBeat.o(110457);
            }
          });
        }
        for (;;)
        {
          AppMethodBeat.o(110458);
          return true;
          GroupSolitatireEditUI.m(GroupSolitatireEditUI.this);
        }
      }
    }, null, s.b.Hom);
    Object localObject1;
    if (this.tzz)
    {
      enableOptionMenu(0, true);
      localObject1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110459);
          Bitmap localBitmap = com.tencent.mm.aj.c.a(GroupSolitatireEditUI.c(GroupSolitatireEditUI.this).field_creator, false, -1, null);
          if (localBitmap == null)
          {
            GroupSolitatireEditUI.n(GroupSolitatireEditUI.this).setImageResource(2131231875);
            AppMethodBeat.o(110459);
            return;
          }
          GroupSolitatireEditUI.n(GroupSolitatireEditUI.this).setImageBitmap(localBitmap);
          AppMethodBeat.o(110459);
        }
      };
      if (!ap.isMainThread()) {
        break label465;
      }
      ((Runnable)localObject1).run();
    }
    for (;;)
    {
      if (this.tzw.tyS.size() <= 0) {
        break label1477;
      }
      localObject1 = new HashSet();
      i = 1;
      while (i <= this.tzw.tyS.size())
      {
        ((Set)localObject1).add(((com.tencent.mm.plugin.groupsolitaire.c.b)this.tzw.tyS.get(Integer.valueOf(i))).username);
        i += 1;
      }
      enableOptionMenu(0, false);
      break;
      label465:
      ap.f(new GroupSolitatireEditUI.2(this, (Runnable)localObject1));
    }
    label784:
    label923:
    label1066:
    label1091:
    label1477:
    for (int i = ((Set)localObject1).size();; i = 0)
    {
      this.lgw.setText(getString(2131760119, new Object[] { bm(this.tzw.field_creator, true), String.valueOf(i) }));
      Object localObject2;
      if ((!bs.isNullOrNil(this.tzw.header)) && (this.tzw.tyQ == 1))
      {
        localObject2 = this.tzw.header;
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (com.tencent.mm.plugin.groupsolitaire.b.b.aie((String)localObject2) > com.tencent.mm.plugin.groupsolitaire.b.b.cSi() * 2)
          {
            localObject1 = ((String)localObject2).substring(0, com.tencent.mm.plugin.groupsolitaire.b.b.dA((String)localObject2, com.tencent.mm.plugin.groupsolitaire.b.b.cSi() * 2));
            this.tzw.header = ((String)localObject1);
          }
        }
        localObject1 = com.tencent.mm.pluginsdk.ui.span.k.a(this.tzh.getContext(), (CharSequence)localObject1, (int)this.tzh.getTextSize(), 1);
        this.tzh.setText((CharSequence)localObject1);
        if ((this.tzz) && (!bs.isNullOrNil(this.tzw.header)) && (this.tzw.tyQ == 0))
        {
          this.tzw.tyQ = 1;
          this.tzw.header = "";
          if ((this.tzw.tyS.size() > 0) && (((com.tencent.mm.plugin.groupsolitaire.c.b)this.tzw.tyS.get(Integer.valueOf(1))).tyV == 1)) {
            ((com.tencent.mm.plugin.groupsolitaire.c.b)this.tzw.tyS.get(Integer.valueOf(1))).tyV = 0;
          }
        }
        if (bs.isNullOrNil(this.tzw.tyP)) {
          break label1341;
        }
        localObject1 = com.tencent.mm.pluginsdk.ui.span.k.a(this.tzm.getContext(), this.tzw.tyP, (int)this.tzm.getTextSize(), 1);
        this.tzm.setText((CharSequence)localObject1);
        if (!this.tzz) {
          break label1373;
        }
        this.tzh.setFocusable(true);
        this.tzh.setFocusableInTouchMode(true);
        this.tzh.requestFocus();
        this.tzh.setOnTouchListener(this.tzH);
        if (bs.isNullOrNil(this.tzw.header)) {
          this.tzh.setHeight(com.tencent.mm.cc.a.fromDPToPix(getContext(), 160));
        }
        this.tzh.addTextChangedListener(this.auC);
        this.tzh.setMaxLines(10);
        this.tzm.setFocusable(true);
        this.tzm.setFocusableInTouchMode(true);
        this.tzm.addTextChangedListener(this.auC);
        this.tzm.setOnTouchListener(this.tzH);
        this.tzm.setMaxLines(10);
        this.tzh.setTag(2131300643, Integer.valueOf(1));
        this.tzm.setTag(2131300643, Integer.valueOf(4));
        if ((!bs.isNullOrNil(this.tzw.tyO)) || (this.tzz))
        {
          localObject1 = getLayoutInflater().inflate(2131494425, null);
          ((TextView)((View)localObject1).findViewById(2131300637)).setText(getString(2131760099));
          localObject2 = (MMEditText)((View)localObject1).findViewById(2131300636);
          ((MMEditText)localObject2).setTag(2131300643, Integer.valueOf(2));
          if (bs.isNullOrNil(this.tzw.tyO)) {
            break label1408;
          }
          ((MMEditText)localObject2).setText(com.tencent.mm.pluginsdk.ui.span.k.b(((MMEditText)localObject2).getContext(), this.tzw.tyO, (int)((MMEditText)localObject2).getTextSize()));
          this.tzt = false;
          if (!this.tzz) {
            break label1423;
          }
          ((MMEditText)localObject2).setFocusable(true);
          ((MMEditText)localObject2).setFocusableInTouchMode(true);
          ((MMEditText)localObject2).addTextChangedListener(this.auC);
          ((MMEditText)localObject2).setOnTouchListener(this.tzH);
          ((MMEditText)localObject2).setMaxLines(10);
          this.tzk.addView((View)localObject1);
        }
        cSs();
        if (this.tzw.tyS.size() < com.tencent.mm.plugin.groupsolitaire.b.b.cSg()) {
          this.tzl.setOnClickListener(new GroupSolitatireEditUI.5(this));
        }
        if ((this.scene != 2) && ((!cSq()) || (this.tzw.tyU <= 0)) && (this.scene != 5)) {
          break label1450;
        }
        mU(true);
        if ((this.tzz) && (cSr())) {
          this.tzh.requestFocus();
        }
      }
      for (;;)
      {
        if (this.tzz) {
          this.tzx = this.tzw.cSn();
        }
        cSv();
        mV(true);
        a(this.tzm);
        a(this.tzh);
        this.aNR = new GestureDetector(this, new GestureDetector.OnGestureListener()
        {
          public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
          {
            return false;
          }
          
          public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
          {
            return false;
          }
          
          public final void onLongPress(MotionEvent paramAnonymousMotionEvent) {}
          
          public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
          {
            AppMethodBeat.i(193007);
            if (!GroupSolitatireEditUI.u(GroupSolitatireEditUI.this)) {
              GroupSolitatireEditUI.this.hideVKB();
            }
            AppMethodBeat.o(193007);
            return false;
          }
          
          public final void onShowPress(MotionEvent paramAnonymousMotionEvent) {}
          
          public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
          {
            return false;
          }
        });
        this.tzE = new Rect();
        this.tzF = new Rect();
        AppMethodBeat.o(110463);
        return;
        if (!this.tzz)
        {
          this.tzh.setVisibility(8);
          this.tzi.setVisibility(8);
          break;
        }
        this.tzh.setHint(2131760117);
        break;
        if (!this.tzz)
        {
          this.tzm.setVisibility(8);
          break label784;
        }
        this.tzm.setHint(2131760108);
        break label784;
        label1373:
        this.tzh.setKeyListener(null);
        this.tzh.setTextIsSelectable(true);
        this.tzm.setKeyListener(null);
        this.tzm.setTextIsSelectable(true);
        break label923;
        ((MMEditText)localObject2).setHint(2131760098);
        this.tzt = true;
        break label1066;
        ((MMEditText)localObject2).setTextColor(getResources().getColor(2131099676));
        ((MMEditText)localObject2).setKeyListener(null);
        ((MMEditText)localObject2).setTextIsSelectable(true);
        break label1091;
        if (this.scene == 1) {
          this.kqh.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(110449);
              GroupSolitatireEditUI.i(GroupSolitatireEditUI.this).fullScroll(33);
              AppMethodBeat.o(110449);
            }
          });
        }
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(110478);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ((MMEditText)this.tzs).requestFocus();
    ac.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "onActivityResult reqCode: %d, retCod: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(110478);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(110478);
      return;
      String str1 = bs.bG(paramIntent.getStringExtra("Kwebmap_locaion"), "");
      String str2 = paramIntent.getStringExtra("kPoiName");
      ac.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "REQUEST_CODE_POST_LOC address: %s, poiName：%s", new Object[] { str1, str2 });
      paramIntent = str1;
      if (str1.contains(getString(2131760086))) {
        paramIntent = str1.substring(str1.indexOf(getString(2131760086)) + 1);
      }
      aij(str2 + "(" + paramIntent + ")");
      GM(3);
      AppMethodBeat.o(110478);
      return;
      ac.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "REQUEST_CODE_POST_CONTACT");
      if (this.tzG != null) {
        this.tzG.show();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(110461);
    super.onCreate(paramBundle);
    this.tzz = getIntent().getBooleanExtra("key_group_solitatire_create", false);
    String str1 = getIntent().getStringExtra("key_group_solitatire_key");
    this.tzy = getIntent().getStringExtra("key_group_solitatire_chatroom_username");
    this.scene = getIntent().getIntExtra("key_group_solitatire_scene", 3);
    int i;
    if ((this.scene == 3) || (cSr()))
    {
      paramBundle = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager();
      String str2 = this.tzy;
      ac.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "getTempGroupSolitatireFromCache() username:%s key:%s", new Object[] { str2, str1 });
      paramBundle = (com.tencent.mm.plugin.groupsolitaire.c.a)paramBundle.tyt.get(str2 + str1);
      if (paramBundle != null) {
        break label212;
      }
      ac.e("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "initData() key:%s temp == null", new Object[] { str1 });
      finish();
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        break label319;
      }
      AppMethodBeat.o(110461);
      return;
      paramBundle = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().hb(this.tzy, str1);
      break;
      label212:
      this.tzw = paramBundle.cSn();
      if (this.tzw == null)
      {
        ac.e("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "initData() key:%s mGroupSolitatire == null", new Object[] { str1 });
        finish();
        i = 0;
      }
      else
      {
        this.tzx = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().hb(this.tzy, this.tzw.field_key);
        this.ftP = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).awK().xN(this.tzy);
        setResult(0);
        i = 1;
      }
    }
    label319:
    initView();
    AppMethodBeat.o(110461);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(110470);
    super.onDestroy();
    AppMethodBeat.o(110470);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(110462);
    if (paramInt == 4)
    {
      if (!this.tzA) {
        Wt();
      }
      AppMethodBeat.o(110462);
      return true;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(110462);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(110468);
    super.onPause();
    if (this.fxG != null) {
      this.fxG.close();
    }
    AppMethodBeat.o(110468);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(110479);
    ac.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "onRequestPermissionsResult");
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      AppMethodBeat.o(110479);
      return;
    }
    if (paramArrayOfInt[0] == 0)
    {
      ac.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "onRequestPermissionsResult OK");
      cSu();
      AppMethodBeat.o(110479);
      return;
    }
    ac.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "onRequestPermissionsResult failed");
    com.tencent.mm.ui.base.h.a(getContext(), getString(2131761869), getString(2131761885), getString(2131760598), getString(2131761863), false, new GroupSolitatireEditUI.15(this), null);
    AppMethodBeat.o(110479);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(110467);
    super.onResume();
    this.kqh.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110432);
        if (GroupSolitatireEditUI.q(GroupSolitatireEditUI.this) != null) {
          GroupSolitatireEditUI.q(GroupSolitatireEditUI.this).start();
        }
        AppMethodBeat.o(110432);
      }
    });
    if ((this.scene == 2) || (cSq()) || (this.scene == 5)) {
      this.tzk.postDelayed(new GroupSolitatireEditUI.7(this), 200L);
    }
    AppMethodBeat.o(110467);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void u(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(110477);
    paramBoolean = this.tzA;
    if (paramInt > 0) {}
    for (this.tzA = true; (!paramBoolean) && (this.tzA); this.tzA = false)
    {
      localObject = this.tzD.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((View)((Iterator)localObject).next()).setTag(null);
      }
    }
    if (this.tzu == 0) {
      this.tzu = paramInt;
    }
    if (this.tzz)
    {
      this.tzh.setMaxLines(b(this.tzh));
      this.tzm.setMaxLines(b(this.tzm));
    }
    if (this.tzs != null)
    {
      if (!this.tzA) {
        this.tzs.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(110436);
            ((MMEditText)GroupSolitatireEditUI.b(GroupSolitatireEditUI.this)).setCursorVisible(false);
            AppMethodBeat.o(110436);
          }
        });
      }
    }
    else
    {
      if (!this.tzA) {
        break label293;
      }
      if (this.tzn.getTranslationY() != 0.0F) {
        this.tzn.setTranslationY(0.0F);
      }
    }
    label293:
    for (Object localObject = ObjectAnimator.ofFloat(this.tzn, "translationY", new float[] { this.tzn.getTranslationY(), this.tzn.getTranslationY() - this.tzu });; localObject = ObjectAnimator.ofFloat(this.tzn, "translationY", new float[] { this.tzn.getTranslationY(), this.tzn.getTranslationY() + this.tzu }))
    {
      ((ObjectAnimator)localObject).setDuration(175L);
      ((ObjectAnimator)localObject).setInterpolator(new android.support.v4.view.b.b());
      ((ObjectAnimator)localObject).addListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(110440);
          if (GroupSolitatireEditUI.e(GroupSolitatireEditUI.this))
          {
            GroupSolitatireEditUI.s(GroupSolitatireEditUI.this).setVisibility(4);
            AppMethodBeat.o(110440);
            return;
          }
          GroupSolitatireEditUI.t(GroupSolitatireEditUI.this);
          if (GroupSolitatireEditUI.c(GroupSolitatireEditUI.this).tyS.size() < com.tencent.mm.plugin.groupsolitaire.b.b.cSg()) {
            GroupSolitatireEditUI.s(GroupSolitatireEditUI.this).setVisibility(0);
          }
          GroupSolitatireEditUI.r(GroupSolitatireEditUI.this).setVisibility(8);
          AppMethodBeat.o(110440);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(110439);
          if (GroupSolitatireEditUI.e(GroupSolitatireEditUI.this)) {
            GroupSolitatireEditUI.r(GroupSolitatireEditUI.this).setVisibility(0);
          }
          AppMethodBeat.o(110439);
        }
      });
      ((ObjectAnimator)localObject).start();
      cSv();
      if (this.tzs != null) {
        break label336;
      }
      AppMethodBeat.o(110477);
      return;
      this.tzs.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110437);
          ((MMEditText)GroupSolitatireEditUI.b(GroupSolitatireEditUI.this)).setCursorVisible(true);
          AppMethodBeat.o(110437);
        }
      }, 100L);
      break;
    }
    label336:
    this.tzs.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110441);
        GroupSolitatireEditUI.a(GroupSolitatireEditUI.this, GroupSolitatireEditUI.e(GroupSolitatireEditUI.this));
        AppMethodBeat.o(110441);
      }
    }, 50L);
    ac.d("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "onInputPanelChange() isKeyboardShow:%s keyboardHeight:%s moveHeight:%s", new Object[] { Boolean.valueOf(this.tzA), Integer.valueOf(paramInt), Integer.valueOf(this.tzu) });
    AppMethodBeat.o(110477);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI
 * JD-Core Version:    0.7.0.1
 */