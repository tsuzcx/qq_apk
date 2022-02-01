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
  private int fPp;
  private Context mContext;
  private com.tencent.mm.b.f<String, Bitmap> urk;
  a uuD;
  private e uuE;
  private Set<Integer> uuF;
  
  public c(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(183887);
    this.uuF = new HashSet();
    this.mContext = paramContext;
    this.fPp = paramInt;
    this.urk = new b(30, getClass());
    this.uuE = new e(this.fPp, new e.b()
    {
      public final void dam()
      {
        AppMethodBeat.i(183882);
        c.a(c.this).djY = ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cWH().HR(2);
        Cursor localCursor = ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cWH().HP(1);
        c.a(c.this).changeCursor(localCursor);
        AppMethodBeat.o(183882);
      }
    });
    paramInt = ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cWH().HR(1);
    this.uuD = new a(paramContext, ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cWH().HP(1), paramInt);
    setLayoutManager(new LinearLayoutManager());
    setAdapter(this.uuD);
    AppMethodBeat.o(183887);
  }
  
  private void b(ImageView paramImageView, final String paramString, float paramFloat)
  {
    AppMethodBeat.i(183888);
    e.a.a locala = new e.a.a();
    locala.idp = false;
    locala.uvL = paramFloat;
    com.tencent.mm.plugin.game.f.e.dav().a(paramImageView, paramString, locala.daw(), new com.tencent.mm.plugin.game.f.e.b()
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
    int djY;
    
    public a(Context paramContext, Cursor paramCursor, int paramInt)
    {
      super(paramCursor);
      this.djY = paramInt;
    }
  }
  
  final class b
    extends RecyclerView.w
  {
    ImageView fUN;
    TextView opA;
    TextView timeTv;
    ViewGroup uuH;
    TextView uuI;
    TextView uuJ;
    ImageView uuK;
    TextView uuL;
    TextView uuM;
    View uuN;
    View uuO;
    View uuP;
    
    public b(View paramView)
    {
      super();
      AppMethodBeat.i(183886);
      this.uuH = ((ViewGroup)paramView.findViewById(2131302521));
      this.fUN = ((ImageView)paramView.findViewById(2131300891));
      this.opA = ((TextView)paramView.findViewById(2131302867));
      this.uuI = ((TextView)paramView.findViewById(2131302485));
      this.uuJ = ((TextView)paramView.findViewById(2131304199));
      this.uuK = ((ImageView)paramView.findViewById(2131304189));
      this.uuL = ((TextView)paramView.findViewById(2131298778));
      this.timeTv = ((TextView)paramView.findViewById(2131305822));
      this.uuM = ((TextView)paramView.findViewById(2131305134));
      this.uuN = paramView.findViewById(2131300518);
      this.uuO = paramView.findViewById(2131302790);
      this.uuP = paramView.findViewById(2131301490);
      this.uuH.setOnLongClickListener(c.e(c.this));
      this.uuH.setOnClickListener(c.e(c.this));
      this.fUN.setOnLongClickListener(c.e(c.this));
      this.fUN.setOnClickListener(c.e(c.this));
      this.opA.setOnLongClickListener(c.e(c.this));
      this.opA.setOnClickListener(c.e(c.this));
      AppMethodBeat.o(183886);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.c
 * JD-Core Version:    0.7.0.1
 */