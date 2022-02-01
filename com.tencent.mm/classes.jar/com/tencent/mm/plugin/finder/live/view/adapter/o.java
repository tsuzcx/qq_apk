package com.tencent.mm.plugin.finder.live.view.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.live.p.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFastCommentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFastCommentAdapter$CommentListViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "EDIT_TEXT_MAX_NUM", "", "MAX_COMMENT_LIMIT", "canSendBtnEnable", "Lkotlin/Function1;", "", "", "getContext", "()Landroid/content/Context;", "dataList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "setDataList", "(Ljava/util/ArrayList;)V", "firstComeDataListIsEmpty", "isSpace", "()Z", "setSpace", "(Z)V", "itemClickListener", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "Lkotlin/ParameterName;", "name", "contact", "getItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "bindComment", "holder", "position", "checkCanShowSend", "getItemCount", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "type", "resetDataList", "setCanSendBtnEnableListener", "callback", "setETInputFilter", "descTv", "Landroid/widget/EditText;", "maxInputLength", "setItemLimit", "limit", "updateCommentList", "commentList", "commentCount", "CommentListViewHolder", "Companion", "FastCommentTextWatcher", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  extends RecyclerView.a<a>
{
  public static final o.b DQP;
  public int DQQ;
  private int DQR;
  private boolean DQS;
  public kotlin.g.a.b<? super Boolean, ah> DQT;
  private boolean DQU;
  private final Context context;
  public ArrayList<String> pUj;
  
  static
  {
    AppMethodBeat.i(358730);
    DQP = new o.b((byte)0);
    AppMethodBeat.o(358730);
  }
  
  public o(Context paramContext)
  {
    AppMethodBeat.i(358678);
    this.context = paramContext;
    this.pUj = new ArrayList();
    this.DQQ = 2;
    this.DQR = 20;
    this.DQS = true;
    int i = 0;
    int k = this.DQQ;
    if (k > 0)
    {
      int j;
      do
      {
        j = i + 1;
        this.pUj.add("");
        i = j;
      } while (j < k);
    }
    AppMethodBeat.o(358678);
  }
  
  private static final CharSequence a(o paramo, CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(358722);
    s.u(paramo, "this$0");
    paramSpanned = paramCharSequence.toString();
    CharSequence localCharSequence = (CharSequence)"\n";
    if (paramSpanned == null)
    {
      paramo = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(358722);
      throw paramo;
    }
    if (paramSpanned.contentEquals(localCharSequence))
    {
      paramo.DQU = false;
      paramo = (CharSequence)"";
      AppMethodBeat.o(358722);
      return paramo;
    }
    paramCharSequence = paramCharSequence.toString();
    paramSpanned = (CharSequence)" ";
    if (paramCharSequence == null)
    {
      paramo = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(358722);
      throw paramo;
    }
    if (paramCharSequence.contentEquals(paramSpanned))
    {
      if (paramo.DQU) {}
      for (paramo = "";; paramo = null)
      {
        paramo = (CharSequence)paramo;
        AppMethodBeat.o(358722);
        return paramo;
        paramo.DQU = true;
      }
    }
    paramo.DQU = false;
    AppMethodBeat.o(358722);
    return null;
  }
  
  private static final void a(a parama, View paramView)
  {
    AppMethodBeat.i(358692);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFastCommentAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parama, "$holder");
    parama.DQV.setText((CharSequence)"");
    a.a(new Object(), "com/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFastCommentAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(358692);
  }
  
  private static final void a(a parama, EditText paramEditText)
  {
    AppMethodBeat.i(358710);
    s.u(parama, "$holder");
    s.u(paramEditText, "$this_apply");
    parama.DQV.requestFocus();
    paramEditText = paramEditText.getContext().getSystemService("input_method");
    if (paramEditText == null)
    {
      parama = new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
      AppMethodBeat.o(358710);
      throw parama;
    }
    ((InputMethodManager)paramEditText).showSoftInput((View)parama.DQV, 2);
    AppMethodBeat.o(358710);
  }
  
  private static final boolean a(a parama, EditText paramEditText, TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(358702);
    s.u(parama, "$holder");
    s.u(paramEditText, "$this_apply");
    if (6 == paramInt)
    {
      parama.DQV.clearFocus();
      paramEditText = paramEditText.getContext().getSystemService("input_method");
      if (paramEditText == null)
      {
        parama = new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        AppMethodBeat.o(358702);
        throw parama;
      }
      ((InputMethodManager)paramEditText).hideSoftInputFromWindow(parama.DQV.getWindowToken(), 0);
      AppMethodBeat.o(358702);
      return true;
    }
    AppMethodBeat.o(358702);
    return false;
  }
  
  public final void evO()
  {
    AppMethodBeat.i(358779);
    Object localObject = ((Iterable)this.pUj).iterator();
    while (((Iterator)localObject).hasNext())
    {
      if (((CharSequence)((Iterator)localObject).next()).length() == 0) {}
      for (int i = 1; (i == 0) || (!this.DQS); i = 0)
      {
        localObject = this.DQT;
        if (localObject != null) {
          ((kotlin.g.a.b)localObject).invoke(Boolean.TRUE);
        }
        AppMethodBeat.o(358779);
        return;
      }
    }
    localObject = this.DQT;
    if (localObject != null) {
      ((kotlin.g.a.b)localObject).invoke(Boolean.FALSE);
    }
    AppMethodBeat.o(358779);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(358773);
    int i = this.pUj.size();
    AppMethodBeat.o(358773);
    return i;
  }
  
  public final void h(ArrayList<String> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(358765);
    s.u(paramArrayList, "commentList");
    this.pUj.clear();
    this.pUj.addAll((Collection)paramArrayList);
    int j = this.DQQ;
    if (paramInt < j)
    {
      int i;
      do
      {
        i = paramInt + 1;
        this.pUj.add("");
        paramInt = i;
      } while (i < j);
    }
    this.bZE.notifyChanged();
    AppMethodBeat.o(358765);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFastCommentAdapter$CommentListViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFastCommentAdapter;Landroid/view/View;)V", "clearComment", "Landroid/widget/ImageView;", "getClearComment", "()Landroid/widget/ImageView;", "setClearComment", "(Landroid/widget/ImageView;)V", "commentMask", "Landroid/widget/FrameLayout;", "getCommentMask", "()Landroid/widget/FrameLayout;", "setCommentMask", "(Landroid/widget/FrameLayout;)V", "fastCommentEt", "Landroid/widget/EditText;", "getFastCommentEt", "()Landroid/widget/EditText;", "setFastCommentEt", "(Landroid/widget/EditText;)V", "fastCommentTextWatcher", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFastCommentAdapter$FastCommentTextWatcher;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFastCommentAdapter;", "getFastCommentTextWatcher", "()Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFastCommentAdapter$FastCommentTextWatcher;", "setFastCommentTextWatcher", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFastCommentAdapter$FastCommentTextWatcher;)V", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends RecyclerView.v
  {
    EditText DQV;
    private FrameLayout DQW;
    ImageView DQX;
    o.c DQY;
    
    public a()
    {
      super();
      AppMethodBeat.i(359080);
      this$1 = localObject.findViewById(p.e.BDY);
      s.s(o.this, "itemView.findViewById(R.id.fast_comment_et)");
      this.DQV = ((EditText)o.this);
      this$1 = localObject.findViewById(p.e.BDZ);
      s.s(o.this, "itemView.findViewById(R.id.fast_comment_et_mask)");
      this.DQW = ((FrameLayout)o.this);
      this$1 = localObject.findViewById(p.e.BEc);
      s.s(o.this, "itemView.findViewById(R.….fast_comment_text_clear)");
      this.DQX = ((ImageView)o.this);
      this.DQY = new o.c(o.this, new WeakReference(this.DQX), (byte)0);
      this.DQV.addTextChangedListener((TextWatcher)this.DQY);
      AppMethodBeat.o(359080);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFastCommentAdapter$FastCommentTextWatcher;", "Landroid/text/TextWatcher;", "clearComment", "Ljava/lang/ref/WeakReference;", "Landroid/widget/ImageView;", "position", "", "(Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveFastCommentAdapter;Ljava/lang/ref/WeakReference;I)V", "getClearComment", "()Ljava/lang/ref/WeakReference;", "setClearComment", "(Ljava/lang/ref/WeakReference;)V", "getPosition", "()I", "setPosition", "(I)V", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "count", "after", "onTextChanged", "before", "setPoi", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    implements TextWatcher
  {
    private WeakReference<ImageView> DRa;
    int position;
    
    private c()
    {
      AppMethodBeat.i(359074);
      Object localObject;
      this.DRa = localObject;
      this.position = 0;
      AppMethodBeat.o(359074);
    }
    
    public final void afterTextChanged(Editable paramEditable)
    {
      Object localObject2 = null;
      AppMethodBeat.i(359099);
      ArrayList localArrayList = o.this.pUj;
      int i = this.position;
      Object localObject1;
      if (paramEditable == null)
      {
        localObject1 = "";
        localArrayList.set(i, localObject1);
        if (paramEditable == null) {
          break label156;
        }
        paramEditable = paramEditable.toString();
        if (paramEditable == null) {
          break label156;
        }
        if (((CharSequence)paramEditable).length() != 0) {
          break label151;
        }
        i = 1;
        label64:
        if (i != 1) {
          break label156;
        }
        i = 1;
        label71:
        if (i == 0) {
          break label172;
        }
        paramEditable = this.DRa;
        if (paramEditable != null) {
          break label161;
        }
        paramEditable = localObject2;
        label87:
        if (paramEditable != null) {
          paramEditable.setVisibility(8);
        }
      }
      label151:
      label156:
      label161:
      label172:
      label204:
      for (;;)
      {
        o.this.evO();
        AppMethodBeat.o(359099);
        return;
        localObject1 = paramEditable.toString();
        if (localObject1 == null)
        {
          localObject1 = "";
          break;
        }
        String str = n.bq((CharSequence)localObject1).toString();
        localObject1 = str;
        if (str != null) {
          break;
        }
        localObject1 = "";
        break;
        i = 0;
        break label64;
        i = 0;
        break label71;
        paramEditable = (ImageView)paramEditable.get();
        break label87;
        paramEditable = this.DRa;
        if (paramEditable == null) {}
        for (paramEditable = null;; paramEditable = (ImageView)paramEditable.get())
        {
          if (paramEditable == null) {
            break label204;
          }
          paramEditable.setVisibility(0);
          break;
        }
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.o
 * JD-Core Version:    0.7.0.1
 */