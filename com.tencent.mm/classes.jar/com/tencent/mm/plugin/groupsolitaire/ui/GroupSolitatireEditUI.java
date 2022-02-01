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
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.al;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aq;
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
  private GestureDetector aYl;
  private TextWatcher awu;
  private boolean djt;
  private ac fNS;
  private com.tencent.mm.ui.tools.h fSZ;
  private ScrollView kOy;
  private TextView lHT;
  private RelativeLayout ncd;
  private boolean rHE;
  private int scene;
  private MMEditText uNA;
  private LinearLayout uNB;
  private RelativeLayout uNC;
  private RelativeLayout uND;
  private RelativeLayout uNE;
  private View uNF;
  private View uNG;
  private boolean uNH;
  private int uNI;
  private int uNJ;
  private com.tencent.mm.plugin.groupsolitaire.c.a uNK;
  private com.tencent.mm.plugin.groupsolitaire.c.a uNL;
  private String uNM;
  private boolean uNN;
  private boolean uNO;
  private boolean uNP;
  private boolean uNQ;
  private ArrayList<View> uNR;
  private Rect uNS;
  private Rect uNT;
  private a uNU;
  private View.OnTouchListener uNV;
  private CdnImageView uNu;
  private MMEditText uNv;
  private View uNw;
  private View uNx;
  private LinearLayout uNy;
  private ImageButton uNz;
  
  public GroupSolitatireEditUI()
  {
    AppMethodBeat.i(110460);
    this.uNH = false;
    this.uNK = null;
    this.uNL = null;
    this.uNM = "";
    this.uNN = false;
    this.uNO = false;
    this.rHE = false;
    this.uNP = false;
    this.uNQ = false;
    this.uNR = new ArrayList();
    this.djt = false;
    this.awu = new TextWatcher()
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
          String str = ((com.tencent.mm.plugin.emoji.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.emoji.b.a.class)).abU((String)localObject1);
          localObject1 = str;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int i;
            int j;
            ae.e("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "afterTextChanged() emojiSoftBank2Unicode %s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
            continue;
            Object localObject2 = localObject1;
            if (j > com.tencent.mm.plugin.groupsolitaire.b.b.def() * 2)
            {
              i = com.tencent.mm.plugin.groupsolitaire.b.b.dX((String)localObject1, com.tencent.mm.plugin.groupsolitaire.b.b.def() * 2);
              paramAnonymousEditable.delete(i, ((String)localObject1).length());
              localObject2 = ((String)localObject1).substring(0, i);
            }
            GroupSolitatireEditUI.c(GroupSolitatireEditUI.this).header = ((String)localObject2);
            GroupSolitatireEditUI.c(GroupSolitatireEditUI.this).uNe = 1;
            continue;
            GroupSolitatireEditUI.c(GroupSolitatireEditUI.this).uNd = ((String)localObject1);
            continue;
            com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)((MMEditText)GroupSolitatireEditUI.b(GroupSolitatireEditUI.this)).getTag(2131300641);
            if (localb != null)
            {
              localObject2 = localObject1;
              if (j > com.tencent.mm.plugin.groupsolitaire.b.b.dee() * 2)
              {
                i = com.tencent.mm.plugin.groupsolitaire.b.b.dX((String)localObject1, com.tencent.mm.plugin.groupsolitaire.b.b.dee() * 2);
                paramAnonymousEditable.delete(i, ((String)localObject1).length());
                localObject2 = ((String)localObject1).substring(0, i);
              }
              localb.content = ((String)localObject2);
              continue;
              localObject2 = localObject1;
              if (j > com.tencent.mm.plugin.groupsolitaire.b.b.deg() * 2)
              {
                i = com.tencent.mm.plugin.groupsolitaire.b.b.dX((String)localObject1, com.tencent.mm.plugin.groupsolitaire.b.b.deg() * 2);
                paramAnonymousEditable.delete(i, ((String)localObject1).length());
                localObject2 = ((String)localObject1).substring(0, i);
              }
              GroupSolitatireEditUI.c(GroupSolitatireEditUI.this).ufC = ((String)localObject2);
            }
          }
        }
        i = ((Integer)((MMEditText)GroupSolitatireEditUI.b(GroupSolitatireEditUI.this)).getTag(2131300643)).intValue();
        ae.d("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "afterTextChanged() str:%s type:%s", new Object[] { localObject1, Integer.valueOf(i) });
        j = com.tencent.mm.plugin.groupsolitaire.b.b.anS((String)localObject1);
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
          ae.d("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "startTime:%s interTime:%s", new Object[] { Long.valueOf(l), Long.valueOf(System.currentTimeMillis() - l) });
          AppMethodBeat.o(110427);
          return;
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
    this.uNV = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(110438);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
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
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(110438);
        return false;
      }
    };
    AppMethodBeat.o(110460);
  }
  
  private void S(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2) {
      this.rHE = paramBoolean1;
    }
  }
  
  private boolean YV()
  {
    AppMethodBeat.i(110464);
    if (this.rHE) {
      com.tencent.mm.ui.base.h.a(this, getString(2131760092), "", getString(2131760091), getString(2131760090), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(110429);
          ae.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "back_dialot ok");
          ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
          com.tencent.mm.plugin.groupsolitaire.b.d.a(GroupSolitatireEditUI.c(GroupSolitatireEditUI.this), GroupSolitatireEditUI.o(GroupSolitatireEditUI.this), 2, GroupSolitatireEditUI.f(GroupSolitatireEditUI.this));
          GroupSolitatireEditUI.this.finish();
          AppMethodBeat.o(110429);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(110430);
          ae.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "back_dialot cancel");
          AppMethodBeat.o(110430);
        }
      }, 2131100798);
    }
    for (;;)
    {
      AppMethodBeat.o(110464);
      return true;
      ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
      com.tencent.mm.plugin.groupsolitaire.b.d.a(this.uNK, den(), 1, this.uNN);
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
        AppMethodBeat.i(221120);
        if ((paramAnonymousBoolean) && (GroupSolitatireEditUI.b(GroupSolitatireEditUI.this) != null) && (GroupSolitatireEditUI.e(GroupSolitatireEditUI.this)))
        {
          GroupSolitatireEditUI.b(GroupSolitatireEditUI.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(221118);
              GroupSolitatireEditUI.a(GroupSolitatireEditUI.this);
              AppMethodBeat.o(221118);
            }
          }, 200L);
          GroupSolitatireEditUI.b(GroupSolitatireEditUI.this).postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(221119);
              GroupSolitatireEditUI.a(GroupSolitatireEditUI.this, GroupSolitatireEditUI.e(GroupSolitatireEditUI.this));
              AppMethodBeat.o(221119);
            }
          }, 200L);
          AppMethodBeat.o(221120);
          return;
        }
        paramMMEditText.setSelection(0);
        AppMethodBeat.o(221120);
      }
    });
    AppMethodBeat.o(110483);
  }
  
  private void anX(String paramString)
  {
    AppMethodBeat.i(110481);
    ((MMEditText)this.uNG).requestFocus();
    this.uNy.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110443);
        GroupSolitatireEditUI.this.showVKB();
        AppMethodBeat.o(110443);
      }
    }, 200L);
    ((MMEditText)this.uNG).getText().insert(this.uNJ, paramString + "; ");
    AppMethodBeat.o(110481);
  }
  
  private int b(MMEditText paramMMEditText)
  {
    AppMethodBeat.i(110484);
    if (this.uNI == 0)
    {
      AppMethodBeat.o(110484);
      return 10;
    }
    int i = ((WindowManager)getSystemService("window")).getDefaultDisplay().getHeight();
    float f = paramMMEditText.getLineHeight();
    i = (int)((i - (this.uNI + this.uNB.getHeight() + aq.fromDPToPix(this, 145))) / f);
    AppMethodBeat.o(110484);
    return i;
  }
  
  private CharSequence bv(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(110472);
    com.tencent.mm.kernel.g.ajS();
    an localan = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(paramString);
    if ((paramBoolean) && (!bu.isNullOrNil(localan.field_conRemark))) {}
    for (String str = localan.field_conRemark;; str = vq(localan.field_username))
    {
      paramString = str;
      if (bu.isNullOrNil(str)) {
        paramString = localan.field_conRemark;
      }
      str = paramString;
      if (bu.isNullOrNil(paramString)) {
        str = localan.adF();
      }
      paramString = str;
      if (bu.isNullOrNil(str)) {
        paramString = localan.field_username;
      }
      paramString = k.c(getContext(), paramString);
      AppMethodBeat.o(110472);
      return paramString;
    }
  }
  
  private int den()
  {
    AppMethodBeat.i(110465);
    if (deo())
    {
      AppMethodBeat.o(110465);
      return 3;
    }
    int i = this.scene;
    AppMethodBeat.o(110465);
    return i;
  }
  
  private boolean deo()
  {
    return (this.scene == 3) || (this.scene == 4);
  }
  
  private boolean dep()
  {
    return (this.scene == 4) || (this.scene == 5);
  }
  
  private void deq()
  {
    AppMethodBeat.i(110466);
    int j = 1;
    int i = 1;
    MMEditText localMMEditText;
    if (j <= this.uNK.uNg.size())
    {
      com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)this.uNK.uNg.get(Integer.valueOf(j));
      if (localb == null) {
        break label287;
      }
      View localView = getLayoutInflater().inflate(2131494425, null);
      ((TextView)localView.findViewById(2131300637)).setText(String.valueOf(i));
      localMMEditText = (MMEditText)localView.findViewById(2131300636);
      localMMEditText.setTag(2131300643, Integer.valueOf(3));
      localMMEditText.setTag(2131300641, localb);
      localMMEditText.setText(k.b(localMMEditText.getContext(), localb.content, (int)localMMEditText.getTextSize()));
      if (bu.lX(localb.username, v.aAC()))
      {
        this.uNQ = true;
        localMMEditText.requestFocus();
        localMMEditText.setFocusable(true);
        localMMEditText.setFocusableInTouchMode(true);
        localMMEditText.addTextChangedListener(this.awu);
        if (this.scene == 1) {
          localMMEditText.setCursorVisible(false);
        }
        label193:
        localMMEditText.setOnTouchListener(this.uNV);
        localMMEditText.setMaxLines(10);
        this.uNy.addView(localView);
        this.uNR.add(localView);
        a(localMMEditText);
        i += 1;
      }
    }
    label287:
    for (;;)
    {
      j += 1;
      break;
      this.uNQ = false;
      localMMEditText.setTextColor(getResources().getColor(2131099676));
      localMMEditText.setKeyListener(null);
      localMMEditText.setTextIsSelectable(true);
      break label193;
      AppMethodBeat.o(110466);
      return;
    }
  }
  
  private Pair<Boolean, Boolean> der()
  {
    boolean bool4 = false;
    AppMethodBeat.i(221125);
    Object localObject1 = new HashSet();
    int i = 1;
    while (i <= this.uNL.uNg.size())
    {
      localObject2 = (com.tencent.mm.plugin.groupsolitaire.c.b)this.uNL.uNg.get(Integer.valueOf(i));
      if (bu.lX(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject2).username, v.aAC())) {
        ((Set)localObject1).add(localObject2);
      }
      i += 1;
    }
    Object localObject2 = new ArrayList();
    HashSet localHashSet = new HashSet();
    i = 1;
    while (i <= this.uNK.uNg.size())
    {
      com.tencent.mm.plugin.groupsolitaire.c.b localb = (com.tencent.mm.plugin.groupsolitaire.c.b)this.uNK.uNg.get(Integer.valueOf(i));
      if ((bu.lX(localb.username, v.aAC())) && (!bu.isNullOrNil(localb.content.trim())))
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
      AppMethodBeat.o(221125);
      return localObject1;
      bool1 = false;
      break;
      bool1 = false;
    }
  }
  
  private void des()
  {
    AppMethodBeat.i(110480);
    if (com.tencent.mm.aw.b.Gw((String)com.tencent.mm.kernel.g.ajR().ajA().get(274436, null)))
    {
      if (!com.tencent.mm.pluginsdk.permission.b.n(this, "android.permission.ACCESS_COARSE_LOCATION"))
      {
        if (!((Boolean)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IYR, Boolean.FALSE)).booleanValue())
        {
          com.tencent.mm.plugin.account.a.b.a.b(this, getResources().getString(2131760740, new Object[] { ad.fom() }), 30764, true);
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
      ae.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool) });
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
  
  private void det()
  {
    AppMethodBeat.i(110482);
    if (this.ncd.findFocus() == null)
    {
      ae.d("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "mRootContainer.findFocus() is null");
      AppMethodBeat.o(110482);
      return;
    }
    this.uNG = this.ncd.findFocus();
    this.uNJ = ((MMEditText)this.uNG).getSelectionStart();
    AppMethodBeat.o(110482);
  }
  
  private void ns(boolean paramBoolean)
  {
    AppMethodBeat.i(221124);
    com.tencent.mm.plugin.groupsolitaire.c.b localb = new com.tencent.mm.plugin.groupsolitaire.c.b();
    View localView = getLayoutInflater().inflate(2131494425, null);
    ((TextView)localView.findViewById(2131300637)).setText(this.uNK.uNg.size() + 1);
    MMEditText localMMEditText = (MMEditText)localView.findViewById(2131300636);
    CharSequence localCharSequence = bv(v.aAC(), false);
    if (!bu.ah(localCharSequence))
    {
      localMMEditText.setText(localCharSequence + " ");
      localb.content = String.valueOf(localCharSequence);
    }
    localb.username = v.aAC();
    localb.separator = this.uNK.separator;
    localb.uNk = (this.uNK.uNg.size() + 1);
    localMMEditText.setTag(2131300643, Integer.valueOf(3));
    localMMEditText.setTag(2131300641, localb);
    localMMEditText.requestFocus();
    localMMEditText.setFocusable(true);
    localMMEditText.setFocusableInTouchMode(true);
    localMMEditText.addTextChangedListener(this.awu);
    localMMEditText.setOnTouchListener(this.uNV);
    a(localMMEditText);
    localMMEditText.setMaxLines(10);
    this.uNK.uNg.put(Integer.valueOf(this.uNK.uNg.size() + 1), localb);
    this.uNy.addView(localView);
    this.uNR.add(localView);
    localView.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110434);
        GroupSolitatireEditUI.this.showVKB();
        AppMethodBeat.o(110434);
      }
    });
    nt(paramBoolean);
    AppMethodBeat.o(221124);
  }
  
  private void nt(boolean paramBoolean)
  {
    AppMethodBeat.i(110475);
    int i = 1;
    Object localObject;
    if (i <= this.uNK.uNg.size())
    {
      localObject = (com.tencent.mm.plugin.groupsolitaire.c.b)this.uNK.uNg.get(Integer.valueOf(i));
      if ((localObject == null) || (bu.isNullOrNil(((com.tencent.mm.plugin.groupsolitaire.c.b)localObject).content.trim()))) {}
    }
    for (i = 1;; i = 0)
    {
      if (this.uNN)
      {
        if (i != 0)
        {
          enableOptionMenu(0, true);
          if (paramBoolean) {
            break label317;
          }
          if ((this.uNL != null) && (bu.lX(this.uNK.header, this.uNL.header)) && (bu.lX(this.uNK.uNd, this.uNL.uNd)) && (bu.lX(this.uNK.ufC, this.uNL.ufC)))
          {
            localObject = der();
            bool1 = ((Boolean)((Pair)localObject).first).booleanValue();
            bool2 = ((Boolean)((Pair)localObject).second).booleanValue();
            if ((!bool1) && (!bool2))
            {
              S(false, paramBoolean);
              AppMethodBeat.o(110475);
              return;
              i += 1;
              break;
            }
          }
          S(true, paramBoolean);
          AppMethodBeat.o(110475);
          return;
        }
        enableOptionMenu(0, false);
        S(false, paramBoolean);
        AppMethodBeat.o(110475);
        return;
      }
      localObject = der();
      boolean bool1 = ((Boolean)((Pair)localObject).first).booleanValue();
      boolean bool2 = ((Boolean)((Pair)localObject).second).booleanValue();
      if ((i != 0) && ((bool1) || (bool2)))
      {
        enableOptionMenu(0, true);
        S(true, paramBoolean);
        AppMethodBeat.o(110475);
        return;
      }
      enableOptionMenu(0, false);
      S(false, paramBoolean);
      label317:
      AppMethodBeat.o(110475);
      return;
    }
  }
  
  private String vq(String paramString)
  {
    AppMethodBeat.i(110473);
    if (this.fNS == null)
    {
      AppMethodBeat.o(110473);
      return null;
    }
    paramString = this.fNS.zP(paramString);
    AppMethodBeat.o(110473);
    return paramString;
  }
  
  public final void IG(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(110476);
    if ((this.uNG == null) || (!(this.uNG instanceof MMEditText)))
    {
      ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
      com.tencent.mm.plugin.groupsolitaire.b.d.a(this.uNK, paramInt, 0);
      AppMethodBeat.o(110476);
      return;
    }
    switch (((Integer)((MMEditText)this.uNG).getTag(2131300643)).intValue())
    {
    }
    for (;;)
    {
      ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
      com.tencent.mm.plugin.groupsolitaire.b.d.a(this.uNK, paramInt, i);
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
    GestureDetector localGestureDetector = this.aYl;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, locala.ahE(), "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.mt(0)), "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
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
      ae.e("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "finish() hideVKB() %s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
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
    this.fSZ = new com.tencent.mm.ui.tools.h(getContext());
    this.fSZ.Lfj = this;
    this.kOy = ((ScrollView)findViewById(2131304251));
    this.ncd = ((RelativeLayout)findViewById(2131304241));
    this.uNu = ((CdnImageView)findViewById(2131300638));
    this.lHT = ((TextView)findViewById(2131300639));
    this.uNv = ((MMEditText)findViewById(2131300644));
    this.uNw = findViewById(2131300650);
    this.uNx = findViewById(2131300651);
    this.uNy = ((LinearLayout)findViewById(2131300640));
    this.uNz = ((ImageButton)findViewById(2131300642));
    this.uNA = ((MMEditText)findViewById(2131300653));
    this.uNB = ((LinearLayout)findViewById(2131300645));
    this.uNC = ((RelativeLayout)findViewById(2131300646));
    this.uND = ((RelativeLayout)findViewById(2131300647));
    this.uNE = ((RelativeLayout)findViewById(2131300648));
    this.uNF = findViewById(2131300652);
    this.uNC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110450);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        GroupSolitatireEditUI.a(GroupSolitatireEditUI.this);
        GroupSolitatireEditUI.j(GroupSolitatireEditUI.this);
        GroupSolitatireEditUI.this.IG(2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(110450);
      }
    });
    this.uND.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(final View paramAnonymousView)
      {
        AppMethodBeat.i(110453);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        GroupSolitatireEditUI.a(GroupSolitatireEditUI.this);
        if (((GroupSolitatireEditUI.b(GroupSolitatireEditUI.this) instanceof MMEditText)) && ((GroupSolitatireEditUI.b(GroupSolitatireEditUI.this).getParent() instanceof RelativeLayout))) {
          ((RelativeLayout)GroupSolitatireEditUI.b(GroupSolitatireEditUI.this).getParent()).setTag(Integer.valueOf(1));
        }
        paramAnonymousView = new a(GroupSolitatireEditUI.this);
        paramAnonymousView.uNp = new a.a()
        {
          public final void anW(String paramAnonymous2String)
          {
            AppMethodBeat.i(110451);
            paramAnonymousView.hide();
            GroupSolitatireEditUI.a(GroupSolitatireEditUI.this, paramAnonymous2String);
            GroupSolitatireEditUI.this.IG(5);
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
        GroupSolitatireEditUI.this.IG(4);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(110453);
      }
    });
    this.uNE.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110455);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        GroupSolitatireEditUI.a(GroupSolitatireEditUI.this);
        if (((GroupSolitatireEditUI.b(GroupSolitatireEditUI.this) instanceof MMEditText)) && ((GroupSolitatireEditUI.b(GroupSolitatireEditUI.this).getParent() instanceof RelativeLayout))) {
          ((RelativeLayout)GroupSolitatireEditUI.b(GroupSolitatireEditUI.this).getParent()).setTag(Integer.valueOf(1));
        }
        paramAnonymousView = new b(GroupSolitatireEditUI.this);
        int i;
        int j;
        label135:
        int k;
        if (paramAnonymousView.uNr != null)
        {
          i = paramAnonymousView.uNr.getYear();
          if (paramAnonymousView.uNr == null) {
            break label311;
          }
          j = paramAnonymousView.uNr.getMonth();
          if (paramAnonymousView.uNr == null) {
            break label316;
          }
          k = paramAnonymousView.uNr.getDayOfMonth();
          label151:
          paramAnonymousView.uNs = new b.a()
          {
            public final void onResult(boolean paramAnonymous2Boolean, int paramAnonymous2Int1, int paramAnonymous2Int2, int paramAnonymous2Int3)
            {
              AppMethodBeat.i(110454);
              if (paramAnonymous2Boolean)
              {
                ae.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "group solitaire time :%s", new Object[] { String.format(Locale.US, "%04d-%02d-%02d", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) }) });
                GroupSolitatireEditUI.a(GroupSolitatireEditUI.this, String.format(Locale.US, "%04d/%02d/%02d", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(paramAnonymous2Int3) }));
                GroupSolitatireEditUI.this.IG(1);
              }
              AppMethodBeat.o(110454);
            }
          };
          if ((i >= 0) && (j >= 0) && (k >= 0)) {
            break label322;
          }
        }
        for (;;)
        {
          localObject = Calendar.getInstance(Locale.US);
          ((Calendar)localObject).set(2009, 0, 1);
          if (paramAnonymousView.uNr != null) {
            paramAnonymousView.uNr.setMinDate(((Calendar)localObject).getTimeInMillis());
          }
          localObject = Calendar.getInstance(Locale.US);
          ((Calendar)localObject).set(2029, 11, 31);
          if (paramAnonymousView.uNr != null) {
            paramAnonymousView.uNr.setMaxDate(((Calendar)localObject).getTimeInMillis());
          }
          if (paramAnonymousView.uNn != null)
          {
            if (paramAnonymousView.uNr != null) {
              paramAnonymousView.uNr.bGa();
            }
            paramAnonymousView.uNn.show();
          }
          GroupSolitatireEditUI.this.IG(0);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(110455);
          return;
          i = 0;
          break;
          label311:
          j = 0;
          break label135;
          label316:
          k = 0;
          break label151;
          label322:
          if (paramAnonymousView.uNr != null) {
            paramAnonymousView.uNr.a(i, j, k, null);
          }
        }
      }
    });
    addTextOptionMenu(0, getString(2131760107), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(110458);
        ae.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "send group solitaire(sending:%s)", new Object[] { Boolean.valueOf(GroupSolitatireEditUI.k(GroupSolitatireEditUI.this)) });
        if (GroupSolitatireEditUI.k(GroupSolitatireEditUI.this))
        {
          AppMethodBeat.o(110458);
          return true;
        }
        com.tencent.mm.plugin.groupsolitaire.b.b.a(GroupSolitatireEditUI.l(GroupSolitatireEditUI.this), v.aAC(), GroupSolitatireEditUI.c(GroupSolitatireEditUI.this));
        if (GroupSolitatireEditUI.c(GroupSolitatireEditUI.this).uNh) {
          com.tencent.mm.ui.base.h.e(GroupSolitatireEditUI.this.getContext(), GroupSolitatireEditUI.this.getString(2131760105), "", GroupSolitatireEditUI.this.getString(2131760104), GroupSolitatireEditUI.this.getString(2131760103), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(110456);
              ae.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "group solitatire repeat dialog ok");
              GroupSolitatireEditUI.m(GroupSolitatireEditUI.this);
              AppMethodBeat.o(110456);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(110457);
              ae.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "group solitatire repeat dialog cancel");
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
    }, null, s.b.JwA);
    Object localObject1;
    if (this.uNN)
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
      if (!ar.isMainThread()) {
        break label465;
      }
      ((Runnable)localObject1).run();
    }
    for (;;)
    {
      if (this.uNK.uNg.size() <= 0) {
        break label1477;
      }
      localObject1 = new HashSet();
      i = 1;
      while (i <= this.uNK.uNg.size())
      {
        ((Set)localObject1).add(((com.tencent.mm.plugin.groupsolitaire.c.b)this.uNK.uNg.get(Integer.valueOf(i))).username);
        i += 1;
      }
      enableOptionMenu(0, false);
      break;
      label465:
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110428);
          this.val$run.run();
          AppMethodBeat.o(110428);
        }
      });
    }
    label784:
    label923:
    label1066:
    label1091:
    label1477:
    for (int i = ((Set)localObject1).size();; i = 0)
    {
      this.lHT.setText(getString(2131760119, new Object[] { bv(this.uNK.field_creator, true), String.valueOf(i) }));
      Object localObject2;
      if ((!bu.isNullOrNil(this.uNK.header)) && (this.uNK.uNe == 1))
      {
        localObject2 = this.uNK.header;
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (com.tencent.mm.plugin.groupsolitaire.b.b.anS((String)localObject2) > com.tencent.mm.plugin.groupsolitaire.b.b.def() * 2)
          {
            localObject1 = ((String)localObject2).substring(0, com.tencent.mm.plugin.groupsolitaire.b.b.dX((String)localObject2, com.tencent.mm.plugin.groupsolitaire.b.b.def() * 2));
            this.uNK.header = ((String)localObject1);
          }
        }
        localObject1 = k.a(this.uNv.getContext(), (CharSequence)localObject1, (int)this.uNv.getTextSize(), 1);
        this.uNv.setText((CharSequence)localObject1);
        if ((this.uNN) && (!bu.isNullOrNil(this.uNK.header)) && (this.uNK.uNe == 0))
        {
          this.uNK.uNe = 1;
          this.uNK.header = "";
          if ((this.uNK.uNg.size() > 0) && (((com.tencent.mm.plugin.groupsolitaire.c.b)this.uNK.uNg.get(Integer.valueOf(1))).uNj == 1)) {
            ((com.tencent.mm.plugin.groupsolitaire.c.b)this.uNK.uNg.get(Integer.valueOf(1))).uNj = 0;
          }
        }
        if (bu.isNullOrNil(this.uNK.ufC)) {
          break label1341;
        }
        localObject1 = k.a(this.uNA.getContext(), this.uNK.ufC, (int)this.uNA.getTextSize(), 1);
        this.uNA.setText((CharSequence)localObject1);
        if (!this.uNN) {
          break label1373;
        }
        this.uNv.setFocusable(true);
        this.uNv.setFocusableInTouchMode(true);
        this.uNv.requestFocus();
        this.uNv.setOnTouchListener(this.uNV);
        if (bu.isNullOrNil(this.uNK.header)) {
          this.uNv.setHeight(com.tencent.mm.cb.a.fromDPToPix(getContext(), 160));
        }
        this.uNv.addTextChangedListener(this.awu);
        this.uNv.setMaxLines(10);
        this.uNA.setFocusable(true);
        this.uNA.setFocusableInTouchMode(true);
        this.uNA.addTextChangedListener(this.awu);
        this.uNA.setOnTouchListener(this.uNV);
        this.uNA.setMaxLines(10);
        this.uNv.setTag(2131300643, Integer.valueOf(1));
        this.uNA.setTag(2131300643, Integer.valueOf(4));
        if ((!bu.isNullOrNil(this.uNK.uNd)) || (this.uNN))
        {
          localObject1 = getLayoutInflater().inflate(2131494425, null);
          ((TextView)((View)localObject1).findViewById(2131300637)).setText(getString(2131760099));
          localObject2 = (MMEditText)((View)localObject1).findViewById(2131300636);
          ((MMEditText)localObject2).setTag(2131300643, Integer.valueOf(2));
          if (bu.isNullOrNil(this.uNK.uNd)) {
            break label1408;
          }
          ((MMEditText)localObject2).setText(k.b(((MMEditText)localObject2).getContext(), this.uNK.uNd, (int)((MMEditText)localObject2).getTextSize()));
          this.uNH = false;
          if (!this.uNN) {
            break label1423;
          }
          ((MMEditText)localObject2).setFocusable(true);
          ((MMEditText)localObject2).setFocusableInTouchMode(true);
          ((MMEditText)localObject2).addTextChangedListener(this.awu);
          ((MMEditText)localObject2).setOnTouchListener(this.uNV);
          ((MMEditText)localObject2).setMaxLines(10);
          this.uNy.addView((View)localObject1);
        }
        deq();
        if (this.uNK.uNg.size() < com.tencent.mm.plugin.groupsolitaire.b.b.ded()) {
          this.uNz.setOnClickListener(new GroupSolitatireEditUI.5(this));
        }
        if ((this.scene != 2) && ((!deo()) || (this.uNK.uNi <= 0)) && (this.scene != 5)) {
          break label1450;
        }
        ns(true);
        if ((this.uNN) && (dep())) {
          this.uNv.requestFocus();
        }
      }
      for (;;)
      {
        if (this.uNN) {
          this.uNL = this.uNK.del();
        }
        det();
        nt(true);
        a(this.uNA);
        a(this.uNv);
        this.aYl = new GestureDetector(this, new GestureDetector.OnGestureListener()
        {
          public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
          {
            return false;
          }
          
          public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
          {
            return false;
          }
          
          public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(221123);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$26", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$26", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
            AppMethodBeat.o(221123);
          }
          
          public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
          {
            AppMethodBeat.i(221121);
            if (!GroupSolitatireEditUI.u(GroupSolitatireEditUI.this)) {
              GroupSolitatireEditUI.this.hideVKB();
            }
            AppMethodBeat.o(221121);
            return false;
          }
          
          public final void onShowPress(MotionEvent paramAnonymousMotionEvent) {}
          
          public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
          {
            AppMethodBeat.i(221122);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousMotionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$26", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/groupsolitaire/ui/GroupSolitatireEditUI$26", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(221122);
            return false;
          }
        });
        this.uNS = new Rect();
        this.uNT = new Rect();
        AppMethodBeat.o(110463);
        return;
        if (!this.uNN)
        {
          this.uNv.setVisibility(8);
          this.uNw.setVisibility(8);
          break;
        }
        this.uNv.setHint(2131760117);
        break;
        if (!this.uNN)
        {
          this.uNA.setVisibility(8);
          break label784;
        }
        this.uNA.setHint(2131760108);
        break label784;
        label1373:
        this.uNv.setKeyListener(null);
        this.uNv.setTextIsSelectable(true);
        this.uNA.setKeyListener(null);
        this.uNA.setTextIsSelectable(true);
        break label923;
        ((MMEditText)localObject2).setHint(2131760098);
        this.uNH = true;
        break label1066;
        ((MMEditText)localObject2).setTextColor(getResources().getColor(2131099676));
        ((MMEditText)localObject2).setKeyListener(null);
        ((MMEditText)localObject2).setTextIsSelectable(true);
        break label1091;
        if (this.scene == 1) {
          this.kOy.post(new Runnable()
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
    ((MMEditText)this.uNG).requestFocus();
    ae.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "onActivityResult reqCode: %d, retCod: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
      String str1 = bu.bI(paramIntent.getStringExtra("Kwebmap_locaion"), "");
      String str2 = paramIntent.getStringExtra("kPoiName");
      ae.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "REQUEST_CODE_POST_LOC address: %s, poiName：%s", new Object[] { str1, str2 });
      paramIntent = str1;
      if (str1.contains(getString(2131760086))) {
        paramIntent = str1.substring(str1.indexOf(getString(2131760086)) + 1);
      }
      anX(str2 + "(" + paramIntent + ")");
      IG(3);
      AppMethodBeat.o(110478);
      return;
      ae.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "REQUEST_CODE_POST_CONTACT");
      if (this.uNU != null) {
        this.uNU.show();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(110461);
    super.onCreate(paramBundle);
    this.uNN = getIntent().getBooleanExtra("key_group_solitatire_create", false);
    String str1 = getIntent().getStringExtra("key_group_solitatire_key");
    this.uNM = getIntent().getStringExtra("key_group_solitatire_chatroom_username");
    this.scene = getIntent().getIntExtra("key_group_solitatire_scene", 3);
    int i;
    if ((this.scene == 3) || (dep()))
    {
      paramBundle = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager();
      String str2 = this.uNM;
      ae.d("MicroMsg.groupsolitaire.GroupSolitatireManager", "getTempGroupSolitatireFromCache() username:%s key:%s", new Object[] { str2, str1 });
      paramBundle = (com.tencent.mm.plugin.groupsolitaire.c.a)paramBundle.uMI.get(str2 + str1);
      if (paramBundle != null) {
        break label212;
      }
      ae.e("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "initData() key:%s temp == null", new Object[] { str1 });
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
      paramBundle = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().hu(this.uNM, str1);
      break;
      label212:
      this.uNK = paramBundle.del();
      if (this.uNK == null)
      {
        ae.e("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "initData() key:%s mGroupSolitatire == null", new Object[] { str1 });
        finish();
        i = 0;
      }
      else
      {
        this.uNL = ((PluginGroupSolitaire)com.tencent.mm.kernel.g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().hu(this.uNM, this.uNK.field_key);
        this.fNS = ((com.tencent.mm.plugin.chatroom.a.c)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(this.uNM);
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
      if (!this.uNO) {
        YV();
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
    if (this.fSZ != null) {
      this.fSZ.close();
    }
    AppMethodBeat.o(110468);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(110479);
    ae.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "onRequestPermissionsResult");
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      AppMethodBeat.o(110479);
      return;
    }
    if (paramArrayOfInt[0] == 0)
    {
      ae.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "onRequestPermissionsResult OK");
      des();
      AppMethodBeat.o(110479);
      return;
    }
    ae.i("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "onRequestPermissionsResult failed");
    com.tencent.mm.ui.base.h.a(getContext(), getString(2131761869), getString(2131761885), getString(2131760598), getString(2131761863), false, new GroupSolitatireEditUI.15(this), null);
    AppMethodBeat.o(110479);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(110467);
    super.onResume();
    this.kOy.post(new Runnable()
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
    if ((this.scene == 2) || (deo()) || (this.scene == 5)) {
      this.uNy.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(110433);
          GroupSolitatireEditUI.this.showVKB();
          AppMethodBeat.o(110433);
        }
      }, 200L);
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
    paramBoolean = this.uNO;
    if (paramInt > 0) {}
    for (this.uNO = true; (!paramBoolean) && (this.uNO); this.uNO = false)
    {
      localObject = this.uNR.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((View)((Iterator)localObject).next()).setTag(null);
      }
    }
    if (this.uNI == 0) {
      this.uNI = paramInt;
    }
    if (this.uNN)
    {
      this.uNv.setMaxLines(b(this.uNv));
      this.uNA.setMaxLines(b(this.uNA));
    }
    if (this.uNG != null)
    {
      if (!this.uNO) {
        this.uNG.post(new Runnable()
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
      if (!this.uNO) {
        break label293;
      }
      if (this.uNB.getTranslationY() != 0.0F) {
        this.uNB.setTranslationY(0.0F);
      }
    }
    label293:
    for (Object localObject = ObjectAnimator.ofFloat(this.uNB, "translationY", new float[] { this.uNB.getTranslationY(), this.uNB.getTranslationY() - this.uNI });; localObject = ObjectAnimator.ofFloat(this.uNB, "translationY", new float[] { this.uNB.getTranslationY(), this.uNB.getTranslationY() + this.uNI }))
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
          if (GroupSolitatireEditUI.c(GroupSolitatireEditUI.this).uNg.size() < com.tencent.mm.plugin.groupsolitaire.b.b.ded()) {
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
      det();
      if (this.uNG != null) {
        break label336;
      }
      AppMethodBeat.o(110477);
      return;
      this.uNG.postDelayed(new Runnable()
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
    this.uNG.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(110441);
        GroupSolitatireEditUI.a(GroupSolitatireEditUI.this, GroupSolitatireEditUI.e(GroupSolitatireEditUI.this));
        AppMethodBeat.o(110441);
      }
    }, 50L);
    ae.d("MicroMsg.groupsolitaire.GroupSolitatireEditUI", "onInputPanelChange() isKeyboardShow:%s keyboardHeight:%s moveHeight:%s", new Object[] { Boolean.valueOf(this.uNO), Integer.valueOf(paramInt), Integer.valueOf(this.uNI) });
    AppMethodBeat.o(110477);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.ui.GroupSolitatireEditUI
 * JD-Core Version:    0.7.0.1
 */