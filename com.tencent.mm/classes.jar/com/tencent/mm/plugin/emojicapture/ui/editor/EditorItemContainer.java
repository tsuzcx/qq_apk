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
import com.tencent.mm.plugin.emojicapture.c.c.a;
import com.tencent.mm.plugin.recordvideo.ui.editor.c.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "clearActive", "Ljava/lang/Runnable;", "currActiveItem", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/IEditorItemView;", "deleteEnalbe", "", "getDeleteEnalbe", "()Z", "setDeleteEnalbe", "(Z)V", "deleteView", "Landroid/widget/TextView;", "deletingItem", "editorMask", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorOutsideView;", "itemLayout", "Landroid/view/ViewGroup;", "stateChangeListener", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer$OnStateChangeListener;", "getStateChangeListener", "()Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer$OnStateChangeListener;", "setStateChangeListener", "(Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer$OnStateChangeListener;)V", "tasksAfterSizeValid", "Ljava/util/LinkedList;", "validAreaView", "Landroid/view/View;", "validRect", "Landroid/graphics/RectF;", "activeDeleteView", "", "active", "addEditorItem", "itemView", "touchMatrix", "Landroid/graphics/Matrix;", "createTextItem", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/TextEditorItemView;", "deleteCheck", "event", "Landroid/view/MotionEvent;", "getAllEmojiMd5", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getAllItemViews", "", "getAttachedText", "getTextItem", "getValidRect", "handleItemTouch", "onApplyWindowInsets", "Landroid/view/WindowInsets;", "insets", "onInterceptTouchEvent", "ev", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "pause", "postOnSizeValid", "r", "removeAllItems", "requestEditing", "editing", "resume", "setEditing", "toggleDeleteView", "show", "Companion", "OnStateChangeListener", "plugin-emojicapture_release"})
public final class EditorItemContainer
  extends RelativeLayout
{
  public static final EditorItemContainer.a ruW;
  private final String TAG;
  private View ruL;
  private TextView ruM;
  public final ViewGroup ruN;
  public final EditorOutsideView ruO;
  private b ruP;
  private boolean ruQ;
  private final RectF ruR;
  private a ruS;
  private Runnable ruT;
  private a ruU;
  private final LinkedList<Runnable> ruV;
  
  static
  {
    AppMethodBeat.i(762);
    ruW = new EditorItemContainer.a((byte)0);
    AppMethodBeat.o(762);
  }
  
  public EditorItemContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(761);
    AppMethodBeat.o(761);
  }
  
  public EditorItemContainer(final Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(760);
    this.TAG = "MicroMsg.EditorItemContainer";
    this.ruQ = true;
    this.ruR = new RectF();
    this.ruT = ((Runnable)new d(this));
    this.ruV = new LinkedList();
    View.inflate(paramContext, 2131493903, (ViewGroup)this);
    paramAttributeSet = findViewById(2131299908);
    p.g(paramAttributeSet, "findViewById(R.id.editor_valid_area)");
    this.ruL = paramAttributeSet;
    paramAttributeSet = findViewById(2131299880);
    p.g(paramAttributeSet, "findViewById(R.id.editor_delete_view)");
    this.ruM = ((TextView)paramAttributeSet);
    this.ruM.setTextColor(getResources().getColor(2131100301));
    paramAttributeSet = findViewById(2131299948);
    p.g(paramAttributeSet, "findViewById(R.id.emoji_capture_editor_layout)");
    this.ruN = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131299949);
    p.g(paramAttributeSet, "findViewById(R.id.emoji_capture_editor_mask)");
    this.ruO = ((EditorOutsideView)paramAttributeSet);
    al((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(736);
        EditorItemContainer.h(this.ruX).a(this.ruX.getValidRect(), paramContext.getResources().getDimension(2131166247));
        AppMethodBeat.o(736);
      }
    });
    AppMethodBeat.o(760);
  }
  
  private final boolean b(a parama, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(759);
    int j = paramMotionEvent.getPointerCount();
    float f = 0.0F;
    int i = 0;
    while (i < j)
    {
      f += paramMotionEvent.getY(i);
      i += 1;
    }
    boolean bool;
    if (f / j > this.ruM.getTop())
    {
      bool = true;
      if (!bool) {
        break label99;
      }
      lN(true);
      if (this.ruU == null) {
        this.ruU = parama;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(759);
      return bool;
      bool = false;
      break;
      label99:
      lN(false);
      if (this.ruU != null) {
        this.ruU = null;
      }
    }
  }
  
  private final void lM(boolean paramBoolean)
  {
    AppMethodBeat.i(757);
    Object localObject = this.ruM;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      ((TextView)localObject).setVisibility(i);
      if (this.ruP != null)
      {
        localObject = this.ruP;
        if (localObject == null) {
          p.hyc();
        }
        ((b)localObject).lL(paramBoolean);
      }
      AppMethodBeat.o(757);
      return;
    }
  }
  
  private final void lN(boolean paramBoolean)
  {
    AppMethodBeat.i(758);
    this.ruM.setActivated(paramBoolean);
    if (paramBoolean)
    {
      this.ruM.setText(2131758472);
      AppMethodBeat.o(758);
      return;
    }
    this.ruM.setText(2131758471);
    AppMethodBeat.o(758);
  }
  
  public final void a(final a parama, final Matrix paramMatrix)
  {
    AppMethodBeat.i(741);
    p.h(parama, "itemView");
    al((Runnable)new c(this, parama, paramMatrix));
    AppMethodBeat.o(741);
  }
  
  public final void a(a parama, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(743);
    p.h(parama, "itemView");
    p.h(paramMotionEvent, "event");
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        AppMethodBeat.o(743);
        return;
        removeCallbacks(this.ruT);
        a(parama, true);
        AppMethodBeat.o(743);
        return;
      } while (!this.ruQ);
      b(parama, paramMotionEvent);
      lM(true);
      AppMethodBeat.o(743);
      return;
    }
    this.ruN.bringChildToFront((View)getTextItem());
    if (this.ruU != null) {
      post((Runnable)new e(this));
    }
    for (;;)
    {
      lM(false);
      break;
      if (this.ruS != null) {
        postDelayed(this.ruT, 1500L);
      }
    }
  }
  
  public final void a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(755);
    p.h(parama, "itemView");
    if (paramBoolean) {
      if ((p.j(parama, this.ruS) ^ true))
      {
        a locala = this.ruS;
        if (locala != null) {
          locala.setEditing(false);
        }
        this.ruS = parama;
      }
    }
    for (;;)
    {
      parama.setEditing(paramBoolean);
      AppMethodBeat.o(755);
      return;
      if (p.j(parama, this.ruS)) {
        this.ruS = null;
      }
    }
  }
  
  public final void al(Runnable paramRunnable)
  {
    AppMethodBeat.i(756);
    p.h(paramRunnable, "r");
    if (!this.ruR.isEmpty())
    {
      paramRunnable.run();
      AppMethodBeat.o(756);
      return;
    }
    this.ruV.add(paramRunnable);
    AppMethodBeat.o(756);
  }
  
  public final ArrayList<String> getAllEmojiMd5()
  {
    AppMethodBeat.i(749);
    ArrayList localArrayList = new ArrayList();
    int j = this.ruN.getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = this.ruN.getChildAt(i);
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
      i += 1;
    }
    AppMethodBeat.o(749);
    return localArrayList;
  }
  
  public final List<a> getAllItemViews()
  {
    AppMethodBeat.i(750);
    List localList = (List)new ArrayList();
    int i = 0;
    int j = this.ruN.getChildCount();
    while (i < j)
    {
      View localView = this.ruN.getChildAt(i);
      if ((localView instanceof a)) {
        localList.add(localView);
      }
      i += 1;
    }
    AppMethodBeat.o(750);
    return localList;
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
    return this.ruQ;
  }
  
  public final b getStateChangeListener()
  {
    return this.ruP;
  }
  
  public final TextEditorItemView getTextItem()
  {
    AppMethodBeat.i(747);
    int j = this.ruN.getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = this.ruN.getChildAt(i);
      if ((localObject instanceof TextEditorItemView))
      {
        localObject = (TextEditorItemView)localObject;
        AppMethodBeat.o(747);
        return localObject;
      }
      i += 1;
    }
    AppMethodBeat.o(747);
    return null;
  }
  
  public final RectF getValidRect()
  {
    AppMethodBeat.i(753);
    this.ruR.set(this.ruL.getLeft(), this.ruL.getTop(), this.ruL.getRight(), this.ruL.getBottom());
    RectF localRectF = this.ruR;
    AppMethodBeat.o(753);
    return localRectF;
  }
  
  public final WindowInsets onApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    AppMethodBeat.i(256447);
    if (paramWindowInsets == null)
    {
      paramWindowInsets = super.onApplyWindowInsets(paramWindowInsets);
      p.g(paramWindowInsets, "super.onApplyWindowInsets(insets)");
      AppMethodBeat.o(256447);
      return paramWindowInsets;
    }
    Object localObject2 = this.ruL.getLayoutParams();
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof ViewGroup.MarginLayoutParams)) {
      localObject1 = null;
    }
    localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
    localObject2 = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onApplyWindowInsets: ");
    if (localObject1 != null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i((String)localObject2, bool);
      if (localObject1 != null)
      {
        ((ViewGroup.MarginLayoutParams)localObject1).topMargin = (getResources().getDimensionPixelSize(2131166813) + paramWindowInsets.getSystemWindowInsetTop());
        this.ruL.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      paramWindowInsets = super.onApplyWindowInsets(paramWindowInsets);
      p.g(paramWindowInsets, "super.onApplyWindowInsets(insets)");
      AppMethodBeat.o(256447);
      return paramWindowInsets;
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(744);
    p.h(paramMotionEvent, "ev");
    if ((paramMotionEvent.getActionMasked() == 0) && (!this.ruR.contains(paramMotionEvent.getX(), paramMotionEvent.getY())))
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
      post((Runnable)new f(this));
    }
    AppMethodBeat.o(746);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(745);
    if ((paramMotionEvent != null) && (paramMotionEvent.getActionMasked() == 0))
    {
      if (!this.ruR.contains(paramMotionEvent.getX(), paramMotionEvent.getY()))
      {
        AppMethodBeat.o(745);
        return false;
      }
      if (this.ruS != null)
      {
        a locala = this.ruS;
        if (locala == null) {
          p.hyc();
        }
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
    int j = this.ruN.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.ruN.getChildAt(i);
      if ((localView instanceof a)) {
        ((a)localView).pause();
      }
      i += 1;
    }
    AppMethodBeat.o(752);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(751);
    int j = this.ruN.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.ruN.getChildAt(i);
      if ((localView instanceof a)) {
        ((a)localView).resume();
      }
      i += 1;
    }
    AppMethodBeat.o(751);
  }
  
  public final void setDeleteEnalbe(boolean paramBoolean)
  {
    this.ruQ = paramBoolean;
  }
  
  public final void setEditing(a parama)
  {
    AppMethodBeat.i(754);
    p.h(parama, "itemView");
    removeCallbacks(this.ruT);
    a(parama, true);
    postDelayed(this.ruT, 1500L);
    AppMethodBeat.o(754);
  }
  
  public final void setStateChangeListener(b paramb)
  {
    this.ruP = paramb;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer$OnStateChangeListener;", "", "onStateChange", "", "showDelete", "", "plugin-emojicapture_release"})
  public static abstract interface b
  {
    public abstract void lL(boolean paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(EditorItemContainer paramEditorItemContainer, a parama, Matrix paramMatrix) {}
    
    public final void run()
    {
      AppMethodBeat.i(737);
      Object localObject1 = new RelativeLayout.LayoutParams(-1, -1);
      Object localObject2 = EditorItemContainer.a(this.ruX);
      Object localObject3 = parama;
      if (localObject3 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(737);
        throw ((Throwable)localObject1);
      }
      ((ViewGroup)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject1);
      localObject1 = parama;
      localObject2 = this.ruX.getValidRect();
      localObject3 = this.ruX.getContext();
      p.g(localObject3, "context");
      ((a)localObject1).a((RectF)localObject2, ((Context)localObject3).getResources().getDimension(2131166247));
      this.ruX.setEditing(parama);
      EditorItemContainer.a(this.ruX).bringChildToFront((View)this.ruX.getTextItem());
      if ((paramMatrix != null) && ((parama instanceof EmojiEditorItemView)))
      {
        localObject1 = (EmojiEditorItemView)parama;
        localObject2 = paramMatrix;
        p.h(localObject2, "m");
        ((EmojiEditorItemView)localObject1).rvc.getTouchTracker().gT.set((Matrix)localObject2);
      }
      AppMethodBeat.o(737);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(EditorItemContainer paramEditorItemContainer) {}
    
    public final void run()
    {
      AppMethodBeat.i(738);
      if (EditorItemContainer.d(this.ruX) != null)
      {
        EditorItemContainer localEditorItemContainer = this.ruX;
        a locala = EditorItemContainer.d(this.ruX);
        if (locala == null) {
          p.hyc();
        }
        localEditorItemContainer.a(locala, false);
      }
      AppMethodBeat.o(738);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(EditorItemContainer paramEditorItemContainer) {}
    
    public final void run()
    {
      AppMethodBeat.i(739);
      if (EditorItemContainer.b(this.ruX) != null)
      {
        Object localObject = EditorItemContainer.b(this.ruX);
        if (localObject == null) {
          p.hyc();
        }
        if (!((a)localObject).cJP())
        {
          localObject = EditorItemContainer.a(this.ruX);
          a locala = EditorItemContainer.b(this.ruX);
          if (locala == null)
          {
            localObject = new t("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(739);
            throw ((Throwable)localObject);
          }
          ((ViewGroup)localObject).removeView((View)locala);
        }
      }
      EditorItemContainer.c(this.ruX);
      EditorItemContainer.e(this.ruX);
      AppMethodBeat.o(739);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(EditorItemContainer paramEditorItemContainer) {}
    
    public final void run()
    {
      AppMethodBeat.i(740);
      this.ruX.getValidRect();
      if (!EditorItemContainer.f(this.ruX).isEmpty())
      {
        Iterator localIterator = ((Iterable)EditorItemContainer.g(this.ruX)).iterator();
        while (localIterator.hasNext()) {
          ((Runnable)localIterator.next()).run();
        }
      }
      AppMethodBeat.o(740);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer
 * JD-Core Version:    0.7.0.1
 */