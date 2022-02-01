package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLayoutChangeListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import androidx.appcompat.a.a;
import androidx.appcompat.a.d;
import androidx.appcompat.a.f;
import androidx.appcompat.a.g;
import androidx.appcompat.a.h;
import androidx.appcompat.a.j;
import androidx.appcompat.view.c;
import androidx.core.g.z;
import androidx.customview.view.AbsSavedState;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView
  extends LinearLayoutCompat
  implements c
{
  static final a vN;
  private final AdapterView.OnItemSelectedListener gz;
  private final View.OnClickListener mOnClickListener;
  final SearchAutoComplete uY;
  private final View uZ;
  androidx.d.a.a vA;
  private boolean vB;
  private CharSequence vC;
  private boolean vD;
  private boolean vE;
  private int vF;
  private boolean vG;
  private CharSequence vH;
  private CharSequence vI;
  private boolean vJ;
  private int vK;
  SearchableInfo vL;
  Bundle vM;
  private final Runnable vO;
  private Runnable vP;
  private final WeakHashMap<String, Drawable.ConstantState> vQ;
  View.OnKeyListener vR;
  private final TextView.OnEditorActionListener vS;
  private final AdapterView.OnItemClickListener vT;
  private TextWatcher vU;
  final View va;
  private final View vb;
  final ImageView vc;
  final ImageView vd;
  final ImageView ve;
  final ImageView vf;
  final View vg;
  private SearchView.e vh;
  private Rect vi;
  private Rect vj;
  private int[] vk;
  private int[] vl;
  private final ImageView vm;
  private final Drawable vn;
  private final int vo;
  private final int vp;
  final Intent vq;
  final Intent vr;
  private final CharSequence vs;
  private c vt;
  private b vu;
  View.OnFocusChangeListener vv;
  d vw;
  private View.OnClickListener vx;
  boolean vy;
  private boolean vz;
  
  static
  {
    AppMethodBeat.i(199535);
    vN = new a();
    AppMethodBeat.o(199535);
  }
  
  public SearchView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SearchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.searchViewStyle);
  }
  
  public SearchView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(199362);
    this.vi = new Rect();
    this.vj = new Rect();
    this.vk = new int[2];
    this.vl = new int[2];
    this.vO = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(199773);
        SearchView.this.eZ();
        AppMethodBeat.o(199773);
      }
    };
    this.vP = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(199746);
        if ((SearchView.this.vA != null) && ((SearchView.this.vA instanceof x))) {
          SearchView.this.vA.c(null);
        }
        AppMethodBeat.o(199746);
      }
    };
    this.vQ = new WeakHashMap();
    this.mOnClickListener = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        Object localObject3 = null;
        Object localObject1 = null;
        AppMethodBeat.i(199892);
        if (paramAnonymousView == SearchView.this.vc)
        {
          SearchView.this.ff();
          AppMethodBeat.o(199892);
          return;
        }
        if (paramAnonymousView == SearchView.this.ve)
        {
          SearchView.this.fe();
          AppMethodBeat.o(199892);
          return;
        }
        if (paramAnonymousView == SearchView.this.vd)
        {
          SearchView.this.fb();
          AppMethodBeat.o(199892);
          return;
        }
        SearchView localSearchView;
        SearchableInfo localSearchableInfo;
        Object localObject2;
        label237:
        ComponentName localComponentName;
        PendingIntent localPendingIntent;
        Bundle localBundle;
        Intent localIntent;
        int i;
        if (paramAnonymousView == SearchView.this.vf)
        {
          localSearchView = SearchView.this;
          if (localSearchView.vL != null) {
            localSearchableInfo = localSearchView.vL;
          }
          for (;;)
          {
            try
            {
              if (!localSearchableInfo.getVoiceSearchLaunchWebSearch()) {
                break;
              }
              localObject2 = new Intent(localSearchView.vq);
              paramAnonymousView = localSearchableInfo.getSearchActivity();
              if (paramAnonymousView != null) {
                break label237;
              }
              paramAnonymousView = (View)localObject1;
              ((Intent)localObject2).putExtra("calling_package", paramAnonymousView);
              paramAnonymousView = localSearchView.getContext();
              localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "androidx/appcompat/widget/SearchView", "onVoiceClicked", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "androidx/appcompat/widget/SearchView", "onVoiceClicked", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(199892);
              return;
            }
            catch (ActivityNotFoundException paramAnonymousView) {}
            AppMethodBeat.o(199892);
            return;
            paramAnonymousView = paramAnonymousView.flattenToShortString();
          }
          if (localSearchableInfo.getVoiceSearchLaunchRecognizer())
          {
            paramAnonymousView = localSearchView.vr;
            localComponentName = localSearchableInfo.getSearchActivity();
            localObject1 = new Intent("android.intent.action.SEARCH");
            ((Intent)localObject1).setComponent(localComponentName);
            localPendingIntent = PendingIntent.getActivity(localSearchView.getContext(), 0, (Intent)localObject1, 1073741824);
            localBundle = new Bundle();
            if (localSearchView.vM != null) {
              localBundle.putParcelable("app_data", localSearchView.vM);
            }
            localIntent = new Intent(paramAnonymousView);
            i = 1;
            localObject2 = localSearchView.getResources();
            if (localSearchableInfo.getVoiceLanguageModeId() == 0) {
              break label608;
            }
          }
        }
        label608:
        for (paramAnonymousView = ((Resources)localObject2).getString(localSearchableInfo.getVoiceLanguageModeId());; paramAnonymousView = "free_form")
        {
          if (localSearchableInfo.getVoicePromptTextId() != 0) {}
          for (localObject1 = ((Resources)localObject2).getString(localSearchableInfo.getVoicePromptTextId());; localObject1 = null)
          {
            if (localSearchableInfo.getVoiceLanguageId() != 0) {}
            for (localObject2 = ((Resources)localObject2).getString(localSearchableInfo.getVoiceLanguageId());; localObject2 = null)
            {
              if (localSearchableInfo.getVoiceMaxResults() != 0) {
                i = localSearchableInfo.getVoiceMaxResults();
              }
              localIntent.putExtra("android.speech.extra.LANGUAGE_MODEL", paramAnonymousView);
              localIntent.putExtra("android.speech.extra.PROMPT", (String)localObject1);
              localIntent.putExtra("android.speech.extra.LANGUAGE", (String)localObject2);
              localIntent.putExtra("android.speech.extra.MAX_RESULTS", i);
              if (localComponentName == null) {}
              for (paramAnonymousView = localObject3;; paramAnonymousView = localComponentName.flattenToShortString())
              {
                localIntent.putExtra("calling_package", paramAnonymousView);
                localIntent.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", localPendingIntent);
                localIntent.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", localBundle);
                paramAnonymousView = localSearchView.getContext();
                localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
                com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "androidx/appcompat/widget/SearchView", "onVoiceClicked", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
                com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "androidx/appcompat/widget/SearchView", "onVoiceClicked", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(199892);
                return;
              }
              if (paramAnonymousView == SearchView.this.uY) {
                SearchView.this.fh();
              }
              AppMethodBeat.o(199892);
              return;
            }
          }
        }
      }
    };
    this.vR = new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(199869);
        if (SearchView.this.vL == null)
        {
          AppMethodBeat.o(199869);
          return false;
        }
        if ((SearchView.this.uY.isPopupShowing()) && (SearchView.this.uY.getListSelection() != -1))
        {
          boolean bool = SearchView.this.b(paramAnonymousInt, paramAnonymousKeyEvent);
          AppMethodBeat.o(199869);
          return bool;
        }
        if (TextUtils.getTrimmedLength(SearchView.this.uY.getText()) == 0) {}
        for (int i = 1; (i == 0) && (paramAnonymousKeyEvent.hasNoModifiers()) && (paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousInt == 66); i = 0)
        {
          paramAnonymousView.cancelLongPress();
          SearchView.this.t(SearchView.this.uY.getText().toString());
          AppMethodBeat.o(199869);
          return true;
        }
        AppMethodBeat.o(199869);
        return false;
      }
    };
    this.vS = new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(199839);
        SearchView.this.fb();
        AppMethodBeat.o(199839);
        return true;
      }
    };
    this.vT = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(199800);
        SearchView.this.av(paramAnonymousInt);
        AppMethodBeat.o(199800);
      }
    };
    this.gz = new AdapterView.OnItemSelectedListener()
    {
      public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(200174);
        paramAnonymousAdapterView = SearchView.this;
        if ((paramAnonymousAdapterView.vw == null) || (!paramAnonymousAdapterView.vw.fl()))
        {
          paramAnonymousView = paramAnonymousAdapterView.uY.getText();
          Object localObject = paramAnonymousAdapterView.vA.Fv();
          if (localObject != null)
          {
            if (((Cursor)localObject).moveToPosition(paramAnonymousInt))
            {
              localObject = paramAnonymousAdapterView.vA.d((Cursor)localObject);
              if (localObject != null)
              {
                paramAnonymousAdapterView.setQuery((CharSequence)localObject);
                AppMethodBeat.o(200174);
                return;
              }
              paramAnonymousAdapterView.setQuery(paramAnonymousView);
              AppMethodBeat.o(200174);
              return;
            }
            paramAnonymousAdapterView.setQuery(paramAnonymousView);
          }
        }
        AppMethodBeat.o(200174);
      }
      
      public final void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
    };
    this.vU = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(199752);
        SearchView.this.f(paramAnonymousCharSequence);
        AppMethodBeat.o(199752);
      }
    };
    paramAttributeSet = ac.a(paramContext, paramAttributeSet, a.j.SearchView, paramInt, 0);
    LayoutInflater.from(paramContext).inflate(paramAttributeSet.w(a.j.SearchView_layout, a.g.abc_search_view), this, true);
    this.uY = ((SearchAutoComplete)findViewById(a.f.search_src_text));
    this.uY.setSearchView(this);
    this.uZ = findViewById(a.f.search_edit_frame);
    this.va = findViewById(a.f.search_plate);
    this.vb = findViewById(a.f.submit_area);
    this.vc = ((ImageView)findViewById(a.f.search_button));
    this.vd = ((ImageView)findViewById(a.f.search_go_btn));
    this.ve = ((ImageView)findViewById(a.f.search_close_btn));
    this.vf = ((ImageView)findViewById(a.f.search_voice_btn));
    this.vm = ((ImageView)findViewById(a.f.search_mag_icon));
    z.a(this.va, paramAttributeSet.getDrawable(a.j.SearchView_queryBackground));
    z.a(this.vb, paramAttributeSet.getDrawable(a.j.SearchView_submitBackground));
    this.vc.setImageDrawable(paramAttributeSet.getDrawable(a.j.SearchView_searchIcon));
    this.vd.setImageDrawable(paramAttributeSet.getDrawable(a.j.SearchView_goIcon));
    this.ve.setImageDrawable(paramAttributeSet.getDrawable(a.j.SearchView_closeIcon));
    this.vf.setImageDrawable(paramAttributeSet.getDrawable(a.j.SearchView_voiceIcon));
    this.vm.setImageDrawable(paramAttributeSet.getDrawable(a.j.SearchView_searchIcon));
    this.vn = paramAttributeSet.getDrawable(a.j.SearchView_searchHintIcon);
    ae.a(this.vc, getResources().getString(a.h.abc_searchview_description_search));
    this.vo = paramAttributeSet.w(a.j.SearchView_suggestionRowLayout, a.g.abc_search_dropdown_item_icons_2line);
    this.vp = paramAttributeSet.w(a.j.SearchView_commitIcon, 0);
    this.vc.setOnClickListener(this.mOnClickListener);
    this.ve.setOnClickListener(this.mOnClickListener);
    this.vd.setOnClickListener(this.mOnClickListener);
    this.vf.setOnClickListener(this.mOnClickListener);
    this.uY.setOnClickListener(this.mOnClickListener);
    this.uY.addTextChangedListener(this.vU);
    this.uY.setOnEditorActionListener(this.vS);
    this.uY.setOnItemClickListener(this.vT);
    this.uY.setOnItemSelectedListener(this.gz);
    this.uY.setOnKeyListener(this.vR);
    this.uY.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(199731);
        if (SearchView.this.vv != null) {
          SearchView.this.vv.onFocusChange(SearchView.this, paramAnonymousBoolean);
        }
        AppMethodBeat.o(199731);
      }
    });
    setIconifiedByDefault(paramAttributeSet.m(a.j.SearchView_iconifiedByDefault, true));
    paramInt = paramAttributeSet.u(a.j.SearchView_android_maxWidth, -1);
    if (paramInt != -1) {
      setMaxWidth(paramInt);
    }
    this.vs = paramAttributeSet.getText(a.j.SearchView_defaultQueryHint);
    this.vC = paramAttributeSet.getText(a.j.SearchView_queryHint);
    paramInt = paramAttributeSet.getInt(a.j.SearchView_android_imeOptions, -1);
    if (paramInt != -1) {
      setImeOptions(paramInt);
    }
    paramInt = paramAttributeSet.getInt(a.j.SearchView_android_inputType, -1);
    if (paramInt != -1) {
      setInputType(paramInt);
    }
    setFocusable(paramAttributeSet.m(a.j.SearchView_android_focusable, true));
    paramAttributeSet.xv.recycle();
    this.vq = new Intent("android.speech.action.WEB_SEARCH");
    this.vq.addFlags(268435456);
    this.vq.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
    this.vr = new Intent("android.speech.action.RECOGNIZE_SPEECH");
    this.vr.addFlags(268435456);
    this.vg = findViewById(this.uY.getDropDownAnchor());
    if (this.vg != null) {
      this.vg.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          AppMethodBeat.i(199905);
          paramAnonymousView = SearchView.this;
          Rect localRect;
          if (paramAnonymousView.vg.getWidth() > 1)
          {
            Resources localResources = paramAnonymousView.getContext().getResources();
            paramAnonymousInt3 = paramAnonymousView.va.getPaddingLeft();
            localRect = new Rect();
            boolean bool = ai.s(paramAnonymousView);
            if (!paramAnonymousView.vy) {
              break label161;
            }
            paramAnonymousInt1 = localResources.getDimensionPixelSize(a.d.abc_dropdownitem_icon_width);
            paramAnonymousInt1 = localResources.getDimensionPixelSize(a.d.abc_dropdownitem_text_padding_left) + paramAnonymousInt1;
            paramAnonymousView.uY.getDropDownBackground().getPadding(localRect);
            if (!bool) {
              break label166;
            }
          }
          label161:
          label166:
          for (paramAnonymousInt2 = -localRect.left;; paramAnonymousInt2 = paramAnonymousInt3 - (localRect.left + paramAnonymousInt1))
          {
            paramAnonymousView.uY.setDropDownHorizontalOffset(paramAnonymousInt2);
            paramAnonymousInt2 = paramAnonymousView.vg.getWidth();
            paramAnonymousInt4 = localRect.left;
            paramAnonymousInt5 = localRect.right;
            paramAnonymousView.uY.setDropDownWidth(paramAnonymousInt1 + (paramAnonymousInt2 + paramAnonymousInt4 + paramAnonymousInt5) - paramAnonymousInt3);
            AppMethodBeat.o(199905);
            return;
            paramAnonymousInt1 = 0;
            break;
          }
        }
      });
    }
    T(this.vy);
    fa();
    AppMethodBeat.o(199362);
  }
  
  static boolean K(Context paramContext)
  {
    AppMethodBeat.i(199525);
    if (paramContext.getResources().getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(199525);
      return true;
    }
    AppMethodBeat.o(199525);
    return false;
  }
  
  private void T(boolean paramBoolean)
  {
    boolean bool2 = true;
    int j = 8;
    AppMethodBeat.i(199386);
    this.vz = paramBoolean;
    int i;
    boolean bool1;
    if (paramBoolean)
    {
      i = 0;
      if (TextUtils.isEmpty(this.uY.getText())) {
        break label135;
      }
      bool1 = true;
      label39:
      this.vc.setVisibility(i);
      U(bool1);
      View localView = this.uZ;
      if (!paramBoolean) {
        break label141;
      }
      i = 8;
      label66:
      localView.setVisibility(i);
      i = j;
      if (this.vm.getDrawable() != null)
      {
        if (!this.vy) {
          break label146;
        }
        i = j;
      }
      label93:
      this.vm.setVisibility(i);
      eX();
      if (bool1) {
        break label151;
      }
    }
    label135:
    label141:
    label146:
    label151:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      V(paramBoolean);
      eW();
      AppMethodBeat.o(199386);
      return;
      i = 8;
      break;
      bool1 = false;
      break label39;
      i = 0;
      break label66;
      i = 0;
      break label93;
    }
  }
  
  private void U(boolean paramBoolean)
  {
    AppMethodBeat.i(199402);
    int j = 8;
    int i = j;
    if (this.vB)
    {
      i = j;
      if (eV())
      {
        i = j;
        if (hasFocus()) {
          if (!paramBoolean)
          {
            i = j;
            if (this.vG) {}
          }
          else
          {
            i = 0;
          }
        }
      }
    }
    this.vd.setVisibility(i);
    AppMethodBeat.o(199402);
  }
  
  private void V(boolean paramBoolean)
  {
    AppMethodBeat.i(199462);
    int i;
    if ((this.vG) && (!this.vz) && (paramBoolean))
    {
      i = 0;
      this.vd.setVisibility(8);
    }
    for (;;)
    {
      this.vf.setVisibility(i);
      AppMethodBeat.o(199462);
      return;
      i = 8;
    }
  }
  
  private Intent a(Cursor paramCursor)
  {
    AppMethodBeat.i(199513);
    try
    {
      localObject3 = x.a(paramCursor, "suggest_intent_action");
      localObject1 = localObject3;
      if (localObject3 != null) {
        break label204;
      }
      localObject1 = this.vL.getSuggestIntentAction();
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        Object localObject4;
        try
        {
          Object localObject1;
          String str;
          i = paramCursor.getPosition();
          new StringBuilder("Search suggestions cursor at row ").append(i).append(" returned exception.");
          AppMethodBeat.o(199513);
          return null;
        }
        catch (RuntimeException paramCursor)
        {
          int i = -1;
          continue;
        }
        Object localObject3 = localRuntimeException;
        if (localRuntimeException == null)
        {
          localObject3 = "android.intent.action.SEARCH";
          continue;
          if (localObject4 == null) {
            Object localObject2 = null;
          }
        }
      }
    }
    localObject4 = x.a(paramCursor, "suggest_intent_data");
    localObject1 = localObject4;
    if (localObject4 == null) {
      localObject1 = this.vL.getSuggestIntentData();
    }
    localObject4 = localObject1;
    if (localObject1 != null)
    {
      str = x.a(paramCursor, "suggest_intent_data_id");
      localObject4 = localObject1;
      if (str != null)
      {
        localObject4 = (String)localObject1 + "/" + Uri.encode(str);
        break label219;
        for (;;)
        {
          localObject4 = x.a(paramCursor, "suggest_intent_query");
          localObject1 = a((String)localObject3, (Uri)localObject1, x.a(paramCursor, "suggest_intent_extra_data"), (String)localObject4, 0, null);
          AppMethodBeat.o(199513);
          return localObject1;
          localObject1 = Uri.parse((String)localObject4);
        }
      }
    }
  }
  
  private Intent a(String paramString1, Uri paramUri, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    AppMethodBeat.i(199496);
    paramString1 = new Intent(paramString1);
    paramString1.addFlags(268435456);
    if (paramUri != null) {
      paramString1.setData(paramUri);
    }
    paramString1.putExtra("user_query", this.vI);
    if (paramString3 != null) {
      paramString1.putExtra("query", paramString3);
    }
    if (paramString2 != null) {
      paramString1.putExtra("intent_extra_data_key", paramString2);
    }
    if (this.vM != null) {
      paramString1.putExtra("app_data", this.vM);
    }
    paramString1.setComponent(this.vL.getSearchActivity());
    AppMethodBeat.o(199496);
    return paramString1;
  }
  
  private boolean aw(int paramInt)
  {
    AppMethodBeat.i(199474);
    Cursor localCursor = this.vA.Fv();
    if ((localCursor != null) && (localCursor.moveToPosition(paramInt)))
    {
      c(a(localCursor));
      AppMethodBeat.o(199474);
      return true;
    }
    AppMethodBeat.o(199474);
    return false;
  }
  
  private void c(Intent paramIntent)
  {
    AppMethodBeat.i(199483);
    if (paramIntent == null)
    {
      AppMethodBeat.o(199483);
      return;
    }
    try
    {
      Context localContext = getContext();
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(localContext, locala.aYi(), "androidx/appcompat/widget/SearchView", "launchIntent", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localContext.startActivity((Intent)locala.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localContext, "androidx/appcompat/widget/SearchView", "launchIntent", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(199483);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      new StringBuilder("Failed launch activity: ").append(paramIntent);
      AppMethodBeat.o(199483);
    }
  }
  
  private CharSequence e(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(199443);
    if ((!this.vy) || (this.vn == null))
    {
      AppMethodBeat.o(199443);
      return paramCharSequence;
    }
    int i = (int)(this.uY.getTextSize() * 1.25D);
    this.vn.setBounds(0, 0, i, i);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder("   ");
    localSpannableStringBuilder.setSpan(new ImageSpan(this.vn), 1, 2, 33);
    localSpannableStringBuilder.append(paramCharSequence);
    AppMethodBeat.o(199443);
    return localSpannableStringBuilder;
  }
  
  private boolean eV()
  {
    return ((this.vB) || (this.vG)) && (!this.vz);
  }
  
  private void eW()
  {
    AppMethodBeat.i(199411);
    int j = 8;
    int i = j;
    if (eV()) {
      if (this.vd.getVisibility() != 0)
      {
        i = j;
        if (this.vf.getVisibility() != 0) {}
      }
      else
      {
        i = 0;
      }
    }
    this.vb.setVisibility(i);
    AppMethodBeat.o(199411);
  }
  
  private void eX()
  {
    int m = 1;
    int k = 0;
    AppMethodBeat.i(199418);
    int i;
    int j;
    label50:
    label62:
    Drawable localDrawable;
    if (!TextUtils.isEmpty(this.uY.getText()))
    {
      i = 1;
      j = m;
      if (i == 0)
      {
        if ((!this.vy) || (this.vJ)) {
          break label111;
        }
        j = m;
      }
      localObject = this.ve;
      if (j == 0) {
        break label116;
      }
      j = k;
      ((ImageView)localObject).setVisibility(j);
      localDrawable = this.ve.getDrawable();
      if (localDrawable != null) {
        if (i == 0) {
          break label122;
        }
      }
    }
    label111:
    label116:
    label122:
    for (Object localObject = ENABLED_STATE_SET;; localObject = EMPTY_STATE_SET)
    {
      localDrawable.setState((int[])localObject);
      AppMethodBeat.o(199418);
      return;
      i = 0;
      break;
      j = 0;
      break label50;
      j = 8;
      break label62;
    }
  }
  
  private void eY()
  {
    AppMethodBeat.i(199430);
    post(this.vO);
    AppMethodBeat.o(199430);
  }
  
  private void fa()
  {
    AppMethodBeat.i(199453);
    CharSequence localCharSequence = getQueryHint();
    SearchAutoComplete localSearchAutoComplete = this.uY;
    Object localObject = localCharSequence;
    if (localCharSequence == null) {
      localObject = "";
    }
    localSearchAutoComplete.setHint(e((CharSequence)localObject));
    AppMethodBeat.o(199453);
  }
  
  private int getPreferredHeight()
  {
    AppMethodBeat.i(199375);
    int i = getContext().getResources().getDimensionPixelSize(a.d.abc_search_view_preferred_height);
    AppMethodBeat.o(199375);
    return i;
  }
  
  private int getPreferredWidth()
  {
    AppMethodBeat.i(199369);
    int i = getContext().getResources().getDimensionPixelSize(a.d.abc_search_view_preferred_width);
    AppMethodBeat.o(199369);
    return i;
  }
  
  final boolean av(int paramInt)
  {
    AppMethodBeat.i(199943);
    if ((this.vw == null) || (!this.vw.fm()))
    {
      aw(paramInt);
      this.uY.setImeVisibility(false);
      this.uY.dismissDropDown();
      AppMethodBeat.o(199943);
      return true;
    }
    AppMethodBeat.o(199943);
    return false;
  }
  
  final boolean b(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(199822);
    if (this.vL == null)
    {
      AppMethodBeat.o(199822);
      return false;
    }
    if (this.vA == null)
    {
      AppMethodBeat.o(199822);
      return false;
    }
    if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.hasNoModifiers()))
    {
      if ((paramInt == 66) || (paramInt == 84) || (paramInt == 61))
      {
        boolean bool = av(this.uY.getListSelection());
        AppMethodBeat.o(199822);
        return bool;
      }
      if ((paramInt == 21) || (paramInt == 22))
      {
        if (paramInt == 21) {}
        for (paramInt = 0;; paramInt = this.uY.length())
        {
          this.uY.setSelection(paramInt);
          this.uY.setListSelection(0);
          this.uY.clearListSelection();
          vN.c(this.uY);
          AppMethodBeat.o(199822);
          return true;
        }
      }
      if ((paramInt == 19) && (this.uY.getListSelection() == 0))
      {
        AppMethodBeat.o(199822);
        return false;
      }
    }
    AppMethodBeat.o(199822);
    return false;
  }
  
  public void clearFocus()
  {
    AppMethodBeat.i(199640);
    this.vE = true;
    super.clearFocus();
    this.uY.clearFocus();
    this.uY.setImeVisibility(false);
    this.vE = false;
    AppMethodBeat.o(199640);
  }
  
  public final void cu()
  {
    AppMethodBeat.i(199916);
    if (this.vJ)
    {
      AppMethodBeat.o(199916);
      return;
    }
    this.vJ = true;
    this.vK = this.uY.getImeOptions();
    this.uY.setImeOptions(this.vK | 0x2000000);
    this.uY.setText("");
    setIconified(false);
    AppMethodBeat.o(199916);
  }
  
  public final void cv()
  {
    AppMethodBeat.i(199907);
    this.uY.setText("");
    this.uY.setSelection(this.uY.length());
    this.vI = "";
    clearFocus();
    T(true);
    this.uY.setImeOptions(this.vK);
    this.vJ = false;
    AppMethodBeat.o(199907);
  }
  
  final void eZ()
  {
    AppMethodBeat.i(199803);
    if (this.uY.hasFocus()) {}
    for (int[] arrayOfInt = FOCUSED_STATE_SET;; arrayOfInt = EMPTY_STATE_SET)
    {
      Drawable localDrawable = this.va.getBackground();
      if (localDrawable != null) {
        localDrawable.setState(arrayOfInt);
      }
      localDrawable = this.vb.getBackground();
      if (localDrawable != null) {
        localDrawable.setState(arrayOfInt);
      }
      invalidate();
      AppMethodBeat.o(199803);
      return;
    }
  }
  
  final void f(CharSequence paramCharSequence)
  {
    boolean bool2 = true;
    AppMethodBeat.i(199834);
    Editable localEditable = this.uY.getText();
    this.vI = localEditable;
    if (!TextUtils.isEmpty(localEditable))
    {
      bool1 = true;
      U(bool1);
      if (bool1) {
        break label104;
      }
    }
    label104:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      V(bool1);
      eX();
      eW();
      if ((this.vt != null) && (!TextUtils.equals(paramCharSequence, this.vH))) {
        paramCharSequence.toString();
      }
      this.vH = paramCharSequence.toString();
      AppMethodBeat.o(199834);
      return;
      bool1 = false;
      break;
    }
  }
  
  final void fb()
  {
    AppMethodBeat.i(199846);
    Editable localEditable = this.uY.getText();
    if ((localEditable != null) && (TextUtils.getTrimmedLength(localEditable) > 0)) {
      if (this.vt != null)
      {
        c localc = this.vt;
        localEditable.toString();
        if (localc.fj()) {}
      }
      else
      {
        if (this.vL != null) {
          t(localEditable.toString());
        }
        this.uY.setImeVisibility(false);
        this.uY.dismissDropDown();
      }
    }
    AppMethodBeat.o(199846);
  }
  
  final void fe()
  {
    AppMethodBeat.i(199857);
    if (TextUtils.isEmpty(this.uY.getText()))
    {
      if ((this.vy) && ((this.vu == null) || (!this.vu.fi())))
      {
        clearFocus();
        T(true);
        AppMethodBeat.o(199857);
      }
    }
    else
    {
      this.uY.setText("");
      this.uY.requestFocus();
      this.uY.setImeVisibility(true);
    }
    AppMethodBeat.o(199857);
  }
  
  final void ff()
  {
    AppMethodBeat.i(199868);
    T(false);
    this.uY.requestFocus();
    this.uY.setImeVisibility(true);
    if (this.vx != null) {
      this.vx.onClick(this);
    }
    AppMethodBeat.o(199868);
  }
  
  final void fg()
  {
    AppMethodBeat.i(199879);
    T(this.vz);
    eY();
    if (this.uY.hasFocus()) {
      fh();
    }
    AppMethodBeat.o(199879);
  }
  
  final void fh()
  {
    AppMethodBeat.i(199974);
    vN.a(this.uY);
    vN.b(this.uY);
    AppMethodBeat.o(199974);
  }
  
  public int getImeOptions()
  {
    AppMethodBeat.i(199600);
    int i = this.uY.getImeOptions();
    AppMethodBeat.o(199600);
    return i;
  }
  
  public int getInputType()
  {
    AppMethodBeat.i(199622);
    int i = this.uY.getInputType();
    AppMethodBeat.o(199622);
    return i;
  }
  
  public int getMaxWidth()
  {
    return this.vF;
  }
  
  public CharSequence getQuery()
  {
    AppMethodBeat.i(199690);
    Editable localEditable = this.uY.getText();
    AppMethodBeat.o(199690);
    return localEditable;
  }
  
  public CharSequence getQueryHint()
  {
    AppMethodBeat.i(199710);
    CharSequence localCharSequence;
    if (this.vC != null) {
      localCharSequence = this.vC;
    }
    for (;;)
    {
      AppMethodBeat.o(199710);
      return localCharSequence;
      if ((this.vL != null) && (this.vL.getHintId() != 0)) {
        localCharSequence = getContext().getText(this.vL.getHintId());
      } else {
        localCharSequence = this.vs;
      }
    }
  }
  
  int getSuggestionCommitIconResId()
  {
    return this.vp;
  }
  
  int getSuggestionRowLayout()
  {
    return this.vo;
  }
  
  public androidx.d.a.a getSuggestionsAdapter()
  {
    return this.vA;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(199810);
    removeCallbacks(this.vO);
    post(this.vP);
    super.onDetachedFromWindow();
    AppMethodBeat.o(199810);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(199793);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      SearchAutoComplete localSearchAutoComplete = this.uY;
      Rect localRect = this.vi;
      localSearchAutoComplete.getLocationInWindow(this.vk);
      getLocationInWindow(this.vl);
      paramInt1 = this.vk[1] - this.vl[1];
      paramInt3 = this.vk[0] - this.vl[0];
      localRect.set(paramInt3, paramInt1, localSearchAutoComplete.getWidth() + paramInt3, localSearchAutoComplete.getHeight() + paramInt1);
      this.vj.set(this.vi.left, 0, this.vi.right, paramInt4 - paramInt2);
      if (this.vh == null)
      {
        this.vh = new SearchView.e(this.vj, this.vi, this.uY);
        setTouchDelegate(this.vh);
        AppMethodBeat.o(199793);
        return;
      }
      this.vh.e(this.vj, this.vi);
    }
    AppMethodBeat.o(199793);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199780);
    if (this.vz)
    {
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(199780);
      return;
    }
    int j = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    switch (j)
    {
    default: 
      paramInt1 = i;
      i = View.MeasureSpec.getMode(paramInt2);
      paramInt2 = View.MeasureSpec.getSize(paramInt2);
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
      AppMethodBeat.o(199780);
      return;
      if (this.vF > 0)
      {
        paramInt1 = Math.min(this.vF, i);
        break;
      }
      paramInt1 = Math.min(getPreferredWidth(), i);
      break;
      paramInt1 = i;
      if (this.vF <= 0) {
        break;
      }
      paramInt1 = Math.min(this.vF, i);
      break;
      if (this.vF > 0)
      {
        paramInt1 = this.vF;
        break;
      }
      paramInt1 = getPreferredWidth();
      break;
      paramInt2 = Math.min(getPreferredHeight(), paramInt2);
      continue;
      paramInt2 = getPreferredHeight();
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(199932);
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(199932);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.bxs);
    T(paramParcelable.vZ);
    requestLayout();
    AppMethodBeat.o(199932);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(199924);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.vZ = this.vz;
    AppMethodBeat.o(199924);
    return localSavedState;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(199898);
    super.onWindowFocusChanged(paramBoolean);
    eY();
    AppMethodBeat.o(199898);
  }
  
  public boolean requestFocus(int paramInt, Rect paramRect)
  {
    AppMethodBeat.i(199630);
    if (this.vE)
    {
      AppMethodBeat.o(199630);
      return false;
    }
    if (!isFocusable())
    {
      AppMethodBeat.o(199630);
      return false;
    }
    if (!this.vz)
    {
      bool = this.uY.requestFocus(paramInt, paramRect);
      if (bool) {
        T(false);
      }
      AppMethodBeat.o(199630);
      return bool;
    }
    boolean bool = super.requestFocus(paramInt, paramRect);
    AppMethodBeat.o(199630);
    return bool;
  }
  
  public void setAppSearchData(Bundle paramBundle)
  {
    this.vM = paramBundle;
  }
  
  public void setIconified(boolean paramBoolean)
  {
    AppMethodBeat.i(199722);
    if (paramBoolean)
    {
      fe();
      AppMethodBeat.o(199722);
      return;
    }
    ff();
    AppMethodBeat.o(199722);
  }
  
  public void setIconifiedByDefault(boolean paramBoolean)
  {
    AppMethodBeat.i(199715);
    if (this.vy == paramBoolean)
    {
      AppMethodBeat.o(199715);
      return;
    }
    this.vy = paramBoolean;
    T(paramBoolean);
    fa();
    AppMethodBeat.o(199715);
  }
  
  public void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(199590);
    this.uY.setImeOptions(paramInt);
    AppMethodBeat.o(199590);
  }
  
  public void setInputType(int paramInt)
  {
    AppMethodBeat.i(199610);
    this.uY.setInputType(paramInt);
    AppMethodBeat.o(199610);
  }
  
  public void setMaxWidth(int paramInt)
  {
    AppMethodBeat.i(199760);
    this.vF = paramInt;
    requestLayout();
    AppMethodBeat.o(199760);
  }
  
  public void setOnCloseListener(b paramb)
  {
    this.vu = paramb;
  }
  
  public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.vv = paramOnFocusChangeListener;
  }
  
  public void setOnQueryTextListener(c paramc)
  {
    this.vt = paramc;
  }
  
  public void setOnSearchClickListener(View.OnClickListener paramOnClickListener)
  {
    this.vx = paramOnClickListener;
  }
  
  public void setOnSuggestionListener(d paramd)
  {
    this.vw = paramd;
  }
  
  void setQuery(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(199955);
    this.uY.setText(paramCharSequence);
    SearchAutoComplete localSearchAutoComplete = this.uY;
    if (TextUtils.isEmpty(paramCharSequence)) {}
    for (int i = 0;; i = paramCharSequence.length())
    {
      localSearchAutoComplete.setSelection(i);
      AppMethodBeat.o(199955);
      return;
    }
  }
  
  public void setQueryHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(199699);
    this.vC = paramCharSequence;
    fa();
    AppMethodBeat.o(199699);
  }
  
  public void setQueryRefinementEnabled(boolean paramBoolean)
  {
    this.vD = paramBoolean;
    x localx;
    if ((this.vA instanceof x))
    {
      localx = (x)this.vA;
      if (!paramBoolean) {
        break label35;
      }
    }
    label35:
    for (int i = 2;; i = 1)
    {
      localx.wm = i;
      return;
    }
  }
  
  public void setSearchableInfo(SearchableInfo paramSearchableInfo)
  {
    boolean bool = true;
    AppMethodBeat.i(199570);
    this.vL = paramSearchableInfo;
    int i;
    if (this.vL != null)
    {
      this.uY.setThreshold(this.vL.getSuggestThreshold());
      this.uY.setImeOptions(this.vL.getImeOptions());
      int j = this.vL.getInputType();
      i = j;
      if ((j & 0xF) == 1)
      {
        j &= 0xFFFEFFFF;
        i = j;
        if (this.vL.getSuggestAuthority() != null) {
          i = j | 0x10000 | 0x80000;
        }
      }
      this.uY.setInputType(i);
      if (this.vA != null) {
        this.vA.c(null);
      }
      if (this.vL.getSuggestAuthority() != null)
      {
        this.vA = new x(getContext(), this, this.vL, this.vQ);
        this.uY.setAdapter(this.vA);
        paramSearchableInfo = (x)this.vA;
        if (this.vD)
        {
          i = 2;
          paramSearchableInfo.wm = i;
        }
      }
      else
      {
        fa();
      }
    }
    else
    {
      if ((this.vL == null) || (!this.vL.getVoiceSearchEnabled())) {
        break label309;
      }
      if (!this.vL.getVoiceSearchLaunchWebSearch()) {
        break label285;
      }
      paramSearchableInfo = this.vq;
    }
    for (;;)
    {
      label221:
      if (paramSearchableInfo != null) {
        if (getContext().getPackageManager().resolveActivity(paramSearchableInfo, 65536) == null) {}
      }
      for (;;)
      {
        this.vG = bool;
        if (this.vG) {
          this.uY.setPrivateImeOptions("nm");
        }
        T(this.vz);
        AppMethodBeat.o(199570);
        return;
        i = 1;
        break;
        label285:
        if (!this.vL.getVoiceSearchLaunchRecognizer()) {
          break label315;
        }
        paramSearchableInfo = this.vr;
        break label221;
        bool = false;
        continue;
        label309:
        bool = false;
      }
      label315:
      paramSearchableInfo = null;
    }
  }
  
  public void setSubmitButtonEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(199728);
    this.vB = paramBoolean;
    T(this.vz);
    AppMethodBeat.o(199728);
  }
  
  public void setSuggestionsAdapter(androidx.d.a.a parama)
  {
    AppMethodBeat.i(199740);
    this.vA = parama;
    this.uY.setAdapter(this.vA);
    AppMethodBeat.o(199740);
  }
  
  final void t(String paramString)
  {
    AppMethodBeat.i(199965);
    Object localObject = a("android.intent.action.SEARCH", null, null, paramString, 0, null);
    paramString = getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "androidx/appcompat/widget/SearchView", "launchQuerySearch", "(ILjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramString, "androidx/appcompat/widget/SearchView", "launchQuerySearch", "(ILjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(199965);
  }
  
  static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    boolean vZ;
    
    static
    {
      AppMethodBeat.i(200165);
      CREATOR = new Parcelable.ClassLoaderCreator() {};
      AppMethodBeat.o(200165);
    }
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      AppMethodBeat.i(200157);
      this.vZ = ((Boolean)paramParcel.readValue(null)).booleanValue();
      AppMethodBeat.o(200157);
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      AppMethodBeat.i(200180);
      String str = "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.vZ + "}";
      AppMethodBeat.o(200180);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(200173);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeValue(Boolean.valueOf(this.vZ));
      AppMethodBeat.o(200173);
    }
  }
  
  public static class SearchAutoComplete
    extends AppCompatAutoCompleteTextView
  {
    private int mThreshold;
    private SearchView wa;
    boolean wb;
    final Runnable wc;
    
    public SearchAutoComplete(Context paramContext, AttributeSet paramAttributeSet)
    {
      this(paramContext, paramAttributeSet, a.a.autoCompleteTextViewStyle);
    }
    
    public SearchAutoComplete(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
      AppMethodBeat.i(200144);
      this.wc = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(199666);
          SearchView.SearchAutoComplete localSearchAutoComplete = SearchView.SearchAutoComplete.this;
          if (localSearchAutoComplete.wb)
          {
            ((InputMethodManager)localSearchAutoComplete.getContext().getSystemService("input_method")).showSoftInput(localSearchAutoComplete, 0);
            localSearchAutoComplete.wb = false;
          }
          AppMethodBeat.o(199666);
        }
      };
      this.mThreshold = getThreshold();
      AppMethodBeat.o(200144);
    }
    
    private int getSearchViewTextMinWidthDp()
    {
      AppMethodBeat.i(200156);
      Configuration localConfiguration = getResources().getConfiguration();
      int i = localConfiguration.screenWidthDp;
      int j = localConfiguration.screenHeightDp;
      if ((i >= 960) && (j >= 720) && (localConfiguration.orientation == 2))
      {
        AppMethodBeat.o(200156);
        return 256;
      }
      if ((i >= 600) || ((i >= 640) && (j >= 480)))
      {
        AppMethodBeat.o(200156);
        return 192;
      }
      AppMethodBeat.o(200156);
      return 160;
    }
    
    public boolean enoughToFilter()
    {
      AppMethodBeat.i(200236);
      if ((this.mThreshold <= 0) || (super.enoughToFilter()))
      {
        AppMethodBeat.o(200236);
        return true;
      }
      AppMethodBeat.o(200236);
      return false;
    }
    
    public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
    {
      AppMethodBeat.i(200256);
      paramEditorInfo = super.onCreateInputConnection(paramEditorInfo);
      if (this.wb)
      {
        removeCallbacks(this.wc);
        post(this.wc);
      }
      AppMethodBeat.o(200256);
      return paramEditorInfo;
    }
    
    protected void onFinishInflate()
    {
      AppMethodBeat.i(200168);
      super.onFinishInflate();
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      setMinWidth((int)TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), localDisplayMetrics));
      AppMethodBeat.o(200168);
    }
    
    protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
    {
      AppMethodBeat.i(200229);
      super.onFocusChanged(paramBoolean, paramInt, paramRect);
      this.wa.fg();
      AppMethodBeat.o(200229);
    }
    
    public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(200248);
      if (paramInt == 4)
      {
        KeyEvent.DispatcherState localDispatcherState;
        if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
        {
          localDispatcherState = getKeyDispatcherState();
          if (localDispatcherState != null) {
            localDispatcherState.startTracking(paramKeyEvent, this);
          }
          AppMethodBeat.o(200248);
          return true;
        }
        if (paramKeyEvent.getAction() == 1)
        {
          localDispatcherState = getKeyDispatcherState();
          if (localDispatcherState != null) {
            localDispatcherState.handleUpEvent(paramKeyEvent);
          }
          if ((paramKeyEvent.isTracking()) && (!paramKeyEvent.isCanceled()))
          {
            this.wa.clearFocus();
            setImeVisibility(false);
            AppMethodBeat.o(200248);
            return true;
          }
        }
      }
      boolean bool = super.onKeyPreIme(paramInt, paramKeyEvent);
      AppMethodBeat.o(200248);
      return bool;
    }
    
    public void onWindowFocusChanged(boolean paramBoolean)
    {
      AppMethodBeat.i(200221);
      super.onWindowFocusChanged(paramBoolean);
      if ((paramBoolean) && (this.wa.hasFocus()) && (getVisibility() == 0))
      {
        this.wb = true;
        if (SearchView.K(getContext())) {
          SearchView.vN.c(this);
        }
      }
      AppMethodBeat.o(200221);
    }
    
    public void performCompletion() {}
    
    protected void replaceText(CharSequence paramCharSequence) {}
    
    void setImeVisibility(boolean paramBoolean)
    {
      AppMethodBeat.i(200264);
      InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
      if (!paramBoolean)
      {
        this.wb = false;
        removeCallbacks(this.wc);
        localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        AppMethodBeat.o(200264);
        return;
      }
      if (localInputMethodManager.isActive(this))
      {
        this.wb = false;
        removeCallbacks(this.wc);
        localInputMethodManager.showSoftInput(this, 0);
        AppMethodBeat.o(200264);
        return;
      }
      this.wb = true;
      AppMethodBeat.o(200264);
    }
    
    void setSearchView(SearchView paramSearchView)
    {
      this.wa = paramSearchView;
    }
    
    public void setThreshold(int paramInt)
    {
      AppMethodBeat.i(200181);
      super.setThreshold(paramInt);
      this.mThreshold = paramInt;
      AppMethodBeat.o(200181);
    }
  }
  
  static final class a
  {
    private Method vW;
    private Method vX;
    private Method vY;
    
    a()
    {
      AppMethodBeat.i(199547);
      try
      {
        this.vW = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
        this.vW.setAccessible(true);
        try
        {
          label32:
          this.vX = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
          this.vX.setAccessible(true);
          try
          {
            label55:
            this.vY = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[] { Boolean.TYPE });
            this.vY.setAccessible(true);
            AppMethodBeat.o(199547);
            return;
          }
          catch (NoSuchMethodException localNoSuchMethodException1)
          {
            AppMethodBeat.o(199547);
            return;
          }
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          break label55;
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException3)
      {
        break label32;
      }
    }
    
    final void a(AutoCompleteTextView paramAutoCompleteTextView)
    {
      AppMethodBeat.i(199558);
      if (this.vW != null) {
        try
        {
          this.vW.invoke(paramAutoCompleteTextView, new Object[0]);
          AppMethodBeat.o(199558);
          return;
        }
        catch (Exception paramAutoCompleteTextView) {}
      }
      AppMethodBeat.o(199558);
    }
    
    final void b(AutoCompleteTextView paramAutoCompleteTextView)
    {
      AppMethodBeat.i(199569);
      if (this.vX != null) {
        try
        {
          this.vX.invoke(paramAutoCompleteTextView, new Object[0]);
          AppMethodBeat.o(199569);
          return;
        }
        catch (Exception paramAutoCompleteTextView) {}
      }
      AppMethodBeat.o(199569);
    }
    
    final void c(AutoCompleteTextView paramAutoCompleteTextView)
    {
      AppMethodBeat.i(199581);
      if (this.vY != null) {
        try
        {
          this.vY.invoke(paramAutoCompleteTextView, new Object[] { Boolean.TRUE });
          AppMethodBeat.o(199581);
          return;
        }
        catch (Exception paramAutoCompleteTextView) {}
      }
      AppMethodBeat.o(199581);
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean fi();
  }
  
  public static abstract interface c
  {
    public abstract boolean fj();
  }
  
  public static abstract interface d
  {
    public abstract boolean fl();
    
    public abstract boolean fm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.widget.SearchView
 * JD-Core Version:    0.7.0.1
 */