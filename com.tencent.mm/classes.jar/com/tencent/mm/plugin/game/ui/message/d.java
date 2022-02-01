package com.tencent.mm.plugin.game.ui.message;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.plugin.game.f.e.a.a;
import com.tencent.mm.plugin.game.model.s;
import java.util.HashSet;
import java.util.Set;

public final class d
  extends RecyclerView
{
  private int fRv;
  private Context mContext;
  private com.tencent.mm.b.f<String, Bitmap> uCE;
  private e uGd;
  private Set<Integer> uGe;
  b uGp;
  
  public d(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(183896);
    this.uGe = new HashSet();
    this.mContext = paramContext;
    this.fRv = paramInt;
    this.uCE = new b(30, getClass());
    this.uGd = new e(this.fRv, new e.b()
    {
      public final void dcY()
      {
        AppMethodBeat.i(183891);
        d.a(d.this);
        AppMethodBeat.o(183891);
      }
    });
    paramInt = ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cZl().Io(2);
    this.uGp = new b(paramContext, ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cZl().Im(2), paramInt);
    setLayoutManager(new LinearLayoutManager());
    setAdapter(this.uGp);
    AppMethodBeat.o(183896);
  }
  
  private void b(ImageView paramImageView, final String paramString, float paramFloat)
  {
    AppMethodBeat.i(183897);
    e.a.a locala = new e.a.a();
    locala.igi = false;
    locala.uHk = paramFloat;
    com.tencent.mm.plugin.game.f.e.ddh().a(paramImageView, paramString, locala.ddi(), new com.tencent.mm.plugin.game.f.e.b()
    {
      public final void a(View paramAnonymousView, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(183892);
        if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled())) {
          d.f(d.this).put(paramString, paramAnonymousBitmap);
        }
        AppMethodBeat.o(183892);
      }
    });
    AppMethodBeat.o(183897);
  }
  
  final class a
    extends RecyclerView.w
  {
    ImageView fWT;
    TextView gXb;
    TextView ovs;
    TextView timeTv;
    TextView titleTv;
    ViewGroup uGg;
    View uGm;
    View uGn;
    View uGo;
    private ViewGroup uGr;
    ImageView uGs;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(183893);
      this.uGg = ((ViewGroup)paramView.findViewById(2131302521));
      this.fWT = ((ImageView)paramView.findViewById(2131300891));
      this.ovs = ((TextView)paramView.findViewById(2131302867));
      this.uGr = ((ViewGroup)paramView.findViewById(2131302522));
      this.uGs = ((ImageView)paramView.findViewById(2131297877));
      this.titleTv = ((TextView)paramView.findViewById(2131297914));
      this.gXb = ((TextView)paramView.findViewById(2131297777));
      this.timeTv = ((TextView)paramView.findViewById(2131305822));
      this.uGm = paramView.findViewById(2131300518);
      this.uGn = paramView.findViewById(2131302790);
      this.uGo = paramView.findViewById(2131301490);
      this.uGg.setOnLongClickListener(d.e(d.this));
      this.uGg.setOnClickListener(d.e(d.this));
      this.fWT.setOnLongClickListener(d.e(d.this));
      this.fWT.setOnClickListener(d.e(d.this));
      this.ovs.setOnLongClickListener(d.e(d.this));
      this.ovs.setOnClickListener(d.e(d.this));
      AppMethodBeat.o(183893);
    }
  }
  
  final class b
    extends f<d.a>
  {
    int dla;
    
    public b(Context paramContext, Cursor paramCursor, int paramInt)
    {
      super(paramCursor);
      this.dla = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.d
 * JD-Core Version:    0.7.0.1
 */