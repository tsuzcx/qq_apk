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

public final class c
  extends RecyclerView
{
  private int fRv;
  private Context mContext;
  private com.tencent.mm.b.f<String, Bitmap> uCE;
  a uGc;
  private e uGd;
  private Set<Integer> uGe;
  
  public c(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(183887);
    this.uGe = new HashSet();
    this.mContext = paramContext;
    this.fRv = paramInt;
    this.uCE = new b(30, getClass());
    this.uGd = new e(this.fRv, new e.b()
    {
      public final void dcY()
      {
        AppMethodBeat.i(183882);
        c.a(c.this);
        AppMethodBeat.o(183882);
      }
    });
    paramInt = ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cZl().Io(1);
    this.uGc = new a(paramContext, ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cZl().Im(1), paramInt);
    setLayoutManager(new LinearLayoutManager());
    setAdapter(this.uGc);
    AppMethodBeat.o(183887);
  }
  
  private void b(ImageView paramImageView, final String paramString, float paramFloat)
  {
    AppMethodBeat.i(183888);
    e.a.a locala = new e.a.a();
    locala.igi = false;
    locala.uHk = paramFloat;
    com.tencent.mm.plugin.game.f.e.ddh().a(paramImageView, paramString, locala.ddi(), new com.tencent.mm.plugin.game.f.e.b()
    {
      public final void a(View paramAnonymousView, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(183883);
        if ((paramAnonymousBitmap != null) && (!paramAnonymousBitmap.isRecycled())) {
          c.f(c.this).put(paramString, paramAnonymousBitmap);
        }
        AppMethodBeat.o(183883);
      }
    });
    AppMethodBeat.o(183888);
  }
  
  final class a
    extends f<c.b>
  {
    int dla;
    
    public a(Context paramContext, Cursor paramCursor, int paramInt)
    {
      super(paramCursor);
      this.dla = paramInt;
    }
  }
  
  final class b
    extends RecyclerView.w
  {
    ImageView fWT;
    TextView ovs;
    TextView timeTv;
    ViewGroup uGg;
    TextView uGh;
    TextView uGi;
    ImageView uGj;
    TextView uGk;
    TextView uGl;
    View uGm;
    View uGn;
    View uGo;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(183886);
      this.uGg = ((ViewGroup)paramView.findViewById(2131302521));
      this.fWT = ((ImageView)paramView.findViewById(2131300891));
      this.ovs = ((TextView)paramView.findViewById(2131302867));
      this.uGh = ((TextView)paramView.findViewById(2131302485));
      this.uGi = ((TextView)paramView.findViewById(2131304199));
      this.uGj = ((ImageView)paramView.findViewById(2131304189));
      this.uGk = ((TextView)paramView.findViewById(2131298778));
      this.timeTv = ((TextView)paramView.findViewById(2131305822));
      this.uGl = ((TextView)paramView.findViewById(2131305134));
      this.uGm = paramView.findViewById(2131300518);
      this.uGn = paramView.findViewById(2131302790);
      this.uGo = paramView.findViewById(2131301490);
      this.uGg.setOnLongClickListener(c.e(c.this));
      this.uGg.setOnClickListener(c.e(c.this));
      this.fWT.setOnLongClickListener(c.e(c.this));
      this.fWT.setOnClickListener(c.e(c.this));
      this.ovs.setOnLongClickListener(c.e(c.this));
      this.ovs.setOnClickListener(c.e(c.this));
      AppMethodBeat.o(183886);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.c
 * JD-Core Version:    0.7.0.1
 */