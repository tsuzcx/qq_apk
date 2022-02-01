package com.tencent.mm.plugin.gallery.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.gallery.model.s.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.ao;
import java.util.ArrayList;
import java.util.List;

final class SmartGalleryUI$a
  extends RecyclerView.a<a>
{
  View.OnClickListener iu;
  private Context mContext;
  private View.OnLongClickListener sOP;
  SmartGalleryUI.c sTl;
  List<s.a> sTp;
  private int sTq;
  
  SmartGalleryUI$a(Context paramContext)
  {
    AppMethodBeat.i(111681);
    this.iu = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(111678);
        paramAnonymousView = paramAnonymousView.getTag();
        if (((paramAnonymousView instanceof s.a)) && (SmartGalleryUI.a.a(SmartGalleryUI.a.this) != null)) {
          SmartGalleryUI.a.a(SmartGalleryUI.a.this).a((s.a)paramAnonymousView);
        }
        AppMethodBeat.o(111678);
      }
    };
    this.sOP = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(111679);
        paramAnonymousView = paramAnonymousView.getTag();
        if ((paramAnonymousView instanceof s.a))
        {
          paramAnonymousView = (s.a)paramAnonymousView;
          ((ClipboardManager)SmartGalleryUI.a.b(SmartGalleryUI.a.this).getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("media info", paramAnonymousView.toString()));
        }
        AppMethodBeat.o(111679);
        return true;
      }
    };
    this.mContext = paramContext;
    this.sTp = new ArrayList();
    this.sTq = ((this.mContext.getResources().getDisplayMetrics().widthPixels - ao.av(this.mContext, 2131165289) - ao.av(this.mContext, 2131165303) * 4) / 9 * 2);
    ac.d("MicroMsg.SmartGalleryUI", "mThumbSize: %d.", new Object[] { Integer.valueOf(this.sTq) });
    AppMethodBeat.o(111681);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(111682);
    int i = this.sTp.size();
    AppMethodBeat.o(111682);
    return i;
  }
  
  static final class a
    extends RecyclerView.w
  {
    ImageView sTs;
    TextView sTt;
    TextView sTu;
    
    a(View paramView, int paramInt)
    {
      super();
      AppMethodBeat.i(111680);
      this.sTs = ((ImageView)paramView.findViewById(2131296565));
      ViewGroup.LayoutParams localLayoutParams = this.sTs.getLayoutParams();
      localLayoutParams.width = paramInt;
      localLayoutParams.height = paramInt;
      this.sTs.setLayoutParams(localLayoutParams);
      this.sTt = ((TextView)paramView.findViewById(2131296593));
      this.sTu = ((TextView)paramView.findViewById(2131296542));
      AppMethodBeat.o(111680);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.SmartGalleryUI.a
 * JD-Core Version:    0.7.0.1
 */