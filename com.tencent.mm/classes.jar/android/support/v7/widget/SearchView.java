package android.support.v7.widget;

import android.app.SearchableInfo;
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
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
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
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewConfiguration;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageView;
import android.widget.TextView.OnEditorActionListener;
import java.util.WeakHashMap;

public class SearchView
  extends LinearLayoutCompat
  implements c
{
  static final SearchView.a amb = new SearchView.a();
  private final AdapterView.OnItemSelectedListener Oh = new SearchView.10(this);
  private int[] alA = new int[2];
  private final ImageView alB;
  private final Drawable alC;
  private final int alD;
  private final int alE;
  final Intent alF;
  final Intent alG;
  private final CharSequence alH;
  private SearchView.c alI;
  private SearchView.b alJ;
  View.OnFocusChangeListener alK;
  SearchView.d alL;
  private View.OnClickListener alM;
  boolean alN;
  private boolean alO;
  f alP;
  private boolean alQ;
  private CharSequence alR;
  private boolean alS;
  private boolean alT;
  private boolean alU;
  private CharSequence alV;
  private CharSequence alW;
  private boolean alX;
  private int alY;
  SearchableInfo alZ;
  final SearchView.SearchAutoComplete aln;
  private final View alo;
  final View alp;
  private final View alq;
  final ImageView alr;
  final ImageView als;
  final ImageView alt;
  final ImageView alu;
  final View alv;
  private e alw;
  private Rect alx = new Rect();
  private Rect aly = new Rect();
  private int[] alz = new int[2];
  Bundle ama;
  private final Runnable amc = new SearchView.1(this);
  private Runnable amd = new SearchView.3(this);
  private final WeakHashMap<String, Drawable.ConstantState> ame = new WeakHashMap();
  View.OnKeyListener amf = new SearchView.7(this);
  private final TextView.OnEditorActionListener amg = new SearchView.8(this);
  private final AdapterView.OnItemClickListener amh = new SearchView.9(this);
  private TextWatcher ami = new SearchView.2(this);
  private int mMaxWidth;
  private final View.OnClickListener mOnClickListener = new SearchView.6(this);
  
  public SearchView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SearchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130772191);
  }
  
  public SearchView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = az.a(paramContext, paramAttributeSet, a.a.SearchView, paramInt, 0);
    LayoutInflater.from(paramContext).inflate(paramAttributeSet.getResourceId(4, 2130968609), this, true);
    this.aln = ((SearchView.SearchAutoComplete)findViewById(2131820966));
    this.aln.setSearchView(this);
    this.alo = findViewById(2131820963);
    this.alp = findViewById(2131820965);
    this.alq = findViewById(2131820968);
    this.alr = ((ImageView)findViewById(2131820962));
    this.als = ((ImageView)findViewById(2131820969));
    this.alt = ((ImageView)findViewById(2131820967));
    this.alu = ((ImageView)findViewById(2131820970));
    this.alB = ((ImageView)findViewById(2131820964));
    t.a(this.alp, paramAttributeSet.getDrawable(15));
    t.a(this.alq, paramAttributeSet.getDrawable(16));
    this.alr.setImageDrawable(paramAttributeSet.getDrawable(10));
    this.als.setImageDrawable(paramAttributeSet.getDrawable(9));
    this.alt.setImageDrawable(paramAttributeSet.getDrawable(8));
    this.alu.setImageDrawable(paramAttributeSet.getDrawable(12));
    this.alB.setImageDrawable(paramAttributeSet.getDrawable(10));
    this.alC = paramAttributeSet.getDrawable(11);
    bb.a(this.alr, getResources().getString(2131296277));
    this.alD = paramAttributeSet.getResourceId(14, 2130968608);
    this.alE = paramAttributeSet.getResourceId(13, 0);
    this.alr.setOnClickListener(this.mOnClickListener);
    this.alt.setOnClickListener(this.mOnClickListener);
    this.als.setOnClickListener(this.mOnClickListener);
    this.alu.setOnClickListener(this.mOnClickListener);
    this.aln.setOnClickListener(this.mOnClickListener);
    this.aln.addTextChangedListener(this.ami);
    this.aln.setOnEditorActionListener(this.amg);
    this.aln.setOnItemClickListener(this.amh);
    this.aln.setOnItemSelectedListener(this.Oh);
    this.aln.setOnKeyListener(this.amf);
    this.aln.setOnFocusChangeListener(new SearchView.4(this));
    setIconifiedByDefault(paramAttributeSet.getBoolean(5, true));
    paramInt = paramAttributeSet.getDimensionPixelSize(1, -1);
    if (paramInt != -1) {
      setMaxWidth(paramInt);
    }
    this.alH = paramAttributeSet.getText(7);
    this.alR = paramAttributeSet.getText(6);
    paramInt = paramAttributeSet.getInt(3, -1);
    if (paramInt != -1) {
      setImeOptions(paramInt);
    }
    paramInt = paramAttributeSet.getInt(2, -1);
    if (paramInt != -1) {
      setInputType(paramInt);
    }
    setFocusable(paramAttributeSet.getBoolean(0, true));
    paramAttributeSet.aoo.recycle();
    this.alF = new Intent("android.speech.action.WEB_SEARCH");
    this.alF.addFlags(268435456);
    this.alF.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
    this.alG = new Intent("android.speech.action.RECOGNIZE_SPEECH");
    this.alG.addFlags(268435456);
    this.alv = findViewById(this.aln.getDropDownAnchor());
    if (this.alv != null) {
      this.alv.addOnLayoutChangeListener(new SearchView.5(this));
    }
    ar(this.alN);
    kj();
  }
  
  static boolean Y(Context paramContext)
  {
    return paramContext.getResources().getConfiguration().orientation == 2;
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
      localObject1 = this.alZ.getSuggestIntentAction();
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
      localObject1 = this.alZ.getSuggestIntentData();
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
    paramString1.putExtra("user_query", this.alW);
    if (paramString3 != null) {
      paramString1.putExtra("query", paramString3);
    }
    if (paramString2 != null) {
      paramString1.putExtra("intent_extra_data_key", paramString2);
    }
    if (this.ama != null) {
      paramString1.putExtra("app_data", this.ama);
    }
    paramString1.setComponent(this.alZ.getSearchActivity());
    return paramString1;
  }
  
  private void ar(boolean paramBoolean)
  {
    boolean bool2 = true;
    int j = 8;
    this.alO = paramBoolean;
    int i;
    boolean bool1;
    if (paramBoolean)
    {
      i = 0;
      if (TextUtils.isEmpty(this.aln.getText())) {
        break label123;
      }
      bool1 = true;
      label33:
      this.alr.setVisibility(i);
      as(bool1);
      View localView = this.alo;
      if (!paramBoolean) {
        break label129;
      }
      i = 8;
      label60:
      localView.setVisibility(i);
      i = j;
      if (this.alB.getDrawable() != null)
      {
        if (!this.alN) {
          break label134;
        }
        i = j;
      }
      label87:
      this.alB.setVisibility(i);
      kg();
      if (bool1) {
        break label139;
      }
    }
    label129:
    label134:
    label139:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      at(paramBoolean);
      kf();
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
  
  private void as(boolean paramBoolean)
  {
    int j = 8;
    int i = j;
    if (this.alQ)
    {
      i = j;
      if (ke())
      {
        i = j;
        if (hasFocus()) {
          if (!paramBoolean)
          {
            i = j;
            if (this.alU) {}
          }
          else
          {
            i = 0;
          }
        }
      }
    }
    this.als.setVisibility(i);
  }
  
  private void at(boolean paramBoolean)
  {
    int i;
    if ((this.alU) && (!this.alO) && (paramBoolean))
    {
      i = 0;
      this.als.setVisibility(8);
    }
    for (;;)
    {
      this.alu.setVisibility(i);
      return;
      i = 8;
    }
  }
  
  private boolean ck(int paramInt)
  {
    Cursor localCursor = this.alP.getCursor();
    if ((localCursor != null) && (localCursor.moveToPosition(paramInt)))
    {
      d(a(localCursor));
      return true;
    }
    return false;
  }
  
  private void d(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    try
    {
      getContext().startActivity(paramIntent);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      new StringBuilder("Failed launch activity: ").append(paramIntent);
    }
  }
  
  private int getPreferredHeight()
  {
    return getContext().getResources().getDimensionPixelSize(2131427956);
  }
  
  private int getPreferredWidth()
  {
    return getContext().getResources().getDimensionPixelSize(2131427957);
  }
  
  private boolean ke()
  {
    return ((this.alQ) || (this.alU)) && (!this.alO);
  }
  
  private void kf()
  {
    int j = 8;
    int i = j;
    if (ke()) {
      if (this.als.getVisibility() != 0)
      {
        i = j;
        if (this.alu.getVisibility() != 0) {}
      }
      else
      {
        i = 0;
      }
    }
    this.alq.setVisibility(i);
  }
  
  private void kg()
  {
    int m = 1;
    int k = 0;
    int i;
    int j;
    label44:
    label56:
    Drawable localDrawable;
    if (!TextUtils.isEmpty(this.aln.getText()))
    {
      i = 1;
      j = m;
      if (i == 0)
      {
        if ((!this.alN) || (this.alX)) {
          break label99;
        }
        j = m;
      }
      localObject = this.alt;
      if (j == 0) {
        break label104;
      }
      j = k;
      ((ImageView)localObject).setVisibility(j);
      localDrawable = this.alt.getDrawable();
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
  
  private void kh()
  {
    post(this.amc);
  }
  
  private void kj()
  {
    CharSequence localCharSequence = getQueryHint();
    SearchView.SearchAutoComplete localSearchAutoComplete = this.aln;
    Object localObject = localCharSequence;
    if (localCharSequence == null) {
      localObject = "";
    }
    localSearchAutoComplete.setHint(l((CharSequence)localObject));
  }
  
  private CharSequence l(CharSequence paramCharSequence)
  {
    if ((!this.alN) || (this.alC == null)) {
      return paramCharSequence;
    }
    int i = (int)(this.aln.getTextSize() * 1.25D);
    this.alC.setBounds(0, 0, i, i);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder("   ");
    localSpannableStringBuilder.setSpan(new ImageSpan(this.alC), 1, 2, 33);
    localSpannableStringBuilder.append(paramCharSequence);
    return localSpannableStringBuilder;
  }
  
  final void T(String paramString)
  {
    paramString = a("android.intent.action.SEARCH", null, null, paramString);
    getContext().startActivity(paramString);
  }
  
  final boolean b(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.alZ == null) {}
    do
    {
      do
      {
        return false;
      } while ((this.alP == null) || (paramKeyEvent.getAction() != 0) || (!paramKeyEvent.hasNoModifiers()));
      if ((paramInt == 66) || (paramInt == 84) || (paramInt == 61)) {
        return cj(this.aln.getListSelection());
      }
      if ((paramInt == 21) || (paramInt == 22))
      {
        if (paramInt == 21) {}
        for (paramInt = 0;; paramInt = this.aln.length())
        {
          this.aln.setSelection(paramInt);
          this.aln.setListSelection(0);
          this.aln.clearListSelection();
          amb.c(this.aln);
          return true;
        }
      }
    } while ((paramInt != 19) || (this.aln.getListSelection() != 0));
    return false;
  }
  
  final boolean cj(int paramInt)
  {
    boolean bool = false;
    if ((this.alL == null) || (!this.alL.kr()))
    {
      ck(paramInt);
      this.aln.setImeVisibility(false);
      this.aln.dismissDropDown();
      bool = true;
    }
    return bool;
  }
  
  public void clearFocus()
  {
    this.alT = true;
    super.clearFocus();
    this.aln.clearFocus();
    this.aln.setImeVisibility(false);
    this.alT = false;
  }
  
  public int getImeOptions()
  {
    return this.aln.getImeOptions();
  }
  
  public int getInputType()
  {
    return this.aln.getInputType();
  }
  
  public int getMaxWidth()
  {
    return this.mMaxWidth;
  }
  
  public CharSequence getQuery()
  {
    return this.aln.getText();
  }
  
  public CharSequence getQueryHint()
  {
    if (this.alR != null) {
      return this.alR;
    }
    if ((this.alZ != null) && (this.alZ.getHintId() != 0)) {
      return getContext().getText(this.alZ.getHintId());
    }
    return this.alH;
  }
  
  int getSuggestionCommitIconResId()
  {
    return this.alE;
  }
  
  int getSuggestionRowLayout()
  {
    return this.alD;
  }
  
  public f getSuggestionsAdapter()
  {
    return this.alP;
  }
  
  final void ki()
  {
    if (this.aln.hasFocus()) {}
    for (int[] arrayOfInt = FOCUSED_STATE_SET;; arrayOfInt = EMPTY_STATE_SET)
    {
      Drawable localDrawable = this.alp.getBackground();
      if (localDrawable != null) {
        localDrawable.setState(arrayOfInt);
      }
      localDrawable = this.alq.getBackground();
      if (localDrawable != null) {
        localDrawable.setState(arrayOfInt);
      }
      invalidate();
      return;
    }
  }
  
  final void kk()
  {
    Editable localEditable = this.aln.getText();
    if ((localEditable != null) && (TextUtils.getTrimmedLength(localEditable) > 0)) {
      if (this.alI != null)
      {
        SearchView.c localc = this.alI;
        localEditable.toString();
        if (localc.kp()) {}
      }
      else
      {
        if (this.alZ != null) {
          T(localEditable.toString());
        }
        this.aln.setImeVisibility(false);
        this.aln.dismissDropDown();
      }
    }
  }
  
  final void kl()
  {
    if (TextUtils.isEmpty(this.aln.getText()))
    {
      if ((this.alN) && ((this.alJ == null) || (!this.alJ.onClose())))
      {
        clearFocus();
        ar(true);
      }
      return;
    }
    this.aln.setText("");
    this.aln.requestFocus();
    this.aln.setImeVisibility(true);
  }
  
  final void km()
  {
    ar(false);
    this.aln.requestFocus();
    this.aln.setImeVisibility(true);
    if (this.alM != null) {
      this.alM.onClick(this);
    }
  }
  
  final void kn()
  {
    ar(this.alO);
    kh();
    if (this.aln.hasFocus()) {
      ko();
    }
  }
  
  final void ko()
  {
    amb.a(this.aln);
    amb.b(this.aln);
  }
  
  final void m(CharSequence paramCharSequence)
  {
    boolean bool2 = true;
    Editable localEditable = this.aln.getText();
    this.alW = localEditable;
    if (!TextUtils.isEmpty(localEditable))
    {
      bool1 = true;
      as(bool1);
      if (bool1) {
        break label92;
      }
    }
    label92:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      at(bool1);
      kg();
      kf();
      if ((this.alI != null) && (!TextUtils.equals(paramCharSequence, this.alV))) {
        paramCharSequence.toString();
      }
      this.alV = paramCharSequence.toString();
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void onActionViewCollapsed()
  {
    this.aln.setText("");
    this.aln.setSelection(this.aln.length());
    this.alW = "";
    clearFocus();
    ar(true);
    this.aln.setImeOptions(this.alY);
    this.alX = false;
  }
  
  public final void onActionViewExpanded()
  {
    if (this.alX) {
      return;
    }
    this.alX = true;
    this.alY = this.aln.getImeOptions();
    this.aln.setImeOptions(this.alY | 0x2000000);
    this.aln.setText("");
    setIconified(false);
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.amc);
    post(this.amd);
    super.onDetachedFromWindow();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      SearchView.SearchAutoComplete localSearchAutoComplete = this.aln;
      Rect localRect = this.alx;
      localSearchAutoComplete.getLocationInWindow(this.alz);
      getLocationInWindow(this.alA);
      paramInt1 = this.alz[1] - this.alA[1];
      paramInt3 = this.alz[0] - this.alA[0];
      localRect.set(paramInt3, paramInt1, localSearchAutoComplete.getWidth() + paramInt3, localSearchAutoComplete.getHeight() + paramInt1);
      this.aly.set(this.alx.left, 0, this.alx.right, paramInt4 - paramInt2);
      if (this.alw == null)
      {
        this.alw = new e(this.aly, this.alx, this.aln);
        setTouchDelegate(this.alw);
      }
    }
    else
    {
      return;
    }
    this.alw.c(this.aly, this.alx);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.alO)
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
    if (!(paramParcelable instanceof SearchView.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SearchView.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.Fo);
    ar(paramParcelable.amn);
    requestLayout();
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SearchView.SavedState localSavedState = new SearchView.SavedState(super.onSaveInstanceState());
    localSavedState.amn = this.alO;
    return localSavedState;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    kh();
  }
  
  public boolean requestFocus(int paramInt, Rect paramRect)
  {
    if (this.alT) {}
    while (!isFocusable()) {
      return false;
    }
    if (!this.alO)
    {
      boolean bool = this.aln.requestFocus(paramInt, paramRect);
      if (bool) {
        ar(false);
      }
      return bool;
    }
    return super.requestFocus(paramInt, paramRect);
  }
  
  public void setAppSearchData(Bundle paramBundle)
  {
    this.ama = paramBundle;
  }
  
  public void setIconified(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      kl();
      return;
    }
    km();
  }
  
  public void setIconifiedByDefault(boolean paramBoolean)
  {
    if (this.alN == paramBoolean) {
      return;
    }
    this.alN = paramBoolean;
    ar(paramBoolean);
    kj();
  }
  
  public void setImeOptions(int paramInt)
  {
    this.aln.setImeOptions(paramInt);
  }
  
  public void setInputType(int paramInt)
  {
    this.aln.setInputType(paramInt);
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.mMaxWidth = paramInt;
    requestLayout();
  }
  
  public void setOnCloseListener(SearchView.b paramb)
  {
    this.alJ = paramb;
  }
  
  public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.alK = paramOnFocusChangeListener;
  }
  
  public void setOnQueryTextListener(SearchView.c paramc)
  {
    this.alI = paramc;
  }
  
  public void setOnSearchClickListener(View.OnClickListener paramOnClickListener)
  {
    this.alM = paramOnClickListener;
  }
  
  public void setOnSuggestionListener(SearchView.d paramd)
  {
    this.alL = paramd;
  }
  
  void setQuery(CharSequence paramCharSequence)
  {
    this.aln.setText(paramCharSequence);
    SearchView.SearchAutoComplete localSearchAutoComplete = this.aln;
    if (TextUtils.isEmpty(paramCharSequence)) {}
    for (int i = 0;; i = paramCharSequence.length())
    {
      localSearchAutoComplete.setSelection(i);
      return;
    }
  }
  
  public void setQueryHint(CharSequence paramCharSequence)
  {
    this.alR = paramCharSequence;
    kj();
  }
  
  public void setQueryRefinementEnabled(boolean paramBoolean)
  {
    this.alS = paramBoolean;
    au localau;
    if ((this.alP instanceof au))
    {
      localau = (au)this.alP;
      if (!paramBoolean) {
        break label35;
      }
    }
    label35:
    for (int i = 2;; i = 1)
    {
      localau.ann = i;
      return;
    }
  }
  
  public void setSearchableInfo(SearchableInfo paramSearchableInfo)
  {
    boolean bool = true;
    this.alZ = paramSearchableInfo;
    int i;
    if (this.alZ != null)
    {
      this.aln.setThreshold(this.alZ.getSuggestThreshold());
      this.aln.setImeOptions(this.alZ.getImeOptions());
      int j = this.alZ.getInputType();
      i = j;
      if ((j & 0xF) == 1)
      {
        j &= 0xFFFEFFFF;
        i = j;
        if (this.alZ.getSuggestAuthority() != null) {
          i = j | 0x10000 | 0x80000;
        }
      }
      this.aln.setInputType(i);
      if (this.alP != null) {
        this.alP.changeCursor(null);
      }
      if (this.alZ.getSuggestAuthority() != null)
      {
        this.alP = new au(getContext(), this, this.alZ, this.ame);
        this.aln.setAdapter(this.alP);
        paramSearchableInfo = (au)this.alP;
        if (this.alS)
        {
          i = 2;
          paramSearchableInfo.ann = i;
        }
      }
      else
      {
        kj();
      }
    }
    else
    {
      if ((this.alZ == null) || (!this.alZ.getVoiceSearchEnabled())) {
        break label297;
      }
      if (!this.alZ.getVoiceSearchLaunchWebSearch()) {
        break label273;
      }
      paramSearchableInfo = this.alF;
    }
    for (;;)
    {
      label215:
      if (paramSearchableInfo != null) {
        if (getContext().getPackageManager().resolveActivity(paramSearchableInfo, 65536) == null) {}
      }
      for (;;)
      {
        this.alU = bool;
        if (this.alU) {
          this.aln.setPrivateImeOptions("nm");
        }
        ar(this.alO);
        return;
        i = 1;
        break;
        label273:
        if (!this.alZ.getVoiceSearchLaunchRecognizer()) {
          break label303;
        }
        paramSearchableInfo = this.alG;
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
    this.alQ = paramBoolean;
    ar(this.alO);
  }
  
  public void setSuggestionsAdapter(f paramf)
  {
    this.alP = paramf;
    this.aln.setAdapter(this.alP);
  }
  
  static final class e
    extends TouchDelegate
  {
    private final View ams;
    private final Rect amt;
    private final Rect amu;
    private final Rect amv;
    private final int amw;
    private boolean amx;
    
    public e(Rect paramRect1, Rect paramRect2, View paramView)
    {
      super(paramView);
      this.amw = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
      this.amt = new Rect();
      this.amv = new Rect();
      this.amu = new Rect();
      c(paramRect1, paramRect2);
      this.ams = paramView;
    }
    
    public final void c(Rect paramRect1, Rect paramRect2)
    {
      this.amt.set(paramRect1);
      this.amv.set(paramRect1);
      this.amv.inset(-this.amw, -this.amw);
      this.amu.set(paramRect2);
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
          if ((i == 0) || (this.amu.contains(j, k))) {
            break label203;
          }
          paramMotionEvent.setLocation(this.ams.getWidth() / 2, this.ams.getHeight() / 2);
        }
        break;
      }
      for (;;)
      {
        bool2 = this.ams.dispatchTouchEvent(paramMotionEvent);
        return bool2;
        if (!this.amt.contains(j, k)) {
          break;
        }
        this.amx = true;
        i = 1;
        bool1 = true;
        break label57;
        bool2 = this.amx;
        bool1 = bool2;
        if (bool2)
        {
          bool1 = bool2;
          if (!this.amv.contains(j, k))
          {
            i = 0;
            bool1 = bool2;
            break label57;
            bool1 = this.amx;
            this.amx = false;
          }
        }
        i = 1;
        break label57;
        label203:
        paramMotionEvent.setLocation(j - this.amu.left, k - this.amu.top);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.v7.widget.SearchView
 * JD-Core Version:    0.7.0.1
 */