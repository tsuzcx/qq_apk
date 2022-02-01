package com.tencent.mm.plugin.label.ui.searchLabel;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.label.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.ui.tools.i;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.ui.tools.s.b;
import com.tencent.mm.ui.tools.s.c;
import com.tencent.mm.ui.widget.a.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LabelSearchUI
  extends MMActivity
  implements h
{
  private View JVc;
  private boolean JVi;
  private boolean JWg;
  private boolean JWh;
  private ArrayList<String> JYc;
  private Button JYd;
  private a JYe;
  private ArrayList<aw> JYf;
  private TextView JYg;
  private View JYh;
  private i lKz;
  private s lMw;
  private RecyclerView mRecyclerView;
  private int mState;
  private TextView njO;
  e pjp;
  private LinearLayoutManager uQP;
  private com.tencent.mm.ui.widget.b.a vEV;
  private u.i yBn;
  
  public LabelSearchUI()
  {
    AppMethodBeat.i(268841);
    this.JYc = new ArrayList();
    this.mState = -1;
    this.JVi = false;
    this.JYf = null;
    this.JWg = false;
    this.JWh = false;
    this.yBn = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(268810);
        switch (paramAnonymousMenuItem.getItemId())
        {
        default: 
          AppMethodBeat.o(268810);
          return;
        }
        AppMethodBeat.o(268810);
      }
    };
    this.pjp = null;
    AppMethodBeat.o(268841);
  }
  
  private void aJP(String paramString)
  {
    AppMethodBeat.i(268847);
    Toast.makeText(this, paramString, 0).show();
    AppMethodBeat.o(268847);
  }
  
  private boolean fTH()
  {
    return this.mState == 0;
  }
  
  public int getLayoutId()
  {
    return R.i.glg;
  }
  
  public void initView()
  {
    AppMethodBeat.i(268953);
    setMMTitle("");
    ((TextView)findViewById(R.h.fGG)).setVisibility(8);
    this.mRecyclerView = ((RecyclerView)findViewById(R.h.fMd));
    this.njO = ((TextView)findViewById(R.h.fGG));
    this.njO.setText(R.l.gqw);
    this.mState = getIntent().getIntExtra("edit_mode_state", -1);
    this.JYf = d.fTa().iZO();
    this.JYe = new a(getContext());
    Object localObject = getIntent().getStringExtra("contact_has_choose_label_list");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      this.JYc.clear();
      this.JYc.addAll(Util.stringToList((String)localObject, ","));
      if (!this.JYc.isEmpty()) {
        this.JYe.JXT = this.JYc;
      }
    }
    this.mRecyclerView.setAdapter(this.JYe);
    this.uQP = new LinearLayoutManager();
    this.mRecyclerView.setLayoutManager(this.uQP);
    this.mRecyclerView.setHasFixedSize(true);
    this.JYe.setData(this.JYf);
    this.lMw = new s(false);
    this.lMw.MY(true);
    this.lMw.afKu = true;
    this.JVc = findViewById(R.h.edit_footer);
    this.lMw.setHint(getResources().getString(R.l.gMw));
    this.JYe.JXW = this.JYf;
    this.JVc.setVisibility(8);
    this.lMw.afKI = new s.b()
    {
      public final void fTI()
      {
        AppMethodBeat.i(268827);
        LabelSearchUI.this.finish();
        AppMethodBeat.o(268827);
      }
    };
    this.lMw.afKz = new s.c()
    {
      public final boolean SN(String paramAnonymousString)
      {
        return false;
      }
      
      public final void SO(String paramAnonymousString)
      {
        AppMethodBeat.i(268832);
        a locala;
        if (TextUtils.isEmpty(paramAnonymousString))
        {
          LabelSearchUI.a(LabelSearchUI.this).setVisibility(0);
          locala = LabelSearchUI.b(LabelSearchUI.this);
          if (locala.JWe != null) {
            locala.JWe.clear();
          }
          locala.pQF = Util.nullAs(paramAnonymousString, "");
          if (!Util.isNullOrNil(locala.pQF)) {
            break label184;
          }
          locala.setData(locala.JXW);
        }
        for (;;)
        {
          if (LabelSearchUI.c(LabelSearchUI.this))
          {
            if ((Util.isNullOrNil(paramAnonymousString)) || (LabelSearchUI.b(LabelSearchUI.this).mlK == null) || (LabelSearchUI.b(LabelSearchUI.this).mlK.size() == 0))
            {
              LabelSearchUI.d(LabelSearchUI.this).setText(LabelSearchUI.this.getResources().getString(R.l.app_multi_selected));
              LabelSearchUI.a(LabelSearchUI.this, false);
              LabelSearchUI.e(LabelSearchUI.this).setVisibility(8);
              AppMethodBeat.o(268832);
              return;
              LabelSearchUI.a(LabelSearchUI.this).setVisibility(8);
              break;
              label184:
              locala.setData(d.fTa().bxm(paramAnonymousString));
              continue;
            }
            LabelSearchUI.e(LabelSearchUI.this).setVisibility(0);
          }
        }
        AppMethodBeat.o(268832);
      }
      
      public final void bWw()
      {
        AppMethodBeat.i(268840);
        if (LabelSearchUI.f(LabelSearchUI.this) != null) {
          LabelSearchUI.f(LabelSearchUI.this).close();
        }
        AppMethodBeat.o(268840);
      }
      
      public final void bWx() {}
      
      public final void bWy() {}
      
      public final void bWz() {}
    };
    addSearchMenu(true, this.lMw);
    this.JYg = ((TextView)findViewById(R.h.fJF));
    this.JYd = ((Button)findViewById(R.h.fND));
    this.JYd.setText(getResources().getString(R.l.app_multi_selected));
    this.JYg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(268828);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/label/ui/searchLabel/LabelSearchUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        LabelSearchUI.g(LabelSearchUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/label/ui/searchLabel/LabelSearchUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(268828);
      }
    });
    this.JYd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(268831);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/label/ui/searchLabel/LabelSearchUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (!LabelSearchUI.h(LabelSearchUI.this))
        {
          LabelSearchUI.a(LabelSearchUI.this, true);
          LabelSearchUI.d(LabelSearchUI.this).setText(LabelSearchUI.this.getResources().getString(R.l.gMm));
          LabelSearchUI.i(LabelSearchUI.this).setVisibility(0);
          if ((LabelSearchUI.b(LabelSearchUI.this).JXy == null) || (LabelSearchUI.b(LabelSearchUI.this).JXy.size() == 0))
          {
            LabelSearchUI.i(LabelSearchUI.this).setText(LabelSearchUI.this.getString(R.l.app_choose));
            LabelSearchUI.b(LabelSearchUI.this).ZA(1);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/label/ui/searchLabel/LabelSearchUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(268831);
          return;
          LabelSearchUI.i(LabelSearchUI.this).setText(LabelSearchUI.this.getString(R.l.app_choose) + "(" + LabelSearchUI.b(LabelSearchUI.this).JXy.size() + ")");
          break;
          LabelSearchUI.a(LabelSearchUI.this, false);
          LabelSearchUI.d(LabelSearchUI.this).setText(LabelSearchUI.this.getResources().getString(R.l.app_multi_selected));
          LabelSearchUI.i(LabelSearchUI.this).setVisibility(8);
          LabelSearchUI.b(LabelSearchUI.this).ZA(0);
        }
      }
    });
    this.vEV = new com.tencent.mm.ui.widget.b.a(getContext());
    this.JYe.JXY = new a.a()
    {
      public final void aD(View paramAnonymousView, int paramAnonymousInt)
      {
        AppMethodBeat.i(268820);
        if ((LabelSearchUI.b(LabelSearchUI.this) != null) && (paramAnonymousInt >= 0))
        {
          aw localaw;
          if ((LabelSearchUI.j(LabelSearchUI.this)) && (LabelSearchUI.b(LabelSearchUI.this) != null) && (paramAnonymousInt >= 0))
          {
            localaw = LabelSearchUI.b(LabelSearchUI.this).Zz(paramAnonymousInt);
            if (localaw != null) {
              LabelSearchUI.a(LabelSearchUI.this, localaw.field_labelID, localaw.field_labelName);
            }
          }
          if (LabelSearchUI.c(LabelSearchUI.this))
          {
            localaw = LabelSearchUI.b(LabelSearchUI.this).Zz(paramAnonymousInt);
            if (localaw != null)
            {
              if (LabelSearchUI.h(LabelSearchUI.this))
              {
                LabelSearchUI.a(LabelSearchUI.this, paramAnonymousView, localaw);
                AppMethodBeat.o(268820);
                return;
              }
              paramAnonymousView = new Intent();
              ArrayList localArrayList = new ArrayList();
              localArrayList.add(String.valueOf(localaw.field_labelID));
              LabelSearchUI.a(LabelSearchUI.this, LabelSearchUI.this.getResources().getString(R.l.gMv, new Object[] { localaw.field_labelName }));
              paramAnonymousView.putExtra("contact_choose_label_list", Util.listToString(localArrayList, ","));
              LabelSearchUI.this.setResult(-1, paramAnonymousView);
              LabelSearchUI.this.finish();
            }
          }
        }
        AppMethodBeat.o(268820);
      }
    };
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(268851);
        LabelSearchUI.this.finish();
        AppMethodBeat.o(268851);
        return false;
      }
    });
    this.mRecyclerView.setVisibility(0);
    localObject = this.mRecyclerView.getLayoutParams();
    if ((fTH()) && ((localObject instanceof ViewGroup.MarginLayoutParams)))
    {
      ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = 0;
      this.mRecyclerView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (this.JYe.getItemCount() == 0)
    {
      this.njO.setSingleLine(false);
      this.njO.setPadding(40, 0, 40, 0);
      this.njO.setVisibility(0);
    }
    this.lKz = new i(this);
    this.lKz.afIL = this;
    this.JYh = findViewById(R.h.mask_view);
    this.JYh.setVisibility(0);
    this.JYh.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(268812);
        LabelSearchUI.this.finish();
        AppMethodBeat.o(268812);
        return true;
      }
    });
    AppMethodBeat.o(268953);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(268942);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(268942);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(268947);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    AppMethodBeat.o(268947);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(268976);
    super.onDestroy();
    AppMethodBeat.o(268976);
  }
  
  public void onKeyboardHeightChanged(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(268962);
    Log.i("MicroMsg.LabelSearchUI", "onKeyboardHeightChanged, height:%s", new Object[] { Integer.valueOf(paramInt) });
    Object localObject = this.JVc;
    if (localObject == null)
    {
      Log.i("MicroMsg.LabelSearchUI", "moveViewUppos, container: isNull");
      AppMethodBeat.o(268962);
      return;
    }
    if (paramInt > 0) {
      if (((View)localObject).getTranslationY() != 0.0F) {
        ((View)localObject).setTranslationY(0.0F);
      }
    }
    for (localObject = ObjectAnimator.ofFloat(localObject, "translationY", new float[] { 0.0F, -paramInt });; localObject = ObjectAnimator.ofFloat(localObject, "translationY", new float[] { ((View)localObject).getTranslationY(), 0.0F }))
    {
      ((ObjectAnimator)localObject).setDuration(200L);
      ((ObjectAnimator)localObject).setInterpolator(new androidx.g.a.a.b());
      ((ObjectAnimator)localObject).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(268816);
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue("translationY")).floatValue();
          Log.i("MicroMsg.LabelSearchUI", "onAnimationUpdate %s", new Object[] { Float.valueOf(f) });
          ViewGroup.MarginLayoutParams localMarginLayoutParams;
          if (LabelSearchUI.k(LabelSearchUI.this) != null)
          {
            paramAnonymousValueAnimator = LabelSearchUI.k(LabelSearchUI.this).getLayoutParams();
            if ((paramAnonymousValueAnimator instanceof ViewGroup.MarginLayoutParams))
            {
              localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramAnonymousValueAnimator;
              if ((!LabelSearchUI.j(LabelSearchUI.this)) && (LabelSearchUI.e(LabelSearchUI.this).getVisibility() == 0)) {
                break label117;
              }
            }
          }
          label117:
          for (f = 0.0F;; f = LabelSearchUI.this.getResources().getDimension(R.f.Edge_7A) - f)
          {
            localMarginLayoutParams.bottomMargin = ((int)f);
            LabelSearchUI.k(LabelSearchUI.this).setLayoutParams(paramAnonymousValueAnimator);
            AppMethodBeat.o(268816);
            return;
          }
        }
      });
      ((ObjectAnimator)localObject).start();
      AppMethodBeat.o(268962);
      return;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(268969);
    if (this.lKz != null) {
      this.lKz.close();
    }
    super.onPause();
    AppMethodBeat.o(268969);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(268966);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if (this.lKz != null) {
      this.lKz.start();
    }
    AppMethodBeat.o(268966);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(268972);
    super.superImportUIComponents(paramHashSet);
    AppMethodBeat.o(268972);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.searchLabel.LabelSearchUI
 * JD-Core Version:    0.7.0.1
 */