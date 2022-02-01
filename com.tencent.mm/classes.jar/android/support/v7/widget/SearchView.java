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
  static final a atA = new a();
  private final AdapterView.OnItemSelectedListener Vm = new AdapterView.OnItemSelectedListener()
  {
    public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      paramAnonymousAdapterView = SearchView.this;
      if ((paramAnonymousAdapterView.atk == null) || (!paramAnonymousAdapterView.atk.lR()))
      {
        paramAnonymousView = paramAnonymousAdapterView.asM.getText();
        Object localObject = paramAnonymousAdapterView.ato.getCursor();
        if (localObject != null)
        {
          if (!((Cursor)localObject).moveToPosition(paramAnonymousInt)) {
            break label86;
          }
          localObject = paramAnonymousAdapterView.ato.convertToString((Cursor)localObject);
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
  final SearchAutoComplete asM;
  private final View asN;
  final View asO;
  private final View asP;
  final ImageView asQ;
  final ImageView asR;
  final ImageView asS;
  final ImageView asT;
  final View asU;
  private SearchView.e asV;
  private Rect asW = new Rect();
  private Rect asX = new Rect();
  private int[] asY = new int[2];
  private int[] asZ = new int[2];
  private final Runnable atB = new Runnable()
  {
    public final void run()
    {
      SearchView.this.lJ();
    }
  };
  private Runnable atC = new Runnable()
  {
    public final void run()
    {
      if ((SearchView.this.ato != null) && ((SearchView.this.ato instanceof au))) {
        SearchView.this.ato.changeCursor(null);
      }
    }
  };
  private final WeakHashMap<String, Drawable.ConstantState> atD = new WeakHashMap();
  View.OnKeyListener atE = new View.OnKeyListener()
  {
    public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
    {
      if (SearchView.this.aty == null) {}
      for (;;)
      {
        return false;
        if ((SearchView.this.asM.isPopupShowing()) && (SearchView.this.asM.getListSelection() != -1)) {
          return SearchView.this.b(paramAnonymousInt, paramAnonymousKeyEvent);
        }
        if (TextUtils.getTrimmedLength(SearchView.this.asM.getText()) == 0) {}
        for (int i = 1; (i == 0) && (paramAnonymousKeyEvent.hasNoModifiers()) && (paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousInt == 66); i = 0)
        {
          paramAnonymousView.cancelLongPress();
          SearchView.this.F(SearchView.this.asM.getText().toString());
          return true;
        }
      }
    }
  };
  private final TextView.OnEditorActionListener atF = new TextView.OnEditorActionListener()
  {
    public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
    {
      SearchView.this.lL();
      return true;
    }
  };
  private final AdapterView.OnItemClickListener atG = new AdapterView.OnItemClickListener()
  {
    public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      SearchView.this.cD(paramAnonymousInt);
    }
  };
  private TextWatcher atH = new TextWatcher()
  {
    public final void afterTextChanged(Editable paramAnonymousEditable) {}
    
    public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      SearchView.this.p(paramAnonymousCharSequence);
    }
  };
  private final ImageView ata;
  private final Drawable atb;
  private final int atc;
  private final int atd;
  final Intent ate;
  final Intent atf;
  private final CharSequence atg;
  private c ath;
  private b ati;
  View.OnFocusChangeListener atj;
  d atk;
  private View.OnClickListener atl;
  boolean atm;
  private boolean atn;
  f ato;
  private boolean atp;
  private CharSequence atq;
  private boolean atr;
  private boolean ats;
  private boolean att;
  private CharSequence atu;
  private CharSequence atv;
  private boolean atw;
  private int atx;
  SearchableInfo aty;
  Bundle atz;
  private int mMaxWidth;
  private final View.OnClickListener mOnClickListener = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      Object localObject3 = null;
      Object localObject1 = null;
      if (paramAnonymousView == SearchView.this.asQ) {
        SearchView.this.lN();
      }
      for (;;)
      {
        return;
        if (paramAnonymousView == SearchView.this.asS)
        {
          SearchView.this.lM();
          return;
        }
        if (paramAnonymousView == SearchView.this.asR)
        {
          SearchView.this.lL();
          return;
        }
        SearchView localSearchView;
        SearchableInfo localSearchableInfo;
        if (paramAnonymousView == SearchView.this.asT)
        {
          localSearchView = SearchView.this;
          if (localSearchView.aty == null) {
            continue;
          }
          localSearchableInfo = localSearchView.aty;
        }
        try
        {
          if (localSearchableInfo.getVoiceSearchLaunchWebSearch())
          {
            localObject2 = new Intent(localSearchView.ate);
            paramAnonymousView = localSearchableInfo.getSearchActivity();
            if (paramAnonymousView == null) {}
            for (paramAnonymousView = (View)localObject1;; paramAnonymousView = paramAnonymousView.flattenToShortString())
            {
              ((Intent)localObject2).putExtra("calling_package", paramAnonymousView);
              paramAnonymousView = localSearchView.getContext();
              localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "android/support/v7/widget/SearchView", "onVoiceClicked", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "android/support/v7/widget/SearchView", "onVoiceClicked", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              return;
            }
          }
          if (!localSearchableInfo.getVoiceSearchLaunchRecognizer()) {
            continue;
          }
          paramAnonymousView = localSearchView.atf;
          ComponentName localComponentName = localSearchableInfo.getSearchActivity();
          localObject1 = new Intent("android.intent.action.SEARCH");
          ((Intent)localObject1).setComponent(localComponentName);
          PendingIntent localPendingIntent = PendingIntent.getActivity(localSearchView.getContext(), 0, (Intent)localObject1, 1073741824);
          Bundle localBundle = new Bundle();
          if (localSearchView.atz != null) {
            localBundle.putParcelable("app_data", localSearchView.atz);
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
                  localObject1 = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "android/support/v7/widget/SearchView", "onVoiceClicked", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0));
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "android/support/v7/widget/SearchView", "onVoiceClicked", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  return;
                }
                if (paramAnonymousView != SearchView.this.asM) {
                  break;
                }
                SearchView.this.lP();
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
    this.asM = ((SearchAutoComplete)findViewById(2131304447));
    this.asM.setSearchView(this);
    this.asN = findViewById(2131304414);
    this.asO = findViewById(2131304437);
    this.asP = findViewById(2131305515);
    this.asQ = ((ImageView)findViewById(2131304396));
    this.asR = ((ImageView)findViewById(2131304418));
    this.asS = ((ImageView)findViewById(2131304402));
    this.asT = ((ImageView)findViewById(2131304453));
    this.ata = ((ImageView)findViewById(2131304434));
    t.a(this.asO, paramAttributeSet.getDrawable(10));
    t.a(this.asP, paramAttributeSet.getDrawable(14));
    this.asQ.setImageDrawable(paramAttributeSet.getDrawable(13));
    this.asR.setImageDrawable(paramAttributeSet.getDrawable(7));
    this.asS.setImageDrawable(paramAttributeSet.getDrawable(4));
    this.asT.setImageDrawable(paramAttributeSet.getDrawable(16));
    this.ata.setImageDrawable(paramAttributeSet.getDrawable(13));
    this.atb = paramAttributeSet.getDrawable(12);
    bb.a(this.asQ, getResources().getString(2131755106));
    this.atc = paramAttributeSet.getResourceId(15, 2131492915);
    this.atd = paramAttributeSet.getResourceId(5, 0);
    this.asQ.setOnClickListener(this.mOnClickListener);
    this.asS.setOnClickListener(this.mOnClickListener);
    this.asR.setOnClickListener(this.mOnClickListener);
    this.asT.setOnClickListener(this.mOnClickListener);
    this.asM.setOnClickListener(this.mOnClickListener);
    this.asM.addTextChangedListener(this.atH);
    this.asM.setOnEditorActionListener(this.atF);
    this.asM.setOnItemClickListener(this.atG);
    this.asM.setOnItemSelectedListener(this.Vm);
    this.asM.setOnKeyListener(this.atE);
    this.asM.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (SearchView.this.atj != null) {
          SearchView.this.atj.onFocusChange(SearchView.this, paramAnonymousBoolean);
        }
      }
    });
    setIconifiedByDefault(paramAttributeSet.getBoolean(8, true));
    paramInt = paramAttributeSet.getDimensionPixelSize(1, -1);
    if (paramInt != -1) {
      setMaxWidth(paramInt);
    }
    this.atg = paramAttributeSet.getText(6);
    this.atq = paramAttributeSet.getText(11);
    paramInt = paramAttributeSet.getInt(3, -1);
    if (paramInt != -1) {
      setImeOptions(paramInt);
    }
    paramInt = paramAttributeSet.getInt(2, -1);
    if (paramInt != -1) {
      setInputType(paramInt);
    }
    setFocusable(paramAttributeSet.getBoolean(0, true));
    paramAttributeSet.avP.recycle();
    this.ate = new Intent("android.speech.action.WEB_SEARCH");
    this.ate.addFlags(268435456);
    this.ate.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
    this.atf = new Intent("android.speech.action.RECOGNIZE_SPEECH");
    this.atf.addFlags(268435456);
    this.asU = findViewById(this.asM.getDropDownAnchor());
    if (this.asU != null) {
      this.asU.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          paramAnonymousView = SearchView.this;
          Rect localRect;
          if (paramAnonymousView.asU.getWidth() > 1)
          {
            Resources localResources = paramAnonymousView.getContext().getResources();
            paramAnonymousInt3 = paramAnonymousView.asO.getPaddingLeft();
            localRect = new Rect();
            boolean bool = bh.d(paramAnonymousView);
            if (!paramAnonymousView.atm) {
              break label149;
            }
            paramAnonymousInt1 = localResources.getDimensionPixelSize(2131165673);
            paramAnonymousInt1 = localResources.getDimensionPixelSize(2131165674) + paramAnonymousInt1;
            paramAnonymousView.asM.getDropDownBackground().getPadding(localRect);
            if (!bool) {
              break label154;
            }
          }
          label149:
          label154:
          for (paramAnonymousInt2 = -localRect.left;; paramAnonymousInt2 = paramAnonymousInt3 - (localRect.left + paramAnonymousInt1))
          {
            paramAnonymousView.asM.setDropDownHorizontalOffset(paramAnonymousInt2);
            paramAnonymousInt2 = paramAnonymousView.asU.getWidth();
            paramAnonymousInt4 = localRect.left;
            paramAnonymousInt5 = localRect.right;
            paramAnonymousView.asM.setDropDownWidth(paramAnonymousInt1 + (paramAnonymousInt2 + paramAnonymousInt4 + paramAnonymousInt5) - paramAnonymousInt3);
            return;
            paramAnonymousInt1 = 0;
            break;
          }
        }
      });
    }
    az(this.atm);
    lK();
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
      localObject1 = this.aty.getSuggestIntentAction();
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
      localObject1 = this.aty.getSuggestIntentData();
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
    paramString1.putExtra("user_query", this.atv);
    if (paramString3 != null) {
      paramString1.putExtra("query", paramString3);
    }
    if (paramString2 != null) {
      paramString1.putExtra("intent_extra_data_key", paramString2);
    }
    if (this.atz != null) {
      paramString1.putExtra("app_data", this.atz);
    }
    paramString1.setComponent(this.aty.getSearchActivity());
    return paramString1;
  }
  
  private void aA(boolean paramBoolean)
  {
    int j = 8;
    int i = j;
    if (this.atp)
    {
      i = j;
      if (lF())
      {
        i = j;
        if (hasFocus()) {
          if (!paramBoolean)
          {
            i = j;
            if (this.att) {}
          }
          else
          {
            i = 0;
          }
        }
      }
    }
    this.asR.setVisibility(i);
  }
  
  private void aB(boolean paramBoolean)
  {
    int i;
    if ((this.att) && (!this.atn) && (paramBoolean))
    {
      i = 0;
      this.asR.setVisibility(8);
    }
    for (;;)
    {
      this.asT.setVisibility(i);
      return;
      i = 8;
    }
  }
  
  static boolean aa(Context paramContext)
  {
    return paramContext.getResources().getConfiguration().orientation == 2;
  }
  
  private void az(boolean paramBoolean)
  {
    boolean bool2 = true;
    int j = 8;
    this.atn = paramBoolean;
    int i;
    boolean bool1;
    if (paramBoolean)
    {
      i = 0;
      if (TextUtils.isEmpty(this.asM.getText())) {
        break label123;
      }
      bool1 = true;
      label33:
      this.asQ.setVisibility(i);
      aA(bool1);
      View localView = this.asN;
      if (!paramBoolean) {
        break label129;
      }
      i = 8;
      label60:
      localView.setVisibility(i);
      i = j;
      if (this.ata.getDrawable() != null)
      {
        if (!this.atm) {
          break label134;
        }
        i = j;
      }
      label87:
      this.ata.setVisibility(i);
      lH();
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
      lG();
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
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bd(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(localContext, locala.adn(), "android/support/v7/widget/SearchView", "launchIntent", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localContext.startActivity((Intent)locala.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(localContext, "android/support/v7/widget/SearchView", "launchIntent", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      new StringBuilder("Failed launch activity: ").append(paramIntent);
    }
  }
  
  private boolean cE(int paramInt)
  {
    Cursor localCursor = this.ato.getCursor();
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
  
  private boolean lF()
  {
    return ((this.atp) || (this.att)) && (!this.atn);
  }
  
  private void lG()
  {
    int j = 8;
    int i = j;
    if (lF()) {
      if (this.asR.getVisibility() != 0)
      {
        i = j;
        if (this.asT.getVisibility() != 0) {}
      }
      else
      {
        i = 0;
      }
    }
    this.asP.setVisibility(i);
  }
  
  private void lH()
  {
    int m = 1;
    int k = 0;
    int i;
    int j;
    label44:
    label56:
    Drawable localDrawable;
    if (!TextUtils.isEmpty(this.asM.getText()))
    {
      i = 1;
      j = m;
      if (i == 0)
      {
        if ((!this.atm) || (this.atw)) {
          break label99;
        }
        j = m;
      }
      localObject = this.asS;
      if (j == 0) {
        break label104;
      }
      j = k;
      ((ImageView)localObject).setVisibility(j);
      localDrawable = this.asS.getDrawable();
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
  
  private void lI()
  {
    post(this.atB);
  }
  
  private void lK()
  {
    CharSequence localCharSequence = getQueryHint();
    SearchAutoComplete localSearchAutoComplete = this.asM;
    Object localObject = localCharSequence;
    if (localCharSequence == null) {
      localObject = "";
    }
    localSearchAutoComplete.setHint(o((CharSequence)localObject));
  }
  
  private CharSequence o(CharSequence paramCharSequence)
  {
    if ((!this.atm) || (this.atb == null)) {
      return paramCharSequence;
    }
    int i = (int)(this.asM.getTextSize() * 1.25D);
    this.atb.setBounds(0, 0, i, i);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder("   ");
    localSpannableStringBuilder.setSpan(new ImageSpan(this.atb), 1, 2, 33);
    localSpannableStringBuilder.append(paramCharSequence);
    return localSpannableStringBuilder;
  }
  
  final void F(String paramString)
  {
    Object localObject = a("android.intent.action.SEARCH", null, null, paramString);
    paramString = getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "android/support/v7/widget/SearchView", "launchQuerySearch", "(ILjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramString, "android/support/v7/widget/SearchView", "launchQuerySearch", "(ILjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
  }
  
  final boolean b(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.aty == null) {}
    do
    {
      do
      {
        return false;
      } while ((this.ato == null) || (paramKeyEvent.getAction() != 0) || (!paramKeyEvent.hasNoModifiers()));
      if ((paramInt == 66) || (paramInt == 84) || (paramInt == 61)) {
        return cD(this.asM.getListSelection());
      }
      if ((paramInt == 21) || (paramInt == 22))
      {
        if (paramInt == 21) {}
        for (paramInt = 0;; paramInt = this.asM.length())
        {
          this.asM.setSelection(paramInt);
          this.asM.setListSelection(0);
          this.asM.clearListSelection();
          atA.c(this.asM);
          return true;
        }
      }
    } while ((paramInt != 19) || (this.asM.getListSelection() != 0));
    return false;
  }
  
  final boolean cD(int paramInt)
  {
    boolean bool = false;
    if ((this.atk == null) || (!this.atk.lS()))
    {
      cE(paramInt);
      this.asM.setImeVisibility(false);
      this.asM.dismissDropDown();
      bool = true;
    }
    return bool;
  }
  
  public void clearFocus()
  {
    this.ats = true;
    super.clearFocus();
    this.asM.clearFocus();
    this.asM.setImeVisibility(false);
    this.ats = false;
  }
  
  public int getImeOptions()
  {
    return this.asM.getImeOptions();
  }
  
  public int getInputType()
  {
    return this.asM.getInputType();
  }
  
  public int getMaxWidth()
  {
    return this.mMaxWidth;
  }
  
  public CharSequence getQuery()
  {
    return this.asM.getText();
  }
  
  public CharSequence getQueryHint()
  {
    if (this.atq != null) {
      return this.atq;
    }
    if ((this.aty != null) && (this.aty.getHintId() != 0)) {
      return getContext().getText(this.aty.getHintId());
    }
    return this.atg;
  }
  
  int getSuggestionCommitIconResId()
  {
    return this.atd;
  }
  
  int getSuggestionRowLayout()
  {
    return this.atc;
  }
  
  public f getSuggestionsAdapter()
  {
    return this.ato;
  }
  
  final void lJ()
  {
    if (this.asM.hasFocus()) {}
    for (int[] arrayOfInt = FOCUSED_STATE_SET;; arrayOfInt = EMPTY_STATE_SET)
    {
      Drawable localDrawable = this.asO.getBackground();
      if (localDrawable != null) {
        localDrawable.setState(arrayOfInt);
      }
      localDrawable = this.asP.getBackground();
      if (localDrawable != null) {
        localDrawable.setState(arrayOfInt);
      }
      invalidate();
      return;
    }
  }
  
  final void lL()
  {
    Editable localEditable = this.asM.getText();
    if ((localEditable != null) && (TextUtils.getTrimmedLength(localEditable) > 0)) {
      if (this.ath != null)
      {
        c localc = this.ath;
        localEditable.toString();
        if (localc.lQ()) {}
      }
      else
      {
        if (this.aty != null) {
          F(localEditable.toString());
        }
        this.asM.setImeVisibility(false);
        this.asM.dismissDropDown();
      }
    }
  }
  
  final void lM()
  {
    if (TextUtils.isEmpty(this.asM.getText()))
    {
      if ((this.atm) && ((this.ati == null) || (!this.ati.onClose())))
      {
        clearFocus();
        az(true);
      }
      return;
    }
    this.asM.setText("");
    this.asM.requestFocus();
    this.asM.setImeVisibility(true);
  }
  
  final void lN()
  {
    az(false);
    this.asM.requestFocus();
    this.asM.setImeVisibility(true);
    if (this.atl != null) {
      this.atl.onClick(this);
    }
  }
  
  final void lO()
  {
    az(this.atn);
    lI();
    if (this.asM.hasFocus()) {
      lP();
    }
  }
  
  final void lP()
  {
    atA.a(this.asM);
    atA.b(this.asM);
  }
  
  public final void onActionViewCollapsed()
  {
    this.asM.setText("");
    this.asM.setSelection(this.asM.length());
    this.atv = "";
    clearFocus();
    az(true);
    this.asM.setImeOptions(this.atx);
    this.atw = false;
  }
  
  public final void onActionViewExpanded()
  {
    if (this.atw) {
      return;
    }
    this.atw = true;
    this.atx = this.asM.getImeOptions();
    this.asM.setImeOptions(this.atx | 0x2000000);
    this.asM.setText("");
    setIconified(false);
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.atB);
    post(this.atC);
    super.onDetachedFromWindow();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      SearchAutoComplete localSearchAutoComplete = this.asM;
      Rect localRect = this.asW;
      localSearchAutoComplete.getLocationInWindow(this.asY);
      getLocationInWindow(this.asZ);
      paramInt1 = this.asY[1] - this.asZ[1];
      paramInt3 = this.asY[0] - this.asZ[0];
      localRect.set(paramInt3, paramInt1, localSearchAutoComplete.getWidth() + paramInt3, localSearchAutoComplete.getHeight() + paramInt1);
      this.asX.set(this.asW.left, 0, this.asW.right, paramInt4 - paramInt2);
      if (this.asV == null)
      {
        this.asV = new SearchView.e(this.asX, this.asW, this.asM);
        setTouchDelegate(this.asV);
      }
    }
    else
    {
      return;
    }
    this.asV.a(this.asX, this.asW);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.atn)
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
    super.onRestoreInstanceState(paramParcelable.Mm);
    az(paramParcelable.atM);
    requestLayout();
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.atM = this.atn;
    return localSavedState;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    lI();
  }
  
  final void p(CharSequence paramCharSequence)
  {
    boolean bool2 = true;
    Editable localEditable = this.asM.getText();
    this.atv = localEditable;
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
      lH();
      lG();
      if ((this.ath != null) && (!TextUtils.equals(paramCharSequence, this.atu))) {
        paramCharSequence.toString();
      }
      this.atu = paramCharSequence.toString();
      return;
      bool1 = false;
      break;
    }
  }
  
  public boolean requestFocus(int paramInt, Rect paramRect)
  {
    if (this.ats) {}
    while (!isFocusable()) {
      return false;
    }
    if (!this.atn)
    {
      boolean bool = this.asM.requestFocus(paramInt, paramRect);
      if (bool) {
        az(false);
      }
      return bool;
    }
    return super.requestFocus(paramInt, paramRect);
  }
  
  public void setAppSearchData(Bundle paramBundle)
  {
    this.atz = paramBundle;
  }
  
  public void setIconified(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      lM();
      return;
    }
    lN();
  }
  
  public void setIconifiedByDefault(boolean paramBoolean)
  {
    if (this.atm == paramBoolean) {
      return;
    }
    this.atm = paramBoolean;
    az(paramBoolean);
    lK();
  }
  
  public void setImeOptions(int paramInt)
  {
    this.asM.setImeOptions(paramInt);
  }
  
  public void setInputType(int paramInt)
  {
    this.asM.setInputType(paramInt);
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.mMaxWidth = paramInt;
    requestLayout();
  }
  
  public void setOnCloseListener(b paramb)
  {
    this.ati = paramb;
  }
  
  public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.atj = paramOnFocusChangeListener;
  }
  
  public void setOnQueryTextListener(c paramc)
  {
    this.ath = paramc;
  }
  
  public void setOnSearchClickListener(View.OnClickListener paramOnClickListener)
  {
    this.atl = paramOnClickListener;
  }
  
  public void setOnSuggestionListener(d paramd)
  {
    this.atk = paramd;
  }
  
  void setQuery(CharSequence paramCharSequence)
  {
    this.asM.setText(paramCharSequence);
    SearchAutoComplete localSearchAutoComplete = this.asM;
    if (TextUtils.isEmpty(paramCharSequence)) {}
    for (int i = 0;; i = paramCharSequence.length())
    {
      localSearchAutoComplete.setSelection(i);
      return;
    }
  }
  
  public void setQueryHint(CharSequence paramCharSequence)
  {
    this.atq = paramCharSequence;
    lK();
  }
  
  public void setQueryRefinementEnabled(boolean paramBoolean)
  {
    this.atr = paramBoolean;
    au localau;
    if ((this.ato instanceof au))
    {
      localau = (au)this.ato;
      if (!paramBoolean) {
        break label35;
      }
    }
    label35:
    for (int i = 2;; i = 1)
    {
      localau.auM = i;
      return;
    }
  }
  
  public void setSearchableInfo(SearchableInfo paramSearchableInfo)
  {
    boolean bool = true;
    this.aty = paramSearchableInfo;
    int i;
    if (this.aty != null)
    {
      this.asM.setThreshold(this.aty.getSuggestThreshold());
      this.asM.setImeOptions(this.aty.getImeOptions());
      int j = this.aty.getInputType();
      i = j;
      if ((j & 0xF) == 1)
      {
        j &= 0xFFFEFFFF;
        i = j;
        if (this.aty.getSuggestAuthority() != null) {
          i = j | 0x10000 | 0x80000;
        }
      }
      this.asM.setInputType(i);
      if (this.ato != null) {
        this.ato.changeCursor(null);
      }
      if (this.aty.getSuggestAuthority() != null)
      {
        this.ato = new au(getContext(), this, this.aty, this.atD);
        this.asM.setAdapter(this.ato);
        paramSearchableInfo = (au)this.ato;
        if (this.atr)
        {
          i = 2;
          paramSearchableInfo.auM = i;
        }
      }
      else
      {
        lK();
      }
    }
    else
    {
      if ((this.aty == null) || (!this.aty.getVoiceSearchEnabled())) {
        break label297;
      }
      if (!this.aty.getVoiceSearchLaunchWebSearch()) {
        break label273;
      }
      paramSearchableInfo = this.ate;
    }
    for (;;)
    {
      label215:
      if (paramSearchableInfo != null) {
        if (getContext().getPackageManager().resolveActivity(paramSearchableInfo, 65536) == null) {}
      }
      for (;;)
      {
        this.att = bool;
        if (this.att) {
          this.asM.setPrivateImeOptions("nm");
        }
        az(this.atn);
        return;
        i = 1;
        break;
        label273:
        if (!this.aty.getVoiceSearchLaunchRecognizer()) {
          break label303;
        }
        paramSearchableInfo = this.atf;
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
    this.atp = paramBoolean;
    az(this.atn);
  }
  
  public void setSuggestionsAdapter(f paramf)
  {
    this.ato = paramf;
    this.asM.setAdapter(this.ato);
  }
  
  static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator() {};
    boolean atM;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.atM = ((Boolean)paramParcel.readValue(null)).booleanValue();
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.atM + "}";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeValue(Boolean.valueOf(this.atM));
    }
  }
  
  public static class SearchAutoComplete
    extends AppCompatAutoCompleteTextView
  {
    private SearchView atN;
    boolean atO;
    final Runnable atP = new Runnable()
    {
      public final void run()
      {
        SearchView.SearchAutoComplete localSearchAutoComplete = SearchView.SearchAutoComplete.this;
        if (localSearchAutoComplete.atO)
        {
          ((InputMethodManager)localSearchAutoComplete.getContext().getSystemService("input_method")).showSoftInput(localSearchAutoComplete, 0);
          localSearchAutoComplete.atO = false;
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
      if (this.atO)
      {
        removeCallbacks(this.atP);
        post(this.atP);
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
      this.atN.lO();
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
            this.atN.clearFocus();
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
      if ((paramBoolean) && (this.atN.hasFocus()) && (getVisibility() == 0))
      {
        this.atO = true;
        if (SearchView.aa(getContext())) {
          SearchView.atA.c(this);
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
        this.atO = false;
        removeCallbacks(this.atP);
        localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        return;
      }
      if (localInputMethodManager.isActive(this))
      {
        this.atO = false;
        removeCallbacks(this.atP);
        localInputMethodManager.showSoftInput(this, 0);
        return;
      }
      this.atO = true;
    }
    
    void setSearchView(SearchView paramSearchView)
    {
      this.atN = paramSearchView;
    }
    
    public void setThreshold(int paramInt)
    {
      super.setThreshold(paramInt);
      this.mThreshold = paramInt;
    }
  }
  
  static final class a
  {
    private Method atJ;
    private Method atK;
    private Method atL;
    
    a()
    {
      try
      {
        this.atJ = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
        this.atJ.setAccessible(true);
        try
        {
          label27:
          this.atK = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
          this.atK.setAccessible(true);
          try
          {
            label50:
            this.atL = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[] { Boolean.TYPE });
            this.atL.setAccessible(true);
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
      if (this.atJ != null) {}
      try
      {
        this.atJ.invoke(paramAutoCompleteTextView, new Object[0]);
        return;
      }
      catch (Exception paramAutoCompleteTextView) {}
    }
    
    final void b(AutoCompleteTextView paramAutoCompleteTextView)
    {
      if (this.atK != null) {}
      try
      {
        this.atK.invoke(paramAutoCompleteTextView, new Object[0]);
        return;
      }
      catch (Exception paramAutoCompleteTextView) {}
    }
    
    final void c(AutoCompleteTextView paramAutoCompleteTextView)
    {
      if (this.atL != null) {}
      try
      {
        this.atL.invoke(paramAutoCompleteTextView, new Object[] { Boolean.TRUE });
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
    public abstract boolean lQ();
  }
  
  public static abstract interface d
  {
    public abstract boolean lR();
    
    public abstract boolean lS();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.widget.SearchView
 * JD-Core Version:    0.7.0.1
 */