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
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewConfiguration;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import java.util.WeakHashMap;

public class SearchView
  extends LinearLayoutCompat
  implements c
{
  static final SearchView.a awn = new SearchView.a();
  private final AdapterView.OnItemSelectedListener XW = new AdapterView.OnItemSelectedListener()
  {
    public final void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      paramAnonymousAdapterView = SearchView.this;
      if ((paramAnonymousAdapterView.avX == null) || (!paramAnonymousAdapterView.avX.ms()))
      {
        paramAnonymousView = paramAnonymousAdapterView.avz.getText();
        Object localObject = paramAnonymousAdapterView.awb.getCursor();
        if (localObject != null)
        {
          if (!((Cursor)localObject).moveToPosition(paramAnonymousInt)) {
            break label86;
          }
          localObject = paramAnonymousAdapterView.awb.convertToString((Cursor)localObject);
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
  final View avB;
  private final View avC;
  final ImageView avD;
  final ImageView avE;
  final ImageView avF;
  final ImageView avG;
  final View avH;
  private e avI;
  private Rect avJ = new Rect();
  private Rect avK = new Rect();
  private int[] avL = new int[2];
  private int[] avM = new int[2];
  private final ImageView avN;
  private final Drawable avO;
  private final int avP;
  private final int avQ;
  final Intent avR;
  final Intent avS;
  private final CharSequence avT;
  private c avU;
  private b avV;
  View.OnFocusChangeListener avW;
  d avX;
  private View.OnClickListener avY;
  boolean avZ;
  final SearchAutoComplete avz;
  private boolean awa;
  f awb;
  private boolean awc;
  private CharSequence awd;
  private boolean awe;
  private boolean awf;
  private boolean awg;
  private CharSequence awh;
  private CharSequence awi;
  private boolean awj;
  private int awk;
  SearchableInfo awl;
  Bundle awm;
  private final Runnable awo = new Runnable()
  {
    public final void run()
    {
      SearchView.this.mk();
    }
  };
  private Runnable awp = new Runnable()
  {
    public final void run()
    {
      if ((SearchView.this.awb != null) && ((SearchView.this.awb instanceof au))) {
        SearchView.this.awb.changeCursor(null);
      }
    }
  };
  private final WeakHashMap<String, Drawable.ConstantState> awq = new WeakHashMap();
  View.OnKeyListener awr = new View.OnKeyListener()
  {
    public final boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
    {
      if (SearchView.this.awl == null) {}
      for (;;)
      {
        return false;
        if ((SearchView.this.avz.isPopupShowing()) && (SearchView.this.avz.getListSelection() != -1)) {
          return SearchView.this.b(paramAnonymousInt, paramAnonymousKeyEvent);
        }
        if (TextUtils.getTrimmedLength(SearchView.this.avz.getText()) == 0) {}
        for (int i = 1; (i == 0) && (paramAnonymousKeyEvent.hasNoModifiers()) && (paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousInt == 66); i = 0)
        {
          paramAnonymousView.cancelLongPress();
          SearchView.this.G(SearchView.this.avz.getText().toString());
          return true;
        }
      }
    }
  };
  private final TextView.OnEditorActionListener aws = new TextView.OnEditorActionListener()
  {
    public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
    {
      SearchView.this.mm();
      return true;
    }
  };
  private final AdapterView.OnItemClickListener awt = new AdapterView.OnItemClickListener()
  {
    public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      SearchView.this.cC(paramAnonymousInt);
    }
  };
  private TextWatcher awu = new TextWatcher()
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
      if (paramAnonymousView == SearchView.this.avD) {
        SearchView.this.mo();
      }
      for (;;)
      {
        return;
        if (paramAnonymousView == SearchView.this.avF)
        {
          SearchView.this.mn();
          return;
        }
        if (paramAnonymousView == SearchView.this.avE)
        {
          SearchView.this.mm();
          return;
        }
        SearchView localSearchView;
        SearchableInfo localSearchableInfo;
        if (paramAnonymousView == SearchView.this.avG)
        {
          localSearchView = SearchView.this;
          if (localSearchView.awl == null) {
            continue;
          }
          localSearchableInfo = localSearchView.awl;
        }
        try
        {
          if (localSearchableInfo.getVoiceSearchLaunchWebSearch())
          {
            localObject2 = new Intent(localSearchView.avR);
            paramAnonymousView = localSearchableInfo.getSearchActivity();
            if (paramAnonymousView == null) {}
            for (paramAnonymousView = (View)localObject1;; paramAnonymousView = paramAnonymousView.flattenToShortString())
            {
              ((Intent)localObject2).putExtra("calling_package", paramAnonymousView);
              paramAnonymousView = localSearchView.getContext();
              localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "android/support/v7/widget/SearchView", "onVoiceClicked", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "android/support/v7/widget/SearchView", "onVoiceClicked", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              return;
            }
          }
          if (!localSearchableInfo.getVoiceSearchLaunchRecognizer()) {
            continue;
          }
          paramAnonymousView = localSearchView.avS;
          ComponentName localComponentName = localSearchableInfo.getSearchActivity();
          localObject1 = new Intent("android.intent.action.SEARCH");
          ((Intent)localObject1).setComponent(localComponentName);
          PendingIntent localPendingIntent = PendingIntent.getActivity(localSearchView.getContext(), 0, (Intent)localObject1, 1073741824);
          Bundle localBundle = new Bundle();
          if (localSearchView.awm != null) {
            localBundle.putParcelable("app_data", localSearchView.awm);
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
                  localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "android/support/v7/widget/SearchView", "onVoiceClicked", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
                  com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "android/support/v7/widget/SearchView", "onVoiceClicked", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  return;
                }
                if (paramAnonymousView != SearchView.this.avz) {
                  break;
                }
                SearchView.this.mq();
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
    this.avz = ((SearchAutoComplete)findViewById(2131304447));
    this.avz.setSearchView(this);
    this.avA = findViewById(2131304414);
    this.avB = findViewById(2131304437);
    this.avC = findViewById(2131305515);
    this.avD = ((ImageView)findViewById(2131304396));
    this.avE = ((ImageView)findViewById(2131304418));
    this.avF = ((ImageView)findViewById(2131304402));
    this.avG = ((ImageView)findViewById(2131304453));
    this.avN = ((ImageView)findViewById(2131304434));
    t.a(this.avB, paramAttributeSet.getDrawable(10));
    t.a(this.avC, paramAttributeSet.getDrawable(14));
    this.avD.setImageDrawable(paramAttributeSet.getDrawable(13));
    this.avE.setImageDrawable(paramAttributeSet.getDrawable(7));
    this.avF.setImageDrawable(paramAttributeSet.getDrawable(4));
    this.avG.setImageDrawable(paramAttributeSet.getDrawable(16));
    this.avN.setImageDrawable(paramAttributeSet.getDrawable(13));
    this.avO = paramAttributeSet.getDrawable(12);
    bb.a(this.avD, getResources().getString(2131755106));
    this.avP = paramAttributeSet.getResourceId(15, 2131492915);
    this.avQ = paramAttributeSet.getResourceId(5, 0);
    this.avD.setOnClickListener(this.mOnClickListener);
    this.avF.setOnClickListener(this.mOnClickListener);
    this.avE.setOnClickListener(this.mOnClickListener);
    this.avG.setOnClickListener(this.mOnClickListener);
    this.avz.setOnClickListener(this.mOnClickListener);
    this.avz.addTextChangedListener(this.awu);
    this.avz.setOnEditorActionListener(this.aws);
    this.avz.setOnItemClickListener(this.awt);
    this.avz.setOnItemSelectedListener(this.XW);
    this.avz.setOnKeyListener(this.awr);
    this.avz.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (SearchView.this.avW != null) {
          SearchView.this.avW.onFocusChange(SearchView.this, paramAnonymousBoolean);
        }
      }
    });
    setIconifiedByDefault(paramAttributeSet.getBoolean(8, true));
    paramInt = paramAttributeSet.getDimensionPixelSize(1, -1);
    if (paramInt != -1) {
      setMaxWidth(paramInt);
    }
    this.avT = paramAttributeSet.getText(6);
    this.awd = paramAttributeSet.getText(11);
    paramInt = paramAttributeSet.getInt(3, -1);
    if (paramInt != -1) {
      setImeOptions(paramInt);
    }
    paramInt = paramAttributeSet.getInt(2, -1);
    if (paramInt != -1) {
      setInputType(paramInt);
    }
    setFocusable(paramAttributeSet.getBoolean(0, true));
    paramAttributeSet.ayA.recycle();
    this.avR = new Intent("android.speech.action.WEB_SEARCH");
    this.avR.addFlags(268435456);
    this.avR.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
    this.avS = new Intent("android.speech.action.RECOGNIZE_SPEECH");
    this.avS.addFlags(268435456);
    this.avH = findViewById(this.avz.getDropDownAnchor());
    if (this.avH != null) {
      this.avH.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
      {
        public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          paramAnonymousView = SearchView.this;
          Rect localRect;
          if (paramAnonymousView.avH.getWidth() > 1)
          {
            Resources localResources = paramAnonymousView.getContext().getResources();
            paramAnonymousInt3 = paramAnonymousView.avB.getPaddingLeft();
            localRect = new Rect();
            boolean bool = bh.d(paramAnonymousView);
            if (!paramAnonymousView.avZ) {
              break label149;
            }
            paramAnonymousInt1 = localResources.getDimensionPixelSize(2131165673);
            paramAnonymousInt1 = localResources.getDimensionPixelSize(2131165674) + paramAnonymousInt1;
            paramAnonymousView.avz.getDropDownBackground().getPadding(localRect);
            if (!bool) {
              break label154;
            }
          }
          label149:
          label154:
          for (paramAnonymousInt2 = -localRect.left;; paramAnonymousInt2 = paramAnonymousInt3 - (localRect.left + paramAnonymousInt1))
          {
            paramAnonymousView.avz.setDropDownHorizontalOffset(paramAnonymousInt2);
            paramAnonymousInt2 = paramAnonymousView.avH.getWidth();
            paramAnonymousInt4 = localRect.left;
            paramAnonymousInt5 = localRect.right;
            paramAnonymousView.avz.setDropDownWidth(paramAnonymousInt1 + (paramAnonymousInt2 + paramAnonymousInt4 + paramAnonymousInt5) - paramAnonymousInt3);
            return;
            paramAnonymousInt1 = 0;
            break;
          }
        }
      });
    }
    az(this.avZ);
    ml();
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
      localObject1 = this.awl.getSuggestIntentAction();
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
      localObject1 = this.awl.getSuggestIntentData();
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
    paramString1.putExtra("user_query", this.awi);
    if (paramString3 != null) {
      paramString1.putExtra("query", paramString3);
    }
    if (paramString2 != null) {
      paramString1.putExtra("intent_extra_data_key", paramString2);
    }
    if (this.awm != null) {
      paramString1.putExtra("app_data", this.awm);
    }
    paramString1.setComponent(this.awl.getSearchActivity());
    return paramString1;
  }
  
  private void aA(boolean paramBoolean)
  {
    int j = 8;
    int i = j;
    if (this.awc)
    {
      i = j;
      if (mg())
      {
        i = j;
        if (hasFocus()) {
          if (!paramBoolean)
          {
            i = j;
            if (this.awg) {}
          }
          else
          {
            i = 0;
          }
        }
      }
    }
    this.avE.setVisibility(i);
  }
  
  private void aB(boolean paramBoolean)
  {
    int i;
    if ((this.awg) && (!this.awa) && (paramBoolean))
    {
      i = 0;
      this.avE.setVisibility(8);
    }
    for (;;)
    {
      this.avG.setVisibility(i);
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
    this.awa = paramBoolean;
    int i;
    boolean bool1;
    if (paramBoolean)
    {
      i = 0;
      if (TextUtils.isEmpty(this.avz.getText())) {
        break label123;
      }
      bool1 = true;
      label33:
      this.avD.setVisibility(i);
      aA(bool1);
      View localView = this.avA;
      if (!paramBoolean) {
        break label129;
      }
      i = 8;
      label60:
      localView.setVisibility(i);
      i = j;
      if (this.avN.getDrawable() != null)
      {
        if (!this.avZ) {
          break label134;
        }
        i = j;
      }
      label87:
      this.avN.setVisibility(i);
      mi();
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
      mh();
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
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.a(localContext, locala.ahp(), "android/support/v7/widget/SearchView", "launchIntent", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localContext.startActivity((Intent)locala.mq(0));
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
    Cursor localCursor = this.awb.getCursor();
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
  
  private boolean mg()
  {
    return ((this.awc) || (this.awg)) && (!this.awa);
  }
  
  private void mh()
  {
    int j = 8;
    int i = j;
    if (mg()) {
      if (this.avE.getVisibility() != 0)
      {
        i = j;
        if (this.avG.getVisibility() != 0) {}
      }
      else
      {
        i = 0;
      }
    }
    this.avC.setVisibility(i);
  }
  
  private void mi()
  {
    int m = 1;
    int k = 0;
    int i;
    int j;
    label44:
    label56:
    Drawable localDrawable;
    if (!TextUtils.isEmpty(this.avz.getText()))
    {
      i = 1;
      j = m;
      if (i == 0)
      {
        if ((!this.avZ) || (this.awj)) {
          break label99;
        }
        j = m;
      }
      localObject = this.avF;
      if (j == 0) {
        break label104;
      }
      j = k;
      ((ImageView)localObject).setVisibility(j);
      localDrawable = this.avF.getDrawable();
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
  
  private void mj()
  {
    post(this.awo);
  }
  
  private void ml()
  {
    CharSequence localCharSequence = getQueryHint();
    SearchAutoComplete localSearchAutoComplete = this.avz;
    Object localObject = localCharSequence;
    if (localCharSequence == null) {
      localObject = "";
    }
    localSearchAutoComplete.setHint(o((CharSequence)localObject));
  }
  
  private CharSequence o(CharSequence paramCharSequence)
  {
    if ((!this.avZ) || (this.avO == null)) {
      return paramCharSequence;
    }
    int i = (int)(this.avz.getTextSize() * 1.25D);
    this.avO.setBounds(0, 0, i, i);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder("   ");
    localSpannableStringBuilder.setSpan(new ImageSpan(this.avO), 1, 2, 33);
    localSpannableStringBuilder.append(paramCharSequence);
    return localSpannableStringBuilder;
  }
  
  final void G(String paramString)
  {
    Object localObject = a("android.intent.action.SEARCH", null, null, paramString);
    paramString = getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "android/support/v7/widget/SearchView", "launchQuerySearch", "(ILjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramString, "android/support/v7/widget/SearchView", "launchQuerySearch", "(ILjava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
  }
  
  final boolean b(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.awl == null) {}
    do
    {
      do
      {
        return false;
      } while ((this.awb == null) || (paramKeyEvent.getAction() != 0) || (!paramKeyEvent.hasNoModifiers()));
      if ((paramInt == 66) || (paramInt == 84) || (paramInt == 61)) {
        return cC(this.avz.getListSelection());
      }
      if ((paramInt == 21) || (paramInt == 22))
      {
        if (paramInt == 21) {}
        for (paramInt = 0;; paramInt = this.avz.length())
        {
          this.avz.setSelection(paramInt);
          this.avz.setListSelection(0);
          this.avz.clearListSelection();
          awn.c(this.avz);
          return true;
        }
      }
    } while ((paramInt != 19) || (this.avz.getListSelection() != 0));
    return false;
  }
  
  final boolean cC(int paramInt)
  {
    boolean bool = false;
    if ((this.avX == null) || (!this.avX.mt()))
    {
      cD(paramInt);
      this.avz.setImeVisibility(false);
      this.avz.dismissDropDown();
      bool = true;
    }
    return bool;
  }
  
  public void clearFocus()
  {
    this.awf = true;
    super.clearFocus();
    this.avz.clearFocus();
    this.avz.setImeVisibility(false);
    this.awf = false;
  }
  
  public int getImeOptions()
  {
    return this.avz.getImeOptions();
  }
  
  public int getInputType()
  {
    return this.avz.getInputType();
  }
  
  public int getMaxWidth()
  {
    return this.mMaxWidth;
  }
  
  public CharSequence getQuery()
  {
    return this.avz.getText();
  }
  
  public CharSequence getQueryHint()
  {
    if (this.awd != null) {
      return this.awd;
    }
    if ((this.awl != null) && (this.awl.getHintId() != 0)) {
      return getContext().getText(this.awl.getHintId());
    }
    return this.avT;
  }
  
  int getSuggestionCommitIconResId()
  {
    return this.avQ;
  }
  
  int getSuggestionRowLayout()
  {
    return this.avP;
  }
  
  public f getSuggestionsAdapter()
  {
    return this.awb;
  }
  
  final void mk()
  {
    if (this.avz.hasFocus()) {}
    for (int[] arrayOfInt = FOCUSED_STATE_SET;; arrayOfInt = EMPTY_STATE_SET)
    {
      Drawable localDrawable = this.avB.getBackground();
      if (localDrawable != null) {
        localDrawable.setState(arrayOfInt);
      }
      localDrawable = this.avC.getBackground();
      if (localDrawable != null) {
        localDrawable.setState(arrayOfInt);
      }
      invalidate();
      return;
    }
  }
  
  final void mm()
  {
    Editable localEditable = this.avz.getText();
    if ((localEditable != null) && (TextUtils.getTrimmedLength(localEditable) > 0)) {
      if (this.avU != null)
      {
        c localc = this.avU;
        localEditable.toString();
        if (localc.mr()) {}
      }
      else
      {
        if (this.awl != null) {
          G(localEditable.toString());
        }
        this.avz.setImeVisibility(false);
        this.avz.dismissDropDown();
      }
    }
  }
  
  final void mn()
  {
    if (TextUtils.isEmpty(this.avz.getText()))
    {
      if ((this.avZ) && ((this.avV == null) || (!this.avV.onClose())))
      {
        clearFocus();
        az(true);
      }
      return;
    }
    this.avz.setText("");
    this.avz.requestFocus();
    this.avz.setImeVisibility(true);
  }
  
  final void mo()
  {
    az(false);
    this.avz.requestFocus();
    this.avz.setImeVisibility(true);
    if (this.avY != null) {
      this.avY.onClick(this);
    }
  }
  
  final void mp()
  {
    az(this.awa);
    mj();
    if (this.avz.hasFocus()) {
      mq();
    }
  }
  
  final void mq()
  {
    awn.a(this.avz);
    awn.b(this.avz);
  }
  
  public final void onActionViewCollapsed()
  {
    this.avz.setText("");
    this.avz.setSelection(this.avz.length());
    this.awi = "";
    clearFocus();
    az(true);
    this.avz.setImeOptions(this.awk);
    this.awj = false;
  }
  
  public final void onActionViewExpanded()
  {
    if (this.awj) {
      return;
    }
    this.awj = true;
    this.awk = this.avz.getImeOptions();
    this.avz.setImeOptions(this.awk | 0x2000000);
    this.avz.setText("");
    setIconified(false);
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.awo);
    post(this.awp);
    super.onDetachedFromWindow();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      SearchAutoComplete localSearchAutoComplete = this.avz;
      Rect localRect = this.avJ;
      localSearchAutoComplete.getLocationInWindow(this.avL);
      getLocationInWindow(this.avM);
      paramInt1 = this.avL[1] - this.avM[1];
      paramInt3 = this.avL[0] - this.avM[0];
      localRect.set(paramInt3, paramInt1, localSearchAutoComplete.getWidth() + paramInt3, localSearchAutoComplete.getHeight() + paramInt1);
      this.avK.set(this.avJ.left, 0, this.avJ.right, paramInt4 - paramInt2);
      if (this.avI == null)
      {
        this.avI = new e(this.avK, this.avJ, this.avz);
        setTouchDelegate(this.avI);
      }
    }
    else
    {
      return;
    }
    this.avI.a(this.avK, this.avJ);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.awa)
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
    super.onRestoreInstanceState(paramParcelable.Pa);
    az(paramParcelable.awz);
    requestLayout();
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.awz = this.awa;
    return localSavedState;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    mj();
  }
  
  final void p(CharSequence paramCharSequence)
  {
    boolean bool2 = true;
    Editable localEditable = this.avz.getText();
    this.awi = localEditable;
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
      mi();
      mh();
      if ((this.avU != null) && (!TextUtils.equals(paramCharSequence, this.awh))) {
        paramCharSequence.toString();
      }
      this.awh = paramCharSequence.toString();
      return;
      bool1 = false;
      break;
    }
  }
  
  public boolean requestFocus(int paramInt, Rect paramRect)
  {
    if (this.awf) {}
    while (!isFocusable()) {
      return false;
    }
    if (!this.awa)
    {
      boolean bool = this.avz.requestFocus(paramInt, paramRect);
      if (bool) {
        az(false);
      }
      return bool;
    }
    return super.requestFocus(paramInt, paramRect);
  }
  
  public void setAppSearchData(Bundle paramBundle)
  {
    this.awm = paramBundle;
  }
  
  public void setIconified(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      mn();
      return;
    }
    mo();
  }
  
  public void setIconifiedByDefault(boolean paramBoolean)
  {
    if (this.avZ == paramBoolean) {
      return;
    }
    this.avZ = paramBoolean;
    az(paramBoolean);
    ml();
  }
  
  public void setImeOptions(int paramInt)
  {
    this.avz.setImeOptions(paramInt);
  }
  
  public void setInputType(int paramInt)
  {
    this.avz.setInputType(paramInt);
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.mMaxWidth = paramInt;
    requestLayout();
  }
  
  public void setOnCloseListener(b paramb)
  {
    this.avV = paramb;
  }
  
  public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.avW = paramOnFocusChangeListener;
  }
  
  public void setOnQueryTextListener(c paramc)
  {
    this.avU = paramc;
  }
  
  public void setOnSearchClickListener(View.OnClickListener paramOnClickListener)
  {
    this.avY = paramOnClickListener;
  }
  
  public void setOnSuggestionListener(d paramd)
  {
    this.avX = paramd;
  }
  
  void setQuery(CharSequence paramCharSequence)
  {
    this.avz.setText(paramCharSequence);
    SearchAutoComplete localSearchAutoComplete = this.avz;
    if (TextUtils.isEmpty(paramCharSequence)) {}
    for (int i = 0;; i = paramCharSequence.length())
    {
      localSearchAutoComplete.setSelection(i);
      return;
    }
  }
  
  public void setQueryHint(CharSequence paramCharSequence)
  {
    this.awd = paramCharSequence;
    ml();
  }
  
  public void setQueryRefinementEnabled(boolean paramBoolean)
  {
    this.awe = paramBoolean;
    au localau;
    if ((this.awb instanceof au))
    {
      localau = (au)this.awb;
      if (!paramBoolean) {
        break label35;
      }
    }
    label35:
    for (int i = 2;; i = 1)
    {
      localau.axz = i;
      return;
    }
  }
  
  public void setSearchableInfo(SearchableInfo paramSearchableInfo)
  {
    boolean bool = true;
    this.awl = paramSearchableInfo;
    int i;
    if (this.awl != null)
    {
      this.avz.setThreshold(this.awl.getSuggestThreshold());
      this.avz.setImeOptions(this.awl.getImeOptions());
      int j = this.awl.getInputType();
      i = j;
      if ((j & 0xF) == 1)
      {
        j &= 0xFFFEFFFF;
        i = j;
        if (this.awl.getSuggestAuthority() != null) {
          i = j | 0x10000 | 0x80000;
        }
      }
      this.avz.setInputType(i);
      if (this.awb != null) {
        this.awb.changeCursor(null);
      }
      if (this.awl.getSuggestAuthority() != null)
      {
        this.awb = new au(getContext(), this, this.awl, this.awq);
        this.avz.setAdapter(this.awb);
        paramSearchableInfo = (au)this.awb;
        if (this.awe)
        {
          i = 2;
          paramSearchableInfo.axz = i;
        }
      }
      else
      {
        ml();
      }
    }
    else
    {
      if ((this.awl == null) || (!this.awl.getVoiceSearchEnabled())) {
        break label297;
      }
      if (!this.awl.getVoiceSearchLaunchWebSearch()) {
        break label273;
      }
      paramSearchableInfo = this.avR;
    }
    for (;;)
    {
      label215:
      if (paramSearchableInfo != null) {
        if (getContext().getPackageManager().resolveActivity(paramSearchableInfo, 65536) == null) {}
      }
      for (;;)
      {
        this.awg = bool;
        if (this.awg) {
          this.avz.setPrivateImeOptions("nm");
        }
        az(this.awa);
        return;
        i = 1;
        break;
        label273:
        if (!this.awl.getVoiceSearchLaunchRecognizer()) {
          break label303;
        }
        paramSearchableInfo = this.avS;
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
    this.awc = paramBoolean;
    az(this.awa);
  }
  
  public void setSuggestionsAdapter(f paramf)
  {
    this.awb = paramf;
    this.avz.setAdapter(this.awb);
  }
  
  static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator() {};
    boolean awz;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.awz = ((Boolean)paramParcel.readValue(null)).booleanValue();
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.awz + "}";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeValue(Boolean.valueOf(this.awz));
    }
  }
  
  public static class SearchAutoComplete
    extends AppCompatAutoCompleteTextView
  {
    private SearchView awA;
    boolean awB;
    final Runnable awC = new Runnable()
    {
      public final void run()
      {
        SearchView.SearchAutoComplete localSearchAutoComplete = SearchView.SearchAutoComplete.this;
        if (localSearchAutoComplete.awB)
        {
          ((InputMethodManager)localSearchAutoComplete.getContext().getSystemService("input_method")).showSoftInput(localSearchAutoComplete, 0);
          localSearchAutoComplete.awB = false;
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
      if (this.awB)
      {
        removeCallbacks(this.awC);
        post(this.awC);
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
      this.awA.mp();
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
            this.awA.clearFocus();
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
      if ((paramBoolean) && (this.awA.hasFocus()) && (getVisibility() == 0))
      {
        this.awB = true;
        if (SearchView.ab(getContext())) {
          SearchView.awn.c(this);
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
        this.awB = false;
        removeCallbacks(this.awC);
        localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        return;
      }
      if (localInputMethodManager.isActive(this))
      {
        this.awB = false;
        removeCallbacks(this.awC);
        localInputMethodManager.showSoftInput(this, 0);
        return;
      }
      this.awB = true;
    }
    
    void setSearchView(SearchView paramSearchView)
    {
      this.awA = paramSearchView;
    }
    
    public void setThreshold(int paramInt)
    {
      super.setThreshold(paramInt);
      this.mThreshold = paramInt;
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean onClose();
  }
  
  public static abstract interface c
  {
    public abstract boolean mr();
  }
  
  public static abstract interface d
  {
    public abstract boolean ms();
    
    public abstract boolean mt();
  }
  
  static final class e
    extends TouchDelegate
  {
    private final View awE;
    private final Rect awF;
    private final Rect awG;
    private final Rect awH;
    private final int awI;
    private boolean awJ;
    
    public e(Rect paramRect1, Rect paramRect2, View paramView)
    {
      super(paramView);
      this.awI = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
      this.awF = new Rect();
      this.awH = new Rect();
      this.awG = new Rect();
      a(paramRect1, paramRect2);
      this.awE = paramView;
    }
    
    public final void a(Rect paramRect1, Rect paramRect2)
    {
      this.awF.set(paramRect1);
      this.awH.set(paramRect1);
      this.awH.inset(-this.awI, -this.awI);
      this.awG.set(paramRect2);
    }
    
    public final boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      boolean bool3 = false;
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      int i;
      boolean bool1;
      label57:
      boolean bool2;
      switch (paramMotionEvent.getAction())
      {
      default: 
        i = 1;
        bool1 = false;
        bool2 = bool3;
        if (bool1)
        {
          if ((i == 0) || (this.awG.contains(j, k))) {
            break label203;
          }
          paramMotionEvent.setLocation(this.awE.getWidth() / 2, this.awE.getHeight() / 2);
        }
        break;
      }
      for (;;)
      {
        bool2 = this.awE.dispatchTouchEvent(paramMotionEvent);
        return bool2;
        if (!this.awF.contains(j, k)) {
          break;
        }
        this.awJ = true;
        i = 1;
        bool1 = true;
        break label57;
        bool2 = this.awJ;
        bool1 = bool2;
        if (bool2)
        {
          bool1 = bool2;
          if (!this.awH.contains(j, k))
          {
            i = 0;
            bool1 = bool2;
            break label57;
            bool1 = this.awJ;
            this.awJ = false;
          }
        }
        i = 1;
        break label57;
        label203:
        paramMotionEvent.setLocation(j - this.awG.left, k - this.awG.top);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v7.widget.SearchView
 * JD-Core Version:    0.7.0.1
 */