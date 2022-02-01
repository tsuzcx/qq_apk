package com.tencent.mm.plugin.emojicapture.ui.editor;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowInsets;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.a.c;
import com.tencent.mm.plugin.emojicapture.a.d;
import com.tencent.mm.plugin.emojicapture.a.f;
import com.tencent.mm.plugin.emojicapture.a.g;
import com.tencent.mm.plugin.emojicapture.a.i;
import com.tencent.mm.plugin.emojicapture.c.c.a;
import com.tencent.mm.plugin.recordvideo.ui.editor.c.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "clearActive", "Ljava/lang/Runnable;", "currActiveItem", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/IEditorItemView;", "deleteEnalbe", "", "getDeleteEnalbe", "()Z", "setDeleteEnalbe", "(Z)V", "deleteView", "Landroid/widget/TextView;", "deletingItem", "editorMask", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorOutsideView;", "itemLayout", "Landroid/view/ViewGroup;", "stateChangeListener", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer$OnStateChangeListener;", "getStateChangeListener", "()Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer$OnStateChangeListener;", "setStateChangeListener", "(Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer$OnStateChangeListener;)V", "tasksAfterSizeValid", "Ljava/util/LinkedList;", "validAreaView", "Landroid/view/View;", "validRect", "Landroid/graphics/RectF;", "activeDeleteView", "", "active", "addEditorItem", "itemView", "touchMatrix", "Landroid/graphics/Matrix;", "createTextItem", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/TextEditorItemView;", "deleteCheck", "event", "Landroid/view/MotionEvent;", "getAllEmojiMd5", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getAllItemViews", "", "getAttachedText", "getTextItem", "getValidRect", "handleItemTouch", "onApplyWindowInsets", "Landroid/view/WindowInsets;", "insets", "onInterceptTouchEvent", "ev", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "pause", "postOnSizeValid", "r", "removeAllItems", "requestEditing", "editing", "resume", "setEditing", "toggleDeleteView", "show", "Companion", "OnStateChangeListener", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class EditorItemContainer
  extends RelativeLayout
{
  public static final EditorItemContainer.a ymq;
  private final String TAG;
  private View ykZ;
  private final LinkedList<Runnable> ymA;
  private TextView ymr;
  public final ViewGroup yms;
  public final EditorOutsideView ymt;
  private b ymu;
  private boolean ymv;
  private final RectF ymw;
  private a ymx;
  private Runnable ymy;
  private a ymz;
  
  static
  {
    AppMethodBeat.i(762);
    ymq = new EditorItemContainer.a((byte)0);
    AppMethodBeat.o(762);
  }
  
  public EditorItemContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(761);
    AppMethodBeat.o(761);
  }
  
  public EditorItemContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(760);
    this.TAG = "MicroMsg.EditorItemContainer";
    this.ymv = true;
    this.ymw = new RectF();
    this.ymy = new EditorItemContainer..ExternalSyntheticLambda2(this);
    this.ymA = new LinkedList();
    View.inflate(paramContext, a.g.yey, (ViewGroup)this);
    paramAttributeSet = findViewById(a.f.yew);
    s.s(paramAttributeSet, "findViewById(R.id.editor_valid_area)");
    this.ykZ = paramAttributeSet;
    paramAttributeSet = findViewById(a.f.editor_delete_view);
    s.s(paramAttributeSet, "findViewById(R.id.editor_delete_view)");
    this.ymr = ((TextView)paramAttributeSet);
    this.ymr.setTextColor(getResources().getColor(a.c.ydQ));
    paramAttributeSet = findViewById(a.f.yez);
    s.s(paramAttributeSet, "findViewById(R.id.emoji_capture_editor_layout)");
    this.yms = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(a.f.yeA);
    s.s(paramAttributeSet, "findViewById(R.id.emoji_capture_editor_mask)");
    this.ymt = ((EditorOutsideView)paramAttributeSet);
    ay(new EditorItemContainer..ExternalSyntheticLambda3(this, paramContext));
    AppMethodBeat.o(760);
  }
  
  private static final void a(EditorItemContainer paramEditorItemContainer)
  {
    AppMethodBeat.i(269508);
    s.u(paramEditorItemContainer, "this$0");
    if (paramEditorItemContainer.ymx != null)
    {
      a locala = paramEditorItemContainer.ymx;
      s.checkNotNull(locala);
      paramEditorItemContainer.a(locala, false);
    }
    AppMethodBeat.o(269508);
  }
  
  private static final void a(EditorItemContainer paramEditorItemContainer, Context paramContext)
  {
    AppMethodBeat.i(269513);
    s.u(paramEditorItemContainer, "this$0");
    s.u(paramContext, "$context");
    paramEditorItemContainer.ymt.a(paramEditorItemContainer.getValidRect(), paramContext.getResources().getDimension(a.d.yea));
    AppMethodBeat.o(269513);
  }
  
  private static final void a(EditorItemContainer paramEditorItemContainer, a parama, Matrix paramMatrix)
  {
    AppMethodBeat.i(269518);
    s.u(paramEditorItemContainer, "this$0");
    s.u(parama, "$itemView");
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    paramEditorItemContainer.yms.addView((View)parama, (ViewGroup.LayoutParams)localLayoutParams);
    parama.a(paramEditorItemContainer.getValidRect(), paramEditorItemContainer.getContext().getResources().getDimension(a.d.yea));
    paramEditorItemContainer.setEditing(parama);
    paramEditorItemContainer.yms.bringChildToFront((View)paramEditorItemContainer.getTextItem());
    if ((paramMatrix != null) && ((parama instanceof EmojiEditorItemView)))
    {
      paramEditorItemContainer = (EmojiEditorItemView)parama;
      s.u(paramMatrix, "m");
      paramEditorItemContainer.ymD.getTouchTracker().matrix.set(paramMatrix);
    }
    AppMethodBeat.o(269518);
  }
  
  private void a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(755);
    s.u(parama, "itemView");
    if (paramBoolean) {
      if (!s.p(parama, this.ymx))
      {
        a locala = this.ymx;
        if (locala != null) {
          locala.setEditing(false);
        }
        this.ymx = parama;
      }
    }
    for (;;)
    {
      parama.setEditing(paramBoolean);
      AppMethodBeat.o(755);
      return;
      if (s.p(parama, this.ymx)) {
        this.ymx = null;
      }
    }
  }
  
  private static final void b(EditorItemContainer paramEditorItemContainer)
  {
    AppMethodBeat.i(269521);
    s.u(paramEditorItemContainer, "this$0");
    if (paramEditorItemContainer.ymz != null)
    {
      Object localObject = paramEditorItemContainer.ymz;
      s.checkNotNull(localObject);
      if (!((a)localObject).dEQ())
      {
        localObject = paramEditorItemContainer.yms;
        a locala = paramEditorItemContainer.ymz;
        if (locala == null)
        {
          paramEditorItemContainer = new NullPointerException("null cannot be cast to non-null type android.view.View");
          AppMethodBeat.o(269521);
          throw paramEditorItemContainer;
        }
        ((ViewGroup)localObject).removeView((View)locala);
      }
    }
    paramEditorItemContainer.ymz = null;
    paramEditorItemContainer.ymx = null;
    AppMethodBeat.o(269521);
  }
  
  private static final void c(EditorItemContainer paramEditorItemContainer)
  {
    AppMethodBeat.i(269527);
    s.u(paramEditorItemContainer, "this$0");
    paramEditorItemContainer.getValidRect();
    if (!paramEditorItemContainer.ymw.isEmpty())
    {
      paramEditorItemContainer = ((Iterable)paramEditorItemContainer.ymA).iterator();
      while (paramEditorItemContainer.hasNext()) {
        ((Runnable)paramEditorItemContainer.next()).run();
      }
    }
    AppMethodBeat.o(269527);
  }
  
  private final void ow(boolean paramBoolean)
  {
    AppMethodBeat.i(757);
    Object localObject = this.ymr;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      ((TextView)localObject).setVisibility(i);
      if (this.ymu != null)
      {
        localObject = this.ymu;
        s.checkNotNull(localObject);
        ((b)localObject).iQ(paramBoolean);
      }
      AppMethodBeat.o(757);
      return;
    }
  }
  
  private final void ox(boolean paramBoolean)
  {
    AppMethodBeat.i(758);
    this.ymr.setActivated(paramBoolean);
    if (paramBoolean)
    {
      this.ymr.setText(a.i.editor_item_release_to_delete);
      AppMethodBeat.o(758);
      return;
    }
    this.ymr.setText(a.i.editor_item_drag_to_delete);
    AppMethodBeat.o(758);
  }
  
  public final void a(a parama, Matrix paramMatrix)
  {
    AppMethodBeat.i(741);
    s.u(parama, "itemView");
    ay(new EditorItemContainer..ExternalSyntheticLambda4(this, parama, paramMatrix));
    AppMethodBeat.o(741);
  }
  
  public final void a(a parama, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(743);
    s.u(parama, "itemView");
    s.u(paramMotionEvent, "event");
    int k;
    int i;
    float f;
    label108:
    int j;
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        AppMethodBeat.o(743);
        return;
        removeCallbacks(this.ymy);
        a(parama, true);
        AppMethodBeat.o(743);
        return;
      } while (!this.ymv);
      k = paramMotionEvent.getPointerCount();
      if (k > 0)
      {
        i = 0;
        f = 0.0F;
        j = i + 1;
        f += paramMotionEvent.getY(i);
        if (j < k) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      if (f / k > this.ymr.getTop())
      {
        i = 1;
        if (i == 0) {
          break label190;
        }
        ox(true);
        if (this.ymz == null) {
          this.ymz = parama;
        }
      }
      for (;;)
      {
        ow(true);
        AppMethodBeat.o(743);
        return;
        i = 0;
        break;
        label190:
        ox(false);
        if (this.ymz != null) {
          this.ymz = null;
        }
      }
      this.yms.bringChildToFront((View)getTextItem());
      if (this.ymz != null) {
        post(new EditorItemContainer..ExternalSyntheticLambda1(this));
      }
      for (;;)
      {
        ow(false);
        break;
        if (this.ymx != null) {
          postDelayed(this.ymy, 1500L);
        }
      }
      i = j;
      break label108;
      f = 0.0F;
    }
  }
  
  public final void ay(Runnable paramRunnable)
  {
    AppMethodBeat.i(756);
    s.u(paramRunnable, "r");
    if (!this.ymw.isEmpty())
    {
      paramRunnable.run();
      AppMethodBeat.o(756);
      return;
    }
    this.ymA.add(paramRunnable);
    AppMethodBeat.o(756);
  }
  
  public final ArrayList<String> getAllEmojiMd5()
  {
    AppMethodBeat.i(749);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int k = this.yms.getChildCount();
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      Object localObject = this.yms.getChildAt(i);
      if ((localObject instanceof EmojiEditorItemView))
      {
        localObject = ((EmojiEditorItemView)localObject).getEmojiInfo();
        if (localObject != null)
        {
          localObject = ((EmojiInfo)localObject).getMd5();
          if (localObject != null) {
            localArrayList.add(localObject);
          }
        }
      }
      if (j >= k)
      {
        AppMethodBeat.o(749);
        return localArrayList;
      }
      i = j;
    }
  }
  
  public final List<a> getAllItemViews()
  {
    AppMethodBeat.i(750);
    List localList = (List)new ArrayList();
    int i = 0;
    int k = this.yms.getChildCount();
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      View localView = this.yms.getChildAt(i);
      if ((localView instanceof a)) {
        localList.add(localView);
      }
      if (j >= k)
      {
        AppMethodBeat.o(750);
        return localList;
      }
      i = j;
    }
  }
  
  public final String getAttachedText()
  {
    AppMethodBeat.i(748);
    Object localObject = getTextItem();
    if (localObject == null)
    {
      AppMethodBeat.o(748);
      return null;
    }
    if (((TextEditorItemView)localObject).getText() == null)
    {
      AppMethodBeat.o(748);
      return null;
    }
    localObject = String.valueOf(((TextEditorItemView)localObject).getText());
    AppMethodBeat.o(748);
    return localObject;
  }
  
  public final boolean getDeleteEnalbe()
  {
    return this.ymv;
  }
  
  public final b getStateChangeListener()
  {
    return this.ymu;
  }
  
  public final TextEditorItemView getTextItem()
  {
    AppMethodBeat.i(747);
    int i = 0;
    int k = this.yms.getChildCount();
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      Object localObject = this.yms.getChildAt(i);
      if ((localObject instanceof TextEditorItemView))
      {
        localObject = (TextEditorItemView)localObject;
        AppMethodBeat.o(747);
        return localObject;
      }
      if (j >= k)
      {
        AppMethodBeat.o(747);
        return null;
      }
      i = j;
    }
  }
  
  public final RectF getValidRect()
  {
    AppMethodBeat.i(753);
    this.ymw.set(this.ykZ.getLeft(), this.ykZ.getTop(), this.ykZ.getRight(), this.ykZ.getBottom());
    RectF localRectF = this.ymw;
    AppMethodBeat.o(753);
    return localRectF;
  }
  
  public final WindowInsets onApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    AppMethodBeat.i(269600);
    if (paramWindowInsets == null)
    {
      paramWindowInsets = super.onApplyWindowInsets(paramWindowInsets);
      s.s(paramWindowInsets, "super.onApplyWindowInsets(insets)");
      AppMethodBeat.o(269600);
      return paramWindowInsets;
    }
    Object localObject = this.ykZ.getLayoutParams();
    String str;
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      str = this.TAG;
      if (localObject == null) {
        break label138;
      }
    }
    label138:
    for (boolean bool = true;; bool = false)
    {
      Log.i(str, s.X("onApplyWindowInsets: ", Boolean.valueOf(bool)));
      if (localObject != null)
      {
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = (getResources().getDimensionPixelSize(a.d.yee) + paramWindowInsets.getSystemWindowInsetTop());
        this.ykZ.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      paramWindowInsets = super.onApplyWindowInsets(paramWindowInsets);
      s.s(paramWindowInsets, "super.onApplyWindowInsets(insets)");
      AppMethodBeat.o(269600);
      return paramWindowInsets;
      localObject = null;
      break;
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(744);
    s.u(paramMotionEvent, "ev");
    if ((paramMotionEvent.getActionMasked() == 0) && (!this.ymw.contains(paramMotionEvent.getX(), paramMotionEvent.getY())))
    {
      AppMethodBeat.o(744);
      return true;
    }
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(744);
    return bool;
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(746);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4)) {
      post(new EditorItemContainer..ExternalSyntheticLambda0(this));
    }
    AppMethodBeat.o(746);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(745);
    int i;
    if ((paramMotionEvent != null) && (paramMotionEvent.getActionMasked() == 0)) {
      i = 1;
    }
    while (i != 0) {
      if (!this.ymw.contains(paramMotionEvent.getX(), paramMotionEvent.getY()))
      {
        AppMethodBeat.o(745);
        return false;
        i = 0;
      }
      else if (this.ymx != null)
      {
        a locala = this.ymx;
        s.checkNotNull(locala);
        a(locala, false);
      }
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(745);
    return bool;
  }
  
  public final void pause()
  {
    AppMethodBeat.i(752);
    int i = 0;
    int k = this.yms.getChildCount();
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      View localView = this.yms.getChildAt(i);
      if ((localView instanceof a)) {
        ((a)localView).pause();
      }
      if (j >= k)
      {
        AppMethodBeat.o(752);
        return;
      }
      i = j;
    }
  }
  
  public final void resume()
  {
    AppMethodBeat.i(751);
    int i = 0;
    int k = this.yms.getChildCount();
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      View localView = this.yms.getChildAt(i);
      if ((localView instanceof a)) {
        ((a)localView).resume();
      }
      if (j >= k)
      {
        AppMethodBeat.o(751);
        return;
      }
      i = j;
    }
  }
  
  public final void setDeleteEnalbe(boolean paramBoolean)
  {
    this.ymv = paramBoolean;
  }
  
  public final void setEditing(a parama)
  {
    AppMethodBeat.i(754);
    s.u(parama, "itemView");
    removeCallbacks(this.ymy);
    a(parama, true);
    postDelayed(this.ymy, 1500L);
    AppMethodBeat.o(754);
  }
  
  public final void setStateChangeListener(b paramb)
  {
    this.ymu = paramb;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer$OnStateChangeListener;", "", "onStateChange", "", "showDelete", "", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void iQ(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer
 * JD-Core Version:    0.7.0.1
 */