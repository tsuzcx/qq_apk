 (function() {
     function WX_Trans_Pre_CheckNeedTrans() {
         var sampleArray = [];
         WX_Trans_Pre_TextNodesUnderForCheck(document.body,sampleArray);
         return sampleArray;
     }

     function WX_Trans_Pre_TextNodesUnderForCheck(node,array) {
         if (node == null){
             return;
         }
         if (node.firstChild == null){
             return;
         }
         if(node.nodeType === 1 && WX_Trans_Pre_nodeDissmiss(node)){
             return;
         }
         for (node = node.firstChild; node; node = node.nextSibling) {
             if (node.nodeType === 3 && WX_Trans_Pre_validTagName(node.parentElement.tagName)&&node.nodeValue.replace(/\s+/, '') !== "") {
                 array.push(node.nodeValue);
             } else {
                 WX_Trans_Pre_TextNodesUnderForCheck(node,array);
             }
         }
     }

     function WX_Trans_Pre_validTagName(tagName) {
         const tagFilter = new Set(['SPAN', 'A', 'P', 'H1', 'H2', 'H3', 'H4', 'H5', 'H6'
                                    , 'B', 'I', 'FIGCAPTION', 'DIV', 'EM', 'STRONG', 'LI','FONT','TABLE'
                                    , 'TD','TR','TH', 'TITLE', 'SECTION', 'LABEL', 'INPUT', 'BUTTON', 'Q', 'CITE', 'BLOCKQUOTE']);
         return tagFilter.has(tagName);
     }
     function WX_Trans_Pre_nodeDissmiss(node){
         var nodeStyle = getComputedStyle(node);
         if(nodeStyle == null){
             return false;
         }

         var displayEqualsNone = nodeStyle.display==='none';
         var visibilityEqualsHidden = nodeStyle.visibility === 'hidden';
         var opacityEqualsZero = parseFloat(nodeStyle.opacity) === 0;
         var sizeEqualsZero = parseFloat(nodeStyle.height) === 0|| parseFloat(nodeStyle.width) === 0;

         var rgba = nodeStyle.color.match(/(\d\.)?\d+/g);
         var alphaEqualsZero = parseFloat(rgba[3])===0;
         return displayEqualsNone || visibilityEqualsHidden || opacityEqualsZero || sizeEqualsZero || alphaEqualsZero;
     }
     return WX_Trans_Pre_CheckNeedTrans();
 })();
