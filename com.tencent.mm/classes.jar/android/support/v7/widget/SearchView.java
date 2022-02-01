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
import android.support.v4.view.t;
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
  static final a auv = new a();
  private final AdapterView.OnItemSelectedListener Wh = new SearchView.10(this);
  final SearchAutoComplete atH;
  private final View atI;
  final View atJ;
  private final View atK;
  final ImageView atL;
  final ImageView atM;
  final ImageView atN;
  final ImageView atO;
  final View atP;
  private SearchView.e atQ;
  private Rect atR = new Rect();
  private Rect atS = new Rect();
  private int[] atT = new int[2];
  private int[] atU = new int[2];
  private final ImageView atV;
  private final Drawable atW;
  private final int atX;
  private final int atY;
  final Intent atZ;
  private final TextView.OnEditorActionListener auA = new TextView.OnEditorActionListener()
  {
    public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
    {
      SearchView.this.lU();
      return true;
    }
  };
  private final AdapterView.OnItemClickListener auB = new AdapterView.OnItemClickListener()
  {
    public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      SearchView.this.cC(paramAnonymousInt);
    }
  };
  private TextWatcher auC = new TextWatcher()
  {
    public final void afterTextChanged(Editable paramAnonymousEditable) {}
    
    public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      SearchView.this.p(paramAnonymousCharSequence);
    }
  };
  final Intent aua;
  private final CharSequence aub;
  private c auc;
  private b aud;
  View.OnFocusChangeListener aue;
  SearchView.d auf;
  private View.OnClickListener aug;
  boolean auh;
  private boolean aui;
  f auj;
  private boolean auk;
  private CharSequence aul;
  private boolean aum;
  private boolean aun;
  private boolean auo;
  private CharSequence aup;
  private CharSequence auq;
  private boolean aur;
  private int aus;
  SearchableInfo aut;
  Bundle auu;
  private final Runnable auw = new Runnable()
  {
    public final void run()
    {
      SearchView.this.lS();
    }
  };
  private Runnable aux = new SearchView.3(this);
  private final WeakHashMap<String, Drawable.ConstantState> auy = new WeakHashMap();
  View.OnKeyListener auz = new View.OnKeyListener()
  {
    public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
    {
      if (SearchView.this.aut == null) {}
      for (;;)
      {
        return false;
        if ((SearchView.this.atH.isPopupShowing()) && (SearchView.this.atH.getListSelection() != -1)) {
          return SearchView.this.b(paramAnonymousInt, paramAnonymousKeyEvent);
        }
        if (TextUtils.getTrimmedLength(SearchView.this.atH.getText()) == 0) {}
        for (int i = 1; (i == 0) && (paramAnonymousKeyEvent.hasNoModifiers()) && (paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousInt == 66); i = 0)
        {
          paramAnonymousView.cancelLongPress();
          SearchView.this.H(SearchView.this.atH.getText().toString());
          return true;
        }
      }
    }
  };
  private int mMaxWidth;
  private final View.OnClickListener mOnClickListener = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      Object localObject3 = null;
      Object localObject1 = null;
      if (paramAnonymousView == SearchView.this.atL) {
        SearchView.this.lW();
      }
      for (;;)
      {
        return;
        if (paramAnonymousView == SearchView.this.atN)
        {
          SearchView.this.lV();
          return;
        }
        if (paramAnonymousView == SearchView.this.atM)
        {
          SearchView.this.lU();
          return;
        }
        SearchView localSearchView;
        SearchableInfo localSearchableInfo;
        if (paramAnonymousView == SearchView.this.atO)
        {
          localSearchView = SearchView.this;
          if (localSearchView.aut == null) {
            continue;
          }
          localSearchableInfo = localSearchView.aut;
        }
        try
        {
          if (localSearchableInfo.getVoiceSearchLaunchWebSearch())
          {
            localObject2 = new Intent(localSearchView.atZ);
            paramAnonymousView = localSearchableInfo.getSearchActivity();
            if (paramAnonymousView == null) {}
            for (paramAnonymousView = (View)localObject1;; paramAnonymousView = paramAnonymousView.flattenToShortString())
            {
              ((Intent)localObject2).putExtra("calling_package", paramAnonymousView);
              paramAnonymousView = localSearchView.getContext();
              localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "android/support/v7/widget/SearchView", "onVoiceClicked", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "android/support/v7/widget/SearchView", "onVoiceClicked", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              return;
            }
          }
          if (!localSearchableInfo.getVoiceSearchLaunchRecognizer()) {
            continue;
          }
          paramAnonymousView = localSearchView.aua;
          ComponentName localComponentName = localSearchableInfo.getSearchActivity();
          localObject1 = new Intent("android.intent.action.SEARCH");
          ((Intent)localObject1).setComponent(localComponentName);
          PendingIntent localPendingIntent = PendingIntent.getActivity(localSearchView.getContext(), 0, (Intent)localObject1, 1073741824);
          Bundle localBundle = new Bundle();
          if (localSearchView.auu != null) {
            localBundle.putParcelable("app_data", localSearchView.auu);
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
                  localObject1 = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "android/support/v7/widget/SearchView", "onVoiceClicked", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0));
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "android/support/v7/widget/SearchView", "onVoiceClicked", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  return;
                }
                if (paramAnonymousView != SearchView.this.atH) {
                  break;
                }
                SearchView.this.lY();
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
    this(paramContext, paramAttributeSet, 2130969429);
  }
  
  public SearchView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = az.a(paramContext, paramAttributeSet, a.a.SearchView, paramInt, 0);
    LayoutInflater.from(paramContext).inflate(paramAttributeSet.getResourceId(9, 2131492916), this, true);
    this.atH = ((SearchAutoComplete)findViewById(2131304447));
    this.atH.setSearchView(this);
    this.atI = findViewById(2131304414);
    this.atJ = findViewById(2131304437);
    this.atK = findViewById(2131305515);
    this.atL = ((ImageView)findViewById(2131304396));
    this.atM = ((ImageView)findViewById(2131304418));
    this.atN = ((ImageView)findViewById(2131304402));
    this.atO = ((ImageView)findViewById(2131304453));
    this.atV = ((ImageView)findViewById(2131304434));
    t.a(this.atJ, paramAttributeSet.getDrawable(10));
    t.a(this.atK, paramAttributeSet.getDrawable(14));
    this.atL.setImageDrawable(paramAttributeSet.getDrawable(13));
    this.atM.setImageDrawable(paramAttributeSet.getDrawable(7));
    this.atN.setImageDrawable(paramAttributeSet.getDrawable(4));
    this.atO.setImageDrawable(paramAttributeSet.getDrawable(16));
    this.atV.setImageDrawable(paramAttributeSet.getDrawable(13));
    this.atW = paramAttributeSet.getDrawable(12);
    bb.a(this.atL, getResources().getString(2131755106));
    this.atX = paramAttributeSet.getResourceId(15, 2131492915);
    this.atY = paramAttributeSet.getResourceId(5, 0);
    this.atL.setOnClickListener(this.mOnClickListener);
    this.atN.setOnClickListener(this.mOnClickListener);
    this.atM.setOnClickListener(this.mOnClickListener);
    this.atO.setOnClickListener(this.mOnClickListener);
    this.atH.setOnClickListener(this.mOnClickListener);
    this.atH.addTextChangedListener(this.auC);
    this.atH.setOnEditorActionListener(this.auA);
    this.atH.setOnItemClickListener(this.auB);
    this.atH.setOnItemSelectedListener(this.Wh);
    this.atH.setOnKeyListener(this.auz);
    this.atH.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (SearchView.this.aue != null) {
          SearchView.this.aue.onFocusChange(SearchView.this, paramAnonymousBoolean);
        }
      }
    });
    setIconifiedByDefault(paramAttributeSet.getBoolean(8, true));
    paramInt = paramAttributeSet.getDimensionPixelSize(1, -1);
    if (paramInt != -1) {
      setMaxWidth(paramInt);
    }
    this.aub = paramAttributeSet.getText(6);
    this.aul = paramAttributeSet.getText(11);
    paramInt = paramAttributeSet.getInt(3, -1);
    if (paramInt != -1) {
      setImeOptions(paramInt);
    }
    paramInt = paramAttributeSet.getInt(2, -1);
    if (paramInt != -1) {
      setInputType(paramInt);
    }
    setFocusable(paramAttributeSet.getBoolean(0, true));
    paramAttributeSet.awJ.recycle();
    this.atZ = new Intent("android.speech.action.WEB_SEARCH");
    this.atZ.addFlags(268435456);
    this.atZ.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
    this.aua = new Intent("android.speech.action.RECOGNIZE_SPEECH");
    this.aua.addFlags(268435456);
    this.atP = findViewById(this.atH.getDropDownAnchor());
    if (this.atP != null) {
      this.atP.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          paramAnonymousView = SearchView.this;
          Rect localRect;
          if (paramAnonymousView.atP.getWidth() > 1)
          {
            Resources localResources = paramAnonymousView.getContext().getResources();
            paramAnonymousInt3 = paramAnonymousView.atJ.getPaddingLeft();
            localRect = new Rect();
            boolean bool = bh.d(paramAnonymousView);
            if (!paramAnonymousView.auh) {
              break label149;
            }
            paramAnonymousInt1 = localResources.getDimensionPixelSize(2131165673);
            paramAnonymousInt1 = localResources.getDimensionPixelSize(2131165674) + paramAnonymousInt1;
            paramAnonymousView.atH.getDropDownBackground().getPadding(localRect);
            if (!bool) {
              break label154;
            }
          }
          label149:
          label154:
          for (paramAnonymousInt2 = -localRect.left;; paramAnonymousInt2 = paramAnonymousInt3 - (localRect.left + paramAnonymousInt1))
          {
            paramAnonymousView.atH.setDropDownHorizontalOffset(paramAnonymousInt2);
            paramAnonymousInt2 = paramAnonymousView.atP.getWidth();
            paramAnonymousInt4 = localRect.left;
            paramAnonymousInt5 = localRect.right;
            paramAnonymousView.atH.setDropDownWidth(paramAnonymousInt1 + (paramAnonymousInt2 + paramAnonymousInt4 + paramAnonymousInt5) - paramAnonymousInt3);
            return;
            paramAnonymousInt1 = 0;
            break;
          }
        }
      });
    }
    az(this.auh);
    lT();
  }
  
  private Intent a(Cursor paramCursor)
  {
    try
    {
      localObject3 = au.a(paramCursor, "suggest_intent_action");
      localObject1 = localObject3;
      if (localObject3 != null) {
        break label188;
      }
      localObject1 = this.aut.getSuggestIntentAction();
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
        label188:
        do
        {
          localObject3 = localRuntimeException;
          break;
        } while (localRuntimeException != null);
        Object localObject3 = "android.intent.action.SEARCH";
        continue;
        label200:
        if (localObject4 == null) {
          Object localObject2 = null;
        }
      }
    }
    localObject4 = au.a(paramCursor, "suggest_intent_data");
    localObject1 = localObject4;
    if (localObject4 == null) {
      localObject1 = this.aut.getSuggestIntentData();
    }
    localObject4 = localObject1;
    if (localObject1 != null)
    {
      str = au.a(paramCursor, "suggest_intent_data_id");
      localObject4 = localObject1;
      if (str != null)
      {
        localObject4 = (String)localObject1 + "/" + Uri.encode(str);
        break label200;
        for (;;)
        {
          localObject4 = au.a(paramCursor, "suggest_intent_query");
          return a((String)localObject3, (Uri)localObject1, au.a(paramCursor, "suggest_intent_extra_data"), (String)localObject4);
          localObject1 = Uri.parse((String)localObject4);
        }
      }
    }
  }
  
  private Intent a(String paramString1, Uri paramUri, String paramString2, String paramString3)
  {
    paramString1 = new Intent(paramString1);
    paramString1.addFlags(268435456);
    if (paramUri != null) {
      paramString1.setData(paramUri);
    }
    paramString1.putExtra("user_query", this.auq);
    if (paramString3 != null) {
      paramString1.putExtra("query", paramString3);
    }
    if (paramString2 != null) {
      paramString1.putExtra("intent_extra_data_key", paramString2);
    }
    if (this.auu != null) {
      paramString1.putExtra("app_data", this.auu);
    }
    paramString1.setComponent(this.aut.getSearchActivity());
    return paramString1;
  }
  
  private void aA(boolean paramBoolean)
  {
    int j = 8;
    int i = j;
    if (this.auk)
    {
      i = j;
      if (lO())
      {
        i = j;
        if (hasFocus()) {
          if (!paramBoolean)
          {
            i = j;
            if (this.auo) {}
          }
          else
          {
            i = 0;
          }
        }
      }
    }
    this.atM.setVisibility(i);
  }
  
  private void aB(boolean paramBoolean)
  {
    int i;
    if ((this.auo) && (!this.aui) && (paramBoolean))
    {
      i = 0;
      this.atM.setVisibility(8);
    }
    for (;;)
    {
      this.atO.setVisibility(i);
      return;
      i = 8;
    }
  }
  
  static boolean ab(Context paramContext)
  {
    return paramContext.getResources().getConfiguration().orientation == 2;
  }
  
  private void az(boolean paramBoolean)
  {
    boolean bool2 = true;
    int j = 8;
    this.aui = paramBoolean;
    int i;
    boolean bool1;
    if (paramBoolean)
    {
      i = 0;
      if (TextUtils.isEmpty(this.atH.getText())) {
        break label123;
      }
      bool1 = true;
      label33:
      this.atL.setVisibility(i);
      aA(bool1);
      View localView = this.atI;
      if (!paramBoolean) {
        break label129;
      }
      i = 8;
      label60:
      localView.setVisibility(i);
      i = j;
      if (this.atV.getDrawable() != null)
      {
        if (!this.auh) {
          break label134;
        }
        i = j;
      }
      label87:
      this.atV.setVisibility(i);
      lQ();
      if (bool1) {
        break label139;
      }
    }
    label129:
    label134:
    label139:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      aB(paramBoolean);
      lP();
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
  
  private void c(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    try
    {
      Context localContext = getContext();
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().ba(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(localContext, locala.aeD(), "android/support/v7/widget/SearchView", "launchIntent", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localContext.startActivity((Intent)locala.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(localContext, "android/support/v7/widget/SearchView", "launchIntent", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      new StringBuilder("Failed launch activity: ").append(paramIntent);
    }
  }
  
  private boolean cD(int paramInt)
  {
    Cursor localCursor = this.auj.getCursor();
    if ((localCursor != null) && (localCursor.moveToPosition(paramInt)))
    {
      c(a(localCursor));
      return true;
    }
    return false;
  }
  
  private int getPreferredHeight()
  {
    return getContext().getResources().getDimensionPixelSize(2131165683);
  }
  
  private int getPreferredWidth()
  {
    return getContext().getResources().getDimensionPixelSize(2131165684);
  }
  
  private boolean lO()
  {
    return ((this.auk) || (this.auo)) && (!this.aui);
  }
  
  private void lP()
  {
    int j = 8;
    int i = j;
    if (lO()) {
      if (this.atM.getVisibility() != 0)
      {
        i = j;
        if (this.atO.getVisibility() != 0) {}
      }
      else
      {
        i = 0;
      }
    }
    this.atK.setVisibility(i);
  }
  
  private void lQ()
  {
    int m = 1;
    int k = 0;
    int i;
    int j;
    label44:
    label56:
    Drawable localDrawable;
    if (!TextUtils.isEmpty(this.atH.getText()))
    {
      i = 1;
      j = m;
      if (i == 0)
      {
        if ((!this.auh) || (this.aur)) {
          break label99;
        }
        j = m;
      }
      localObject = this.atN;
      if (j == 0) {
        break label104;
      }
      j = k;
      ((ImageView)localObject).setVisibility(j);
      localDrawable = this.atN.getDrawable();
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
  
  private void lR()
  {
    post(this.auw);
  }
  
  private void lT()
  {
    CharSequence localCharSequence = getQueryHint();
    SearchAutoComplete localSearchAutoComplete = this.atH;
    Object localObject = localCharSequence;
    if (localCharSequence == null) {
      localObject = "";
    }
    localSearchAutoComplete.setHint(o((CharSequence)localObject));
  }
  
  private CharSequence o(CharSequence paramCharSequence)
  {
    if ((!this.auh) || (this.atW == null)) {
      return paramCharSequence;
    }
    int i = (int)(this.atH.getTextSize() * 1.25D);
    this.atW.setBounds(0, 0, i, i);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder("   ");
    localSpannableStringBuilder.setSpan(new ImageSpan(this.atW), 1, 2, 33);
    localSpannableStringBuilder.append(paramCharSequence);
    return localSpannableStringBuilder;
  }
  
  final void H(String paramString)
  {
    Object localObject = a("android.intent.action.SEARCH", null, null, paramString);
    paramString = getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "android/support/v7/widget/SearchView", "launchQuerySearch", "(ILjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramString, "android/support/v7/widget/SearchView", "launchQuerySearch", "(ILjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
  }
  
  final boolean b(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.aut == null) {}
    do
    {
      do
      {
        return false;
      } while ((this.auj == null) || (paramKeyEvent.getAction() != 0) || (!paramKeyEvent.hasNoModifiers()));
      if ((paramInt == 66) || (paramInt == 84) || (paramInt == 61)) {
        return cC(this.atH.getListSelection());
      }
      if ((paramInt == 21) || (paramInt == 22))
      {
        if (paramInt == 21) {}
        for (paramInt = 0;; paramInt = this.atH.length())
        {
          this.atH.setSelection(paramInt);
          this.atH.setListSelection(0);
          this.atH.clearListSelection();
          auv.c(this.atH);
          return true;
        }
      }
    } while ((paramInt != 19) || (this.atH.getListSelection() != 0));
    return false;
  }
  
  final boolean cC(int paramInt)
  {
    boolean bool = false;
    if ((this.auf == null) || (!this.auf.mb()))
    {
      cD(paramInt);
      this.atH.setImeVisibility(false);
      this.atH.dismissDropDown();
      bool = true;
    }
    return bool;
  }
  
  public void clearFocus()
  {
    this.aun = true;
    super.clearFocus();
    this.atH.clearFocus();
    this.atH.setImeVisibility(false);
    this.aun = false;
  }
  
  public int getImeOptions()
  {
    return this.atH.getImeOptions();
  }
  
  public int getInputType()
  {
    return this.atH.getInputType();
  }
  
  public int getMaxWidth()
  {
    return this.mMaxWidth;
  }
  
  public CharSequence getQuery()
  {
    return this.atH.getText();
  }
  
  public CharSequence getQueryHint()
  {
    if (this.aul != null) {
      return this.aul;
    }
    if ((this.aut != null) && (this.aut.getHintId() != 0)) {
      return getContext().getText(this.aut.getHintId());
    }
    return this.aub;
  }
  
  int getSuggestionCommitIconResId()
  {
    return this.atY;
  }
  
  int getSuggestionRowLayout()
  {
    return this.atX;
  }
  
  public f getSuggestionsAdapter()
  {
    return this.auj;
  }
  
  final void lS()
  {
    if (this.atH.hasFocus()) {}
    for (int[] arrayOfInt = FOCUSED_STATE_SET;; arrayOfInt = EMPTY_STATE_SET)
    {
      Drawable localDrawable = this.atJ.getBackground();
      if (localDrawable != null) {
        localDrawable.setState(arrayOfInt);
      }
      localDrawable = this.atK.getBackground();
      if (localDrawable != null) {
        localDrawable.setState(arrayOfInt);
      }
      invalidate();
      return;
    }
  }
  
  final void lU()
  {
    Editable localEditable = this.atH.getText();
    if ((localEditable != null) && (TextUtils.getTrimmedLength(localEditable) > 0)) {
      if (this.auc != null)
      {
        c localc = this.auc;
        localEditable.toString();
        if (localc.lZ()) {}
      }
      else
      {
        if (this.aut != null) {
          H(localEditable.toString());
        }
        this.atH.setImeVisibility(false);
        this.atH.dismissDropDown();
      }
    }
  }
  
  final void lV()
  {
    if (TextUtils.isEmpty(this.atH.getText()))
    {
      if ((this.auh) && ((this.aud == null) || (!this.aud.onClose())))
      {
        clearFocus();
        az(true);
      }
      return;
    }
    this.atH.setText("");
    this.atH.requestFocus();
    this.atH.setImeVisibility(true);
  }
  
  final void lW()
  {
    az(false);
    this.atH.requestFocus();
    this.atH.setImeVisibility(true);
    if (this.aug != null) {
      this.aug.onClick(this);
    }
  }
  
  final void lX()
  {
    az(this.aui);
    lR();
    if (this.atH.hasFocus()) {
      lY();
    }
  }
  
  final void lY()
  {
    auv.a(this.atH);
    auv.b(this.atH);
  }
  
  public final void onActionViewCollapsed()
  {
    this.atH.setText("");
    this.atH.setSelection(this.atH.length());
    this.auq = "";
    clearFocus();
    az(true);
    this.atH.setImeOptions(this.aus);
    this.aur = false;
  }
  
  public final void onActionViewExpanded()
  {
    if (this.aur) {
      return;
    }
    this.aur = true;
    this.aus = this.atH.getImeOptions();
    this.atH.setImeOptions(this.aus | 0x2000000);
    this.atH.setText("");
    setIconified(false);
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.auw);
    post(this.aux);
    super.onDetachedFromWindow();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      SearchAutoComplete localSearchAutoComplete = this.atH;
      Rect localRect = this.atR;
      localSearchAutoComplete.getLocationInWindow(this.atT);
      getLocationInWindow(this.atU);
      paramInt1 = this.atT[1] - this.atU[1];
      paramInt3 = this.atT[0] - this.atU[0];
      localRect.set(paramInt3, paramInt1, localSearchAutoComplete.getWidth() + paramInt3, localSearchAutoComplete.getHeight() + paramInt1);
      this.atS.set(this.atR.left, 0, this.atR.right, paramInt4 - paramInt2);
      if (this.atQ == null)
      {
        this.atQ = new SearchView.e(this.atS, this.atR, this.atH);
        setTouchDelegate(this.atQ);
      }
    }
    else
    {
      return;
    }
    this.atQ.a(this.atS, this.atR);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.aui)
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
    super.onRestoreInstanceState(paramParcelable.Nj);
    az(paramParcelable.auH);
    requestLayout();
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.auH = this.aui;
    return localSavedState;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    lR();
  }
  
  final void p(CharSequence paramCharSequence)
  {
    boolean bool2 = true;
    Editable localEditable = this.atH.getText();
    this.auq = localEditable;
    if (!TextUtils.isEmpty(localEditable))
    {
      bool1 = true;
      aA(bool1);
      if (bool1) {
        break label92;
      }
    }
    label92:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      aB(bool1);
      lQ();
      lP();
      if ((this.auc != null) && (!TextUtils.equals(paramCharSequence, this.aup))) {
        paramCharSequence.toString();
      }
      this.aup = paramCharSequence.toString();
      return;
      bool1 = false;
      break;
    }
  }
  
  public boolean requestFocus(int paramInt, Rect paramRect)
  {
    if (this.aun) {}
    while (!isFocusable()) {
      return false;
    }
    if (!this.aui)
    {
      boolean bool = this.atH.requestFocus(paramInt, paramRect);
      if (bool) {
        az(false);
      }
      return bool;
    }
    return super.requestFocus(paramInt, paramRect);
  }
  
  public void setAppSearchData(Bundle paramBundle)
  {
    this.auu = paramBundle;
  }
  
  public void setIconified(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      lV();
      return;
    }
    lW();
  }
  
  public void setIconifiedByDefault(boolean paramBoolean)
  {
    if (this.auh == paramBoolean) {
      return;
    }
    this.auh = paramBoolean;
    az(paramBoolean);
    lT();
  }
  
  public void setImeOptions(int paramInt)
  {
    this.atH.setImeOptions(paramInt);
  }
  
  public void setInputType(int paramInt)
  {
    this.atH.setInputType(paramInt);
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.mMaxWidth = paramInt;
    requestLayout();
  }
  
  public void setOnCloseListener(b paramb)
  {
    this.aud = paramb;
  }
  
  public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.aue = paramOnFocusChangeListener;
  }
  
  public void setOnQueryTextListener(c paramc)
  {
    this.auc = paramc;
  }
  
  public void setOnSearchClickListener(View.OnClickListener paramOnClickListener)
  {
    this.aug = paramOnClickListener;
  }
  
  public void setOnSuggestionListener(SearchView.d paramd)
  {
    this.auf = paramd;
  }
  
  void setQuery(CharSequence paramCharSequence)
  {
    this.atH.setText(paramCharSequence);
    SearchAutoComplete localSearchAutoComplete = this.atH;
    if (TextUtils.isEmpty(paramCharSequence)) {}
    for (int i = 0;; i = paramCharSequence.length())
    {
      localSearchAutoComplete.setSelection(i);
      return;
    }
  }
  
  public void setQueryHint(CharSequence paramCharSequence)
  {
    this.aul = paramCharSequence;
    lT();
  }
  
  public void setQueryRefinementEnabled(boolean paramBoolean)
  {
    this.aum = paramBoolean;
    au localau;
    if ((this.auj instanceof au))
    {
      localau = (au)this.auj;
      if (!paramBoolean) {
        break label35;
      }
    }
    label35:
    for (int i = 2;; i = 1)
    {
      localau.avI = i;
      return;
    }
  }
  
  public void setSearchableInfo(SearchableInfo paramSearchableInfo)
  {
    boolean bool = true;
    this.aut = paramSearchableInfo;
    int i;
    if (this.aut != null)
    {
      this.atH.setThreshold(this.aut.getSuggestThreshold());
      this.atH.setImeOptions(this.aut.getImeOptions());
      int j = this.aut.getInputType();
      i = j;
      if ((j & 0xF) == 1)
      {
        j &= 0xFFFEFFFF;
        i = j;
        if (this.aut.getSuggestAuthority() != null) {
          i = j | 0x10000 | 0x80000;
        }
      }
      this.atH.setInputType(i);
      if (this.auj != null) {
        this.auj.changeCursor(null);
      }
      if (this.aut.getSuggestAuthority() != null)
      {
        this.auj = new au(getContext(), this, this.aut, this.auy);
        this.atH.setAdapter(this.auj);
        paramSearchableInfo = (au)this.auj;
        if (this.aum)
        {
          i = 2;
          paramSearchableInfo.avI = i;
        }
      }
      else
      {
        lT();
      }
    }
    else
    {
      if ((this.aut == null) || (!this.aut.getVoiceSearchEnabled())) {
        break label297;
      }
      if (!this.aut.getVoiceSearchLaunchWebSearch()) {
        break label273;
      }
      paramSearchableInfo = this.atZ;
    }
    for (;;)
    {
      label215:
      if (paramSearchableInfo != null) {
        if (getContext().getPackageManager().resolveActivity(paramSearchableInfo, 65536) == null) {}
      }
      for (;;)
      {
        this.auo = bool;
        if (this.auo) {
          this.atH.setPrivateImeOptions("nm");
        }
        az(this.aui);
        return;
        i = 1;
        break;
        label273:
        if (!this.aut.getVoiceSearchLaunchRecognizer()) {
          break label303;
        }
        paramSearchableInfo = this.aua;
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
    this.auk = paramBoolean;
    az(this.aui);
  }
  
  public void setSuggestionsAdapter(f paramf)
  {
    this.auj = paramf;
    this.atH.setAdapter(this.auj);
  }
  
  static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator() {};
    boolean auH;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.auH = ((Boolean)paramParcel.readValue(null)).booleanValue();
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.auH + "}";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeValue(Boolean.valueOf(this.auH));
    }
  }
  
  public static class SearchAutoComplete
    extends AppCompatAutoCompleteTextView
  {
    private SearchView auI;
    boolean auJ;
    final Runnable auK = new Runnable()
    {
      public final void run()
      {
        SearchView.SearchAutoComplete localSearchAutoComplete = SearchView.SearchAutoComplete.this;
        if (localSearchAutoComplete.auJ)
        {
          ((InputMethodManager)localSearchAutoComplete.getContext().getSystemService("input_method")).showSoftInput(localSearchAutoComplete, 0);
          localSearchAutoComplete.auJ = false;
        }
      }
    };
    private int mThreshold = getThreshold();
    
    public SearchAutoComplete(Context paramContext, AttributeSet paramAttributeSet)
    {
      this(paramContext, paramAttributeSet, 2130968660);
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
      if (this.auJ)
      {
        removeCallbacks(this.auK);
        post(this.auK);
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
      this.auI.lX();
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
            this.auI.clearFocus();
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
      if ((paramBoolean) && (this.auI.hasFocus()) && (getVisibility() == 0))
      {
        this.auJ = true;
        if (SearchView.ab(getContext())) {
          SearchView.auv.c(this);
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
        this.auJ = false;
        removeCallbacks(this.auK);
        localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        return;
      }
      if (localInputMethodManager.isActive(this))
      {
        this.auJ = false;
        removeCallbacks(this.auK);
        localInputMethodManager.showSoftInput(this, 0);
        return;
      }
      this.auJ = true;
    }
    
    void setSearchView(SearchView paramSearchView)
    {
      this.auI = paramSearchView;
    }
    
    public void setThreshold(int paramInt)
    {
      super.setThreshold(paramInt);
      this.mThreshold = paramInt;
    }
  }
  
  static final class a
  {
    private Method auE;
    private Method auF;
    private Method auG;
    
    a()
    {
      try
      {
        this.auE = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
        this.auE.setAccessible(true);
        try
        {
          label27:
          this.auF = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
          this.auF.setAccessible(true);
          try
          {
            label50:
            this.auG = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[] { Boolean.TYPE });
            this.auG.setAccessible(true);
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
      if (this.auE != null) {}
      try
      {
        this.auE.invoke(paramAutoCompleteTextView, new Object[0]);
        return;
      }
      catch (Exception paramAutoCompleteTextView) {}
    }
    
    final void b(AutoCompleteTextView paramAutoCompleteTextView)
    {
      if (this.auF != null) {}
      try
      {
        this.auF.invoke(paramAutoCompleteTextView, new Object[0]);
        return;
      }
      catch (Exception paramAutoCompleteTextView) {}
    }
    
    final void c(AutoCompleteTextView paramAutoCompleteTextView)
    {
      if (this.auG != null) {}
      try
      {
        this.auG.invoke(paramAutoCompleteTextView, new Object[] { Boolean.TRUE });
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
    public abstract boolean lZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v7.widget.SearchView
 * JD-Core Version:    0.7.0.1
 */