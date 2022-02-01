package com.tencent.mm.plugin.game.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.LayoutParams;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.RecyclerView.w;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.plugin.gallery.ui.ImagePreviewUI;
import com.tencent.mm.plugin.gallery.ui.h.a;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.game.widget.GameGridLayoutManager;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class GameLocalGalleryView
  extends FrameLayout
{
  static final int sZK;
  static final int sZL;
  private RecyclerView sZM;
  c sZN;
  private TextView sZO;
  private Button sZP;
  private int sZQ;
  private boolean sZR;
  
  static
  {
    AppMethodBeat.i(41027);
    sZK = "GameLocalGalleryView_REQUEST_CODE_VIDEO".hashCode() & 0xFFFF;
    sZL = "GameLocalGalleryView_REQUEST_CODE_IMAGE".hashCode() & 0xFFFF;
    AppMethodBeat.o(41027);
  }
  
  public GameLocalGalleryView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(41016);
    init();
    AppMethodBeat.o(41016);
  }
  
  public GameLocalGalleryView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(41017);
    init();
    AppMethodBeat.o(41017);
  }
  
  public GameLocalGalleryView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(41018);
    init();
    AppMethodBeat.o(41018);
  }
  
  static void cPq()
  {
    AppMethodBeat.i(41023);
    a.Gj(2);
    AppMethodBeat.o(41023);
  }
  
  private static void fV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41024);
    HashMap localHashMap = new HashMap();
    com.tencent.mm.game.report.b.a.a(ai.getContext(), 8767, paramInt1, paramInt2, com.tencent.mm.game.report.b.a.a(7, localHashMap));
    AppMethodBeat.o(41024);
  }
  
  private void init()
  {
    AppMethodBeat.i(41019);
    View localView = LayoutInflater.from(getContext()).inflate(2131494368, this, false);
    this.sZM = ((RecyclerView)localView.findViewById(2131300504));
    getContext();
    GameGridLayoutManager localGameGridLayoutManager = new GameGridLayoutManager((byte)0);
    this.sZM.setLayoutManager(localGameGridLayoutManager);
    this.sZM.a(new a());
    this.sZN = new c(getContext());
    this.sZM.setAdapter(this.sZN);
    this.sZO = ((TextView)localView.findViewById(2131300507));
    this.sZO.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(40997);
        paramAnonymousView = GameLocalGalleryView.a(GameLocalGalleryView.this);
        if (paramAnonymousView.sOK != null) {}
        for (int i = paramAnonymousView.sOK.size(); i > 0; i = 0)
        {
          paramAnonymousView = new Intent(GameLocalGalleryView.this.getContext(), ImagePreviewUI.class);
          paramAnonymousView.putStringArrayListExtra("preview_image_list", GameLocalGalleryView.a(GameLocalGalleryView.this).cNv());
          paramAnonymousView.putParcelableArrayListExtra("preview_media_item_list", GameLocalGalleryView.c.a(GameLocalGalleryView.a(GameLocalGalleryView.this)));
          paramAnonymousView.putExtra("max_select_count", GameLocalGalleryView.b(GameLocalGalleryView.this));
          paramAnonymousView.putExtra("send_raw_img", false);
          com.tencent.mm.br.d.b(GameLocalGalleryView.this.getContext(), "gallery", ".ui.ImagePreviewUI", paramAnonymousView, GameLocalGalleryView.sZL);
          AppMethodBeat.o(40997);
          return;
        }
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("key_game_haowan_text", true);
        ((Activity)GameLocalGalleryView.this.getContext()).setResult(-1, paramAnonymousView);
        ((Activity)GameLocalGalleryView.this.getContext()).finish();
        AppMethodBeat.o(40997);
      }
    });
    this.sZP = ((Button)localView.findViewById(2131300506));
    this.sZP.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(40998);
        Object localObject = GameLocalGalleryView.a(GameLocalGalleryView.this).sOK;
        paramAnonymousView = new ArrayList();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)((Iterator)localObject).next();
          if ((localMediaItem.mMimeType.equals("edit")) && (!bs.isNullOrNil(localMediaItem.sKj))) {
            paramAnonymousView.add(localMediaItem.sKj);
          } else {
            paramAnonymousView.add(localMediaItem.sKh);
          }
        }
        if (!bs.gY(paramAnonymousView)) {
          GameLocalGalleryView.cPr();
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("CropImage_OutputPath_List", paramAnonymousView);
        ((Activity)GameLocalGalleryView.this.getContext()).setResult(-1, (Intent)localObject);
        ((Activity)GameLocalGalleryView.this.getContext()).finish();
        AppMethodBeat.o(40998);
      }
    });
    this.sZN.sZT = new b()
    {
      public final void Go(int paramAnonymousInt)
      {
        AppMethodBeat.i(40999);
        if (paramAnonymousInt > 0)
        {
          GameLocalGalleryView.c(GameLocalGalleryView.this).setText(GameLocalGalleryView.this.getResources().getString(2131759923, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(GameLocalGalleryView.b(GameLocalGalleryView.this)) }));
          GameLocalGalleryView.c(GameLocalGalleryView.this).setEnabled(true);
          GameLocalGalleryView.d(GameLocalGalleryView.this).setText(GameLocalGalleryView.this.getResources().getString(2131759924));
          AppMethodBeat.o(40999);
          return;
        }
        GameLocalGalleryView.c(GameLocalGalleryView.this).setText(GameLocalGalleryView.this.getResources().getString(2131759922));
        GameLocalGalleryView.c(GameLocalGalleryView.this).setEnabled(false);
        GameLocalGalleryView.d(GameLocalGalleryView.this).setText(GameLocalGalleryView.this.getResources().getString(2131766521));
        AppMethodBeat.o(40999);
      }
    };
    addView(localView, -1, -1);
    AppMethodBeat.o(41019);
  }
  
  public final void cPo()
  {
    AppMethodBeat.i(41020);
    if (!this.sZR) {
      fV(0, 1);
    }
    this.sZR = true;
    AppMethodBeat.o(41020);
  }
  
  public final void cPp()
  {
    AppMethodBeat.i(41022);
    c localc = this.sZN;
    localc.sOK.clear();
    if (localc.sZT != null) {
      localc.sZT.Go(localc.sOK.size());
    }
    localc.sZS.postDelayed(new GameLocalGalleryView.c.4(localc), 500L);
    AppMethodBeat.o(41022);
  }
  
  public void setQueryType(int paramInt)
  {
    AppMethodBeat.i(41021);
    this.sZN.sKz = paramInt;
    a.a(paramInt, new a.c()
    {
      public final void as(LinkedList<GalleryItem.MediaItem> paramAnonymousLinkedList)
      {
        AppMethodBeat.i(41000);
        ArrayList localArrayList = new ArrayList();
        if (paramAnonymousLinkedList != null) {
          localArrayList.addAll(paramAnonymousLinkedList);
        }
        ap.f(new GameLocalGalleryView.c.3(GameLocalGalleryView.a(GameLocalGalleryView.this), localArrayList));
        AppMethodBeat.o(41000);
      }
    });
    AppMethodBeat.o(41021);
  }
  
  public void setSelectLimitCount(int paramInt)
  {
    this.sZN.sOI = paramInt;
    this.sZQ = paramInt;
  }
  
  final class a
    extends RecyclerView.h
  {
    private int mSize;
    
    public a()
    {
      AppMethodBeat.i(41001);
      this.mSize = ao.fromDPToPix(ai.getContext(), 3);
      AppMethodBeat.o(41001);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
    {
      AppMethodBeat.i(41002);
      paramRecyclerView = (GridLayoutManager)paramRecyclerView.getLayoutManager();
      paramt = (GridLayoutManager.LayoutParams)paramView.getLayoutParams();
      int i = paramRecyclerView.anI;
      int j = RecyclerView.bw(paramView);
      int k = paramt.anP;
      ac.i("MicroMsg.GameLocalMediaView", "getItemOffsets, spanSize = %d, spanCount = %d, index = %d", new Object[] { Integer.valueOf(paramt.anQ), Integer.valueOf(i), Integer.valueOf(k) });
      if (j < i)
      {
        if (k == 0)
        {
          paramRect.set(0, 0, 0, 0);
          AppMethodBeat.o(41002);
          return;
        }
        paramRect.set(this.mSize, 0, 0, 0);
        AppMethodBeat.o(41002);
        return;
      }
      if (k == 0)
      {
        paramRect.set(0, this.mSize, 0, 0);
        AppMethodBeat.o(41002);
        return;
      }
      paramRect.set(this.mSize, this.mSize, 0, 0);
      AppMethodBeat.o(41002);
    }
  }
  
  static abstract interface b
  {
    public abstract void Go(int paramInt);
  }
  
  final class c
    extends RecyclerView.a<GameLocalGalleryView.d>
  {
    private Context mContext;
    int sKz;
    int sOI;
    ArrayList<GalleryItem.MediaItem> sOJ;
    ArrayList<GalleryItem.MediaItem> sOK;
    private View.OnClickListener sOQ;
    GameLocalGalleryView.b sZT;
    
    c(Context paramContext)
    {
      AppMethodBeat.i(41009);
      this.sOJ = new ArrayList();
      this.sOK = new ArrayList();
      this.sOQ = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(41008);
          if (!(paramAnonymousView.getTag(2131302205) instanceof Integer))
          {
            AppMethodBeat.o(41008);
            return;
          }
          Object localObject = (Integer)paramAnonymousView.getTag(2131302205);
          if (localObject == null)
          {
            ac.e("MicroMsg.GameLocalMediaView", "[onClick] null == position!");
            AppMethodBeat.o(41008);
            return;
          }
          localObject = (GalleryItem.MediaItem)GameLocalGalleryView.c.e(GameLocalGalleryView.c.this).get(((Integer)localObject).intValue());
          if ((localObject == null) || (bs.isNullOrNil(((GalleryItem.MediaItem)localObject).sKh)))
          {
            ac.e("MicroMsg.GameLocalMediaView", "[onClick] null == item!");
            AppMethodBeat.o(41008);
            return;
          }
          ac.i("MicroMsg.GameLocalMediaView", "click Image path:" + ((GalleryItem.MediaItem)localObject).sKh);
          int i;
          int j;
          if (GameLocalGalleryView.c.b(GameLocalGalleryView.c.this).contains(localObject))
          {
            GameLocalGalleryView.c.b(GameLocalGalleryView.c.this).remove(localObject);
            i = 1;
            j = 0;
          }
          for (;;)
          {
            if (j != 0)
            {
              if (GameLocalGalleryView.c.f(GameLocalGalleryView.c.this) == 1) {
                h.cg(GameLocalGalleryView.c.c(GameLocalGalleryView.c.this), GameLocalGalleryView.c.c(GameLocalGalleryView.c.this).getResources().getQuantityString(2131623950, GameLocalGalleryView.c.d(GameLocalGalleryView.c.this), new Object[] { Integer.valueOf(GameLocalGalleryView.c.d(GameLocalGalleryView.c.this)) }));
              }
            }
            else
            {
              label223:
              if (1 != i) {
                break label555;
              }
              ((CheckBox)paramAnonymousView.getTag(2131302204)).setChecked(false);
              ((View)paramAnonymousView.getTag(2131302212)).setVisibility(0);
              ((View)paramAnonymousView.getTag(2131302212)).setBackgroundResource(2131100506);
            }
            for (;;)
            {
              if (GameLocalGalleryView.c.g(GameLocalGalleryView.c.this) != null) {
                GameLocalGalleryView.c.g(GameLocalGalleryView.c.this).Go(GameLocalGalleryView.c.b(GameLocalGalleryView.c.this).size());
              }
              AppMethodBeat.o(41008);
              return;
              if ((com.tencent.mm.plugin.gallery.model.e.cMt().kxr == 3) && (localObject != null) && (((GalleryItem.MediaItem)localObject).mMimeType.equalsIgnoreCase("image/gif")))
              {
                i.aSp(((GalleryItem.MediaItem)localObject).sKh);
                if (!((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().XY(((GalleryItem.MediaItem)localObject).sKh))
                {
                  h.cg(GameLocalGalleryView.c.c(GameLocalGalleryView.c.this), GameLocalGalleryView.c.c(GameLocalGalleryView.c.this).getString(2131759800));
                  AppMethodBeat.o(41008);
                  return;
                }
              }
              if (GameLocalGalleryView.c.b(GameLocalGalleryView.c.this).size() >= GameLocalGalleryView.c.d(GameLocalGalleryView.c.this)) {
                break label602;
              }
              GameLocalGalleryView.c.b(GameLocalGalleryView.c.this).add(localObject);
              i = 0;
              j = 0;
              break;
              if (GameLocalGalleryView.c.f(GameLocalGalleryView.c.this) == 2)
              {
                h.cg(GameLocalGalleryView.c.c(GameLocalGalleryView.c.this), GameLocalGalleryView.c.c(GameLocalGalleryView.c.this).getResources().getQuantityString(2131623952, GameLocalGalleryView.c.d(GameLocalGalleryView.c.this), new Object[] { Integer.valueOf(GameLocalGalleryView.c.d(GameLocalGalleryView.c.this)) }));
                break label223;
              }
              h.cg(GameLocalGalleryView.c.c(GameLocalGalleryView.c.this), GameLocalGalleryView.c.c(GameLocalGalleryView.c.this).getResources().getQuantityString(2131623951, GameLocalGalleryView.c.d(GameLocalGalleryView.c.this), new Object[] { Integer.valueOf(GameLocalGalleryView.c.d(GameLocalGalleryView.c.this)) }));
              break label223;
              label555:
              ((CheckBox)paramAnonymousView.getTag(2131302204)).setChecked(true);
              ((View)paramAnonymousView.getTag(2131302212)).setVisibility(0);
              ((View)paramAnonymousView.getTag(2131302212)).setBackgroundResource(2131099819);
              GameLocalGalleryView.Gn(1);
            }
            label602:
            i = 1;
            j = 1;
          }
        }
      };
      this.mContext = paramContext;
      this.sOJ.add(new GalleryItem.ImageMediaItem());
      ac.i("MicroMsg.GameLocalMediaView", "RecycleViewAdapter");
      AppMethodBeat.o(41009);
    }
    
    final void ad(ArrayList<String> paramArrayList)
    {
      AppMethodBeat.i(41012);
      ac.d("MicroMsg.GameLocalMediaView", "before set selected paths, selected[%s]", new Object[] { this.sOK });
      this.sOK.clear();
      if (paramArrayList != null)
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          String str = (String)paramArrayList.next();
          GalleryItem.MediaItem localMediaItem = GalleryItem.MediaItem.a(0, 0L, str, str, "");
          if (com.tencent.mm.plugin.gallery.model.e.cMv() != null)
          {
            int i = com.tencent.mm.plugin.gallery.model.e.cMv().indexOf(localMediaItem);
            if (i >= 0)
            {
              localMediaItem = (GalleryItem.MediaItem)com.tencent.mm.plugin.gallery.model.e.cMv().get(i);
              if ((localMediaItem != null) && (localMediaItem.getType() == 2))
              {
                this.sOK.add(GalleryItem.MediaItem.a(2, 0L, str, "", ""));
                continue;
              }
            }
          }
          ac.d("MicroMsg.GameLocalMediaView", "media item no exist on preview items.");
          this.sOK.add(GalleryItem.MediaItem.a(1, 0L, str, "", ""));
        }
      }
      ac.d("MicroMsg.GameLocalMediaView", "after set selected paths, selected[%s]", new Object[] { this.sOK });
      if (this.sZT != null) {
        this.sZT.Go(this.sOK.size());
      }
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(41007);
          GameLocalGalleryView.c.this.arg.notifyChanged();
          AppMethodBeat.o(41007);
        }
      });
      AppMethodBeat.o(41012);
    }
    
    public final ArrayList<String> cNv()
    {
      AppMethodBeat.i(41011);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.sOK.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((GalleryItem.MediaItem)localIterator.next()).sKh);
      }
      AppMethodBeat.o(41011);
      return localArrayList;
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(41010);
      ac.i("MicroMsg.GameLocalMediaView", "getItemCount, count : %d", new Object[] { Integer.valueOf(this.sOJ.size()) });
      int i = this.sOJ.size();
      AppMethodBeat.o(41010);
      return i;
    }
  }
  
  final class d
    extends RecyclerView.w
  {
    CheckBox ijt;
    View qSM;
    ImageView sFo;
    ImageView sOU;
    ImageView sSM;
    RelativeLayout sSN;
    TextView sSO;
    ImageView sSQ;
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(41015);
      this.sSM = ((ImageView)paramView.findViewById(2131302216));
      this.sFo = ((ImageView)paramView.findViewById(2131302221));
      this.sSN = ((RelativeLayout)paramView.findViewById(2131306355));
      this.sSO = ((TextView)paramView.findViewById(2131306357));
      this.ijt = ((CheckBox)paramView.findViewById(2131302204));
      this.qSM = paramView.findViewById(2131302205);
      this.sOU = ((ImageView)paramView.findViewById(2131302212));
      this.qSM.setTag(2131302204, this.ijt);
      this.qSM.setTag(2131302212, this.sOU);
      this.sSQ = ((ImageView)paramView.findViewById(2131299258));
      AppMethodBeat.o(41015);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GameLocalGalleryView
 * JD-Core Version:    0.7.0.1
 */