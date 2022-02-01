package android.support.v7.widget;

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
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.u;
import android.support.v4.widget.f;
import android.support.v7.a.a.a;
import android.support.v7.view.c;
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
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView
  extends LinearLayoutCompat
  implements c
{
  static final a awl = new a();
  private final AdapterView.OnItemSelectedListener Yj = new AdapterView.OnItemSelectedListener()
  {
    public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      paramAnonymousAdapterView = SearchView.this;
      if ((paramAnonymousAdapterView.avV == null) || (!paramAnonymousAdapterView.avV.mw()))
      {
        paramAnonymousView = paramAnonymousAdapterView.avx.getText();
        Object localObject = paramAnonymousAdapterView.avZ.getCursor();
        if (localObject != null)
        {
          if (!((Cursor)localObject).moveToPosition(paramAnonymousInt)) {
            break label86;
          }
          localObject = paramAnonymousAdapterView.avZ.convertToString((Cursor)localObject);
          if (localObject == null) {
            break label80;
          }
          paramAnonymousAdapterView.setQuery((CharSequence)localObject);
        }
      }
      return;
      label80:
      paramAnonymousAdapterView.setQuery(paramAnonymousView);
      return;
      label86:
      paramAnonymousAdapterView.setQuery(paramAnonymousView);
    }
    
    public final void onNothingSelected(AdapterView<?> paramAnonymousAdapterView) {}
  };
  private final View avA;
  final ImageView avB;
  final ImageView avC;
  final ImageView avD;
  final ImageView avE;
  final View avF;
  private SearchView.e avG;
  private Rect avH = new Rect();
  private Rect avI = new Rect();
  private int[] avJ = new int[2];
  private int[] avK = new int[2];
  private final ImageView avL;
  private final Drawable avM;
  private final int avN;
  private final int avO;
  final Intent avP;
  final Intent avQ;
  private final CharSequence avR;
  private c avS;
  private b avT;
  View.OnFocusChangeListener avU;
  d avV;
  private View.OnClickListener avW;
  boolean avX;
  private boolean avY;
  f avZ;
  final SearchAutoComplete avx;
  private final View avy;
  final View avz;
  private boolean awa;
  private CharSequence awb;
  private boolean awc;
  private boolean awd;
  private boolean awe;
  private CharSequence awf;
  private CharSequence awg;
  private boolean awh;
  private int awi;
  SearchableInfo awj;
  Bundle awk;
  private final Runnable awm = new Runnable()
  {
    public final void run()
    {
      SearchView.this.mo();
    }
  };
  private Runnable awn = new Runnable()
  {
    public final void run()
    {
      if ((SearchView.this.avZ != null) && ((SearchView.this.avZ instanceof au))) {
        SearchView.this.avZ.changeCursor(null);
      }
    }
  };
  private final WeakHashMap<String, Drawable.ConstantState> awo = new WeakHashMap();
  View.OnKeyListener awp = new View.OnKeyListener()
  {
    public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
    {
      if (SearchView.this.awj == null) {}
      for (;;)
      {
        return false;
        if ((SearchView.this.avx.isPopupShowing()) && (SearchView.this.avx.getListSelection() != -1)) {
          return SearchView.this.b(paramAnonymousInt, paramAnonymousKeyEvent);
        }
        if (TextUtils.getTrimmedLength(SearchView.this.avx.getText()) == 0) {}
        for (int i = 1; (i == 0) && (paramAnonymousKeyEvent.hasNoModifiers()) && (paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousInt == 66); i = 0)
        {
          paramAnonymousView.cancelLongPress();
          SearchView.this.G(SearchView.this.avx.getText().toString());
          return true;
        }
      }
    }
  };
  private final TextView.OnEditorActionListener awq = new TextView.OnEditorActionListener()
  {
    public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
    {
      SearchView.this.mq();
      return true;
    }
  };
  private final AdapterView.OnItemClickListener awr = new AdapterView.OnItemClickListener()
  {
    public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      SearchView.this.cw(paramAnonymousInt);
    }
  };
  private TextWatcher aws = new TextWatcher()
  {
    public final void afterTextChanged(Editable paramAnonymousEditable) {}
    
    public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      SearchView.this.p(paramAnonymousCharSequence);
    }
  };
  private int mMaxWidth;
  private final View.OnClickListener mOnClickListener = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      Object localObject3 = null;
      Object localObject1 = null;
      if (paramAnonymousView == SearchView.this.avB) {
        SearchView.this.ms();
      }
      for (;;)
      {
        return;
        if (paramAnonymousView == SearchView.this.avD)
        {
          SearchView.this.mr();
          return;
        }
        if (paramAnonymousView == SearchView.this.avC)
        {
          SearchView.this.mq();
          return;
        }
        SearchView localSearchView;
        SearchableInfo localSearchableInfo;
        if (paramAnonymousView == SearchView.this.avE)
        {
          localSearchView = SearchView.this;
          if (localSearchView.awj == null) {
            continue;
          }
          localSearchableInfo = localSearchView.awj;
        }
        try
        {
          if (localSearchableInfo.getVoiceSearchLaunchWebSearch())
          {
            localObject2 = new Intent(localSearchView.avP);
            paramAnonymousView = localSearchableInfo.getSearchActivity();
            if (paramAnonymousView == null) {}
            for (paramAnonymousView = (View)localObject1;; paramAnonymousView = paramAnonymousView.flattenToShortString())
            {
              ((Intent)localObject2).putExtra("calling_package", paramAnonymousView);
              paramAnonymousView = localSearchView.getContext();
              localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "android/support/v7/widget/SearchView", "onVoiceClicked", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "android/support/v7/widget/SearchView", "onVoiceClicked", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              return;
            }
          }
          if (!localSearchableInfo.getVoiceSearchLaunchRecognizer()) {
            continue;
          }
          paramAnonymousView = localSearchView.avQ;
          ComponentName localComponentName = localSearchableInfo.getSearchActivity();
          localObject1 = new Intent("android.intent.action.SEARCH");
          ((Intent)localObject1).setComponent(localComponentName);
          PendingIntent localPendingIntent = PendingIntent.getActivity(localSearchView.getContext(), 0, (Intent)localObject1, 1073741824);
          Bundle localBundle = new Bundle();
          if (localSearchView.awk != null) {
            localBundle.putParcelable("app_data", localSearchView.awk);
          }
          Intent localIntent = new Intent(paramAnonymousView);
          int i = 1;
          Object localObject2 = localSearchView.getResources();
          if (localSearchableInfo.getVoiceLanguageModeId() != 0) {}
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
                  localObject1 = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "android/support/v7/widget/SearchView", "onVoiceClicked", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0));
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "android/support/v7/widget/SearchView", "onVoiceClicked", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  return;
                }
                if (paramAnonymousView != SearchView.this.avx) {
                  break;
                }
                SearchView.this.mu();
                return;
              }
            }
          }
          return;
        }
        catch (ActivityNotFoundException paramAnonymousView) {}
      }
    }
  };
  
  public SearchView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SearchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969510);
  }
  
  public SearchView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = az.a(paramContext, paramAttributeSet, a.a.SearchView, paramInt, 0);
    LayoutInflater.from(paramContext).inflate(paramAttributeSet.getResourceId(9, 2131492933), this, true);
    this.avx = ((SearchAutoComplete)findViewById(2131307423));
    this.avx.setSearchView(this);
    this.avy = findViewById(2131307380);
    this.avz = findViewById(2131307413);
    this.avA = findViewById(2131308731);
    this.avB = ((ImageView)findViewById(2131307361));
    this.avC = ((ImageView)findViewById(2131307385));
    this.avD = ((ImageView)findViewById(2131307367));
    this.avE = ((ImageView)findViewById(2131307429));
    this.avL = ((ImageView)findViewById(2131307406));
    u.a(this.avz, paramAttributeSet.getDrawable(10));
    u.a(this.avA, paramAttributeSet.getDrawable(14));
    this.avB.setImageDrawable(paramAttributeSet.getDrawable(13));
    this.avC.setImageDrawable(paramAttributeSet.getDrawable(7));
    this.avD.setImageDrawable(paramAttributeSet.getDrawable(4));
    this.avE.setImageDrawable(paramAttributeSet.getDrawable(16));
    this.avL.setImageDrawable(paramAttributeSet.getDrawable(13));
    this.avM = paramAttributeSet.getDrawable(12);
    bb.a(this.avB, getResources().getString(2131755119));
    this.avN = paramAttributeSet.getResourceId(15, 2131492932);
    this.avO = paramAttributeSet.getResourceId(5, 0);
    this.avB.setOnClickListener(this.mOnClickListener);
    this.avD.setOnClickListener(this.mOnClickListener);
    this.avC.setOnClickListener(this.mOnClickListener);
    this.avE.setOnClickListener(this.mOnClickListener);
    this.avx.setOnClickListener(this.mOnClickListener);
    this.avx.addTextChangedListener(this.aws);
    this.avx.setOnEditorActionListener(this.awq);
    this.avx.setOnItemClickListener(this.awr);
    this.avx.setOnItemSelectedListener(this.Yj);
    this.avx.setOnKeyListener(this.awp);
    this.avx.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (SearchView.this.avU != null) {
          SearchView.this.avU.onFocusChange(SearchView.this, paramAnonymousBoolean);
        }
      }
    });
    setIconifiedByDefault(paramAttributeSet.getBoolean(8, true));
    paramInt = paramAttributeSet.getDimensionPixelSize(1, -1);
    if (paramInt != -1) {
      setMaxWidth(paramInt);
    }
    this.avR = paramAttributeSet.getText(6);
    this.awb = paramAttributeSet.getText(11);
    paramInt = paramAttributeSet.getInt(3, -1);
    if (paramInt != -1) {
      setImeOptions(paramInt);
    }
    paramInt = paramAttributeSet.getInt(2, -1);
    if (paramInt != -1) {
      setInputType(paramInt);
    }
    setFocusable(paramAttributeSet.getBoolean(0, true));
    paramAttributeSet.ayy.recycle();
    this.avP = new Intent("android.speech.action.WEB_SEARCH");
    this.avP.addFlags(268435456);
    this.avP.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
    this.avQ = new Intent("android.speech.action.RECOGNIZE_SPEECH");
    this.avQ.addFlags(268435456);
    this.avF = findViewById(this.avx.getDropDownAnchor());
    if (this.avF != null) {
      this.avF.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          paramAnonymousView = SearchView.this;
          Rect localRect;
          if (paramAnonymousView.avF.getWidth() > 1)
          {
            Resources localResources = paramAnonymousView.getContext().getResources();
            paramAnonymousInt3 = paramAnonymousView.avz.getPaddingLeft();
            localRect = new Rect();
            boolean bool = bh.d(paramAnonymousView);
            if (!paramAnonymousView.avX) {
              break label149;
            }
            paramAnonymousInt1 = localResources.getDimensionPixelSize(2131165691);
            paramAnonymousInt1 = localResources.getDimensionPixelSize(2131165692) + paramAnonymousInt1;
            paramAnonymousView.avx.getDropDownBackground().getPadding(localRect);
            if (!bool) {
              break label154;
            }
          }
          label149:
          label154:
          for (paramAnonymousInt2 = -localRect.left;; paramAnonymousInt2 = paramAnonymousInt3 - (localRect.left + paramAnonymousInt1))
          {
            paramAnonymousView.avx.setDropDownHorizontalOffset(paramAnonymousInt2);
            paramAnonymousInt2 = paramAnonymousView.avF.getWidth();
            paramAnonymousInt4 = localRect.left;
            paramAnonymousInt5 = localRect.right;
            paramAnonymousView.avx.setDropDownWidth(paramAnonymousInt1 + (paramAnonymousInt2 + paramAnonymousInt4 + paramAnonymousInt5) - paramAnonymousInt3);
            return;
            paramAnonymousInt1 = 0;
            break;
          }
        }
      });
    }
    ax(this.avX);
    mp();
  }
  
  private Intent a(Cursor paramCursor)
  {
    try
    {
      localObject3 = au.a(paramCursor, "suggest_intent_action");
      localObject1 = localObject3;
      if (localObject3 != null) {
        break label184;
      }
      localObject1 = this.awj.getSuggestIntentAction();
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
          return null;
        }
        catch (RuntimeException paramCursor)
        {
          int i = -1;
          continue;
        }
        label184:
        Object localObject3 = localRuntimeException;
        if (localRuntimeException == null)
        {
          localObject3 = "android.intent.action.SEARCH";
          continue;
          label199:
          if (localObject4 == null) {
            Object localObject2 = null;
          }
        }
      }
    }
    localObject4 = au.a(paramCursor, "suggest_intent_data");
    localObject1 = localObject4;
    if (localObject4 == null) {
      localObject1 = this.awj.getSuggestIntentData();
    }
    localObject4 = localObject1;
    if (localObject1 != null)
    {
      str = au.a(paramCursor, "suggest_intent_data_id");
      localObject4 = localObject1;
      if (str != null)
      {
        localObject4 = (String)localObject1 + "/" + Uri.encode(str);
        break label199;
        for (;;)
        {
          localObject4 = au.a(paramCursor, "suggest_intent_query");
          return a((String)localObject3, (Uri)localObject1, au.a(paramCursor, "suggest_intent_extra_data"), (String)localObject4, 0, null);
          localObject1 = Uri.parse((String)localObject4);
        }
      }
    }
  }
  
  private Intent a(String paramString1, Uri paramUri, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    paramString1 = new Intent(paramString1);
    paramString1.addFlags(268435456);
    if (paramUri != null) {
      paramString1.setData(paramUri);
    }
    paramString1.putExtra("user_query", this.awg);
    if (paramString3 != null) {
      paramString1.putExtra("query", paramString3);
    }
    if (paramString2 != null) {
      paramString1.putExtra("intent_extra_data_key", paramString2);
    }
    if (this.awk != null) {
      paramString1.putExtra("app_data", this.awk);
    }
    paramString1.setComponent(this.awj.getSearchActivity());
    return paramString1;
  }
  
  static boolean ad(Context paramContext)
  {
    return paramContext.getResources().getConfiguration().orientation == 2;
  }
  
  private void ax(boolean paramBoolean)
  {
    boolean bool2 = true;
    int j = 8;
    this.avY = paramBoolean;
    int i;
    boolean bool1;
    if (paramBoolean)
    {
      i = 0;
      if (TextUtils.isEmpty(this.avx.getText())) {
        break label123;
      }
      bool1 = true;
      label33:
      this.avB.setVisibility(i);
      ay(bool1);
      View localView = this.avy;
      if (!paramBoolean) {
        break label129;
      }
      i = 8;
      label60:
      localView.setVisibility(i);
      i = j;
      if (this.avL.getDrawable() != null)
      {
        if (!this.avX) {
          break label134;
        }
        i = j;
      }
      label87:
      this.avL.setVisibility(i);
      mm();
      if (bool1) {
        break label139;
      }
    }
    label129:
    label134:
    label139:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      az(paramBoolean);
      ml();
      return;
      i = 8;
      break;
      label123:
      bool1 = false;
      break label33;
      i = 0;
      break label60;
      i = 0;
      break label87;
    }
  }
  
  private void ay(boolean paramBoolean)
  {
    int j = 8;
    int i = j;
    if (this.awa)
    {
      i = j;
      if (mk())
      {
        i = j;
        if (hasFocus()) {
          if (!paramBoolean)
          {
            i = j;
            if (this.awe) {}
          }
          else
          {
            i = 0;
          }
        }
      }
    }
    this.avC.setVisibility(i);
  }
  
  private void az(boolean paramBoolean)
  {
    int i;
    if ((this.awe) && (!this.avY) && (paramBoolean))
    {
      i = 0;
      this.avC.setVisibility(8);
    }
    for (;;)
    {
      this.avE.setVisibility(i);
      return;
      i = 8;
    }
  }
  
  private void c(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    try
    {
      Context localContext = getContext();
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bl(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(localContext, locala.axQ(), "android/support/v7/widget/SearchView", "launchIntent", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localContext.startActivity((Intent)locala.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(localContext, "android/support/v7/widget/SearchView", "launchIntent", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      new StringBuilder("Failed launch activity: ").append(paramIntent);
    }
  }
  
  private boolean cx(int paramInt)
  {
    Cursor localCursor = this.avZ.getCursor();
    if ((localCursor != null) && (localCursor.moveToPosition(paramInt)))
    {
      c(a(localCursor));
      return true;
    }
    return false;
  }
  
  private int getPreferredHeight()
  {
    return getContext().getResources().getDimensionPixelSize(2131165701);
  }
  
  private int getPreferredWidth()
  {
    return getContext().getResources().getDimensionPixelSize(2131165702);
  }
  
  private boolean mk()
  {
    return ((this.awa) || (this.awe)) && (!this.avY);
  }
  
  private void ml()
  {
    int j = 8;
    int i = j;
    if (mk()) {
      if (this.avC.getVisibility() != 0)
      {
        i = j;
        if (this.avE.getVisibility() != 0) {}
      }
      else
      {
        i = 0;
      }
    }
    this.avA.setVisibility(i);
  }
  
  private void mm()
  {
    int m = 1;
    int k = 0;
    int i;
    int j;
    label44:
    label56:
    Drawable localDrawable;
    if (!TextUtils.isEmpty(this.avx.getText()))
    {
      i = 1;
      j = m;
      if (i == 0)
      {
        if ((!this.avX) || (this.awh)) {
          break label99;
        }
        j = m;
      }
      localObject = this.avD;
      if (j == 0) {
        break label104;
      }
      j = k;
      ((ImageView)localObject).setVisibility(j);
      localDrawable = this.avD.getDrawable();
      if (localDrawable != null) {
        if (i == 0) {
          break label110;
        }
      }
    }
    label99:
    label104:
    label110:
    for (Object localObject = ENABLED_STATE_SET;; localObject = EMPTY_STATE_SET)
    {
      localDrawable.setState((int[])localObject);
      return;
      i = 0;
      break;
      j = 0;
      break label44;
      j = 8;
      break label56;
    }
  }
  
  private void mn()
  {
    post(this.awm);
  }
  
  private void mp()
  {
    CharSequence localCharSequence = getQueryHint();
    SearchAutoComplete localSearchAutoComplete = this.avx;
    Object localObject = localCharSequence;
    if (localCharSequence == null) {
      localObject = "";
    }
    localSearchAutoComplete.setHint(o((CharSequence)localObject));
  }
  
  private CharSequence o(CharSequence paramCharSequence)
  {
    if ((!this.avX) || (this.avM == null)) {
      return paramCharSequence;
    }
    int i = (int)(this.avx.getTextSize() * 1.25D);
    this.avM.setBounds(0, 0, i, i);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder("   ");
    localSpannableStringBuilder.setSpan(new ImageSpan(this.avM), 1, 2, 33);
    localSpannableStringBuilder.append(paramCharSequence);
    return localSpannableStringBuilder;
  }
  
  final void G(String paramString)
  {
    Object localObject = a("android.intent.action.SEARCH", null, null, paramString, 0, null);
    paramString = getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "android/support/v7/widget/SearchView", "launchQuerySearch", "(ILjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramString, "android/support/v7/widget/SearchView", "launchQuerySearch", "(ILjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
  }
  
  final boolean b(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.awj == null) {}
    do
    {
      do
      {
        return false;
      } while ((this.avZ == null) || (paramKeyEvent.getAction() != 0) || (!paramKeyEvent.hasNoModifiers()));
      if ((paramInt == 66) || (paramInt == 84) || (paramInt == 61)) {
        return cw(this.avx.getListSelection());
      }
      if ((paramInt == 21) || (paramInt == 22))
      {
        if (paramInt == 21) {}
        for (paramInt = 0;; paramInt = this.avx.length())
        {
          this.avx.setSelection(paramInt);
          this.avx.setListSelection(0);
          this.avx.clearListSelection();
          awl.c(this.avx);
          return true;
        }
      }
    } while ((paramInt != 19) || (this.avx.getListSelection() != 0));
    return false;
  }
  
  public void clearFocus()
  {
    this.awd = true;
    super.clearFocus();
    this.avx.clearFocus();
    this.avx.setImeVisibility(false);
    this.awd = false;
  }
  
  final boolean cw(int paramInt)
  {
    boolean bool = false;
    if ((this.avV == null) || (!this.avV.mx()))
    {
      cx(paramInt);
      this.avx.setImeVisibility(false);
      this.avx.dismissDropDown();
      bool = true;
    }
    return bool;
  }
  
  public int getImeOptions()
  {
    return this.avx.getImeOptions();
  }
  
  public int getInputType()
  {
    return this.avx.getInputType();
  }
  
  public int getMaxWidth()
  {
    return this.mMaxWidth;
  }
  
  public CharSequence getQuery()
  {
    return this.avx.getText();
  }
  
  public CharSequence getQueryHint()
  {
    if (this.awb != null) {
      return this.awb;
    }
    if ((this.awj != null) && (this.awj.getHintId() != 0)) {
      return getContext().getText(this.awj.getHintId());
    }
    return this.avR;
  }
  
  int getSuggestionCommitIconResId()
  {
    return this.avO;
  }
  
  int getSuggestionRowLayout()
  {
    return this.avN;
  }
  
  public f getSuggestionsAdapter()
  {
    return this.avZ;
  }
  
  final void mo()
  {
    if (this.avx.hasFocus()) {}
    for (int[] arrayOfInt = FOCUSED_STATE_SET;; arrayOfInt = EMPTY_STATE_SET)
    {
      Drawable localDrawable = this.avz.getBackground();
      if (localDrawable != null) {
        localDrawable.setState(arrayOfInt);
      }
      localDrawable = this.avA.getBackground();
      if (localDrawable != null) {
        localDrawable.setState(arrayOfInt);
      }
      invalidate();
      return;
    }
  }
  
  final void mq()
  {
    Editable localEditable = this.avx.getText();
    if ((localEditable != null) && (TextUtils.getTrimmedLength(localEditable) > 0)) {
      if (this.avS != null)
      {
        c localc = this.avS;
        localEditable.toString();
        if (localc.mv()) {}
      }
      else
      {
        if (this.awj != null) {
          G(localEditable.toString());
        }
        this.avx.setImeVisibility(false);
        this.avx.dismissDropDown();
      }
    }
  }
  
  final void mr()
  {
    if (TextUtils.isEmpty(this.avx.getText()))
    {
      if ((this.avX) && ((this.avT == null) || (!this.avT.onClose())))
      {
        clearFocus();
        ax(true);
      }
      return;
    }
    this.avx.setText("");
    this.avx.requestFocus();
    this.avx.setImeVisibility(true);
  }
  
  final void ms()
  {
    ax(false);
    this.avx.requestFocus();
    this.avx.setImeVisibility(true);
    if (this.avW != null) {
      this.avW.onClick(this);
    }
  }
  
  final void mt()
  {
    ax(this.avY);
    mn();
    if (this.avx.hasFocus()) {
      mu();
    }
  }
  
  final void mu()
  {
    awl.a(this.avx);
    awl.b(this.avx);
  }
  
  public final void onActionViewCollapsed()
  {
    this.avx.setText("");
    this.avx.setSelection(this.avx.length());
    this.awg = "";
    clearFocus();
    ax(true);
    this.avx.setImeOptions(this.awi);
    this.awh = false;
  }
  
  public final void onActionViewExpanded()
  {
    if (this.awh) {
      return;
    }
    this.awh = true;
    this.awi = this.avx.getImeOptions();
    this.avx.setImeOptions(this.awi | 0x2000000);
    this.avx.setText("");
    setIconified(false);
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.awm);
    post(this.awn);
    super.onDetachedFromWindow();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      SearchAutoComplete localSearchAutoComplete = this.avx;
      Rect localRect = this.avH;
      localSearchAutoComplete.getLocationInWindow(this.avJ);
      getLocationInWindow(this.avK);
      paramInt1 = this.avJ[1] - this.avK[1];
      paramInt3 = this.avJ[0] - this.avK[0];
      localRect.set(paramInt3, paramInt1, localSearchAutoComplete.getWidth() + paramInt3, localSearchAutoComplete.getHeight() + paramInt1);
      this.avI.set(this.avH.left, 0, this.avH.right, paramInt4 - paramInt2);
      if (this.avG == null)
      {
        this.avG = new SearchView.e(this.avI, this.avH, this.avx);
        setTouchDelegate(this.avG);
      }
    }
    else
    {
      return;
    }
    this.avG.a(this.avI, this.avH);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.avY)
    {
      super.onMeasure(paramInt1, paramInt2);
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
      return;
      if (this.mMaxWidth > 0)
      {
        paramInt1 = Math.min(this.mMaxWidth, i);
        break;
      }
      paramInt1 = Math.min(getPreferredWidth(), i);
      break;
      paramInt1 = i;
      if (this.mMaxWidth <= 0) {
        break;
      }
      paramInt1 = Math.min(this.mMaxWidth, i);
      break;
      if (this.mMaxWidth > 0)
      {
        paramInt1 = this.mMaxWidth;
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
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.Pm);
    ax(paramParcelable.awx);
    requestLayout();
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.awx = this.avY;
    return localSavedState;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    mn();
  }
  
  final void p(CharSequence paramCharSequence)
  {
    boolean bool2 = true;
    Editable localEditable = this.avx.getText();
    this.awg = localEditable;
    if (!TextUtils.isEmpty(localEditable))
    {
      bool1 = true;
      ay(bool1);
      if (bool1) {
        break label92;
      }
    }
    label92:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      az(bool1);
      mm();
      ml();
      if ((this.avS != null) && (!TextUtils.equals(paramCharSequence, this.awf))) {
        paramCharSequence.toString();
      }
      this.awf = paramCharSequence.toString();
      return;
      bool1 = false;
      break;
    }
  }
  
  public boolean requestFocus(int paramInt, Rect paramRect)
  {
    if (this.awd) {}
    while (!isFocusable()) {
      return false;
    }
    if (!this.avY)
    {
      boolean bool = this.avx.requestFocus(paramInt, paramRect);
      if (bool) {
        ax(false);
      }
      return bool;
    }
    return super.requestFocus(paramInt, paramRect);
  }
  
  public void setAppSearchData(Bundle paramBundle)
  {
    this.awk = paramBundle;
  }
  
  public void setIconified(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      mr();
      return;
    }
    ms();
  }
  
  public void setIconifiedByDefault(boolean paramBoolean)
  {
    if (this.avX == paramBoolean) {
      return;
    }
    this.avX = paramBoolean;
    ax(paramBoolean);
    mp();
  }
  
  public void setImeOptions(int paramInt)
  {
    this.avx.setImeOptions(paramInt);
  }
  
  public void setInputType(int paramInt)
  {
    this.avx.setInputType(paramInt);
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.mMaxWidth = paramInt;
    requestLayout();
  }
  
  public void setOnCloseListener(b paramb)
  {
    this.avT = paramb;
  }
  
  public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.avU = paramOnFocusChangeListener;
  }
  
  public void setOnQueryTextListener(c paramc)
  {
    this.avS = paramc;
  }
  
  public void setOnSearchClickListener(View.OnClickListener paramOnClickListener)
  {
    this.avW = paramOnClickListener;
  }
  
  public void setOnSuggestionListener(d paramd)
  {
    this.avV = paramd;
  }
  
  void setQuery(CharSequence paramCharSequence)
  {
    this.avx.setText(paramCharSequence);
    SearchAutoComplete localSearchAutoComplete = this.avx;
    if (TextUtils.isEmpty(paramCharSequence)) {}
    for (int i = 0;; i = paramCharSequence.length())
    {
      localSearchAutoComplete.setSelection(i);
      return;
    }
  }
  
  public void setQueryHint(CharSequence paramCharSequence)
  {
    this.awb = paramCharSequence;
    mp();
  }
  
  public void setQueryRefinementEnabled(boolean paramBoolean)
  {
    this.awc = paramBoolean;
    au localau;
    if ((this.avZ instanceof au))
    {
      localau = (au)this.avZ;
      if (!paramBoolean) {
        break label35;
      }
    }
    label35:
    for (int i = 2;; i = 1)
    {
      localau.axx = i;
      return;
    }
  }
  
  public void setSearchableInfo(SearchableInfo paramSearchableInfo)
  {
    boolean bool = true;
    this.awj = paramSearchableInfo;
    int i;
    if (this.awj != null)
    {
      this.avx.setThreshold(this.awj.getSuggestThreshold());
      this.avx.setImeOptions(this.awj.getImeOptions());
      int j = this.awj.getInputType();
      i = j;
      if ((j & 0xF) == 1)
      {
        j &= 0xFFFEFFFF;
        i = j;
        if (this.awj.getSuggestAuthority() != null) {
          i = j | 0x10000 | 0x80000;
        }
      }
      this.avx.setInputType(i);
      if (this.avZ != null) {
        this.avZ.changeCursor(null);
      }
      if (this.awj.getSuggestAuthority() != null)
      {
        this.avZ = new au(getContext(), this, this.awj, this.awo);
        this.avx.setAdapter(this.avZ);
        paramSearchableInfo = (au)this.avZ;
        if (this.awc)
        {
          i = 2;
          paramSearchableInfo.axx = i;
        }
      }
      else
      {
        mp();
      }
    }
    else
    {
      if ((this.awj == null) || (!this.awj.getVoiceSearchEnabled())) {
        break label297;
      }
      if (!this.awj.getVoiceSearchLaunchWebSearch()) {
        break label273;
      }
      paramSearchableInfo = this.avP;
    }
    for (;;)
    {
      label215:
      if (paramSearchableInfo != null) {
        if (getContext().getPackageManager().resolveActivity(paramSearchableInfo, 65536) == null) {}
      }
      for (;;)
      {
        this.awe = bool;
        if (this.awe) {
          this.avx.setPrivateImeOptions("nm");
        }
        ax(this.avY);
        return;
        i = 1;
        break;
        label273:
        if (!this.awj.getVoiceSearchLaunchRecognizer()) {
          break label303;
        }
        paramSearchableInfo = this.avQ;
        break label215;
        bool = false;
        continue;
        label297:
        bool = false;
      }
      label303:
      paramSearchableInfo = null;
    }
  }
  
  public void setSubmitButtonEnabled(boolean paramBoolean)
  {
    this.awa = paramBoolean;
    ax(this.avY);
  }
  
  public void setSuggestionsAdapter(f paramf)
  {
    this.avZ = paramf;
    this.avx.setAdapter(this.avZ);
  }
  
  static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator() {};
    boolean awx;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.awx = ((Boolean)paramParcel.readValue(null)).booleanValue();
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.awx + "}";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeValue(Boolean.valueOf(this.awx));
    }
  }
  
  public static class SearchAutoComplete
    extends AppCompatAutoCompleteTextView
  {
    final Runnable awA = new Runnable()
    {
      public final void run()
      {
        SearchView.SearchAutoComplete localSearchAutoComplete = SearchView.SearchAutoComplete.this;
        if (localSearchAutoComplete.awz)
        {
          ((InputMethodManager)localSearchAutoComplete.getContext().getSystemService("input_method")).showSoftInput(localSearchAutoComplete, 0);
          localSearchAutoComplete.awz = false;
        }
      }
    };
    private SearchView awy;
    boolean awz;
    private int mThreshold = getThreshold();
    
    public SearchAutoComplete(Context paramContext, AttributeSet paramAttributeSet)
    {
      this(paramContext, paramAttributeSet, 2130968665);
    }
    
    public SearchAutoComplete(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
    }
    
    private int getSearchViewTextMinWidthDp()
    {
      Configuration localConfiguration = getResources().getConfiguration();
      int i = localConfiguration.screenWidthDp;
      int j = localConfiguration.screenHeightDp;
      if ((i >= 960) && (j >= 720) && (localConfiguration.orientation == 2)) {
        return 256;
      }
      if ((i >= 600) || ((i >= 640) && (j >= 480))) {
        return 192;
      }
      return 160;
    }
    
    public boolean enoughToFilter()
    {
      return (this.mThreshold <= 0) || (super.enoughToFilter());
    }
    
    public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
    {
      paramEditorInfo = super.onCreateInputConnection(paramEditorInfo);
      if (this.awz)
      {
        removeCallbacks(this.awA);
        post(this.awA);
      }
      return paramEditorInfo;
    }
    
    protected void onFinishInflate()
    {
      super.onFinishInflate();
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      setMinWidth((int)TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), localDisplayMetrics));
    }
    
    protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
    {
      super.onFocusChanged(paramBoolean, paramInt, paramRect);
      this.awy.mt();
    }
    
    public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
    {
      if (paramInt == 4)
      {
        KeyEvent.DispatcherState localDispatcherState;
        if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
        {
          localDispatcherState = getKeyDispatcherState();
          if (localDispatcherState != null) {
            localDispatcherState.startTracking(paramKeyEvent, this);
          }
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
            this.awy.clearFocus();
            setImeVisibility(false);
            return true;
          }
        }
      }
      return super.onKeyPreIme(paramInt, paramKeyEvent);
    }
    
    public void onWindowFocusChanged(boolean paramBoolean)
    {
      super.onWindowFocusChanged(paramBoolean);
      if ((paramBoolean) && (this.awy.hasFocus()) && (getVisibility() == 0))
      {
        this.awz = true;
        if (SearchView.ad(getContext())) {
          SearchView.awl.c(this);
        }
      }
    }
    
    public void performCompletion() {}
    
    protected void replaceText(CharSequence paramCharSequence) {}
    
    void setImeVisibility(boolean paramBoolean)
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
      if (!paramBoolean)
      {
        this.awz = false;
        removeCallbacks(this.awA);
        localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        return;
      }
      if (localInputMethodManager.isActive(this))
      {
        this.awz = false;
        removeCallbacks(this.awA);
        localInputMethodManager.showSoftInput(this, 0);
        return;
      }
      this.awz = true;
    }
    
    void setSearchView(SearchView paramSearchView)
    {
      this.awy = paramSearchView;
    }
    
    public void setThreshold(int paramInt)
    {
      super.setThreshold(paramInt);
      this.mThreshold = paramInt;
    }
  }
  
  static final class a
  {
    private Method awu;
    private Method awv;
    private Method aww;
    
    a()
    {
      try
      {
        this.awu = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
        this.awu.setAccessible(true);
        try
        {
          label27:
          this.awv = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
          this.awv.setAccessible(true);
          try
          {
            label50:
            this.aww = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[] { Boolean.TYPE });
            this.aww.setAccessible(true);
            return;
          }
          catch (NoSuchMethodException localNoSuchMethodException1) {}
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          break label50;
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException3)
      {
        break label27;
      }
    }
    
    final void a(AutoCompleteTextView paramAutoCompleteTextView)
    {
      if (this.awu != null) {}
      try
      {
        this.awu.invoke(paramAutoCompleteTextView, new Object[0]);
        return;
      }
      catch (Exception paramAutoCompleteTextView) {}
    }
    
    final void b(AutoCompleteTextView paramAutoCompleteTextView)
    {
      if (this.awv != null) {}
      try
      {
        this.awv.invoke(paramAutoCompleteTextView, new Object[0]);
        return;
      }
      catch (Exception paramAutoCompleteTextView) {}
    }
    
    final void c(AutoCompleteTextView paramAutoCompleteTextView)
    {
      if (this.aww != null) {}
      try
      {
        this.aww.invoke(paramAutoCompleteTextView, new Object[] { Boolean.TRUE });
        return;
      }
      catch (Exception paramAutoCompleteTextView) {}
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean onClose();
  }
  
  public static abstract interface c
  {
    public abstract boolean mv();
  }
  
  public static abstract interface d
  {
    public abstract boolean mw();
    
    public abstract boolean mx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.SearchView
 * JD-Core Version:    0.7.0.1
 */