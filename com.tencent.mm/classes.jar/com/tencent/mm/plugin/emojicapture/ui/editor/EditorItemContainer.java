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
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emojicapture.c.c.a;
import com.tencent.mm.plugin.recordvideo.ui.editor.c.c;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.b.p;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "clearActive", "Ljava/lang/Runnable;", "currActiveItem", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/IEditorItemView;", "deleteEnalbe", "", "getDeleteEnalbe", "()Z", "setDeleteEnalbe", "(Z)V", "deleteView", "Landroid/widget/TextView;", "deletingItem", "editorMask", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorOutsideView;", "itemLayout", "Landroid/view/ViewGroup;", "stateChangeListener", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer$OnStateChangeListener;", "getStateChangeListener", "()Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer$OnStateChangeListener;", "setStateChangeListener", "(Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer$OnStateChangeListener;)V", "tasksAfterSizeValid", "Ljava/util/LinkedList;", "validAreaView", "Landroid/view/View;", "validRect", "Landroid/graphics/RectF;", "activeDeleteView", "", "active", "addEditorItem", "itemView", "touchMatrix", "Landroid/graphics/Matrix;", "createTextItem", "Lcom/tencent/mm/plugin/emojicapture/ui/editor/TextEditorItemView;", "deleteCheck", "event", "Landroid/view/MotionEvent;", "getAllEmojiMd5", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getAllItemViews", "", "getAttachedText", "getTextItem", "getValidRect", "handleItemTouch", "onInterceptTouchEvent", "ev", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "pause", "postOnSizeValid", "r", "removeAllItems", "requestEditing", "editing", "resume", "setEditing", "toggleDeleteView", "show", "Companion", "OnStateChangeListener", "plugin-emojicapture_release"})
public final class EditorItemContainer
  extends RelativeLayout
{
  public static final EditorItemContainer.a pXt;
  private final String TAG;
  private View pXi;
  private TextView pXj;
  public final ViewGroup pXk;
  public final EditorOutsideView pXl;
  private b pXm;
  private boolean pXn;
  private final RectF pXo;
  private a pXp;
  private Runnable pXq;
  private a pXr;
  private final LinkedList<Runnable> pXs;
  
  static
  {
    AppMethodBeat.i(762);
    pXt = new EditorItemContainer.a((byte)0);
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
    this.pXn = true;
    this.pXo = new RectF();
    this.pXq = ((Runnable)new d(this));
    this.pXs = new LinkedList();
    View.inflate(paramContext, 2131493754, (ViewGroup)this);
    paramAttributeSet = findViewById(2131299304);
    p.g(paramAttributeSet, "findViewById(R.id.editor_valid_area)");
    this.pXi = paramAttributeSet;
    paramAttributeSet = findViewById(2131299290);
    p.g(paramAttributeSet, "findViewById(R.id.editor_delete_view)");
    this.pXj = ((TextView)paramAttributeSet);
    this.pXj.setTextColor(getResources().getColor(2131100267));
    paramAttributeSet = findViewById(2131299336);
    p.g(paramAttributeSet, "findViewById(R.id.emoji_capture_editor_layout)");
    this.pXk = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131299337);
    p.g(paramAttributeSet, "findViewById(R.id.emoji_capture_editor_mask)");
    this.pXl = ((EditorOutsideView)paramAttributeSet);
    ah((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(736);
        EditorItemContainer.h(this.pXu).a(this.pXu.getValidRect(), paramContext.getResources().getDimension(2131166204));
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
    if (f / j > this.pXj.getTop())
    {
      bool = true;
      if (!bool) {
        break label99;
      }
      kK(true);
      if (this.pXr == null) {
        this.pXr = parama;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(759);
      return bool;
      bool = false;
      break;
      label99:
      kK(false);
      if (this.pXr != null) {
        this.pXr = null;
      }
    }
  }
  
  private final void kJ(boolean paramBoolean)
  {
    AppMethodBeat.i(757);
    Object localObject = this.pXj;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      ((TextView)localObject).setVisibility(i);
      if (this.pXm != null)
      {
        localObject = this.pXm;
        if (localObject == null) {
          p.gfZ();
        }
        ((b)localObject).kI(paramBoolean);
      }
      AppMethodBeat.o(757);
      return;
    }
  }
  
  private final void kK(boolean paramBoolean)
  {
    AppMethodBeat.i(758);
    this.pXj.setActivated(paramBoolean);
    if (paramBoolean)
    {
      this.pXj.setText(2131758185);
      AppMethodBeat.o(758);
      return;
    }
    this.pXj.setText(2131758184);
    AppMethodBeat.o(758);
  }
  
  public final void a(final a parama, final Matrix paramMatrix)
  {
    AppMethodBeat.i(741);
    p.h(parama, "itemView");
    ah((Runnable)new c(this, parama, paramMatrix));
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
        removeCallbacks(this.pXq);
        a(parama, true);
        AppMethodBeat.o(743);
        return;
      } while (!this.pXn);
      b(parama, paramMotionEvent);
      kJ(true);
      AppMethodBeat.o(743);
      return;
    }
    this.pXk.bringChildToFront((View)getTextItem());
    if (this.pXr != null) {
      post((Runnable)new e(this));
    }
    for (;;)
    {
      kJ(false);
      break;
      if (this.pXp != null) {
        postDelayed(this.pXq, 1500L);
      }
    }
  }
  
  public final void a(a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(755);
    p.h(parama, "itemView");
    if (paramBoolean) {
      if ((p.i(parama, this.pXp) ^ true))
      {
        a locala = this.pXp;
        if (locala != null) {
          locala.setEditing(false);
        }
        this.pXp = parama;
      }
    }
    for (;;)
    {
      parama.setEditing(paramBoolean);
      AppMethodBeat.o(755);
      return;
      if (p.i(parama, this.pXp)) {
        this.pXp = null;
      }
    }
  }
  
  public final void ah(Runnable paramRunnable)
  {
    AppMethodBeat.i(756);
    p.h(paramRunnable, "r");
    if (!this.pXo.isEmpty())
    {
      paramRunnable.run();
      AppMethodBeat.o(756);
      return;
    }
    this.pXs.add(paramRunnable);
    AppMethodBeat.o(756);
  }
  
  public final ArrayList<String> getAllEmojiMd5()
  {
    AppMethodBeat.i(749);
    ArrayList localArrayList = new ArrayList();
    int j = this.pXk.getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = this.pXk.getChildAt(i);
      if ((localObject instanceof EmojiEditorItemView))
      {
        localObject = ((EmojiEditorItemView)localObject).getEmojiInfo();
        if (localObject != null)
        {
          localObject = ((EmojiInfo)localObject).Lb();
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
    int j = this.pXk.getChildCount();
    while (i < j)
    {
      View localView = this.pXk.getChildAt(i);
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
    return this.pXn;
  }
  
  public final b getStateChangeListener()
  {
    return this.pXm;
  }
  
  public final TextEditorItemView getTextItem()
  {
    AppMethodBeat.i(747);
    int j = this.pXk.getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = this.pXk.getChildAt(i);
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
    this.pXo.set(this.pXi.getLeft(), this.pXi.getTop(), this.pXi.getRight(), this.pXi.getBottom());
    RectF localRectF = this.pXo;
    AppMethodBeat.o(753);
    return localRectF;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(744);
    p.h(paramMotionEvent, "ev");
    if ((paramMotionEvent.getActionMasked() == 0) && (!this.pXo.contains(paramMotionEvent.getX(), paramMotionEvent.getY())))
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
      if (!this.pXo.contains(paramMotionEvent.getX(), paramMotionEvent.getY()))
      {
        AppMethodBeat.o(745);
        return false;
      }
      if (this.pXp != null)
      {
        a locala = this.pXp;
        if (locala == null) {
          p.gfZ();
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
    int j = this.pXk.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.pXk.getChildAt(i);
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
    int j = this.pXk.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.pXk.getChildAt(i);
      if ((localView instanceof a)) {
        ((a)localView).resume();
      }
      i += 1;
    }
    AppMethodBeat.o(751);
  }
  
  public final void setDeleteEnalbe(boolean paramBoolean)
  {
    this.pXn = paramBoolean;
  }
  
  public final void setEditing(a parama)
  {
    AppMethodBeat.i(754);
    p.h(parama, "itemView");
    removeCallbacks(this.pXq);
    a(parama, true);
    postDelayed(this.pXq, 1500L);
    AppMethodBeat.o(754);
  }
  
  public final void setStateChangeListener(b paramb)
  {
    this.pXm = paramb;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/ui/editor/EditorItemContainer$OnStateChangeListener;", "", "onStateChange", "", "showDelete", "", "plugin-emojicapture_release"})
  public static abstract interface b
  {
    public abstract void kI(boolean paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(EditorItemContainer paramEditorItemContainer, a parama, Matrix paramMatrix) {}
    
    public final void run()
    {
      AppMethodBeat.i(737);
      Object localObject1 = new RelativeLayout.LayoutParams(-1, -1);
      Object localObject2 = EditorItemContainer.a(this.pXu);
      Object localObject3 = parama;
      if (localObject3 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(737);
        throw ((Throwable)localObject1);
      }
      ((ViewGroup)localObject2).addView((View)localObject3, (ViewGroup.LayoutParams)localObject1);
      localObject1 = parama;
      localObject2 = this.pXu.getValidRect();
      localObject3 = this.pXu.getContext();
      p.g(localObject3, "context");
      ((a)localObject1).a((RectF)localObject2, ((Context)localObject3).getResources().getDimension(2131166204));
      this.pXu.setEditing(parama);
      EditorItemContainer.a(this.pXu).bringChildToFront((View)this.pXu.getTextItem());
      if ((paramMatrix != null) && ((parama instanceof EmojiEditorItemView)))
      {
        localObject1 = (EmojiEditorItemView)parama;
        localObject2 = paramMatrix;
        p.h(localObject2, "m");
        ((EmojiEditorItemView)localObject1).pXz.getTouchTracker().gR.set((Matrix)localObject2);
      }
      AppMethodBeat.o(737);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(EditorItemContainer paramEditorItemContainer) {}
    
    public final void run()
    {
      AppMethodBeat.i(738);
      if (EditorItemContainer.d(this.pXu) != null)
      {
        EditorItemContainer localEditorItemContainer = this.pXu;
        a locala = EditorItemContainer.d(this.pXu);
        if (locala == null) {
          p.gfZ();
        }
        localEditorItemContainer.a(locala, false);
      }
      AppMethodBeat.o(738);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(EditorItemContainer paramEditorItemContainer) {}
    
    public final void run()
    {
      AppMethodBeat.i(739);
      if (EditorItemContainer.b(this.pXu) != null)
      {
        Object localObject = EditorItemContainer.b(this.pXu);
        if (localObject == null) {
          p.gfZ();
        }
        if (!((a)localObject).ckx())
        {
          localObject = EditorItemContainer.a(this.pXu);
          a locala = EditorItemContainer.b(this.pXu);
          if (locala == null)
          {
            localObject = new v("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(739);
            throw ((Throwable)localObject);
          }
          ((ViewGroup)localObject).removeView((View)locala);
        }
      }
      EditorItemContainer.c(this.pXu);
      EditorItemContainer.e(this.pXu);
      AppMethodBeat.o(739);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(EditorItemContainer paramEditorItemContainer) {}
    
    public final void run()
    {
      AppMethodBeat.i(740);
      this.pXu.getValidRect();
      if (!EditorItemContainer.f(this.pXu).isEmpty())
      {
        Iterator localIterator = ((Iterable)EditorItemContainer.g(this.pXu)).iterator();
        while (localIterator.hasNext()) {
          ((Runnable)localIterator.next()).run();
        }
      }
      AppMethodBeat.o(740);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer
 * JD-Core Version:    0.7.0.1
 */