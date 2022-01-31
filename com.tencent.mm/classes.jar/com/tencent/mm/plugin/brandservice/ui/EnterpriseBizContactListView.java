package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.database.Cursor;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.m.a;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.protocal.protobuf.me;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.c.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EnterpriseBizContactListView
  extends BaseSortView
{
  private ListView gJa;
  private String jUc;
  private boolean jUi;
  private int jUj = -1;
  private EnterpriseBizContactListView.b jUk;
  private EnterpriseBizContactListView.a jUl;
  private int jUm = 0;
  private int jUn = 0;
  
  public EnterpriseBizContactListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private List<com.tencent.mm.ui.base.sortview.d> getSortEntityList()
  {
    AppMethodBeat.i(13969);
    ArrayList localArrayList = new ArrayList();
    z.afi();
    Cursor localCursor = e.G(this.jUc, this.jUi);
    while (localCursor.moveToNext())
    {
      me localme = new me();
      Object localObject;
      if (localCursor != null)
      {
        localObject = new ad();
        ((ad)localObject).convertFrom(localCursor);
        com.tencent.mm.aj.d locald = new com.tencent.mm.aj.d();
        locald.convertFrom(localCursor);
        localme.userName = ((aq)localObject).field_username;
        localme.contact = ((ad)localObject);
        localme.pyd = locald;
      }
      if (localme.contact != null)
      {
        localObject = new com.tencent.mm.ui.base.sortview.d();
        ((com.tencent.mm.ui.base.sortview.d)localObject).data = localme;
        if (localme.pyd.aei()) {
          ((com.tencent.mm.ui.base.sortview.d)localObject).zsM = "!1";
        }
        for (;;)
        {
          localArrayList.add(localObject);
          break;
          if (localme.contact.Oa())
          {
            ((com.tencent.mm.ui.base.sortview.d)localObject).zsM = "!2";
          }
          else
          {
            int j = localme.contact.Nu();
            int i = j;
            if (j >= 97)
            {
              i = j;
              if (j <= 122) {
                i = j - 32;
              }
            }
            if ((i >= 65) && (i <= 90)) {
              ((com.tencent.mm.ui.base.sortview.d)localObject).zsM = ((char)i);
            } else {
              ((com.tencent.mm.ui.base.sortview.d)localObject).zsM = "#";
            }
          }
        }
      }
    }
    localCursor.close();
    this.jUj = localArrayList.size();
    Collections.sort(localArrayList, new d((byte)0));
    AppMethodBeat.o(13969);
    return localArrayList;
  }
  
  public static void release()
  {
    AppMethodBeat.i(13970);
    z.afs().afc();
    AppMethodBeat.o(13970);
  }
  
  public final boolean a(String paramString, com.tencent.mm.ui.base.sortview.d paramd)
  {
    AppMethodBeat.i(13971);
    if ((!bo.isNullOrNil(paramString)) && (paramd != null))
    {
      Object localObject = (me)paramd.data;
      if (localObject == null)
      {
        AppMethodBeat.o(13971);
        return false;
      }
      paramd = ((me)localObject).contact.Of();
      String str = ((me)localObject).contact.Ht();
      localObject = ((me)localObject).contact.Hu();
      paramString = paramString.toUpperCase();
      if (((!bo.isNullOrNil(paramd)) && (paramd.toUpperCase().indexOf(paramString) != -1)) || ((!bo.isNullOrNil(str)) && (str.toUpperCase().indexOf(paramString) != -1)) || ((!bo.isNullOrNil((String)localObject)) && (((String)localObject).toUpperCase().startsWith(paramString))))
      {
        AppMethodBeat.o(13971);
        return true;
      }
    }
    AppMethodBeat.o(13971);
    return false;
  }
  
  public final void aWB()
  {
    AppMethodBeat.i(13968);
    setOnItemClickListener(new EnterpriseBizContactListView.1(this));
    if (getMode() == 0) {
      setOnItemLongClickListener(new EnterpriseBizContactListView.2(this));
    }
    AppMethodBeat.o(13968);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(13967);
    if (paramMotionEvent.getAction() == 0)
    {
      this.jUm = ((int)paramMotionEvent.getRawX());
      this.jUn = ((int)paramMotionEvent.getRawY());
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(13967);
    return bool;
  }
  
  public int getContactCount()
  {
    return this.jUj;
  }
  
  public c.a getItemViewCreator()
  {
    AppMethodBeat.i(13976);
    EnterpriseBizContactListView.3 local3 = new EnterpriseBizContactListView.3(this);
    AppMethodBeat.o(13976);
    return local3;
  }
  
  public ListView getListView()
  {
    AppMethodBeat.i(13974);
    this.gJa = ((ListView)findViewById(2131821736));
    ListView localListView = this.gJa;
    AppMethodBeat.o(13974);
    return localListView;
  }
  
  public View getNoResultView()
  {
    AppMethodBeat.i(13975);
    TextView localTextView = (TextView)findViewById(2131821961);
    localTextView.setText(2131299317);
    AppMethodBeat.o(13975);
    return localTextView;
  }
  
  public VerticalScrollBar getScrollBar()
  {
    AppMethodBeat.i(13973);
    VerticalScrollBar localVerticalScrollBar = (VerticalScrollBar)findViewById(2131821737);
    AppMethodBeat.o(13973);
    return localVerticalScrollBar;
  }
  
  public final View inflate()
  {
    AppMethodBeat.i(13972);
    View localView = View.inflate(getContext(), 2130969431, this);
    AppMethodBeat.o(13972);
    return localView;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(13977);
    if (this.jUk != null) {
      this.jUk.aWA();
    }
    if (super.onInterceptTouchEvent(paramMotionEvent))
    {
      AppMethodBeat.o(13977);
      return true;
    }
    AppMethodBeat.o(13977);
    return false;
  }
  
  public final void refresh()
  {
    AppMethodBeat.i(13966);
    dI(getSortEntityList());
    super.refresh();
    AppMethodBeat.o(13966);
  }
  
  public void setExcludeBizChat(boolean paramBoolean)
  {
    this.jUi = paramBoolean;
  }
  
  public void setFatherBizName(String paramString)
  {
    this.jUc = paramString;
  }
  
  public void setOnTouchListener(EnterpriseBizContactListView.b paramb)
  {
    this.jUk = paramb;
  }
  
  final class d
    implements Comparator<com.tencent.mm.ui.base.sortview.d>
  {
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView
 * JD-Core Version:    0.7.0.1
 */