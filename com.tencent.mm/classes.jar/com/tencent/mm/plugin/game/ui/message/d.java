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
  private int fPp;
  private Context mContext;
  private com.tencent.mm.b.f<String, Bitmap> urk;
  private e uuE;
  private Set<Integer> uuF;
  b uuQ;
  
  public d(Context paramContext, int paramInt)
  {
    super(paramContext);
    AppMethodBeat.i(183896);
    this.uuF = new HashSet();
    this.mContext = paramContext;
    this.fPp = paramInt;
    this.urk = new b(30, getClass());
    this.uuE = new e(this.fPp, new e.b()
    {
      public final void dam()
      {
        AppMethodBeat.i(183891);
        d.a(d.this).djY = ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cWH().HR(2);
        Cursor localCursor = ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cWH().HP(2);
        d.a(d.this).changeCursor(localCursor);
        AppMethodBeat.o(183891);
      }
    });
    paramInt = ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cWH().HR(2);
    this.uuQ = new b(paramContext, ((com.tencent.mm.plugin.game.api.f)g.ab(com.tencent.mm.plugin.game.api.f.class)).cWH().HP(2), paramInt);
    setLayoutManager(new LinearLayoutManager());
    setAdapter(this.uuQ);
    AppMethodBeat.o(183896);
  }
  
  private void b(ImageView paramImageView, final String paramString, float paramFloat)
  {
    AppMethodBeat.i(183897);
    e.a.a locala = new e.a.a();
    locala.idp = false;
    locala.uvL = paramFloat;
    com.tencent.mm.plugin.game.f.e.dav().a(paramImageView, paramString, locala.daw(), new com.tencent.mm.plugin.game.f.e.b()
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
    ImageView fUN;
    TextView gUs;
    TextView opA;
    TextView timeTv;
    TextView titleTv;
    ViewGroup uuH;
    View uuN;
    View uuO;
    View uuP;
    private ViewGroup uuS;
    ImageView uuT;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(183893);
      this.uuH = ((ViewGroup)paramView.findViewById(2131302521));
      this.fUN = ((ImageView)paramView.findViewById(2131300891));
      this.opA = ((TextView)paramView.findViewById(2131302867));
      this.uuS = ((ViewGroup)paramView.findViewById(2131302522));
      this.uuT = ((ImageView)paramView.findViewById(2131297877));
      this.titleTv = ((TextView)paramView.findViewById(2131297914));
      this.gUs = ((TextView)paramView.findViewById(2131297777));
      this.timeTv = ((TextView)paramView.findViewById(2131305822));
      this.uuN = paramView.findViewById(2131300518);
      this.uuO = paramView.findViewById(2131302790);
      this.uuP = paramView.findViewById(2131301490);
      this.uuH.setOnLongClickListener(d.e(d.this));
      this.uuH.setOnClickListener(d.e(d.this));
      this.fUN.setOnLongClickListener(d.e(d.this));
      this.fUN.setOnClickListener(d.e(d.this));
      this.opA.setOnLongClickListener(d.e(d.this));
      this.opA.setOnClickListener(d.e(d.this));
      AppMethodBeat.o(183893);
    }
  }
  
  final class b
    extends f<d.a>
  {
    int djY;
    
    public b(Context paramContext, Cursor paramCursor, int paramInt)
    {
      super(paramCursor);
      this.djY = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.message.d
 * JD-Core Version:    0.7.0.1
 */