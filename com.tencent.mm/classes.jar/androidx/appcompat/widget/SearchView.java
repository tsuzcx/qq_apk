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
import androidx.core.g.w;
import androidx.customview.view.AbsSavedState;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView
  extends LinearLayoutCompat
  implements c
{
  static final a uR;
  private final AdapterView.OnItemSelectedListener fE;
  private final View.OnClickListener mOnClickListener;
  final SearchAutoComplete tZ;
  d uA;
  private View.OnClickListener uB;
  boolean uC;
  private boolean uD;
  androidx.c.a.a uE;
  private boolean uF;
  private CharSequence uG;
  private boolean uH;
  private boolean uI;
  private int uJ;
  private boolean uK;
  private CharSequence uL;
  private CharSequence uM;
  private boolean uN;
  private int uO;
  SearchableInfo uP;
  Bundle uQ;
  private final Runnable uS;
  private Runnable uT;
  private final WeakHashMap<String, Drawable.ConstantState> uU;
  View.OnKeyListener uV;
  private final TextView.OnEditorActionListener uW;
  private final AdapterView.OnItemClickListener uX;
  private TextWatcher uY;
  private final View ua;
  final View ub;
  private final View uc;
  final ImageView ud;
  final ImageView ue;
  final ImageView uf;
  final ImageView ug;
  final View uh;
  private SearchView.e uj;
  private Rect uk;
  private Rect ul;
  private int[] um;
  private int[] un;
  private final ImageView uo;
  private final Drawable uq;
  private final int ur;
  private final int ut;
  final Intent uu;
  final Intent uv;
  private final CharSequence uw;
  private c ux;
  private b uy;
  View.OnFocusChangeListener uz;
  
  static
  {
    AppMethodBeat.i(241869);
    uR = new a();
    AppMethodBeat.o(241869);
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
    AppMethodBeat.i(241790);
    this.uk = new Rect();
    this.ul = new Rect();
    this.um = new int[2];
    this.un = new int[2];
    this.uS = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(241556);
        SearchView.this.dZ();
        AppMethodBeat.o(241556);
      }
    };
    this.uT = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(241565);
        if ((SearchView.this.uE != null) && ((SearchView.this.uE instanceof x))) {
          SearchView.this.uE.c(null);
        }
        AppMethodBeat.o(241565);
      }
    };
    this.uU = new WeakHashMap();
    this.mOnClickListener = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        Object localObject3 = null;
        Object localObject1 = null;
        AppMethodBeat.i(241605);
        if (paramAnonymousView == SearchView.this.ud)
        {
          SearchView.this.ej();
          AppMethodBeat.o(241605);
          return;
        }
        if (paramAnonymousView == SearchView.this.uf)
        {
          SearchView.this.ei();
          AppMethodBeat.o(241605);
          return;
        }
        if (paramAnonymousView == SearchView.this.ue)
        {
          SearchView.this.eb();
          AppMethodBeat.o(241605);
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
        if (paramAnonymousView == SearchView.this.ug)
        {
          localSearchView = SearchView.this;
          if (localSearchView.uP != null) {
            localSearchableInfo = localSearchView.uP;
          }
          for (;;)
          {
            try
            {
              if (!localSearchableInfo.getVoiceSearchLaunchWebSearch()) {
                break;
              }
              localObject2 = new Intent(localSearchView.uu);
              paramAnonymousView = localSearchableInfo.getSearchActivity();
              if (paramAnonymousView != null) {
                break label237;
              }
              paramAnonymousView = (View)localObject1;
              ((Intent)localObject2).putExtra("calling_package", paramAnonymousView);
              paramAnonymousView = localSearchView.getContext();
              localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "androidx/appcompat/widget/SearchView", "onVoiceClicked", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "androidx/appcompat/widget/SearchView", "onVoiceClicked", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(241605);
              return;
            }
            catch (ActivityNotFoundException paramAnonymousView) {}
            AppMethodBeat.o(241605);
            return;
            paramAnonymousView = paramAnonymousView.flattenToShortString();
          }
          if (localSearchableInfo.getVoiceSearchLaunchRecognizer())
          {
            paramAnonymousView = localSearchView.uv;
            localComponentName = localSearchableInfo.getSearchActivity();
            localObject1 = new Intent("android.intent.action.SEARCH");
            ((Intent)localObject1).setComponent(localComponentName);
            localPendingIntent = PendingIntent.getActivity(localSearchView.getContext(), 0, (Intent)localObject1, 1073741824);
            localBundle = new Bundle();
            if (localSearchView.uQ != null) {
              localBundle.putParcelable("app_data", localSearchView.uQ);
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
                localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
                com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "androidx/appcompat/widget/SearchView", "onVoiceClicked", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
                com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "androidx/appcompat/widget/SearchView", "onVoiceClicked", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(241605);
                return;
              }
              if (paramAnonymousView == SearchView.this.tZ) {
                SearchView.this.el();
              }
              AppMethodBeat.o(241605);
              return;
            }
          }
        }
      }
    };
    this.uV = new View.OnKeyListener()
    {
      public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(241609);
        if (SearchView.this.uP == null)
        {
          AppMethodBeat.o(241609);
          return false;
        }
        if ((SearchView.this.tZ.isPopupShowing()) && (SearchView.this.tZ.getListSelection() != -1))
        {
          boolean bool = SearchView.this.b(paramAnonymousInt, paramAnonymousKeyEvent);
          AppMethodBeat.o(241609);
          return bool;
        }
        if (TextUtils.getTrimmedLength(SearchView.this.tZ.getText()) == 0) {}
        for (int i = 1; (i == 0) && (paramAnonymousKeyEvent.hasNoModifiers()) && (paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousInt == 66); i = 0)
        {
          paramAnonymousView.cancelLongPress();
          SearchView.this.s(SearchView.this.tZ.getText().toString());
          AppMethodBeat.o(241609);
          return true;
        }
        AppMethodBeat.o(241609);
        return false;
      }
    };
    this.uW = new TextView.OnEditorActionListener()
    {
      public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        AppMethodBeat.i(241617);
        SearchView.this.eb();
        AppMethodBeat.o(241617);
        return true;
      }
    };
    this.uX = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(241633);
        SearchView.this.ay(paramAnonymousInt);
        AppMethodBeat.o(241633);
      }
    };
    this.fE = new AdapterView.OnItemSelectedListener()
    {
      public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(241644);
        paramAnonymousAdapterView = SearchView.this;
        if ((paramAnonymousAdapterView.uA == null) || (!paramAnonymousAdapterView.uA.eo()))
        {
          paramAnonymousView = paramAnonymousAdapterView.tZ.getText();
          Object localObject = paramAnonymousAdapterView.uE.hK();
          if (localObject != null)
          {
            if (((Cursor)localObject).moveToPosition(paramAnonymousInt))
            {
              localObject = paramAnonymousAdapterView.uE.d((Cursor)localObject);
              if (localObject != null)
              {
                paramAnonymousAdapterView.setQuery((CharSequence)localObject);
                AppMethodBeat.o(241644);
                return;
              }
              paramAnonymousAdapterView.setQuery(paramAnonymousView);
              AppMethodBeat.o(241644);
              return;
            }
            paramAnonymousAdapterView.setQuery(paramAnonymousView);
          }
        }
        AppMethodBeat.o(241644);
      }
      
      public final void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
    };
    this.uY = new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable) {}
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(241562);
        SearchView.this.f(paramAnonymousCharSequence);
        AppMethodBeat.o(241562);
      }
    };
    paramAttributeSet = ac.a(paramContext, paramAttributeSet, a.j.SearchView, paramInt, 0);
    LayoutInflater.from(paramContext).inflate(paramAttributeSet.r(a.j.SearchView_layout, a.g.abc_search_view), this, true);
    this.tZ = ((SearchAutoComplete)findViewById(a.f.search_src_text));
    this.tZ.setSearchView(this);
    this.ua = findViewById(a.f.search_edit_frame);
    this.ub = findViewById(a.f.search_plate);
    this.uc = findViewById(a.f.submit_area);
    this.ud = ((ImageView)findViewById(a.f.search_button));
    this.ue = ((ImageView)findViewById(a.f.search_go_btn));
    this.uf = ((ImageView)findViewById(a.f.search_close_btn));
    this.ug = ((ImageView)findViewById(a.f.search_voice_btn));
    this.uo = ((ImageView)findViewById(a.f.search_mag_icon));
    w.a(this.ub, paramAttributeSet.getDrawable(a.j.SearchView_queryBackground));
    w.a(this.uc, paramAttributeSet.getDrawable(a.j.SearchView_submitBackground));
    this.ud.setImageDrawable(paramAttributeSet.getDrawable(a.j.SearchView_searchIcon));
    this.ue.setImageDrawable(paramAttributeSet.getDrawable(a.j.SearchView_goIcon));
    this.uf.setImageDrawable(paramAttributeSet.getDrawable(a.j.SearchView_closeIcon));
    this.ug.setImageDrawable(paramAttributeSet.getDrawable(a.j.SearchView_voiceIcon));
    this.uo.setImageDrawable(paramAttributeSet.getDrawable(a.j.SearchView_searchIcon));
    this.uq = paramAttributeSet.getDrawable(a.j.SearchView_searchHintIcon);
    ae.a(this.ud, getResources().getString(a.h.abc_searchview_description_search));
    this.ur = paramAttributeSet.r(a.j.SearchView_suggestionRowLayout, a.g.abc_search_dropdown_item_icons_2line);
    this.ut = paramAttributeSet.r(a.j.SearchView_commitIcon, 0);
    this.ud.setOnClickListener(this.mOnClickListener);
    this.uf.setOnClickListener(this.mOnClickListener);
    this.ue.setOnClickListener(this.mOnClickListener);
    this.ug.setOnClickListener(this.mOnClickListener);
    this.tZ.setOnClickListener(this.mOnClickListener);
    this.tZ.addTextChangedListener(this.uY);
    this.tZ.setOnEditorActionListener(this.uW);
    this.tZ.setOnItemClickListener(this.uX);
    this.tZ.setOnItemSelectedListener(this.fE);
    this.tZ.setOnKeyListener(this.uV);
    this.tZ.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(241579);
        if (SearchView.this.uz != null) {
          SearchView.this.uz.onFocusChange(SearchView.this, paramAnonymousBoolean);
        }
        AppMethodBeat.o(241579);
      }
    });
    setIconifiedByDefault(paramAttributeSet.c(a.j.SearchView_iconifiedByDefault, true));
    paramInt = paramAttributeSet.p(a.j.SearchView_android_maxWidth, -1);
    if (paramInt != -1) {
      setMaxWidth(paramInt);
    }
    this.uw = paramAttributeSet.getText(a.j.SearchView_defaultQueryHint);
    this.uG = paramAttributeSet.getText(a.j.SearchView_queryHint);
    paramInt = paramAttributeSet.getInt(a.j.SearchView_android_imeOptions, -1);
    if (paramInt != -1) {
      setImeOptions(paramInt);
    }
    paramInt = paramAttributeSet.getInt(a.j.SearchView_android_inputType, -1);
    if (paramInt != -1) {
      setInputType(paramInt);
    }
    setFocusable(paramAttributeSet.c(a.j.SearchView_android_focusable, true));
    paramAttributeSet.wA.recycle();
    this.uu = new Intent("android.speech.action.WEB_SEARCH");
    this.uu.addFlags(268435456);
    this.uu.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
    this.uv = new Intent("android.speech.action.RECOGNIZE_SPEECH");
    this.uv.addFlags(268435456);
    this.uh = findViewById(this.tZ.getDropDownAnchor());
    if (this.uh != null) {
      this.uh.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          AppMethodBeat.i(241601);
          paramAnonymousView = SearchView.this;
          Rect localRect;
          if (paramAnonymousView.uh.getWidth() > 1)
          {
            Resources localResources = paramAnonymousView.getContext().getResources();
            paramAnonymousInt3 = paramAnonymousView.ub.getPaddingLeft();
            localRect = new Rect();
            boolean bool = ai.s(paramAnonymousView);
            if (!paramAnonymousView.uC) {
              break label161;
            }
            paramAnonymousInt1 = localResources.getDimensionPixelSize(a.d.abc_dropdownitem_icon_width);
            paramAnonymousInt1 = localResources.getDimensionPixelSize(a.d.abc_dropdownitem_text_padding_left) + paramAnonymousInt1;
            paramAnonymousView.tZ.getDropDownBackground().getPadding(localRect);
            if (!bool) {
              break label166;
            }
          }
          label161:
          label166:
          for (paramAnonymousInt2 = -localRect.left;; paramAnonymousInt2 = paramAnonymousInt3 - (localRect.left + paramAnonymousInt1))
          {
            paramAnonymousView.tZ.setDropDownHorizontalOffset(paramAnonymousInt2);
            paramAnonymousInt2 = paramAnonymousView.uh.getWidth();
            paramAnonymousInt4 = localRect.left;
            paramAnonymousInt5 = localRect.right;
            paramAnonymousView.tZ.setDropDownWidth(paramAnonymousInt1 + (paramAnonymousInt2 + paramAnonymousInt4 + paramAnonymousInt5) - paramAnonymousInt3);
            AppMethodBeat.o(241601);
            return;
            paramAnonymousInt1 = 0;
            break;
          }
        }
      });
    }
    Q(this.uC);
    ea();
    AppMethodBeat.o(241790);
  }
  
  static boolean K(Context paramContext)
  {
    AppMethodBeat.i(241867);
    if (paramContext.getResources().getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(241867);
      return true;
    }
    AppMethodBeat.o(241867);
    return false;
  }
  
  private void Q(boolean paramBoolean)
  {
    boolean bool2 = true;
    int j = 8;
    AppMethodBeat.i(241825);
    this.uD = paramBoolean;
    int i;
    boolean bool1;
    if (paramBoolean)
    {
      i = 0;
      if (TextUtils.isEmpty(this.tZ.getText())) {
        break label135;
      }
      bool1 = true;
      label39:
      this.ud.setVisibility(i);
      R(bool1);
      View localView = this.ua;
      if (!paramBoolean) {
        break label141;
      }
      i = 8;
      label66:
      localView.setVisibility(i);
      i = j;
      if (this.uo.getDrawable() != null)
      {
        if (!this.uC) {
          break label146;
        }
        i = j;
      }
      label93:
      this.uo.setVisibility(i);
      dX();
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
      S(paramBoolean);
      dW();
      AppMethodBeat.o(241825);
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
  
  private void R(boolean paramBoolean)
  {
    AppMethodBeat.i(241826);
    int j = 8;
    int i = j;
    if (this.uF)
    {
      i = j;
      if (dV())
      {
        i = j;
        if (hasFocus()) {
          if (!paramBoolean)
          {
            i = j;
            if (this.uK) {}
          }
          else
          {
            i = 0;
          }
        }
      }
    }
    this.ue.setVisibility(i);
    AppMethodBeat.o(241826);
  }
  
  private void S(boolean paramBoolean)
  {
    AppMethodBeat.i(241839);
    int i;
    if ((this.uK) && (!this.uD) && (paramBoolean))
    {
      i = 0;
      this.ue.setVisibility(8);
    }
    for (;;)
    {
      this.ug.setVisibility(i);
      AppMethodBeat.o(241839);
      return;
      i = 8;
    }
  }
  
  private Intent a(Cursor paramCursor)
  {
    AppMethodBeat.i(241865);
    try
    {
      localObject3 = x.a(paramCursor, "suggest_intent_action");
      localObject1 = localObject3;
      if (localObject3 != null) {
        break label204;
      }
      localObject1 = this.uP.getSuggestIntentAction();
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
          AppMethodBeat.o(241865);
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
      localObject1 = this.uP.getSuggestIntentData();
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
          AppMethodBeat.o(241865);
          return localObject1;
          localObject1 = Uri.parse((String)localObject4);
        }
      }
    }
  }
  
  private Intent a(String paramString1, Uri paramUri, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    AppMethodBeat.i(241864);
    paramString1 = new Intent(paramString1);
    paramString1.addFlags(268435456);
    if (paramUri != null) {
      paramString1.setData(paramUri);
    }
    paramString1.putExtra("user_query", this.uM);
    if (paramString3 != null) {
      paramString1.putExtra("query", paramString3);
    }
    if (paramString2 != null) {
      paramString1.putExtra("intent_extra_data_key", paramString2);
    }
    if (this.uQ != null) {
      paramString1.putExtra("app_data", this.uQ);
    }
    paramString1.setComponent(this.uP.getSearchActivity());
    AppMethodBeat.o(241864);
    return paramString1;
  }
  
  private boolean az(int paramInt)
  {
    AppMethodBeat.i(241860);
    Cursor localCursor = this.uE.hK();
    if ((localCursor != null) && (localCursor.moveToPosition(paramInt)))
    {
      b(a(localCursor));
      AppMethodBeat.o(241860);
      return true;
    }
    AppMethodBeat.o(241860);
    return false;
  }
  
  private void b(Intent paramIntent)
  {
    AppMethodBeat.i(241861);
    if (paramIntent == null)
    {
      AppMethodBeat.o(241861);
      return;
    }
    try
    {
      Context localContext = getContext();
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bm(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(localContext, locala.aFh(), "androidx/appcompat/widget/SearchView", "launchIntent", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localContext.startActivity((Intent)locala.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(localContext, "androidx/appcompat/widget/SearchView", "launchIntent", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(241861);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      new StringBuilder("Failed launch activity: ").append(paramIntent);
      AppMethodBeat.o(241861);
    }
  }
  
  private boolean dV()
  {
    return ((this.uF) || (this.uK)) && (!this.uD);
  }
  
  private void dW()
  {
    AppMethodBeat.i(241827);
    int j = 8;
    int i = j;
    if (dV()) {
      if (this.ue.getVisibility() != 0)
      {
        i = j;
        if (this.ug.getVisibility() != 0) {}
      }
      else
      {
        i = 0;
      }
    }
    this.uc.setVisibility(i);
    AppMethodBeat.o(241827);
  }
  
  private void dX()
  {
    int m = 1;
    int k = 0;
    AppMethodBeat.i(241828);
    int i;
    int j;
    label50:
    label62:
    Drawable localDrawable;
    if (!TextUtils.isEmpty(this.tZ.getText()))
    {
      i = 1;
      j = m;
      if (i == 0)
      {
        if ((!this.uC) || (this.uN)) {
          break label111;
        }
        j = m;
      }
      localObject = this.uf;
      if (j == 0) {
        break label116;
      }
      j = k;
      ((ImageView)localObject).setVisibility(j);
      localDrawable = this.uf.getDrawable();
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
      AppMethodBeat.o(241828);
      return;
      i = 0;
      break;
      j = 0;
      break label50;
      j = 8;
      break label62;
    }
  }
  
  private void dY()
  {
    AppMethodBeat.i(241829);
    post(this.uS);
    AppMethodBeat.o(241829);
  }
  
  private CharSequence e(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(241835);
    if ((!this.uC) || (this.uq == null))
    {
      AppMethodBeat.o(241835);
      return paramCharSequence;
    }
    int i = (int)(this.tZ.getTextSize() * 1.25D);
    this.uq.setBounds(0, 0, i, i);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder("   ");
    localSpannableStringBuilder.setSpan(new ImageSpan(this.uq), 1, 2, 33);
    localSpannableStringBuilder.append(paramCharSequence);
    AppMethodBeat.o(241835);
    return localSpannableStringBuilder;
  }
  
  private void ea()
  {
    AppMethodBeat.i(241837);
    CharSequence localCharSequence = getQueryHint();
    SearchAutoComplete localSearchAutoComplete = this.tZ;
    Object localObject = localCharSequence;
    if (localCharSequence == null) {
      localObject = "";
    }
    localSearchAutoComplete.setHint(e((CharSequence)localObject));
    AppMethodBeat.o(241837);
  }
  
  private int getPreferredHeight()
  {
    AppMethodBeat.i(241824);
    int i = getContext().getResources().getDimensionPixelSize(a.d.abc_search_view_preferred_height);
    AppMethodBeat.o(241824);
    return i;
  }
  
  private int getPreferredWidth()
  {
    AppMethodBeat.i(241823);
    int i = getContext().getResources().getDimensionPixelSize(a.d.abc_search_view_preferred_width);
    AppMethodBeat.o(241823);
    return i;
  }
  
  final boolean ay(int paramInt)
  {
    AppMethodBeat.i(241858);
    if ((this.uA == null) || (!this.uA.ep()))
    {
      az(paramInt);
      this.tZ.setImeVisibility(false);
      this.tZ.dismissDropDown();
      AppMethodBeat.o(241858);
      return true;
    }
    AppMethodBeat.o(241858);
    return false;
  }
  
  final boolean b(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(241833);
    if (this.uP == null)
    {
      AppMethodBeat.o(241833);
      return false;
    }
    if (this.uE == null)
    {
      AppMethodBeat.o(241833);
      return false;
    }
    if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.hasNoModifiers()))
    {
      if ((paramInt == 66) || (paramInt == 84) || (paramInt == 61))
      {
        boolean bool = ay(this.tZ.getListSelection());
        AppMethodBeat.o(241833);
        return bool;
      }
      if ((paramInt == 21) || (paramInt == 22))
      {
        if (paramInt == 21) {}
        for (paramInt = 0;; paramInt = this.tZ.length())
        {
          this.tZ.setSelection(paramInt);
          this.tZ.setListSelection(0);
          this.tZ.clearListSelection();
          uR.c(this.tZ);
          AppMethodBeat.o(241833);
          return true;
        }
      }
      if ((paramInt == 19) && (this.tZ.getListSelection() == 0))
      {
        AppMethodBeat.o(241833);
        return false;
      }
    }
    AppMethodBeat.o(241833);
    return false;
  }
  
  public final void bB()
  {
    AppMethodBeat.i(241855);
    if (this.uN)
    {
      AppMethodBeat.o(241855);
      return;
    }
    this.uN = true;
    this.uO = this.tZ.getImeOptions();
    this.tZ.setImeOptions(this.uO | 0x2000000);
    this.tZ.setText("");
    setIconified(false);
    AppMethodBeat.o(241855);
  }
  
  public final void bC()
  {
    AppMethodBeat.i(241854);
    this.tZ.setText("");
    this.tZ.setSelection(this.tZ.length());
    this.uM = "";
    clearFocus();
    Q(true);
    this.tZ.setImeOptions(this.uO);
    this.uN = false;
    AppMethodBeat.o(241854);
  }
  
  public void clearFocus()
  {
    AppMethodBeat.i(241802);
    this.uI = true;
    super.clearFocus();
    this.tZ.clearFocus();
    this.tZ.setImeVisibility(false);
    this.uI = false;
    AppMethodBeat.o(241802);
  }
  
  final void dZ()
  {
    AppMethodBeat.i(241830);
    if (this.tZ.hasFocus()) {}
    for (int[] arrayOfInt = FOCUSED_STATE_SET;; arrayOfInt = EMPTY_STATE_SET)
    {
      Drawable localDrawable = this.ub.getBackground();
      if (localDrawable != null) {
        localDrawable.setState(arrayOfInt);
      }
      localDrawable = this.uc.getBackground();
      if (localDrawable != null) {
        localDrawable.setState(arrayOfInt);
      }
      invalidate();
      AppMethodBeat.o(241830);
      return;
    }
  }
  
  final void eb()
  {
    AppMethodBeat.i(241844);
    Editable localEditable = this.tZ.getText();
    if ((localEditable != null) && (TextUtils.getTrimmedLength(localEditable) > 0)) {
      if (this.ux != null)
      {
        c localc = this.ux;
        localEditable.toString();
        if (localc.en()) {}
      }
      else
      {
        if (this.uP != null) {
          s(localEditable.toString());
        }
        this.tZ.setImeVisibility(false);
        this.tZ.dismissDropDown();
      }
    }
    AppMethodBeat.o(241844);
  }
  
  final void ei()
  {
    AppMethodBeat.i(241847);
    if (TextUtils.isEmpty(this.tZ.getText()))
    {
      if ((this.uC) && ((this.uy == null) || (!this.uy.em())))
      {
        clearFocus();
        Q(true);
        AppMethodBeat.o(241847);
      }
    }
    else
    {
      this.tZ.setText("");
      this.tZ.requestFocus();
      this.tZ.setImeVisibility(true);
    }
    AppMethodBeat.o(241847);
  }
  
  final void ej()
  {
    AppMethodBeat.i(241849);
    Q(false);
    this.tZ.requestFocus();
    this.tZ.setImeVisibility(true);
    if (this.uB != null) {
      this.uB.onClick(this);
    }
    AppMethodBeat.o(241849);
  }
  
  final void ek()
  {
    AppMethodBeat.i(241851);
    Q(this.uD);
    dY();
    if (this.tZ.hasFocus()) {
      el();
    }
    AppMethodBeat.o(241851);
  }
  
  final void el()
  {
    AppMethodBeat.i(241866);
    uR.a(this.tZ);
    uR.b(this.tZ);
    AppMethodBeat.o(241866);
  }
  
  final void f(CharSequence paramCharSequence)
  {
    boolean bool2 = true;
    AppMethodBeat.i(241841);
    Editable localEditable = this.tZ.getText();
    this.uM = localEditable;
    if (!TextUtils.isEmpty(localEditable))
    {
      bool1 = true;
      R(bool1);
      if (bool1) {
        break label104;
      }
    }
    label104:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      S(bool1);
      dX();
      dW();
      if ((this.ux != null) && (!TextUtils.equals(paramCharSequence, this.uL))) {
        paramCharSequence.toString();
      }
      this.uL = paramCharSequence.toString();
      AppMethodBeat.o(241841);
      return;
      bool1 = false;
      break;
    }
  }
  
  public int getImeOptions()
  {
    AppMethodBeat.i(241797);
    int i = this.tZ.getImeOptions();
    AppMethodBeat.o(241797);
    return i;
  }
  
  public int getInputType()
  {
    AppMethodBeat.i(241799);
    int i = this.tZ.getInputType();
    AppMethodBeat.o(241799);
    return i;
  }
  
  public int getMaxWidth()
  {
    return this.uJ;
  }
  
  public CharSequence getQuery()
  {
    AppMethodBeat.i(241806);
    Editable localEditable = this.tZ.getText();
    AppMethodBeat.o(241806);
    return localEditable;
  }
  
  public CharSequence getQueryHint()
  {
    AppMethodBeat.i(241809);
    CharSequence localCharSequence;
    if (this.uG != null) {
      localCharSequence = this.uG;
    }
    for (;;)
    {
      AppMethodBeat.o(241809);
      return localCharSequence;
      if ((this.uP != null) && (this.uP.getHintId() != 0)) {
        localCharSequence = getContext().getText(this.uP.getHintId());
      } else {
        localCharSequence = this.uw;
      }
    }
  }
  
  int getSuggestionCommitIconResId()
  {
    return this.ut;
  }
  
  int getSuggestionRowLayout()
  {
    return this.ur;
  }
  
  public androidx.c.a.a getSuggestionsAdapter()
  {
    return this.uE;
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(241832);
    removeCallbacks(this.uS);
    post(this.uT);
    super.onDetachedFromWindow();
    AppMethodBeat.o(241832);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(241822);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      SearchAutoComplete localSearchAutoComplete = this.tZ;
      Rect localRect = this.uk;
      localSearchAutoComplete.getLocationInWindow(this.um);
      getLocationInWindow(this.un);
      paramInt1 = this.um[1] - this.un[1];
      paramInt3 = this.um[0] - this.un[0];
      localRect.set(paramInt3, paramInt1, localSearchAutoComplete.getWidth() + paramInt3, localSearchAutoComplete.getHeight() + paramInt1);
      this.ul.set(this.uk.left, 0, this.uk.right, paramInt4 - paramInt2);
      if (this.uj == null)
      {
        this.uj = new SearchView.e(this.ul, this.uk, this.tZ);
        setTouchDelegate(this.uj);
        AppMethodBeat.o(241822);
        return;
      }
      this.uj.a(this.ul, this.uk);
    }
    AppMethodBeat.o(241822);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(241821);
    if (this.uD)
    {
      super.onMeasure(paramInt1, paramInt2);
      AppMethodBeat.o(241821);
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
      AppMethodBeat.o(241821);
      return;
      if (this.uJ > 0)
      {
        paramInt1 = Math.min(this.uJ, i);
        break;
      }
      paramInt1 = Math.min(getPreferredWidth(), i);
      break;
      paramInt1 = i;
      if (this.uJ <= 0) {
        break;
      }
      paramInt1 = Math.min(this.uJ, i);
      break;
      if (this.uJ > 0)
      {
        paramInt1 = this.uJ;
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
    AppMethodBeat.i(241857);
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(241857);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.Rb);
    Q(paramParcelable.vd);
    requestLayout();
    AppMethodBeat.o(241857);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(241856);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.vd = this.uD;
    AppMethodBeat.o(241856);
    return localSavedState;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(241853);
    super.onWindowFocusChanged(paramBoolean);
    dY();
    AppMethodBeat.o(241853);
  }
  
  public boolean requestFocus(int paramInt, Rect paramRect)
  {
    AppMethodBeat.i(241801);
    if (this.uI)
    {
      AppMethodBeat.o(241801);
      return false;
    }
    if (!isFocusable())
    {
      AppMethodBeat.o(241801);
      return false;
    }
    if (!this.uD)
    {
      bool = this.tZ.requestFocus(paramInt, paramRect);
      if (bool) {
        Q(false);
      }
      AppMethodBeat.o(241801);
      return bool;
    }
    boolean bool = super.requestFocus(paramInt, paramRect);
    AppMethodBeat.o(241801);
    return bool;
  }
  
  final void s(String paramString)
  {
    AppMethodBeat.i(241863);
    Object localObject = a("android.intent.action.SEARCH", null, null, paramString, 0, null);
    paramString = getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "androidx/appcompat/widget/SearchView", "launchQuerySearch", "(ILjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramString, "androidx/appcompat/widget/SearchView", "launchQuerySearch", "(ILjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(241863);
  }
  
  public void setAppSearchData(Bundle paramBundle)
  {
    this.uQ = paramBundle;
  }
  
  public void setIconified(boolean paramBoolean)
  {
    AppMethodBeat.i(241812);
    if (paramBoolean)
    {
      ei();
      AppMethodBeat.o(241812);
      return;
    }
    ej();
    AppMethodBeat.o(241812);
  }
  
  public void setIconifiedByDefault(boolean paramBoolean)
  {
    AppMethodBeat.i(241810);
    if (this.uC == paramBoolean)
    {
      AppMethodBeat.o(241810);
      return;
    }
    this.uC = paramBoolean;
    Q(paramBoolean);
    ea();
    AppMethodBeat.o(241810);
  }
  
  public void setImeOptions(int paramInt)
  {
    AppMethodBeat.i(241796);
    this.tZ.setImeOptions(paramInt);
    AppMethodBeat.o(241796);
  }
  
  public void setInputType(int paramInt)
  {
    AppMethodBeat.i(241798);
    this.tZ.setInputType(paramInt);
    AppMethodBeat.o(241798);
  }
  
  public void setMaxWidth(int paramInt)
  {
    AppMethodBeat.i(241819);
    this.uJ = paramInt;
    requestLayout();
    AppMethodBeat.o(241819);
  }
  
  public void setOnCloseListener(b paramb)
  {
    this.uy = paramb;
  }
  
  public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.uz = paramOnFocusChangeListener;
  }
  
  public void setOnQueryTextListener(c paramc)
  {
    this.ux = paramc;
  }
  
  public void setOnSearchClickListener(View.OnClickListener paramOnClickListener)
  {
    this.uB = paramOnClickListener;
  }
  
  public void setOnSuggestionListener(d paramd)
  {
    this.uA = paramd;
  }
  
  void setQuery(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(241862);
    this.tZ.setText(paramCharSequence);
    SearchAutoComplete localSearchAutoComplete = this.tZ;
    if (TextUtils.isEmpty(paramCharSequence)) {}
    for (int i = 0;; i = paramCharSequence.length())
    {
      localSearchAutoComplete.setSelection(i);
      AppMethodBeat.o(241862);
      return;
    }
  }
  
  public void setQueryHint(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(241808);
    this.uG = paramCharSequence;
    ea();
    AppMethodBeat.o(241808);
  }
  
  public void setQueryRefinementEnabled(boolean paramBoolean)
  {
    this.uH = paramBoolean;
    x localx;
    if ((this.uE instanceof x))
    {
      localx = (x)this.uE;
      if (!paramBoolean) {
        break label35;
      }
    }
    label35:
    for (int i = 2;; i = 1)
    {
      localx.vr = i;
      return;
    }
  }
  
  public void setSearchableInfo(SearchableInfo paramSearchableInfo)
  {
    boolean bool = true;
    AppMethodBeat.i(241793);
    this.uP = paramSearchableInfo;
    int i;
    if (this.uP != null)
    {
      this.tZ.setThreshold(this.uP.getSuggestThreshold());
      this.tZ.setImeOptions(this.uP.getImeOptions());
      int j = this.uP.getInputType();
      i = j;
      if ((j & 0xF) == 1)
      {
        j &= 0xFFFEFFFF;
        i = j;
        if (this.uP.getSuggestAuthority() != null) {
          i = j | 0x10000 | 0x80000;
        }
      }
      this.tZ.setInputType(i);
      if (this.uE != null) {
        this.uE.c(null);
      }
      if (this.uP.getSuggestAuthority() != null)
      {
        this.uE = new x(getContext(), this, this.uP, this.uU);
        this.tZ.setAdapter(this.uE);
        paramSearchableInfo = (x)this.uE;
        if (this.uH)
        {
          i = 2;
          paramSearchableInfo.vr = i;
        }
      }
      else
      {
        ea();
      }
    }
    else
    {
      if ((this.uP == null) || (!this.uP.getVoiceSearchEnabled())) {
        break label309;
      }
      if (!this.uP.getVoiceSearchLaunchWebSearch()) {
        break label285;
      }
      paramSearchableInfo = this.uu;
    }
    for (;;)
    {
      label221:
      if (paramSearchableInfo != null) {
        if (getContext().getPackageManager().resolveActivity(paramSearchableInfo, 65536) == null) {}
      }
      for (;;)
      {
        this.uK = bool;
        if (this.uK) {
          this.tZ.setPrivateImeOptions("nm");
        }
        Q(this.uD);
        AppMethodBeat.o(241793);
        return;
        i = 1;
        break;
        label285:
        if (!this.uP.getVoiceSearchLaunchRecognizer()) {
          break label315;
        }
        paramSearchableInfo = this.uv;
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
    AppMethodBeat.i(241813);
    this.uF = paramBoolean;
    Q(this.uD);
    AppMethodBeat.o(241813);
  }
  
  public void setSuggestionsAdapter(androidx.c.a.a parama)
  {
    AppMethodBeat.i(241817);
    this.uE = parama;
    this.tZ.setAdapter(this.uE);
    AppMethodBeat.o(241817);
  }
  
  static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    boolean vd;
    
    static
    {
      AppMethodBeat.i(241725);
      CREATOR = new Parcelable.ClassLoaderCreator() {};
      AppMethodBeat.o(241725);
    }
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      AppMethodBeat.i(241722);
      this.vd = ((Boolean)paramParcel.readValue(null)).booleanValue();
      AppMethodBeat.o(241722);
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      AppMethodBeat.i(241724);
      String str = "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.vd + "}";
      AppMethodBeat.o(241724);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(241723);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeValue(Boolean.valueOf(this.vd));
      AppMethodBeat.o(241723);
    }
  }
  
  public static class SearchAutoComplete
    extends AppCompatAutoCompleteTextView
  {
    private int mThreshold;
    private SearchView ve;
    boolean vf;
    final Runnable vg;
    
    public SearchAutoComplete(Context paramContext, AttributeSet paramAttributeSet)
    {
      this(paramContext, paramAttributeSet, a.a.autoCompleteTextViewStyle);
    }
    
    public SearchAutoComplete(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
      AppMethodBeat.i(241746);
      this.vg = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(241728);
          SearchView.SearchAutoComplete localSearchAutoComplete = SearchView.SearchAutoComplete.this;
          if (localSearchAutoComplete.vf)
          {
            ((InputMethodManager)localSearchAutoComplete.getContext().getSystemService("input_method")).showSoftInput(localSearchAutoComplete, 0);
            localSearchAutoComplete.vf = false;
          }
          AppMethodBeat.o(241728);
        }
      };
      this.mThreshold = getThreshold();
      AppMethodBeat.o(241746);
    }
    
    private int getSearchViewTextMinWidthDp()
    {
      AppMethodBeat.i(241762);
      Configuration localConfiguration = getResources().getConfiguration();
      int i = localConfiguration.screenWidthDp;
      int j = localConfiguration.screenHeightDp;
      if ((i >= 960) && (j >= 720) && (localConfiguration.orientation == 2))
      {
        AppMethodBeat.o(241762);
        return 256;
      }
      if ((i >= 600) || ((i >= 640) && (j >= 480)))
      {
        AppMethodBeat.o(241762);
        return 192;
      }
      AppMethodBeat.o(241762);
      return 160;
    }
    
    public boolean enoughToFilter()
    {
      AppMethodBeat.i(241757);
      if ((this.mThreshold <= 0) || (super.enoughToFilter()))
      {
        AppMethodBeat.o(241757);
        return true;
      }
      AppMethodBeat.o(241757);
      return false;
    }
    
    public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
    {
      AppMethodBeat.i(241766);
      paramEditorInfo = super.onCreateInputConnection(paramEditorInfo);
      if (this.vf)
      {
        removeCallbacks(this.vg);
        post(this.vg);
      }
      AppMethodBeat.o(241766);
      return paramEditorInfo;
    }
    
    protected void onFinishInflate()
    {
      AppMethodBeat.i(241749);
      super.onFinishInflate();
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      setMinWidth((int)TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), localDisplayMetrics));
      AppMethodBeat.o(241749);
    }
    
    protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
    {
      AppMethodBeat.i(241756);
      super.onFocusChanged(paramBoolean, paramInt, paramRect);
      this.ve.ek();
      AppMethodBeat.o(241756);
    }
    
    public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
    {
      AppMethodBeat.i(241761);
      if (paramInt == 4)
      {
        KeyEvent.DispatcherState localDispatcherState;
        if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
        {
          localDispatcherState = getKeyDispatcherState();
          if (localDispatcherState != null) {
            localDispatcherState.startTracking(paramKeyEvent, this);
          }
          AppMethodBeat.o(241761);
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
            this.ve.clearFocus();
            setImeVisibility(false);
            AppMethodBeat.o(241761);
            return true;
          }
        }
      }
      boolean bool = super.onKeyPreIme(paramInt, paramKeyEvent);
      AppMethodBeat.o(241761);
      return bool;
    }
    
    public void onWindowFocusChanged(boolean paramBoolean)
    {
      AppMethodBeat.i(241755);
      super.onWindowFocusChanged(paramBoolean);
      if ((paramBoolean) && (this.ve.hasFocus()) && (getVisibility() == 0))
      {
        this.vf = true;
        if (SearchView.K(getContext())) {
          SearchView.uR.c(this);
        }
      }
      AppMethodBeat.o(241755);
    }
    
    public void performCompletion() {}
    
    protected void replaceText(CharSequence paramCharSequence) {}
    
    void setImeVisibility(boolean paramBoolean)
    {
      AppMethodBeat.i(241768);
      InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
      if (!paramBoolean)
      {
        this.vf = false;
        removeCallbacks(this.vg);
        localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        AppMethodBeat.o(241768);
        return;
      }
      if (localInputMethodManager.isActive(this))
      {
        this.vf = false;
        removeCallbacks(this.vg);
        localInputMethodManager.showSoftInput(this, 0);
        AppMethodBeat.o(241768);
        return;
      }
      this.vf = true;
      AppMethodBeat.o(241768);
    }
    
    void setSearchView(SearchView paramSearchView)
    {
      this.ve = paramSearchView;
    }
    
    public void setThreshold(int paramInt)
    {
      AppMethodBeat.i(241751);
      super.setThreshold(paramInt);
      this.mThreshold = paramInt;
      AppMethodBeat.o(241751);
    }
  }
  
  static final class a
  {
    private Method va;
    private Method vb;
    private Method vc;
    
    a()
    {
      AppMethodBeat.i(241648);
      try
      {
        this.va = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
        this.va.setAccessible(true);
        try
        {
          label32:
          this.vb = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
          this.vb.setAccessible(true);
          try
          {
            label55:
            this.vc = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[] { Boolean.TYPE });
            this.vc.setAccessible(true);
            AppMethodBeat.o(241648);
            return;
          }
          catch (NoSuchMethodException localNoSuchMethodException1)
          {
            AppMethodBeat.o(241648);
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
      AppMethodBeat.i(241649);
      if (this.va != null) {
        try
        {
          this.va.invoke(paramAutoCompleteTextView, new Object[0]);
          AppMethodBeat.o(241649);
          return;
        }
        catch (Exception paramAutoCompleteTextView) {}
      }
      AppMethodBeat.o(241649);
    }
    
    final void b(AutoCompleteTextView paramAutoCompleteTextView)
    {
      AppMethodBeat.i(241650);
      if (this.vb != null) {
        try
        {
          this.vb.invoke(paramAutoCompleteTextView, new Object[0]);
          AppMethodBeat.o(241650);
          return;
        }
        catch (Exception paramAutoCompleteTextView) {}
      }
      AppMethodBeat.o(241650);
    }
    
    final void c(AutoCompleteTextView paramAutoCompleteTextView)
    {
      AppMethodBeat.i(241651);
      if (this.vc != null) {
        try
        {
          this.vc.invoke(paramAutoCompleteTextView, new Object[] { Boolean.TRUE });
          AppMethodBeat.o(241651);
          return;
        }
        catch (Exception paramAutoCompleteTextView) {}
      }
      AppMethodBeat.o(241651);
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean em();
  }
  
  public static abstract interface c
  {
    public abstract boolean en();
  }
  
  public static abstract interface d
  {
    public abstract boolean eo();
    
    public abstract boolean ep();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.SearchView
 * JD-Core Version:    0.7.0.1
 */