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
import android.support.v4.view.q;
import android.support.v4.widget.f;
import android.support.v7.a.a.a;
import android.support.v7.a.a.d;
import android.support.v7.a.a.f;
import android.support.v7.a.a.g;
import android.support.v7.a.a.h;
import android.support.v7.a.a.j;
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
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView
  extends LinearLayoutCompat
  implements c
{
  static final SearchView.a ajL = new SearchView.a();
  private final AdapterView.OnItemSelectedListener Ot = new SearchView.10(this);
  final SearchView.SearchAutoComplete aiX;
  private final View aiY;
  final View aiZ;
  private boolean ajA;
  private CharSequence ajB;
  private boolean ajC;
  private boolean ajD;
  private boolean ajE;
  private CharSequence ajF;
  private CharSequence ajG;
  private boolean ajH;
  private int ajI;
  SearchableInfo ajJ;
  Bundle ajK;
  private final Runnable ajM = new SearchView.1(this);
  private Runnable ajN = new SearchView.3(this);
  private final WeakHashMap<String, Drawable.ConstantState> ajO = new WeakHashMap();
  View.OnKeyListener ajP = new SearchView.7(this);
  private final TextView.OnEditorActionListener ajQ = new SearchView.8(this);
  private final AdapterView.OnItemClickListener ajR = new SearchView.9(this);
  private TextWatcher ajS = new SearchView.2(this);
  private final View aja;
  final ImageView ajb;
  final ImageView ajc;
  final ImageView ajd;
  final ImageView aje;
  final View ajf;
  private e ajg;
  private Rect ajh = new Rect();
  private Rect aji = new Rect();
  private int[] ajj = new int[2];
  private int[] ajk = new int[2];
  private final ImageView ajl;
  private final Drawable ajm;
  private final int ajn;
  private final int ajo;
  final Intent ajp;
  final Intent ajq;
  private final CharSequence ajr;
  private c ajs;
  private SearchView.b ajt;
  View.OnFocusChangeListener aju;
  SearchView.d ajv;
  private View.OnClickListener ajw;
  boolean ajx;
  private boolean ajy;
  f ajz;
  private int eg;
  private final View.OnClickListener mOnClickListener = new SearchView.6(this);
  
  public SearchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.searchViewStyle);
  }
  
  public SearchView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = ax.a(paramContext, paramAttributeSet, a.j.SearchView, paramInt, 0);
    LayoutInflater.from(paramContext).inflate(paramAttributeSet.getResourceId(a.j.SearchView_layout, a.g.abc_search_view), this, true);
    this.aiX = ((SearchView.SearchAutoComplete)findViewById(a.f.search_src_text));
    this.aiX.setSearchView(this);
    this.aiY = findViewById(a.f.search_edit_frame);
    this.aiZ = findViewById(a.f.search_plate);
    this.aja = findViewById(a.f.submit_area);
    this.ajb = ((ImageView)findViewById(a.f.search_button));
    this.ajc = ((ImageView)findViewById(a.f.search_go_btn));
    this.ajd = ((ImageView)findViewById(a.f.search_close_btn));
    this.aje = ((ImageView)findViewById(a.f.search_voice_btn));
    this.ajl = ((ImageView)findViewById(a.f.search_mag_icon));
    q.a(this.aiZ, paramAttributeSet.getDrawable(a.j.SearchView_queryBackground));
    q.a(this.aja, paramAttributeSet.getDrawable(a.j.SearchView_submitBackground));
    this.ajb.setImageDrawable(paramAttributeSet.getDrawable(a.j.SearchView_searchIcon));
    this.ajc.setImageDrawable(paramAttributeSet.getDrawable(a.j.SearchView_goIcon));
    this.ajd.setImageDrawable(paramAttributeSet.getDrawable(a.j.SearchView_closeIcon));
    this.aje.setImageDrawable(paramAttributeSet.getDrawable(a.j.SearchView_voiceIcon));
    this.ajl.setImageDrawable(paramAttributeSet.getDrawable(a.j.SearchView_searchIcon));
    this.ajm = paramAttributeSet.getDrawable(a.j.SearchView_searchHintIcon);
    az.a(this.ajb, getResources().getString(a.h.abc_searchview_description_search));
    this.ajn = paramAttributeSet.getResourceId(a.j.SearchView_suggestionRowLayout, a.g.abc_search_dropdown_item_icons_2line);
    this.ajo = paramAttributeSet.getResourceId(a.j.SearchView_commitIcon, 0);
    this.ajb.setOnClickListener(this.mOnClickListener);
    this.ajd.setOnClickListener(this.mOnClickListener);
    this.ajc.setOnClickListener(this.mOnClickListener);
    this.aje.setOnClickListener(this.mOnClickListener);
    this.aiX.setOnClickListener(this.mOnClickListener);
    this.aiX.addTextChangedListener(this.ajS);
    this.aiX.setOnEditorActionListener(this.ajQ);
    this.aiX.setOnItemClickListener(this.ajR);
    this.aiX.setOnItemSelectedListener(this.Ot);
    this.aiX.setOnKeyListener(this.ajP);
    this.aiX.setOnFocusChangeListener(new SearchView.4(this));
    setIconifiedByDefault(paramAttributeSet.getBoolean(a.j.SearchView_iconifiedByDefault, true));
    paramInt = paramAttributeSet.getDimensionPixelSize(a.j.SearchView_android_maxWidth, -1);
    if (paramInt != -1) {
      setMaxWidth(paramInt);
    }
    this.ajr = paramAttributeSet.getText(a.j.SearchView_defaultQueryHint);
    this.ajB = paramAttributeSet.getText(a.j.SearchView_queryHint);
    paramInt = paramAttributeSet.getInt(a.j.SearchView_android_imeOptions, -1);
    if (paramInt != -1) {
      setImeOptions(paramInt);
    }
    paramInt = paramAttributeSet.getInt(a.j.SearchView_android_inputType, -1);
    if (paramInt != -1) {
      setInputType(paramInt);
    }
    setFocusable(paramAttributeSet.getBoolean(a.j.SearchView_android_focusable, true));
    paramAttributeSet.alZ.recycle();
    this.ajp = new Intent("android.speech.action.WEB_SEARCH");
    this.ajp.addFlags(268435456);
    this.ajp.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
    this.ajq = new Intent("android.speech.action.RECOGNIZE_SPEECH");
    this.ajq.addFlags(268435456);
    this.ajf = findViewById(this.aiX.getDropDownAnchor());
    if (this.ajf != null) {
      this.ajf.addOnLayoutChangeListener(new SearchView.5(this));
    }
    ai(this.ajx);
    ix();
  }
  
  static boolean U(Context paramContext)
  {
    return paramContext.getResources().getConfiguration().orientation == 2;
  }
  
  private Intent a(String paramString1, Uri paramUri, String paramString2, String paramString3)
  {
    paramString1 = new Intent(paramString1);
    paramString1.addFlags(268435456);
    if (paramUri != null) {
      paramString1.setData(paramUri);
    }
    paramString1.putExtra("user_query", this.ajG);
    if (paramString3 != null) {
      paramString1.putExtra("query", paramString3);
    }
    if (paramString2 != null) {
      paramString1.putExtra("intent_extra_data_key", paramString2);
    }
    if (this.ajK != null) {
      paramString1.putExtra("app_data", this.ajK);
    }
    paramString1.setComponent(this.ajJ.getSearchActivity());
    return paramString1;
  }
  
  private void ai(boolean paramBoolean)
  {
    boolean bool2 = true;
    int j = 8;
    this.ajy = paramBoolean;
    int i;
    boolean bool1;
    if (paramBoolean)
    {
      i = 0;
      if (TextUtils.isEmpty(this.aiX.getText())) {
        break label123;
      }
      bool1 = true;
      label33:
      this.ajb.setVisibility(i);
      aj(bool1);
      View localView = this.aiY;
      if (!paramBoolean) {
        break label129;
      }
      i = 8;
      label60:
      localView.setVisibility(i);
      i = j;
      if (this.ajl.getDrawable() != null)
      {
        if (!this.ajx) {
          break label134;
        }
        i = j;
      }
      label87:
      this.ajl.setVisibility(i);
      iu();
      if (bool1) {
        break label139;
      }
    }
    label129:
    label134:
    label139:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      ak(paramBoolean);
      it();
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
  
  private void aj(boolean paramBoolean)
  {
    int j = 8;
    int i = j;
    if (this.ajA)
    {
      i = j;
      if (is())
      {
        i = j;
        if (hasFocus()) {
          if (!paramBoolean)
          {
            i = j;
            if (this.ajE) {}
          }
          else
          {
            i = 0;
          }
        }
      }
    }
    this.ajc.setVisibility(i);
  }
  
  private void ak(boolean paramBoolean)
  {
    int i;
    if ((this.ajE) && (!this.ajy) && (paramBoolean))
    {
      i = 0;
      this.ajc.setVisibility(8);
    }
    for (;;)
    {
      this.aje.setVisibility(i);
      return;
      i = 8;
    }
  }
  
  private Intent b(Cursor paramCursor)
  {
    try
    {
      localObject3 = as.a(paramCursor, "suggest_intent_action");
      localObject1 = localObject3;
      if (localObject3 != null) {
        break label188;
      }
      localObject1 = this.ajJ.getSuggestIntentAction();
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
    localObject4 = as.a(paramCursor, "suggest_intent_data");
    localObject1 = localObject4;
    if (localObject4 == null) {
      localObject1 = this.ajJ.getSuggestIntentData();
    }
    localObject4 = localObject1;
    if (localObject1 != null)
    {
      str = as.a(paramCursor, "suggest_intent_data_id");
      localObject4 = localObject1;
      if (str != null)
      {
        localObject4 = (String)localObject1 + "/" + Uri.encode(str);
        break label200;
        for (;;)
        {
          localObject4 = as.a(paramCursor, "suggest_intent_query");
          return a((String)localObject3, (Uri)localObject1, as.a(paramCursor, "suggest_intent_extra_data"), (String)localObject4);
          localObject1 = Uri.parse((String)localObject4);
        }
      }
    }
  }
  
  private int getPreferredHeight()
  {
    return getContext().getResources().getDimensionPixelSize(a.d.abc_search_view_preferred_height);
  }
  
  private int getPreferredWidth()
  {
    return getContext().getResources().getDimensionPixelSize(a.d.abc_search_view_preferred_width);
  }
  
  private boolean is()
  {
    return ((this.ajA) || (this.ajE)) && (!this.ajy);
  }
  
  private void it()
  {
    int j = 8;
    int i = j;
    if (is()) {
      if (this.ajc.getVisibility() != 0)
      {
        i = j;
        if (this.aje.getVisibility() != 0) {}
      }
      else
      {
        i = 0;
      }
    }
    this.aja.setVisibility(i);
  }
  
  private void iu()
  {
    int m = 1;
    int k = 0;
    int i;
    int j;
    label44:
    label56:
    Drawable localDrawable;
    if (!TextUtils.isEmpty(this.aiX.getText()))
    {
      i = 1;
      j = m;
      if (i == 0)
      {
        if ((!this.ajx) || (this.ajH)) {
          break label99;
        }
        j = m;
      }
      localObject = this.ajd;
      if (j == 0) {
        break label104;
      }
      j = k;
      ((ImageView)localObject).setVisibility(j);
      localDrawable = this.ajd.getDrawable();
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
  
  private void iv()
  {
    post(this.ajM);
  }
  
  private void ix()
  {
    Object localObject2 = getQueryHint();
    SearchView.SearchAutoComplete localSearchAutoComplete = this.aiX;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject2 = localObject1;
    if (this.ajx)
    {
      if (this.ajm != null) {
        break label46;
      }
      localObject2 = localObject1;
    }
    for (;;)
    {
      localSearchAutoComplete.setHint((CharSequence)localObject2);
      return;
      label46:
      int i = (int)(this.aiX.getTextSize() * 1.25D);
      this.ajm.setBounds(0, 0, i, i);
      localObject2 = new SpannableStringBuilder("   ");
      ((SpannableStringBuilder)localObject2).setSpan(new ImageSpan(this.ajm), 1, 2, 33);
      ((SpannableStringBuilder)localObject2).append((CharSequence)localObject1);
    }
  }
  
  final void R(String paramString)
  {
    paramString = a("android.intent.action.SEARCH", null, null, paramString);
    getContext().startActivity(paramString);
  }
  
  final boolean b(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.ajJ == null) {}
    do
    {
      do
      {
        return false;
      } while ((this.ajz == null) || (paramKeyEvent.getAction() != 0) || (!paramKeyEvent.hasNoModifiers()));
      if ((paramInt == 66) || (paramInt == 84) || (paramInt == 61)) {
        return cb(this.aiX.getListSelection());
      }
      if ((paramInt == 21) || (paramInt == 22))
      {
        if (paramInt == 21) {}
        for (paramInt = 0;; paramInt = this.aiX.length())
        {
          this.aiX.setSelection(paramInt);
          this.aiX.setListSelection(0);
          this.aiX.clearListSelection();
          ajL.a(this.aiX);
          return true;
        }
      }
    } while ((paramInt != 19) || (this.aiX.getListSelection() != 0));
    return false;
  }
  
  final boolean cb(int paramInt)
  {
    boolean bool = false;
    Object localObject;
    if ((this.ajv == null) || (!this.ajv.iF()))
    {
      localObject = this.ajz.JM;
      if ((localObject != null) && (((Cursor)localObject).moveToPosition(paramInt)))
      {
        localObject = b((Cursor)localObject);
        if (localObject == null) {}
      }
    }
    try
    {
      getContext().startActivity((Intent)localObject);
      SearchView.SearchAutoComplete.a(this.aiX, false);
      this.aiX.dismissDropDown();
      bool = true;
      return bool;
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        new StringBuilder("Failed launch activity: ").append(localObject);
      }
    }
  }
  
  public void clearFocus()
  {
    this.ajD = true;
    super.clearFocus();
    this.aiX.clearFocus();
    SearchView.SearchAutoComplete.a(this.aiX, false);
    this.ajD = false;
  }
  
  public int getImeOptions()
  {
    return this.aiX.getImeOptions();
  }
  
  public int getInputType()
  {
    return this.aiX.getInputType();
  }
  
  public int getMaxWidth()
  {
    return this.eg;
  }
  
  public CharSequence getQuery()
  {
    return this.aiX.getText();
  }
  
  public CharSequence getQueryHint()
  {
    if (this.ajB != null) {
      return this.ajB;
    }
    if ((this.ajJ != null) && (this.ajJ.getHintId() != 0)) {
      return getContext().getText(this.ajJ.getHintId());
    }
    return this.ajr;
  }
  
  int getSuggestionCommitIconResId()
  {
    return this.ajo;
  }
  
  int getSuggestionRowLayout()
  {
    return this.ajn;
  }
  
  public f getSuggestionsAdapter()
  {
    return this.ajz;
  }
  
  final void iA()
  {
    ai(false);
    this.aiX.requestFocus();
    SearchView.SearchAutoComplete.a(this.aiX, true);
    if (this.ajw != null) {
      this.ajw.onClick(this);
    }
  }
  
  final void iB()
  {
    ai(this.ajy);
    iv();
    if (this.aiX.hasFocus()) {
      iC();
    }
  }
  
  final void iC()
  {
    SearchView.a locala = ajL;
    SearchView.SearchAutoComplete localSearchAutoComplete = this.aiX;
    if (locala.ajU != null) {}
    try
    {
      locala.ajU.invoke(localSearchAutoComplete, new Object[0]);
      label29:
      locala = ajL;
      localSearchAutoComplete = this.aiX;
      if (locala.ajV != null) {}
      try
      {
        locala.ajV.invoke(localSearchAutoComplete, new Object[0]);
        return;
      }
      catch (Exception localException1) {}
    }
    catch (Exception localException2)
    {
      break label29;
    }
  }
  
  final void iw()
  {
    if (this.aiX.hasFocus()) {}
    for (int[] arrayOfInt = FOCUSED_STATE_SET;; arrayOfInt = EMPTY_STATE_SET)
    {
      Drawable localDrawable = this.aiZ.getBackground();
      if (localDrawable != null) {
        localDrawable.setState(arrayOfInt);
      }
      localDrawable = this.aja.getBackground();
      if (localDrawable != null) {
        localDrawable.setState(arrayOfInt);
      }
      invalidate();
      return;
    }
  }
  
  final void iy()
  {
    Editable localEditable = this.aiX.getText();
    if ((localEditable != null) && (TextUtils.getTrimmedLength(localEditable) > 0)) {
      if (this.ajs != null)
      {
        c localc = this.ajs;
        localEditable.toString();
        if (localc.iD()) {}
      }
      else
      {
        if (this.ajJ != null) {
          R(localEditable.toString());
        }
        SearchView.SearchAutoComplete.a(this.aiX, false);
        this.aiX.dismissDropDown();
      }
    }
  }
  
  final void iz()
  {
    if (TextUtils.isEmpty(this.aiX.getText()))
    {
      if ((this.ajx) && ((this.ajt == null) || (!this.ajt.onClose())))
      {
        clearFocus();
        ai(true);
      }
      return;
    }
    this.aiX.setText("");
    this.aiX.requestFocus();
    SearchView.SearchAutoComplete.a(this.aiX, true);
  }
  
  final void j(CharSequence paramCharSequence)
  {
    boolean bool2 = true;
    Editable localEditable = this.aiX.getText();
    this.ajG = localEditable;
    if (!TextUtils.isEmpty(localEditable))
    {
      bool1 = true;
      aj(bool1);
      if (bool1) {
        break label92;
      }
    }
    label92:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ak(bool1);
      iu();
      it();
      if ((this.ajs != null) && (!TextUtils.equals(paramCharSequence, this.ajF))) {
        paramCharSequence.toString();
      }
      this.ajF = paramCharSequence.toString();
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void onActionViewCollapsed()
  {
    this.aiX.setText("");
    this.aiX.setSelection(this.aiX.length());
    this.ajG = "";
    clearFocus();
    ai(true);
    this.aiX.setImeOptions(this.ajI);
    this.ajH = false;
  }
  
  public final void onActionViewExpanded()
  {
    if (this.ajH) {
      return;
    }
    this.ajH = true;
    this.ajI = this.aiX.getImeOptions();
    this.aiX.setImeOptions(this.ajI | 0x2000000);
    this.aiX.setText("");
    setIconified(false);
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.ajM);
    post(this.ajN);
    super.onDetachedFromWindow();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      SearchView.SearchAutoComplete localSearchAutoComplete = this.aiX;
      Rect localRect = this.ajh;
      localSearchAutoComplete.getLocationInWindow(this.ajj);
      getLocationInWindow(this.ajk);
      paramInt1 = this.ajj[1] - this.ajk[1];
      paramInt3 = this.ajj[0] - this.ajk[0];
      localRect.set(paramInt3, paramInt1, localSearchAutoComplete.getWidth() + paramInt3, localSearchAutoComplete.getHeight() + paramInt1);
      this.aji.set(this.ajh.left, 0, this.ajh.right, paramInt4 - paramInt2);
      if (this.ajg == null)
      {
        this.ajg = new e(this.aji, this.ajh, this.aiX);
        setTouchDelegate(this.ajg);
      }
    }
    else
    {
      return;
    }
    this.ajg.c(this.aji, this.ajh);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.ajy)
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
      if (this.eg > 0)
      {
        paramInt1 = Math.min(this.eg, i);
        break;
      }
      paramInt1 = Math.min(getPreferredWidth(), i);
      break;
      paramInt1 = i;
      if (this.eg <= 0) {
        break;
      }
      paramInt1 = Math.min(this.eg, i);
      break;
      if (this.eg > 0)
      {
        paramInt1 = this.eg;
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
    super.onRestoreInstanceState(paramParcelable.EA);
    ai(paramParcelable.ajX);
    requestLayout();
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SearchView.SavedState localSavedState = new SearchView.SavedState(super.onSaveInstanceState());
    localSavedState.ajX = this.ajy;
    return localSavedState;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    iv();
  }
  
  public boolean requestFocus(int paramInt, Rect paramRect)
  {
    if (this.ajD) {}
    while (!isFocusable()) {
      return false;
    }
    if (!this.ajy)
    {
      boolean bool = this.aiX.requestFocus(paramInt, paramRect);
      if (bool) {
        ai(false);
      }
      return bool;
    }
    return super.requestFocus(paramInt, paramRect);
  }
  
  public void setAppSearchData(Bundle paramBundle)
  {
    this.ajK = paramBundle;
  }
  
  public void setIconified(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      iz();
      return;
    }
    iA();
  }
  
  public void setIconifiedByDefault(boolean paramBoolean)
  {
    if (this.ajx == paramBoolean) {
      return;
    }
    this.ajx = paramBoolean;
    ai(paramBoolean);
    ix();
  }
  
  public void setImeOptions(int paramInt)
  {
    this.aiX.setImeOptions(paramInt);
  }
  
  public void setInputType(int paramInt)
  {
    this.aiX.setInputType(paramInt);
  }
  
  public void setMaxWidth(int paramInt)
  {
    this.eg = paramInt;
    requestLayout();
  }
  
  public void setOnCloseListener(SearchView.b paramb)
  {
    this.ajt = paramb;
  }
  
  public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.aju = paramOnFocusChangeListener;
  }
  
  public void setOnQueryTextListener(c paramc)
  {
    this.ajs = paramc;
  }
  
  public void setOnSearchClickListener(View.OnClickListener paramOnClickListener)
  {
    this.ajw = paramOnClickListener;
  }
  
  public void setOnSuggestionListener(SearchView.d paramd)
  {
    this.ajv = paramd;
  }
  
  void setQuery(CharSequence paramCharSequence)
  {
    this.aiX.setText(paramCharSequence);
    SearchView.SearchAutoComplete localSearchAutoComplete = this.aiX;
    if (TextUtils.isEmpty(paramCharSequence)) {}
    for (int i = 0;; i = paramCharSequence.length())
    {
      localSearchAutoComplete.setSelection(i);
      return;
    }
  }
  
  public void setQueryHint(CharSequence paramCharSequence)
  {
    this.ajB = paramCharSequence;
    ix();
  }
  
  public void setQueryRefinementEnabled(boolean paramBoolean)
  {
    this.ajC = paramBoolean;
    as localas;
    if ((this.ajz instanceof as))
    {
      localas = (as)this.ajz;
      if (!paramBoolean) {
        break label35;
      }
    }
    label35:
    for (int i = 2;; i = 1)
    {
      localas.akU = i;
      return;
    }
  }
  
  public void setSearchableInfo(SearchableInfo paramSearchableInfo)
  {
    boolean bool = true;
    this.ajJ = paramSearchableInfo;
    int i;
    if (this.ajJ != null)
    {
      this.aiX.setThreshold(this.ajJ.getSuggestThreshold());
      this.aiX.setImeOptions(this.ajJ.getImeOptions());
      int j = this.ajJ.getInputType();
      i = j;
      if ((j & 0xF) == 1)
      {
        j &= 0xFFFEFFFF;
        i = j;
        if (this.ajJ.getSuggestAuthority() != null) {
          i = j | 0x10000 | 0x80000;
        }
      }
      this.aiX.setInputType(i);
      if (this.ajz != null) {
        this.ajz.changeCursor(null);
      }
      if (this.ajJ.getSuggestAuthority() != null)
      {
        this.ajz = new as(getContext(), this, this.ajJ, this.ajO);
        this.aiX.setAdapter(this.ajz);
        paramSearchableInfo = (as)this.ajz;
        if (this.ajC)
        {
          i = 2;
          paramSearchableInfo.akU = i;
        }
      }
      else
      {
        ix();
      }
    }
    else
    {
      if ((this.ajJ == null) || (!this.ajJ.getVoiceSearchEnabled())) {
        break label297;
      }
      if (!this.ajJ.getVoiceSearchLaunchWebSearch()) {
        break label273;
      }
      paramSearchableInfo = this.ajp;
    }
    for (;;)
    {
      label215:
      if (paramSearchableInfo != null) {
        if (getContext().getPackageManager().resolveActivity(paramSearchableInfo, 65536) == null) {}
      }
      for (;;)
      {
        this.ajE = bool;
        if (this.ajE) {
          this.aiX.setPrivateImeOptions("nm");
        }
        ai(this.ajy);
        return;
        i = 1;
        break;
        label273:
        if (!this.ajJ.getVoiceSearchLaunchRecognizer()) {
          break label303;
        }
        paramSearchableInfo = this.ajq;
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
    this.ajA = paramBoolean;
    ai(this.ajy);
  }
  
  public void setSuggestionsAdapter(f paramf)
  {
    this.ajz = paramf;
    this.aiX.setAdapter(this.ajz);
  }
  
  public static abstract interface c
  {
    public abstract boolean iD();
  }
  
  private static final class e
    extends TouchDelegate
  {
    private final View akc;
    private final Rect akd;
    private final Rect ake;
    private final Rect akf;
    private final int akg;
    private boolean akh;
    
    public e(Rect paramRect1, Rect paramRect2, View paramView)
    {
      super(paramView);
      this.akg = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
      this.akd = new Rect();
      this.akf = new Rect();
      this.ake = new Rect();
      c(paramRect1, paramRect2);
      this.akc = paramView;
    }
    
    public final void c(Rect paramRect1, Rect paramRect2)
    {
      this.akd.set(paramRect1);
      this.akf.set(paramRect1);
      this.akf.inset(-this.akg, -this.akg);
      this.ake.set(paramRect2);
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
          if ((i == 0) || (this.ake.contains(j, k))) {
            break label203;
          }
          paramMotionEvent.setLocation(this.akc.getWidth() / 2, this.akc.getHeight() / 2);
        }
        break;
      }
      for (;;)
      {
        bool2 = this.akc.dispatchTouchEvent(paramMotionEvent);
        return bool2;
        if (!this.akd.contains(j, k)) {
          break;
        }
        this.akh = true;
        i = 1;
        bool1 = true;
        break label57;
        bool2 = this.akh;
        bool1 = bool2;
        if (bool2)
        {
          bool1 = bool2;
          if (!this.akf.contains(j, k))
          {
            i = 0;
            bool1 = bool2;
            break label57;
            bool1 = this.akh;
            this.akh = false;
          }
        }
        i = 1;
        break label57;
        label203:
        paramMotionEvent.setLocation(j - this.ake.left, k - this.ake.top);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.v7.widget.SearchView
 * JD-Core Version:    0.7.0.1
 */